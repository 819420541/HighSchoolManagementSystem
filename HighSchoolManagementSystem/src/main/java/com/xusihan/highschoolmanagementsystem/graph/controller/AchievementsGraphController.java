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
	
	//��ʾ��״ͼ
    @RequestMapping("graph.action")
    public ModelAndView getPieChart(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) 
    		throws Exception{
    	
    	DefaultPieDataset dpd = getDataset();
		
		//����������ʽ  
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		//���ñ�������  
		standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));  
		//����ͼ��������  
		standardChartTheme.setRegularFont(new Font("����",Font.PLAIN,15));  
		//�������������  
		standardChartTheme.setLargeFont(new Font("����",Font.PLAIN,15));  
		//Ӧ��������ʽ  
		ChartFactory.setChartTheme(standardChartTheme);  
		
		JFreeChart chart = ChartFactory.createPieChart("���Գɼ��ṹͼ",dpd, true, false, false);
		chart.setBackgroundPaint(Color.white);
		//ServletUtilities������web�����Ĺ����࣬����һ���ַ����ļ���,�ļ����Զ����ɣ����ɺõ�ͼƬ���Զ����ڷ�������tomcat������ʱ�ļ��£�temp��
		String fileName = ServletUtilities.saveChartAsPNG(chart,600,400,request.getSession()); 
		//�����ļ���ȥ��ʱĿ¼��Ѱ�Ҹ�ͼƬ�������/DisplayChart·��Ҫ�������ļ����û��Զ����<url-pattern>һ��
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
		
		dataset.setValue("����"	, gradeA);
		dataset.setValue("����"	, gradeB);
		dataset.setValue("����"	, gradeC);
		dataset.setValue("һ��"	, gradeD);
		dataset.setValue("����"	, gradeE);
		dataset.setValue("������"	, gradeF);
		return dataset;
	}

}
