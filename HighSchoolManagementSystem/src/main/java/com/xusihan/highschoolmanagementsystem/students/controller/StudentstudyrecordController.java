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

			// ��ѯ������ϵ��Ϣ
			Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecord.getStudyrecordid());
			model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
			// ��ѯ����ѧ����Ϣ
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);

			
			return "/students/studyrecord/studyrecord_add";
		}
		boolean result = studentstudyrecordService.addStudentstudyrecord(studentstudyrecord);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listStudentstudyrecord(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadStudentstudyrecord(Integer studentstudyrecordid,Model model) {
		
		// ��ѯ������ϵ��Ϣ
		Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecordid);
		model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
		// ��ѯ����ѧ����Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/studyrecord/studyrecord_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteStudentstudyrecord(Studentstudyrecord studentstudyrecord, Model model) throws Exception {
	    
		boolean result =studentstudyrecordService.deleteStudentstudyrecord(studentstudyrecord.getStudyrecordid());
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listStudentstudyrecord(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateStudentstudyrecord(@Validated Studentstudyrecord studentstudyrecord, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// ��ѯ������ϵ��Ϣ
			model.addAttribute("studentstudyrecordInfo", studentstudyrecord);
			// ��ѯ����ѧ����Ϣ
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);
			
			return "/students/studyrecord/studyrecord_update";
		}
		boolean result=studentstudyrecordService.updateStudentstudyrecord(studentstudyrecord);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listStudentstudyrecord(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadStudentstudyrecord(Integer studentstudyrecordid, Model model) {
		
		// ��ѯ������ϵ��Ϣ
		Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecordid);
		model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
		// ��ѯ����ѧ����Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/studyrecord/studyrecord_update";
	}
	
	@RequestMapping("show.action")
	public String showStudentstudyrecord(Integer studentstudyrecordid, Model model) {
		System.out.println(studentstudyrecordid);
		// ��ѯ������ϵ��Ϣ
		Studentstudyrecord studentstudyrecordInfo = studentstudyrecordService.getStudentstudyrecord(studentstudyrecordid);
		model.addAttribute("studentstudyrecordInfo", studentstudyrecordInfo);
		// ��ѯ����ѧ����Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/studyrecord/studyrecord_show";
	}
}
