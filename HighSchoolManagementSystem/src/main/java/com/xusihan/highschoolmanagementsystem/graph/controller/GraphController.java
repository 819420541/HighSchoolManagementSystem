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
		//1. ������ݼ���  
		CategoryDataset dataset = getdataset();  
		//2. ������״ͼ  
		JFreeChart chart = ChartFactory.createBarChart3D(
				"�ɼ��ֲ�ͼ", 			// ͼ�����  
				"�ɼ���", 					// Ŀ¼�����ʾ��ǩ  
				"����", 					// ��ֵ�����ʾ��ǩ  
				dataset, 					// ���ݼ�  
				PlotOrientation.VERTICAL, 	// ͼ����ˮƽ����ֱ  
				false, 						// �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
				false, 						// �Ƿ����ɹ���  
				false 						// �Ƿ�����URL����  
				);  
		//3. ����������״ͼ����ɫ�����֣�char������������������ͼ�ε����ã�  
		chart.setBackgroundPaint(ChartColor.WHITE); // �����ܵı�����ɫ  
		
		//4. ���ͼ�ζ��󣬲�ͨ���˶����ͼ�ε���ɫ���ֽ�������  
		CategoryPlot p = chart.getCategoryPlot();	// ���ͼ�����  
		p.setBackgroundPaint(ChartColor.lightGray);	// ͼ�α�����ɫ  
		p.setRangeGridlinePaint(ChartColor.WHITE);	// ͼ�α����ɫ  
		
		//5. �������ӿ��  
		BarRenderer renderer = (BarRenderer)p.getRenderer();  
		renderer.setMaximumBarWidth(0.06);  
		
		//�����������  
		getChartByFont(chart);  

		//6. ��ͼ��ת��ΪͼƬ������ǰ̨  
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 400, null, request.getSession() );
		System.out.println("����fileName--"+fileName);
		//����URL����������
		String chartURL=request.getContextPath() + "/DisplayChart?filename="+fileName;
		System.out.println("����chartURL--"+chartURL);
		modelMap.put("chartURL", chartURL);
		//����URLʱ����URL���ص�ָ����JSPҳ��
		
		return new ModelAndView("resultmap", modelMap);
		
	}

	//	�˴�����ѡ���Եļ������������ͼ�����
	@RequestMapping("/getColumnChart")  
	public ModelAndView getColumnChart(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws Exception{  
		//1. ������ݼ���  
		CategoryDataset dataset = getDataSet();  
		//2. ������״ͼ  
		JFreeChart chart = ChartFactory.createBarChart3D(
				"ѧ���Խ�ʦ�ڿ������", 			// ͼ�����  
				"�γ���", 					// Ŀ¼�����ʾ��ǩ  
				"�ٷֱ�", 					// ��ֵ�����ʾ��ǩ  
				dataset, 					// ���ݼ�  
				PlotOrientation.VERTICAL, 	// ͼ����ˮƽ����ֱ  
				false, 						// �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
				false, 						// �Ƿ����ɹ���  
				false 						// �Ƿ�����URL����  
				);  
		//3. ����������״ͼ����ɫ�����֣�char������������������ͼ�ε����ã�  
		chart.setBackgroundPaint(ChartColor.WHITE); // �����ܵı�����ɫ  
		
		//4. ���ͼ�ζ��󣬲�ͨ���˶����ͼ�ε���ɫ���ֽ�������  
		CategoryPlot p = chart.getCategoryPlot();	// ���ͼ�����  
		p.setBackgroundPaint(ChartColor.lightGray);	// ͼ�α�����ɫ  
		p.setRangeGridlinePaint(ChartColor.WHITE);	// ͼ�α����ɫ  
		
		//5. �������ӿ��  
		BarRenderer renderer = (BarRenderer)p.getRenderer();  
		renderer.setMaximumBarWidth(0.06);  
		
		//�����������  
		getChartByFont(chart);  

		//6. ��ͼ��ת��ΪͼƬ������ǰ̨  
		String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 400, null, request.getSession());
		System.out.println("����fileName--"+fileName);
		//����URL����������
		String chartURL=request.getContextPath() + "/DisplayChart?filename="+fileName;
		System.out.println("����chartURL--"+chartURL);
		modelMap.put("chartURL", chartURL);
		//����URLʱ����URL���ص�ָ����JSPҳ��
		return new ModelAndView("resultmap", modelMap);
    }  

	//����������ʽ  
	private static void getChartByFont(JFreeChart chart) {  
		/*
		 * 1. ͼ�α�����������  
		 */
		TextTitle textTitle = chart.getTitle();     
		textTitle.setFont(new Font("����",Font.BOLD,20));  
		
		/*
		 * 2. ͼ��X���������ֵ�����  
		 */
		CategoryPlot plot = (CategoryPlot) chart.getPlot();  
		CategoryAxis axis = plot.getDomainAxis(); 
		//����X�������ϱ��������
		axis.setLabelFont(new Font("����",Font.BOLD,22));   
		//����X�������ϵ����� 
		axis.setTickLabelFont(new Font("����",Font.BOLD,15));
		
		/*
		 * 3. ͼ��Y���������ֵ�����  
		 */
		ValueAxis valueAxis = plot.getRangeAxis(); 
		//����Y�������ϱ�������� 
		valueAxis.setLabelFont(new Font("����",Font.BOLD,15));
		//����Y�������ϵ�����
		valueAxis.setTickLabelFont(new Font("sans-serif",Font.BOLD,12));  
	}  

	// ��ȡһ����ʾ�õ�������ݼ����� ;����ʹ��ģ������ݼ���Ҳ���Բ������ݿⷵ�ص����ݼ���ͨ����������ģ�͵����ݴ��͵���ͼ��
	private static CategoryDataset getDataSet() {  
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		dataset.addValue(40, "", "��ͨ����ѧ");  
		dataset.addValue(50, "", "����ѧ");  
		dataset.addValue(60, "", "�������ѧ");  
		dataset.addValue(70, "", "�������ۿ�");  
		dataset.addValue(80, "", "�������ۿ�");  
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
		
		dataset.setValue(gradeA, "A", "����");
		dataset.setValue(gradeB, "B", "����");
		dataset.setValue(gradeC, "C", "����");
		dataset.setValue(gradeD, "D", "һ��");
		dataset.setValue(gradeE, "E", "����");
		dataset.setValue(gradeF, "F", "������");
		return dataset;
	}
}
