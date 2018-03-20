package com.xusihan.highschoolmanagementsystem.graph.controller;

import java.awt.Font;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsService;
import com.xusihan.highschoolmanagementsystem.po.Achievements;
import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;

@Controller
@RequestMapping("/graph/graph")
public class GraphController {
	
	@Resource(name = "achievementsServiceImpl")
	private AchievementsService achievementsService;
	
	@RequestMapping("list.action")
	public String resultmap(){  
	
		return "resultmap";  
	}  

	@RequestMapping("graph.action") 
	public ModelAndView getColumnChart(Studentstudyrecord studentstudyrecord, Model model, HttpServletRequest request, ModelMap modelMap) 
			throws Exception {
		//1. 获得数据集合  
		CategoryDataset dataset = getdataset();  
		//2. 创建柱状图  
		JFreeChart chart = ChartFactory.createBarChart3D(
				"成绩分布图", 			// 图表标题  
				"成绩段", 					// 目录轴的显示标签  
				"人数", 					// 数值轴的显示标签  
				dataset, 					// 数据集  
				PlotOrientation.VERTICAL, 	// 图表方向：水平、垂直  
				false, 						// 是否显示图例(对于简单的柱状图必须是false)  
				false, 						// 是否生成工具  
				false 						// 是否生成URL链接  
				);  
		//3. 设置整个柱状图的颜色和文字（char对象的设置是针对整个图形的设置）  
		chart.setBackgroundPaint(ChartColor.WHITE); // 设置总的背景颜色  
		
		//4. 获得图形对象，并通过此对象对图形的颜色文字进行设置  
		CategoryPlot p = chart.getCategoryPlot();	// 获得图表对象  
		p.setBackgroundPaint(ChartColor.lightGray);	// 图形背景颜色  
		p.setRangeGridlinePaint(ChartColor.WHITE);	// 图形表格颜色  
		
		//5. 设置柱子宽度  
		BarRenderer renderer = (BarRenderer)p.getRenderer();  
		renderer.setMaximumBarWidth(0.06);  
		
		//解决乱码问题  
		getChartByFont(chart);  

		//6. 将图形转换为图片，传到前台  
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 400, null, request.getSession() );
		System.out.println("测试fileName--"+fileName);
		//生成URL，用于请求
		String chartURL=request.getContextPath() + "/DisplayChart?filename="+fileName;
		System.out.println("测试chartURL--"+chartURL);
		modelMap.put("chartURL", chartURL);
		//请求URL时，将URL返回到指定的JSP页面
		
