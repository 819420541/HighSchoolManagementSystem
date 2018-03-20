package com.xusihan.highschoolmanagementsystem.students.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;
import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordCustom;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.students.service.StudentstudyrecordCustomService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentstudyrecordService;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseService;

@Controller
@RequestMapping("/students/studyrecord")
public class StudentstudyrecordController {

	@Resource(name = "studentstudyrecordServiceImpl")
	private StudentstudyrecordService studentstudyrecordService;
	
	@Resource(name = "studentstudyrecordCustomServiceImpl")
	private StudentstudyrecordCustomService studentstudyrecordCustomService;
	
	@Resource(name = "studentsbaseServiceImpl")
	private StudentsbaseService studentsbaseService;
	
	@RequestMapping("list.action")
	private String listStudentstudyrecord(StudentstudyrecordCustom studentstudyrecordCustom, Model model) throws Exception {
		
		List<StudentstudyrecordCustom> list = studentstudyrecordCustomService.getStudentstudyrecordCustomList(studentstudyrecordCustom);
		model.addAttribute("list", list);
		return "/students/studyrecord/studyrecord_list";
	}
	
	@RequestMapping("add.action")
	private String addStudentstudyrecord(@Validated Studentstudyrecord studentstudyrecord, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有联系信息
			Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecord.getStudyrecordid());
			model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
			// 查询所有学生信息
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);

			
			return "/students/studyrecord/studyrecord_add";
		}
		boolean result = studentstudyrecordService.addStudentstudyrecord(studentstudyrecord);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listStudentstudyrecord(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadStudentstudyrecord(Integer studentstudyrecordid,Model model) {
		
		// 查询所有联系信息
		Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecordid);
		model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/studyrecord/studyrecord_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteStudentstudyrecord(Studentstudyrecord studentstudyrecord, Model model) throws Exception {
	    
		boolean result =studentstudyrecordService.deleteStudentstudyrecord(studentstudyrecord.getStudyrecordid());
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listStudentstudyrecord(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateStudentstudyrecord(@Validated Studentstudyrecord studentstudyrecord, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// 查询所有联系信息
			model.addAttribute("studentstudyrecordInfo", studentstudyrecord);
			// 查询所有学生信息
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);
			
			return "/students/studyrecord/studyrecord_update";
		}
		boolean result=studentstudyrecordService.updateStudentstudyrecord(studentstudyrecord);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		return this.listStudentstudyrecord(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadStudentstudyrecord(Integer studentstudyrecordid, Model model) {
		
		// 查询所有联系信息
		Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecordid);
		model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/studyrecord/studyrecord_update";
	}
	
	@RequestMapping("show.action")
	public String showStudentstudyrecord(Integer studentstudyrecordid, Model model) {
		System.out.println(studentstudyrecordid);
		// 查询所有联系信息
		Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecordid);
		model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
		// 查询所有学生信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/studyrecord/studyrecord_show";
	}
}
