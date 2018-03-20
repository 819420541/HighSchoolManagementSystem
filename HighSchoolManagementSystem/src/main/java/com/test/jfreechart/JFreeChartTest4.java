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
		dataset.setValue(gradeA, "A", "满分");
		dataset.setValue(gradeB, "B", "优秀");
		dataset.setValue(gradeC, "C", "良好");
		dataset.setValue(gradeD, "D", "一般");
		dataset.setValue(gradeE, "E", "及格");
		dataset.setValue(gradeF, "F", "不及格");
		
        JFreeChart chart=ChartFactory.createBarChart("hi", "分布", 
                "数量", dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
        chart.setTitle(new TextTitle("成绩分布图",new Font("宋体",Font.BOLD+Font.ITALIC,20)));
        
        chart.setTitle(new TextTitle("某公司组织结构图",new Font("宋体",Font.BOLD+Font.ITALIC,20)));//可以重新设置标题，替换“hi”标题
        CategoryPlot plot=(CategoryPlot)chart.getPlot();//获得图标中间部分，即plot
        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
        categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,12));//设置横坐标字体
         
        OutputStream os = new FileOutputStream("achievements.jpeg");//图片是文件格式的，故要用到FileOutputStream用来输出。
        ChartUtilities.writeChartAsJPEG(os, chart, 1000, 800);
        //使用一个面向application的工具类，将chart转换成JPEG格式的图片。第3个参数是宽度，第4个参数是高度。
        
        os.close();//关闭输出流
    }


//    private static DefaultCategoryDataset getDataset()
//    {
//    	DefaultCategoryDataset dataset=new DefaultCategoryDataset();
//        dataset.setValue(10,"a","管理人员");
//        dataset.setValue(20,"b","市场人员");
//        dataset.setValue(40,"c","开发人员");
//        dataset.setValue(15,"d","其他人员");
//        return dataset;
//    }
}
