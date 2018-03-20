package com.xusihan.highschoolmanagementsystem.students.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.po.Studentcontact;
import com.xusihan.highschoolmanagementsystem.po.StudentcontactCustom;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.students.service.StudentcontactCustomService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentcontactService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseService;

@Controller
@RequestMapping("/students/contact")
public class StudentcontactController {

	@Resource(name = "studentcontactServiceImpl")
	private StudentcontactService studentcontactService;
	
	@Resource(name = "studentcontactCustomServiceImpl")
	private StudentcontactCustomService studentcontactCustomService;
	
	@Resource(name = "studentsbaseServiceImpl")
	private StudentsbaseService studentsbaseService;
	
	@RequestMapping("list.action")
	private String listStudentcontact(StudentcontactCustom studentcontactCustom, Model model) throws Exception {
		
		List<StudentcontactCustom> list = studentcontactCustomService.getStudentcontactCustomList(studentcontactCustom);
		model.addAttribute("list", list);
		return "/students/contact/contact_list";
	}
	
	@RequestMapping("add.action")
	private String addStudentcontact(@Validated Studentcontact studentcontact, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有联系信息
			Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontact.getStudentcontactid());
			model.addAttribute("studentcontactInfo", studentcontactInfo);
			// 查询所有学生信息
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);

			
			return "/students/contact/contact_add";
		}
		boolean result = studentcontactService.addStudentcontact(studentcontact);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listStudentcontact(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadStudentcontact(Integer studentcontactid,Model model) {
		
		// 查询所有联系信息
		Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontactid);
		model.addAttribute("studentcontactInfo", studentcontactInfo);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/contact/contact_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteStudentcontact(Studentcontact studentcontact, Model model) throws Exception {
	    
		boolean result =studentcontactService.deleteStudentcontact(studentcontact.getStudentcontactid());
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listStudentcontact(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateStudentcontact(@Validated Studentcontact studentcontact, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// 查询所有联系信息
			Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontact.getStudentcontactid());
			model.addAttribute("studentcontactInfo", studentcontactInfo);
			// 查询所有学生信息
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);
			
			return "/students/contact/contact_update";
		}
		boolean result=studentcontactService.updateStudentcontact(studentcontact);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		return this.listStudentcontact(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadStudentcontact(Integer studentcontactid, Model model) {
		
		// 查询所有联系信息
		Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontactid);
		model.addAttribute("studentcontactInfo", studentcontactInfo);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/contact/contact_update";
	}
	
	@RequestMapping("show.action")
	public String showStudentcontact(Integer studentcontactid, Model model) {
		
		// 查询所有联系信息
		Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontactid);
		model.addAttribute("studentcontactInfo", studentcontactInfo);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/contact/contact_show";
	}
}
