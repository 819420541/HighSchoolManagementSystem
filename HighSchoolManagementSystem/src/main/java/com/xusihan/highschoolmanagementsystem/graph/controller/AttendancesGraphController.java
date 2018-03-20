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

import com.xusihan.highschoolmanagementsystem.po.Attendances;
import com.xusihan.highschoolmanagementsystem.students.service.AttendancesService;

@Controller
@RequestMapping("/graph/attendance")
public class AttendancesGraphController {

	@Resource(name = "attendancesServiceImpl")
	private AttendancesService attendancesService;
	
	@RequestMapping("list.action")
	public String getAttendanceGraph(){  
		return "graph/attendance/attendance_graph";  
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
		
		JFreeChart chart = ChartFactory.createPieChart("���ڽṹͼ",dpd, true, false, false);
		chart.setBackgroundPaint(Color.white);
		//ServletUtilities������web�����Ĺ����࣬����һ���ַ����ļ���,�ļ����Զ����ɣ����ɺõ�ͼƬ���Զ����ڷ�������tomcat������ʱ�ļ��£�temp��
		String fileName = ServletUtilities.saveChartAsPNG(chart,600,400,request.getSession()); 
		//�����ļ���ȥ��ʱĿ¼��Ѱ�Ҹ�ͼƬ�������/DisplayChart·��Ҫ�������ļ����û��Զ����<url-pattern>һ��
		String PieURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
		modelMap.put("PieURL", PieURL);
		return new ModelAndView("graph/attendance/attendance_graph", modelMap); 
    }
    
    // �������ݿⷵ�ص����ݼ���ͨ����������ģ�͵����ݴ��͵���ͼ��
 	public DefaultPieDataset getDataset() {
 		
 		List<Attendances> ListOfAttendances = attendancesService.getAttendancesList(null);
 		int numOfAttendances = 0;		// ����
		int numOfLateClasses = 0;		// �ٵ�
		int numOfLeavePermit = 0;		// ���
		int numOfLeavesEarly = 0;		// ����
		int numOfAbsentClass = 0;		// ȱ��
 		
		for(Attendances attendancesList:ListOfAttendances) {
			String str = attendancesList.getSituation();
			if(str.equals("����")) {
				numOfAttendances = numOfAttendances+1;
			}else if(str.equals("�ٵ�")) {
				numOfLateClasses = numOfLateClasses+1;
			}else if(str.equals("���")) {
				numOfLeavePermit = numOfLeavePermit+1;
			}else if(str.equals("����")) {
				numOfLeavesEarly = numOfLeavesEarly+1;
			}else if(str.equals("ȱ��")) {
				numOfAbsentClass = numOfAbsentClass+1;
			}
		}
		
 		DefaultPieDataset dataset = new DefaultPieDataset();
 		
 		dataset.setValue("����", numOfAttendances);
 		dataset.setValue("�ٵ�", numOfLateClasses);
 		dataset.setValue("���", numOfLeavePermit);
 		dataset.setValue("����", numOfLeavesEarly);
 		dataset.setValue("ȱ��", numOfAbsentClass);
 		
		return dataset;
 		
 	}
 	
}
