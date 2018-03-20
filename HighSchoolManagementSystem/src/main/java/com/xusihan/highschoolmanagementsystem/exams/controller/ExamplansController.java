package com.xusihan.highschoolmanagementsystem.exams.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.classes.service.ClassesService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamplansCustomService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamplansService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamsService;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.Examplans;
import com.xusihan.highschoolmanagementsystem.po.ExamplansCustom;
import com.xusihan.highschoolmanagementsystem.po.Exams;

@Controller
@RequestMapping("/exams/plans/")
public class ExamplansController {

	@Resource(name = "examplansServiceImpl")
	private ExamplansService examplansService;
	
	@Resource(name = "examplansCustomServiceImpl")
	private ExamplansCustomService examplansCustomService;
	
	@Resource(name = "examsServiceImpl")
	private ExamsService examsService;
	
	@Resource(name = "classesServiceImpl")
	private ClassesService classesService;
	
	@RequestMapping("list.action")
	private String listExamplans(ExamplansCustom examplansCustom, Model model) throws Exception {
		
		List<ExamplansCustom> list = examplansCustomService.getExamplansCustomList(examplansCustom);
		model.addAttribute("list", list);
		return "exams/plans/examplans_list";
	}
	
	@RequestMapping("add.action")
	private String addExamplan(@Validated Examplans examplans, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有考试安排信息
			model.addAttribute("examplansInfo", examplans);
			// 查询所有考试信息
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// 查询所有班级信息
			List<Classes> listOfClasses = classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			
			return "exams/plans/examplans_add";
		}
		examplans.setExamplanstate(1);
		boolean result = examplansService.addExamplan(examplans);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listExamplans(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadExamplan(Integer examplanid,Model model) {
		// 查询所有考试安排信息
		Examplans examplansInfo =examplansService.getExamplans(examplanid);
		model.addAttribute("examplansInfo", examplansInfo);
		// 查询所有考试信息
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// 查询所有班级信息
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		return "exams/plans/examplans_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteExamplan(Examplans examplans, Model model) throws Exception {
	    
		//将状态设置为 0   代表无效
		examplans.setExamplanstate(0);
		
		boolean result =examplansService.updateExamplan(examplans);
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listExamplans(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateExamplan(@Validated Examplans examplans, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// 查询所有考试安排信息
			model.addAttribute("examplansInfo", examplans);
			// 查询所有考试信息
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// 查询所有班级信息
			List<Classes> listOfClasses = classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			
			return "exams/plans/examplans_update";
		}
		
		boolean result=examplansService.updateExamplan(examplans);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		return this.listExamplans(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadExamplan(Integer examplanid, Model model) {
		
		// 查询所有考试安排信息
		Examplans examplansInfo =examplansService.getExamplans(examplanid);
		model.addAttribute("examplansInfo", examplansInfo);
		// 查询所有考试信息
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// 查询所有班级信息
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		
		return "exams/plans/examplans_update";
	}
	
	@RequestMapping("show.action")
	public String showExamplan(Integer examplanid, Model model) {
		
		// 查询所有考试安排信息
		Examplans examplansInfo =examplansService.getExamplans(examplanid);
		model.addAttribute("examplansInfo", examplansInfo);
		// 查询所有考试信息
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// 查询所有班级信息
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
				
		return "exams/plans/examplans_show";
	}
}
