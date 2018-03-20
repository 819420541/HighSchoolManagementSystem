package com.xusihan.highschoolmanagementsystem.database.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.database.service.SemestersService;
import com.xusihan.highschoolmanagementsystem.po.Semesters;

@Controller
@RequestMapping("/database/semesters")
public class SemestersController {
	
	@Resource(name = "semestersServiceImpl")
	private SemestersService semestersService;
	
	@RequestMapping("list.action")
	private String listSemesters(Semesters semesters, Model model) {
		List<Semesters> list = semestersService.getSemestersList(semesters);
		model.addAttribute("list",list);
		return "database/semesters/semesters_list";
	}
	
	@RequestMapping("add.action")
	public String addSemester(@Validated Semesters semesters, BindingResult bindingResult, 
			Model model) throws ParseException{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("semesters", semesters);
			return "database/semesters/semesters_add";
		}
		semesters.setSemesterstate(1);
		boolean result = semestersService.addSemester(semesters);
		if(result) {
			model.addAttribute("info","��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listSemesters(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadSemester(Integer semesterid,Model model) {
		Semesters semestersInfo = semestersService.getSemesters(semesterid);
		model.addAttribute("semesters", semestersInfo);
		
		return "database/semesters/semesters_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteSemester(Semesters semesters, Model model) {
	    
		//��״̬����Ϊ 0   ������Ч
		semesters.setSemesterstate(0);
		
		boolean result =semestersService.updateSemester(semesters);
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listSemesters(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateSemester(@Validated Semesters semesters, BindingResult bindingResult, 
			Model model) throws ParseException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("semesters", semesters);
			return "database/schools/schools_update";
		}
		
		boolean result=semestersService.updateSemester(semesters);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
		model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listSemesters(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadSemester(Integer semesterid, Model model) {
		
		Semesters semestersInfo =semestersService.getSemesters(semesterid);
		model.addAttribute("semesters", semestersInfo);
		
		return "database/semesters/semesters_update";
	}
	
	@RequestMapping("show.action")
	public String showSemester(Integer semesterid, Model model) {
		
		Semesters semesterInfo = semestersService.getSemesters(semesterid);
		model.addAttribute("semesters", semesterInfo);
		
	return "database/semesters/semesters_show";
	}
}
