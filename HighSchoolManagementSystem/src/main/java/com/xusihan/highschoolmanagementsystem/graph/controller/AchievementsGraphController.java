package com.xusihan.highschoolmanagementsystem.graph.controller;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsService;
import com.xusihan.highschoolmanagementsystem.po.Achievements;

@Controller
@RequestMapping("/graph/achievements")
public class AchievementsGraphController {

	@Resource(name = "achievementsServiceImpl")
	private AchievementsService achievementsService;
	
	@RequestMapping("list.action")
	public String getAchievementsGraph(){  
	
		return "graph/achievements/achievements_graph";  
	}
	
	//显示饼状图
    @RequestMapping("graph.action")
    public ModelAndView getPieChart(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) 
    		throws Exception{
    	
    	DefaultPieDataset dpd = getDataset();
		
		//创建主题样式  
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		//设置标题字体  
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		//设置图例的字体  
		standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		//设置轴向的字体  
		standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		//应用主题样式  
		ChartFactory.setChartTheme(standardChartTheme);  
		
		JFreeChart chart = ChartFactory.createPieChart("考试成绩结构图",dpd, true, false, false);
		chart.setBackgroundPaint(Color.white);
		//ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
		String fileName = ServletUtilities.saveChartAsPNG(chart,600,400,request.getSession()); 
		//根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
		String PieURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
		modelMap.put("PieURL", PieURL);
		return new ModelAndView("graph/achievements/achievements_graph",modelMap); 
    }
	
		
	public DefaultPieDataset getDataset() {
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
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		dataset.setValue("满分"	, gradeA);
		dataset.setValue("优秀"	, gradeB);
		dataset.setValue("良好"	, gradeC);
		dataset.setValue("一般"	, gradeD);
		dataset.setValue("及格"	, gradeE);
		dataset.setValue("不及格"	, gradeF);
		return dataset;
	}

}
