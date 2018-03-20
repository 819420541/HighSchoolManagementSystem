package com.test.jfreechart;


import java.awt.Font;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest3
{
    public static void main(String[] args) throws Exception
    {
        JFreeChart chart=ChartFactory.createPieChart("ĳ��˾��Ա��֯����ͼ",getDataset(),true,true,false);
        chart.setTitle(new TextTitle("ĳ��˾��֯�ṹͼ",new Font("����",Font.BOLD+Font.ITALIC,20)));
        
         LegendTitle legend=chart.getLegend(0);//����Legend
         legend.setItemFont(new Font("����",Font.BOLD,14));
         PiePlot plot=(PiePlot) chart.getPlot();//����Plot
         plot.setLabelFont(new Font("����",Font.BOLD,16));
         
        OutputStream os = new FileOutputStream("company.jpeg");//ͼƬ���ļ���ʽ�ģ���Ҫ�õ�FileOutputStream���������
        ChartUtilities.writeChartAsJPEG(os, chart, 1000, 800);
        //ʹ��һ������application�Ĺ����࣬��chartת����JPEG��ʽ��ͼƬ����3�������ǿ�ȣ���4�������Ǹ߶ȡ�
        
        os.close();//�ر������
    }

    private static DefaultPieDataset getDataset()
    {
        DefaultPieDataset dpd=new DefaultPieDataset(); //����һ��Ĭ�ϵı�ͼ
        dpd.setValue("������Ա", 25);  //��������
        dpd.setValue("�г���Ա", 25);
        dpd.setValue("������Ա", 45);
        dpd.setValue("������Ա", 10);
        return dpd;
    }
}
