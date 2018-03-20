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

import com.xusihan.highschoolmanagementsystem.database.service.CoursebooksService;
import com.xusihan.highschoolmanagementsystem.po.Coursebooks;


@Controller
@RequestMapping("/database/coursebooks/")
public class CoursebooksController {
	
	@Resource(name = "coursebooksServiceImpl")
	private CoursebooksService coursebooksService;
	
	@RequestMapping("list.action")
	private String listCoursebooks(Coursebooks coursebooks, Model model) {
		
		List<Coursebooks> list = coursebooksService.getCoursebookList(coursebooks);
		model.addAttribute("list",list);
		return "database/coursebooks/coursebooks_list";
	}
	
	@RequestMapping("add.action")
	public String addCoursebook(@Validated Coursebooks coursebooks, BindingResult bindingResult, 
			Model model) throws ParseException{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("coursebooks", coursebooks);
			return "database/coursebooks/coursebooks_add";
		}
		coursebooks.setCoursebookstate(1);
		boolean result = coursebooksService.addCoursebook(coursebooks);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listCoursebooks(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadCoursebook(Integer coursebookid,Model model) {
		Coursebooks coursebooksInfo =coursebooksService.getCoursebooks(coursebookid);
		model.addAttribute("coursebooks", coursebooksInfo);
		
		return "database/coursebooks/coursebooks_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteCoursebook(Coursebooks coursebooks, Model model) {
	    
		//将状态设置为 0   代表无效
		coursebooks.setCoursebookstate(0);
		
		boolean result =coursebooksService.updateCoursebook(coursebooks);
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listCoursebooks(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateCoursebook(@Validated Coursebooks coursebooks, BindingResult bindingResult, 
			Model model) throws ParseException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("coursebooks", coursebooks);
			return "database/coursebooks/coursebooks_update";
		}
		
		boolean result=coursebooksService.updateCoursebook(coursebooks);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
		model.addAttribute("info", "修改失败");
		}
		return this.listCoursebooks(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadCoursebook(Integer coursebookid, Model model) {
		
		Coursebooks coursebooksInfo =coursebooksService.getCoursebooks(coursebookid);
		model.addAttribute("coursebooks", coursebooksInfo);
		
		return "database/coursebooks/coursebooks_update";
	}
	
	@RequestMapping("show.action")
	public String showCoursebook(Integer coursebookid, Model model) {
		
		Coursebooks coursebooksInfo = coursebooksService.getCoursebooks(coursebookid);
		model.addAttribute("coursebooks", coursebooksInfo);
		
	return "database/coursebooks/coursebooks_show";
	}
	
}
