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

import com.xusihan.highschoolmanagementsystem.database.service.SchoolsService;
import com.xusihan.highschoolmanagementsystem.po.Schools;

@Controller
@RequestMapping("/database/schools/")
public class SchoolsController {
	
	@Resource(name = "schoolsServiceImpl")
	private SchoolsService schoolsService;

	@RequestMapping("list.action")
	private String listSchools(Schools schools, Model model) {
		
		List<Schools> list = schoolsService.getSchoolsList(schools);
		model.addAttribute("list",list);
		return "database/schools/schools_list";
	}
	
	@RequestMapping("add.action")
	public String addSchool(@Validated Schools schools, BindingResult bindingResult, 
			Model model) throws ParseException{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("schools", schools);
			return "database/schools/schools_add";
		}
		schools.setSchoolstate(1);
		boolean result = schoolsService.addSchool(schools);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listSchools(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadSchool(Integer schoolid,Model model) {
		Schools schoolsInfo =schoolsService.getSchools(schoolid);
		model.addAttribute("schools", schoolsInfo);
		
		return "database/schools/schools_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteSchool(Schools schools, Model model) {
	    
		//将状态设置为 0   代表无效
		schools.setSchoolstate(0);
		
		boolean result =schoolsService.updateSchool(schools);
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listSchools(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateSchool(@Validated Schools schools, BindingResult bindingResult, 
			Model model) throws ParseException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("schools", schools);
			return "database/schools/schools_update";
		}
		
		boolean result=schoolsService.updateSchool(schools);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
		model.addAttribute("info", "修改失败");
		}
		return this.listSchools(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadSchool(Integer schoolid, Model model) {
		
		Schools schoolsInfo =schoolsService.getSchools(schoolid);
		model.addAttribute("schools", schoolsInfo);
		
		return "database/schools/schools_update";
	}
	
	@RequestMapping("show.action")
	public String showSchool(Integer schoolid, Model model) {
		
		Schools schoolsInfo = schoolsService.getSchools(schoolid);
		model.addAttribute("schools", schoolsInfo);
		
	return "database/schools/schools_show";
	}
}
