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
import com.xusihan.highschoolmanagementsystem.database.service.SchoolsService;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.Studentcontact;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseCustom;
import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;
import com.xusihan.highschoolmanagementsystem.students.service.StudentcontactService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseCustomService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentstudyrecordService;

@Controller
@RequestMapping("/students/archives")
public class StudentsbaseController {

	@Resource(name = "studentsbaseServiceImpl")
	private StudentsbaseService studentsbaseService;
	
	@Resource(name = "studentsbaseCustomServiceImpl")
	private StudentsbaseCustomService studentsbaseCustomService;
	
	@Resource(name = "schoolsServiceImpl")
	private SchoolsService schoolsService;
	
	@Resource(name = "classesServiceImpl")
	private ClassesService classesService;
	
	@Resource(name = "studentcontactServiceImpl")
	private StudentcontactService studentcontactService;
	
	@Resource(name = "studentstudyrecordServiceImpl")
	private StudentstudyrecordService studentstudyrecordService;
	
	@RequestMapping("list.action")
	private String listStudentsbase(StudentsbaseCustom studentsbaseCustom, Model model) throws Exception {
		
		List<StudentsbaseCustom> list = studentsbaseCustomService.getStudentsbaseCustomList(studentsbaseCustom);
		model.addAttribute("list", list);
		return "/students/archives/archives_list";
	}
	
	@RequestMapping("add.action")
	private String addStudentsbase(@Validated Studentsbase studentsbase, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有学生信息
			Studentsbase studentsbaseInfo = studentsbaseService.getStudentsbase(studentsbase.getStudentid());
			model.addAttribute("studentsbaseInfo", studentsbaseInfo);
			// 查询所有学校信息
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// 查询所有班级信息
			List<Classes> listOfClasses =classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			
			return "/students/archives/archives_add";
		}
		studentsbase.setStudentstate(1);
		boolean resultOfStudentsbase = studentsbaseService.addStudentsbase(studentsbase);
		
		Studentcontact studentcontact = new Studentcontact();
		studentcontact.setStudentid(studentsbaseService.getStudentsbaseMaxId());
		boolean resultOfStudentcontact = studentcontactService.addStudentcontact(studentcontact);
		
		Studentstudyrecord studentstudyrecord = new Studentstudyrecord();
		studentstudyrecord.setStudentid(studentsbaseService.getStudentsbaseMaxId());
		boolean resultOfStudentstudyrecord = studentstudyrecordService.addStudentstudyrecord(studentstudyrecord);
		
		boolean result = resultOfStudentsbase && resultOfStudentcontact && resultOfStudentstudyrecord;
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listStudentsbase(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadStudentsbase(Integer studentid,Model model) {
		
		// 查询所有学生信息
		Studentsbase studentsbaseInfo = studentsbaseService.getStudentsbase(studentid);
		model.addAttribute("studentsbaseInfo", studentsbaseInfo);
		// 查询所有学校信息
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// 查询所有班级信息
		List<Classes> listOfClasses =classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		
		return "/students/archives/archives_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteStudentsbase(Studentsbase studentsbase, Model model) throws Exception {
	    
		//将状态设置为 0   代表无效
		studentsbase.setStudentstate(0);
		
		boolean result =studentsbaseService.updateStudentsbase(studentsbase);
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listStudentsbase(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateStudentsbase(@Validated Studentsbase studentsbase, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// 查询所有学生信息
			Studentsbase studentsbaseInfo = studentsbaseService.getStudentsbase(studentsbase.getStudentid());
			model.addAttribute("studentsbaseInfo", studentsbaseInfo);
			// 查询所有学校信息
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// 查询所有班级信息
			List<Classes> listOfClasses =classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			
			return "/students/archives/archives_update";
		}
		
		boolean result=studentsbaseService.updateStudentsbase(studentsbase);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		return this.listStudentsbase(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadStudentsbase(Integer studentid, Model model) {
		
		// 查询所有学生信息
		Studentsbase studentsbaseInfo = studentsbaseService.getStudentsbase(studentid);
		model.addAttribute("studentsbaseInfo", studentsbaseInfo);
		// 查询所有学校信息
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// 查询所有班级信息
		List<Classes> listOfClasses =classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		
		return "/students/archives/archives_update";
	}
	
	@RequestMapping("show.action")
	public String showStudentsbase(Integer studentid, Model model) {
		
		Studentsbase studentsbaseInfo = studentsbaseService.getStudentsbase(studentid);
		model.addAttribute("studentsbaseInfo", studentsbaseInfo);
		
		return "/students/archives/archives_show";
	}
}
