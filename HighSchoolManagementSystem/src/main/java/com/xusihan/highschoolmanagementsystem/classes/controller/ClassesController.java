package com.xusihan.highschoolmanagementsystem.classes.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.classes.service.ClassesCustomService;
import com.xusihan.highschoolmanagementsystem.classes.service.ClassesService;
import com.xusihan.highschoolmanagementsystem.database.service.SchoolsService;
import com.xusihan.highschoolmanagementsystem.database.service.SemestersService;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesCustom;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.Semesters;

@Controller
@RequestMapping("/classes/classes")
public class ClassesController {

	@Resource(name = "classesServiceImpl")
	private ClassesService classesService;
	
	@Resource(name = "classesCustomServiceImpl")
	private ClassesCustomService classesCustomService;
	
	@Resource(name = "schoolsServiceImpl")
	private SchoolsService schoolsService;
	
	@Resource(name = "semestersServiceImpl")
	private SemestersService semestersService;
	
	@RequestMapping("list.action")
	private String listClasses(ClassesCustom classesCustom, Model model) throws Exception {
		
		List<ClassesCustom> list = classesCustomService.getClassesCustomList(classesCustom);
		model.addAttribute("list", list);
		return "classes/classes/classes_list";
	}
	
	@RequestMapping("add.action")
	private String addCourse(@Validated Classes classes, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// ��ѯ���а༶��Ϣ
			Classes classInfo = classesService.getClass(classes.getClassid());
			model.addAttribute("classInfo", classInfo);
			// ��ѯ����ѧУ��Ϣ
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// ��ѯ����ѧ����Ϣ
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			
			return "classes/classes/classes_add";
		}
		classes.setClassstate(1);
		boolean result = classesService.addClass(classes);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listClasses(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadClass(Integer classid,Model model) {
		// ��ѯ���а༶��Ϣ
		Classes classInfo =classesService.getClass(classid);
		model.addAttribute("classInfo", classInfo);
		// ��ѯ����ѧ����Ϣ
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// ��ѯ����ѧ����Ϣ
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		
		return "classes/classes/classes_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteClass(Classes classes, Model model) throws Exception {
	    
		//��״̬����Ϊ 0   ������Ч
		classes.setClassstate(0);
		
		boolean result =classesService.updateClass(classes);
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listClasses(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateClass(@Validated Classes classes, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// ��ѯ���а༶��Ϣ
			Classes classInfo =classesService.getClass(classes.getClassid());
			model.addAttribute("classInfo", classInfo);
			// ��ѯ����ѧ����Ϣ
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// ��ѯ����ѧ����Ϣ
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			
			return "classes/classes/classes_update";
		}
		
		boolean result=classesService.updateClass(classes);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
		model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listClasses(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadClass(Integer classid, Model model) {
		
		// ��ѯ���а༶��Ϣ
		Classes classInfo =classesService.getClass(classid);
		model.addAttribute("classInfo", classInfo);
		// ��ѯ����ѧ����Ϣ
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// ��ѯ����ѧ����Ϣ
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		
		return "classes/classes/classes_update";
	}
	
	@RequestMapping("show.action")
	public String showClass(Integer classid, Model model) {
		
		Classes classInfo = classesService.getClass(classid);
		model.addAttribute("classInfo", classInfo);
		
	return "classes/classes/classes_show";
	}
}
