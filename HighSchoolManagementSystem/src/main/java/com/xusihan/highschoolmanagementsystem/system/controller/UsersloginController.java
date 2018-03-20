package com.xusihan.highschoolmanagementsystem.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.po.Userslogin;
import com.xusihan.highschoolmanagementsystem.system.service.UsersloginService;

@Controller
@RequestMapping("/system/usersInfo")
public class UsersloginController {

	@Resource(name = "usersloginServiceImpl")
	private UsersloginService usersloginService;
	
	@RequestMapping("list.action")
	private String listUserslogin(Userslogin userslogin, Model model) throws Exception {
		
		List<Userslogin> list = usersloginService.getUsersloginList(userslogin);
		model.addAttribute("list", list);
		return "/students/usersInfo/usersInfo_list";
	}
	
	@RequestMapping("add.action")
	private String addUserslogin(@Validated Userslogin userslogin, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有考勤信息
			Userslogin usersloginInfo = usersloginService.getUserslogin(userslogin.getAccount());
			model.addAttribute("usersloginInfo", usersloginInfo);

			return "/students/usersInfo/usersInfo_add";
		}
		boolean result = usersloginService.addUserslogin(userslogin);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listUserslogin(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadUserslogin(String account,Model model) {
		
		// 查询所有考勤信息
		Userslogin usersloginInfo = usersloginService.getUserslogin(account);
		model.addAttribute("usersloginInfo", usersloginInfo);
		
		return "/students/usersInfo/usersInfo_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteUserslogin(Userslogin userslogin, Model model) throws Exception {
		
		boolean result =usersloginService.deleteUserslogin(userslogin.getAccount());
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listUserslogin(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateUserslogin(@Validated Userslogin userslogin, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// 查询所有考勤信息
			Userslogin usersloginInfo = usersloginService.getUserslogin(userslogin.getAccount());
			model.addAttribute("usersloginInfo", usersloginInfo);
			
			
			return "/students/usersInfo/usersInfo_update";
		}
		
		boolean result=usersloginService.updateUserslogin(userslogin);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
		model.addAttribute("info", "修改失败");
		}
		return this.listUserslogin(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadUserslogin(String account, Model model) {
		
		// 查询所有考勤信息
		Userslogin usersloginInfo = usersloginService.getUserslogin(account);
		model.addAttribute("usersloginInfo", usersloginInfo);
		
		return "/students/usersInfo/usersInfo_update";
	}
	
	@RequestMapping("show.action")
	public String showUserslogin(String account, Model model) {
		
		Userslogin usersloginInfo = usersloginService.getUserslogin(account);
		model.addAttribute("usersloginInfo", usersloginInfo);
		
		return "/students/usersInfo/usersInfo_show";
	}
	
	@RequestMapping("check.action")
	public String checkUserslogin(Userslogin userslogin, Model model) {
		String account = userslogin.getAccount();
		String password = userslogin.getPassword();
		String theUserAccount = usersloginService.check(account, password);
		if(theUserAccount == null) {
			return "login";
		}
		return "index";
	}
}
