package com.xusihan.highschoolmanagementsystem.exams.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.database.service.SchoolsService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamtypesCustomService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamtypesService;
import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesCustom;
import com.xusihan.highschoolmanagementsystem.po.Schools;

@Controller
@RequestMapping("/exams/types")
public class ExamtypesController {

	@Resource(name = "examtypesServiceImpl")
	private ExamtypesService examtypesService;
	
	@Resource(name = "examtypesCustomServiceImpl")
	private ExamtypesCustomService examtypesCustomService;
	
	@Resource(name = "schoolsServiceImpl")
	private SchoolsService schoolsService;
	
	@RequestMapping("list.action")
	private String listExamtypes(ExamtypesCustom examtypesCustom, Model model) {
		List<ExamtypesCustom> list = examtypesCustomService.getExamtypesCustomList(examtypesCustom);
		model.addAttribute("list",list);
		return "exams/types/examtypes_list";
	}
	
	@RequestMapping("add.action")
	public String addExamtype(@Validated Examtypes examtypes, BindingResult bindingResult, 
			Model model) throws ParseException{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			// ��ѯ���п���������Ϣ
			model.addAttribute("examtypes", examtypes);
			
			// ��ѯ����ѧУ��Ϣ
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			return "exams/types/examtypes_add";
		}
		examtypes.setExamtypestate(1);
		boolean result = examtypesService.addExamtype(examtypes);
		if(result) {
			model.addAttribute("info","��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listExamtypes(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadExamtype(Integer examtypeid,Model model) {
		
		Examtypes examtypesInfo = examtypesService.getExamtype(examtypeid);
		model.addAttribute("examtypesInfo", examtypesInfo);
		
		// ��ѯ����ѧУ��Ϣ
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		return "exams/types/examtypes_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteExamtype(Examtypes examtypes, Model model) {
	    
		//��״̬����Ϊ 0   ������Ч
		examtypes.setExamtypestate(0);
		
		boolean result =examtypesService.updateExamtype(examtypes);
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listExamtypes(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateExamtype(@Validated Examtypes examtypes, BindingResult bindingResult, 
			Model model) throws ParseException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("examtypes", examtypes);
			
			// ��ѯ����ѧУ��Ϣ
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			
			return "exams/types/examstypes_update";
		}
		
		boolean result=examtypesService.updateExamtype(examtypes);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
		model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listExamtypes(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadExamtype(Integer examtypeid, Model model) {
		
		Examtypes examtypesInfo =examtypesService.getExamtype(examtypeid);
		model.addAttribute("examtypesInfo", examtypesInfo);
		
		// ��ѯ����ѧУ��Ϣ
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		
		return "exams/types/examtypes_update";
	}
	
	@RequestMapping("show.action")
	public String showExamtype(Integer examtypeid, Model model) {
		
		Examtypes examtypeInfo = examtypesService.getExamtype(examtypeid);
		model.addAttribute("examtypes", examtypeInfo);
		
	return "exams/types/examtypes_show";
	}
}
