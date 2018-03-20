package com.xusihan.highschoolmanagementsystem.students.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.classes.service.ClassesService;
import com.xusihan.highschoolmanagementsystem.database.service.CoursesService;
import com.xusihan.highschoolmanagementsystem.database.service.SemestersService;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.Course;
import com.xusihan.highschoolmanagementsystem.po.Semesters;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.Attendances;
import com.xusihan.highschoolmanagementsystem.po.AttendancesCustom;
import com.xusihan.highschoolmanagementsystem.students.service.AttendancesCustomService;
import com.xusihan.highschoolmanagementsystem.students.service.AttendancesService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseService;

@Controller
@RequestMapping("/students/attendance")
public class AttendancesController {
	
	@Resource(name = "attendancesServiceImpl")
	private AttendancesService attendancesService;
	
	@Resource(name = "attendancesCustomServiceImpl")
	private AttendancesCustomService attendancesCustomService;
	
	@Resource(name = "semestersServiceImpl")
	private SemestersService semestersService;
	
	@Resource(name = "classesServiceImpl")
	private ClassesService classesService;
	
	@Resource(name = "coursesServiceImpl")
	private CoursesService coursesService;
	
	@Resource(name = "studentsbaseServiceImpl")
	private StudentsbaseService studentsbaseService;
	
	@RequestMapping("list.action")
	private String listAttendances(AttendancesCustom attendancesCustom, Model model) throws Exception {
		
		List<AttendancesCustom> list = attendancesCustomService.getAttendancesCustomList(attendancesCustom);
		model.addAttribute("list", list);
		return "/students/attendance/attendance_list";
	}
	
	@RequestMapping("add.action")
	private String addAttendance(@Validated Attendances attendances, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有考勤信息
			Attendances attendanceInfo = attendancesService.getAttendance(attendances.getAttendanceid());
			model.addAttribute("attendanceInfo", attendanceInfo);
			// 查询所有学期信息
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			// 查询所有班级信息
			List<Classes> listOfClasses =classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			// 查询所有课程信息
			List<Course> listOfCourses =coursesService.getCoursesList(null);
			model.addAttribute("listOfCourses", listOfCourses);
			// 查询所有学生信息
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);

			return "/students/attendance/attendance_add";
		}
		boolean result = attendancesService.addAttendance(attendances);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listAttendances(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadAttendance(Integer attendanceid,Model model) {
		
		// 查询所有考勤信息
		Attendances attendanceInfo = attendancesService.getAttendance(attendanceid);
		model.addAttribute("attendanceInfo", attendanceInfo);
		// 查询所有学期信息
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		// 查询所有班级信息
		List<Classes> listOfClasses =classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		// 查询所有课程信息
		List<Course> listOfCourses =coursesService.getCoursesList(null);
		model.addAttribute("listOfCourses", listOfCourses);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/attendance/attendance_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteAttendance(Attendances attendances, Model model) throws Exception {
		
		boolean result =attendancesService.deleteAttendance(attendances.getAttendanceid());
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listAttendances(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateAttendance(@Validated Attendances attendances, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// 查询所有考勤信息
			Attendances attendanceInfo = attendancesService.getAttendance(attendances.getAttendanceid());
			model.addAttribute("attendanceInfo", attendanceInfo);
			// 查询所有学期信息
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			// 查询所有班级信息
			List<Classes> listOfClasses =classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			// 查询所有课程信息
			List<Course> listOfCourses =coursesService.getCoursesList(null);
			model.addAttribute("listOfCourses", listOfCourses);
			// 查询所有学生信息
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);
			
			return "/students/attendance/attendance_update";
		}
		
		boolean result=attendancesService.updateAttendance(attendances);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
		model.addAttribute("info", "修改失败");
		}
		return this.listAttendances(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadAttendance(Integer attendanceid, Model model) {
		
		// 查询所有考勤信息
		Attendances attendanceInfo = attendancesService.getAttendance(attendanceid);
		model.addAttribute("attendanceInfo", attendanceInfo);
		// 查询所有学期信息
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		// 查询所有班级信息
		List<Classes> listOfClasses =classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		// 查询所有课程信息
		List<Course> listOfCourses =coursesService.getCoursesList(null);
		model.addAttribute("listOfCourses", listOfCourses);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/attendance/attendance_update";
	}
	
	@RequestMapping("show.action")
	public String showAttendance(Integer attendanceid, Model model) {
		
		Attendances attendanceInfo = attendancesService.getAttendance(attendanceid);
		model.addAttribute("attendanceInfo", attendanceInfo);
		
	return "/students/attendance/attendance_show";
	}
}