		return new ModelAndView("resultmap", modelMap);
		
	}

	//	此处可以选择性的加入下面的三个图表代码
	@RequestMapping("/getColumnChart")  
	public ModelAndView getColumnChart(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws Exception{  
		//1. 获得数据集合  
		CategoryDataset dataset = getDataSet();  
		//2. 创建柱状图  
		JFreeChart chart = ChartFactory.createBarChart3D(
				"学生对教师授课满意度", 			// 图表标题  
				"课程名", 					// 目录轴的显示标签  
				"百分比", 					// 数值轴的显示标签  
				dataset, 					// 数据集  
				PlotOrientation.VERTICAL, 	// 图表方向：水平、垂直  
				false, 						// 是否显示图例(对于简单的柱状图必须是false)  
				false, 						// 是否生成工具  
				false 						// 是否生成URL链接  
				);  
		//3. 设置整个柱状图的颜色和文字（char对象的设置是针对整个图形的设置）  
		chart.setBackgroundPaint(ChartColor.WHITE); // 设置总的背景颜色  
		
		//4. 获得图形对象，并通过此对象对图形的颜色文字进行设置  
		CategoryPlot p = chart.getCategoryPlot();	// 获得图表对象  
		p.setBackgroundPaint(ChartColor.lightGray);	// 图形背景颜色  
		p.setRangeGridlinePaint(ChartColor.WHITE);	// 图形表格颜色  
		
		//5. 设置柱子宽度  
		BarRenderer renderer = (BarRenderer)p.getRenderer();  
		renderer.setMaximumBarWidth(0.06);  
		
		//解决乱码问题  
		getChartByFont(chart);  

		//6. 将图形转换为图片，传到前台  
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 400, null, request.getSession());
		System.out.println("测试fileName--"+fileName);
		//生成URL，用于请求
		String chartURL=request.getContextPath() + "/DisplayChart?filename="+fileName;
		System.out.println("测试chartURL--"+chartURL);
		modelMap.put("chartURL", chartURL);
		//请求URL时，将URL返回到指定的JSP页面
		return new ModelAndView("resultmap", modelMap);
    }  

	//设置文字样式  
	private static void getChartByFont(JFreeChart chart) {  
		/*
		 * 1. 图形标题文字设置  
		 */
		TextTitle textTitle = chart.getTitle();     
		textTitle.setFont(new Font("宋体",Font.BOLD,20));  
		
		/*
		 * 2. 图形X轴坐标文字的设置  
		 */
		CategoryPlot plot = (CategoryPlot) chart.getPlot();  
		CategoryAxis axis = plot.getDomainAxis(); 
		//设置X轴坐标上标题的文字
		axis.setLabelFont(new Font("宋体",Font.BOLD,22));   
		//设置X轴坐标上的文字 
		axis.setTickLabelFont(new Font("宋体",Font.BOLD,15));
		
		/*
		 * 3. 图形Y轴坐标文字的设置  
		 */
		ValueAxis valueAxis = plot.getRangeAxis(); 
		//设置Y轴坐标上标题的文字 
		valueAxis.setLabelFont(new Font("宋体",Font.BOLD,15));
		//设置Y轴坐标上的文字
		valueAxis.setTickLabelFont(new Font("sans-serif",Font.BOLD,12));  
	}  

	// 获取一个演示用的组合数据集对象 ;可以使用模拟的数据集，也可以采用数据库返回的数据集，通过控制器将模型的数据传送到视图层
	private static CategoryDataset getDataSet() {  
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		dataset.addValue(40, "", "普通动物学");  
		dataset.addValue(50, "", "生物学");  
		dataset.addValue(60, "", "动物解剖学");  
		dataset.addValue(70, "", "生物理论课");  
		dataset.addValue(80, "", "动物理论课");  
		return dataset;  
	}  
	
	public DefaultCategoryDataset getdataset() {
		List<Achievements> listOfAchievements = achievementsService.getAchievementsList(null);
		int gradeA = 0;		// >=100
		int gradeB = 0;		// 90<= <100
		int gradeC = 0;		// 80<= <90
		int gradeD = 0;		// 70<= <80
		int gradeE = 0;		// 60<= <70
		int gradeF = 0;		// <60
		
		for(Achievements achievementsList:listOfAchievements) {
			String str = achievementsList.getResult();
			try {
			    int score = Integer.parseInt(str);
			    switch( score/10) {
			    	case 0:
			    	case 1:
			    	case 2:
			    	case 3:
			    	case 4:
			    	case 5:	gradeF = gradeF+1;break;
			    	case 6:	gradeE = gradeE+1;break;
			    	case 7:	gradeD = gradeD+1;break;
			    	case 8:	gradeC = gradeC+1;break;
			    	case 9:	gradeB = gradeB+1;break;
			    	case 10:gradeA = gradeA+1;break;		
				}
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
		}
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.setValue(gradeA, "A", "满分");
		dataset.setValue(gradeB, "B", "优秀");
		dataset.setValue(gradeC, "C", "良好");
		dataset.setValue(gradeD, "D", "一般");
		dataset.setValue(gradeE, "E", "及格");
		dataset.setValue(gradeF, "F", "不及格");
		return dataset;
	}
}
