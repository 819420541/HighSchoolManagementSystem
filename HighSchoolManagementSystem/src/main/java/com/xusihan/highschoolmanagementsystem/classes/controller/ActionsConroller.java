package com.xusihan.highschoolmanagementsystem.classes.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.classes.service.ActionsCustomService;
import com.xusihan.highschoolmanagementsystem.classes.service.ActionsService;
import com.xusihan.highschoolmanagementsystem.classes.service.ClassesService;
import com.xusihan.highschoolmanagementsystem.po.Actions;
import com.xusihan.highschoolmanagementsystem.po.ActionsCustom;
import com.xusihan.highschoolmanagementsystem.po.Classes;

@Controller
@RequestMapping("/classes/academic")
public class ActionsConroller {

	@Resource(name = "actionsServiceImpl")
	private ActionsService actionsService;
	
	@Resource(name = "actionsCustomServiceImpl")
	private ActionsCustomService actionsCustomService;
	
	@Resource(name = "classesServiceImpl")
	private ClassesService classesService;
	
	@RequestMapping("list.action")
	private String listActions(ActionsCustom actionsCustom, Model model) throws Exception {
		
		List<ActionsCustom> list = actionsCustomService.getActionsCustomList(actionsCustom);
		model.addAttribute("list", list);
		return "classes/academic/academic_list";
	}
	
	@RequestMapping("add.action")
	private String addAction(@Validated Actions actions, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有活动信息
			Actions actionInfo = actionsService.getAction(actions.getActionid());
			model.addAttribute("actionInfo", actionInfo);
			// 查询所有班级信息
			List<Classes> listOfClasses = classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);

			return "classes/classes/classes_add";
		}
		boolean result = actionsService.addAction(actions);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listActions(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadAction(Integer actionid,Model model) {
		
		// 查询所有活动信息
		Actions actionInfo = actionsService.getAction(actionid);
		model.addAttribute("actionInfo", actionInfo);
		// 查询所有班级信息
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		
		return "classes/academic/academic_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteAction(Actions actions, Model model) throws Exception {
		
		boolean result =actionsService.deleteAction(actions.getActionid());
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listActions(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateAction(@Validated Actions actions, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// 查询所有活动信息
			Actions actionInfo = actionsService.getAction(actions.getActionid());
			model.addAttribute("actionInfo", actionInfo);
			// 查询所有班级信息
			List<Classes> listOfClasses = classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			
			return "classes/academic/academic_update";
		}
		
		boolean result = actionsService.updateAction(actions);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
		model.addAttribute("info", "修改失败");
		}
		return this.listActions(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadAction(Integer actionid, Model model) {
		
		// 查询所有活动信息
		Actions actionInfo = actionsService.getAction(actionid);
		model.addAttribute("actionInfo", actionInfo);
		// 查询所有班级信息
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		
		return "classes/academic/academic_update";
	}
	
	@RequestMapping("show.action")
	public String showAction(Integer actionid, Model model) {
		
		Actions actionInfo = actionsService.getAction(actionid);
		model.addAttribute("actionInfo", actionInfo);
		
		// 查询所有班级信息
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
				
		return "classes/academic/academic_show";
	}
}
