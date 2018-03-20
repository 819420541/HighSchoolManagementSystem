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
		
		JFreeChart chart = ChartFactory.createPieChart("出勤结构图",dpd, true, false, false);
		chart.setBackgroundPaint(Color.white);
		//ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
		String fileName = ServletUtilities.saveChartAsPNG(chart,600,400,request.getSession()); 
		//根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
		String PieURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
		modelMap.put("PieURL", PieURL);
		return new ModelAndView("graph/attendance/attendance_graph", modelMap); 
    }
    
    // 采用数据库返回的数据集，通过控制器将模型的数据传送到视图层
 	public DefaultPieDataset getDataset() {
 		
 		List<Attendances> ListOfAttendances = attendancesService.getAttendancesList(null);
 		int numOfAttendances = 0;		// 出勤
		int numOfLateClasses = 0;		// 迟到
		int numOfLeavePermit = 0;		// 请假
		int numOfLeavesEarly = 0;		// 早退
		int numOfAbsentClass = 0;		// 缺勤
 		
		for(Attendances attendancesList:ListOfAttendances) {
			String str = attendancesList.getSituation();
			if(str.equals("出勤")) {
				numOfAttendances = numOfAttendances+1;
			}else if(str.equals("迟到")) {
				numOfLateClasses = numOfLateClasses+1;
			}else if(str.equals("请假")) {
				numOfLeavePermit = numOfLeavePermit+1;
			}else if(str.equals("早退")) {
				numOfLeavesEarly = numOfLeavesEarly+1;
			}else if(str.equals("缺勤")) {
				numOfAbsentClass = numOfAbsentClass+1;
			}
		}
		
 		DefaultPieDataset dataset = new DefaultPieDataset();
 		
 		dataset.setValue("出勤", numOfAttendances);
 		dataset.setValue("迟到", numOfLateClasses);
 		dataset.setValue("请假", numOfLeavePermit);
 		dataset.setValue("早退", numOfLeavesEarly);
 		dataset.setValue("缺勤", numOfAbsentClass);
 		
		return dataset;
 		
 	}
 	
}
