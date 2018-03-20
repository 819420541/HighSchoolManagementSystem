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

import com.xusihan.highschoolmanagementsystem.database.service.ProjectsService;
import com.xusihan.highschoolmanagementsystem.po.Projects;

@Controller
@RequestMapping("/database/projects")
public class ProjectsController {

	@Resource(name = "projectsServiceImpl")
	private ProjectsService projectsService;
	
	@RequestMapping("list.action")
	private String listProjects(Projects projects, Model model) {
		List<Projects> list = projectsService.getProjectsList(projects);
		model.addAttribute("list",list);
		return "database/projects/projects_list";
	}
	
	@RequestMapping("add.action")
	public String addProject(@Validated Projects projects, BindingResult bindingResult, 
			Model model) throws ParseException{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("projects", projects);
			return "database/projects/projects_add";
		}
		projects.setProjectstate(1);
		boolean result = projectsService.addProject(projects);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listProjects(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadProject(Integer projectid,Model model) {
		Projects projectsInfo = projectsService.getProjects(projectid);
		model.addAttribute("projects", projectsInfo);
		
		return "database/projects/projects_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteProject(Projects projects, Model model) {
	    
		//将状态设置为 0   代表无效
		projects.setProjectstate(0);
		
		boolean result =projectsService.updateProject(projects);
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listProjects(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateProject(@Validated Projects projects, BindingResult bindingResult, 
			Model model) throws ParseException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			model.addAttribute("projects", projects);
			return "database/schools/schools_update";
		}
		
		boolean result=projectsService.updateProject(projects);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
		model.addAttribute("info", "修改失败");
		}
		return this.listProjects(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadProject(Integer projectid, Model model) {
		
		Projects projectsInfo =projectsService.getProjects(projectid);
		model.addAttribute("projects", projectsInfo);
		
		return "database/projects/projects_update";
	}
	
	@RequestMapping("show.action")
	public String showProject(Integer projectid, Model model) {
		
		Projects projectInfo = projectsService.getProjects(projectid);
		model.addAttribute("projects", projectInfo);
		
	return "database/projects/projects_show";
	}
}
