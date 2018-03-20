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

			// ��ѯ������ϵ��Ϣ
			Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontact.getStudentcontactid());
			model.addAttribute("studentcontactInfo", studentcontactInfo);
			// ��ѯ����ѧ����Ϣ
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);

			
			return "/students/contact/contact_add";
		}
		boolean result = studentcontactService.addStudentcontact(studentcontact);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listStudentcontact(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadStudentcontact(Integer studentcontactid,Model model) {
		
		// ��ѯ������ϵ��Ϣ
		Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontactid);
		model.addAttribute("studentcontactInfo", studentcontactInfo);
		// ��ѯ����ѧ����Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/contact/contact_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteStudentcontact(Studentcontact studentcontact, Model model) throws Exception {
	    
		boolean result =studentcontactService.deleteStudentcontact(studentcontact.getStudentcontactid());
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listStudentcontact(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateStudentcontact(@Validated Studentcontact studentcontact, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// ��ѯ������ϵ��Ϣ
			Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontact.getStudentcontactid());
			model.addAttribute("studentcontactInfo", studentcontactInfo);
			// ��ѯ����ѧ����Ϣ
			List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudentsbase", listOfStudentsbase);
			
			return "/students/contact/contact_update";
		}
		boolean result=studentcontactService.updateStudentcontact(studentcontact);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listStudentcontact(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadStudentcontact(Integer studentcontactid, Model model) {
		
		// ��ѯ������ϵ��Ϣ
		Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontactid);
		model.addAttribute("studentcontactInfo", studentcontactInfo);
		// ��ѯ����ѧ����Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/contact/contact_update";
	}
	
	@RequestMapping("show.action")
	public String showStudentcontact(Integer studentcontactid, Model model) {
		
		// ��ѯ������ϵ��Ϣ
		Studentcontact studentcontactInfo = studentcontactService.getStudentcontact(studentcontactid);
		model.addAttribute("studentcontactInfo", studentcontactInfo);
		// ��ѯ����ѧ����Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "/students/contact/contact_show";
	}
}
