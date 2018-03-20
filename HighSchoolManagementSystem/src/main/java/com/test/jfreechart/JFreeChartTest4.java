package com.test.jfreechart;


import java.awt.Font;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsService;
import com.xusihan.highschoolmanagementsystem.exams.service.impl.AchievementsServiceImpl;
import com.xusihan.highschoolmanagementsystem.po.Achievements;

public class JFreeChartTest4{
	
    public static void main(String[] args) throws Exception {
    	
    	AchievementsService achievementsService = new AchievementsServiceImpl();
    	
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
		
        JFreeChart chart=ChartFactory.createBarChart("hi", "�ֲ�", 
                "����", dataset, PlotOrientation.VERTICAL, true, true, false); //����һ��JFreeChart
        chart.setTitle(new TextTitle("�ɼ��ֲ�ͼ",new Font("����",Font.BOLD+Font.ITALIC,20)));
        
        chart.setTitle(new TextTitle("ĳ��˾��֯�ṹͼ",new Font("����",Font.BOLD+Font.ITALIC,20)));//�����������ñ��⣬�滻��hi������
        CategoryPlot plot=(CategoryPlot)chart.getPlot();//���ͼ���м䲿�֣���plot
        CategoryAxis categoryAxis=plot.getDomainAxis();//��ú�����
        categoryAxis.setLabelFont(new Font("΢���ź�",Font.BOLD,12));//���ú���������
         
        OutputStream os = new FileOutputStream("achievements.jpeg");//ͼƬ���ļ���ʽ�ģ���Ҫ�õ�FileOutputStream���������
        ChartUtilities.writeChartAsJPEG(os, chart, 1000, 800);
        //ʹ��һ������application�Ĺ����࣬��chartת����JPEG��ʽ��ͼƬ����3�������ǿ�ȣ���4�������Ǹ߶ȡ�
        
        os.close();//�ر������
    }


//    private static DefaultCategoryDataset getDataset()
//    {
//    	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
//        dataset.setValue(10,"a","������Ա");
//        dataset.setValue(20,"b","�г���Ա");
//        dataset.setValue(40,"c","������Ա");
//        dataset.setValue(15,"d","������Ա");
//        return dataset;
//    }
}
