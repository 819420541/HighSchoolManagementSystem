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
import com.xusihan.highschoolmanagementsystem.database.service.SemestersService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamsCustomService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamsService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamtypesService;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsCustom;
import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.Semesters;

@Controller
@RequestMapping("/exams/exams")
public class ExamsController {

	@Resource(name = "examsServiceImpl")
	private ExamsService examsService;
	
	@Resource(name = "examsCustomServiceImpl")
	private ExamsCustomService examsCustomService;
	
	@Resource(name = "examtypesServiceImpl")
	private ExamtypesService examtypesService;
	
	@Resource(name = "schoolsServiceImpl")
	private SchoolsService schoolsService;
	
	@Resource(name = "semestersServiceImpl")
	private SemestersService semestersService;
	
	@RequestMapping("list.action")
	private String listExams(ExamsCustom examsCustom, Model model) {
		List<ExamsCustom> list = examsCustomService.getExamsCustomList(examsCustom);
		model.addAttribute("list", list);
		return "exams/exams/exams_list";
	}
	
	@RequestMapping("add.action")
	public String addExam(@Validated Exams exams, BindingResult bindingResult, 
			Model model) throws ParseException{
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			// 查询所有考试信息
			model.addAttribute("examInfo", exams);
			// 查询所有类型信息
			List<Examtypes> listOfExamtypes = examtypesService.getExamtypesList(null);
			model.addAttribute("listOfExamtypes", listOfExamtypes);
			// 查询所有学校信息
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// 查询所有学校信息
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			
			return "exams/exams/exams_add";
		}
		exams.setExamstate(1);
		boolean result = examsService.addExam(exams);
		if(result) {
			model.addAttribute("info","添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listExams(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadExam(Integer examid,Model model) {
		// 查询所有考试信息
		Exams examsInfo = examsService.getExam(examid);
		model.addAttribute("examsInfo", examsInfo);
		// 查询所有类型信息
		List<Examtypes> listOfExamtypes = examtypesService.getExamtypesList(null);
		model.addAttribute("listOfExamtypes", listOfExamtypes);
		// 查询所有学校信息
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// 查询所有学校信息
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
					
		return "exams/exams/exams_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteExam(Exams exams, Model model) {
	    
		//将状态设置为 0   代表无效
		exams.setExamstate(0);
		
		boolean result =examsService.updateExam(exams);
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listExams(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateExam(@Validated Exams exams, BindingResult bindingResult, 
			Model model) throws ParseException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			// 查询所有考试信息
			Exams examInfo = examsService.getExam(exams.getExamid());
			model.addAttribute("examInfo", examInfo);
			// 查询所有类型信息
			List<Examtypes> listOfExamtypes = examtypesService.getExamtypesList(null);
			model.addAttribute("listOfExamtypes", listOfExamtypes);
			// 查询所有学校信息
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// 查询所有学校信息
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			
			return "exams/exams/exams_update";
		}
		
		boolean result=examsService.updateExam(exams);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		return this.listExams(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadExam(Integer examid, Model model) {
		
		// 查询所有考试信息
		Exams examInfo = examsService.getExam(examid);
		model.addAttribute("examInfo", examInfo);
		// 查询所有类型信息
		List<Examtypes> listOfExamtypes = examtypesService.getExamtypesList(null);
		model.addAttribute("listOfExamtypes", listOfExamtypes);
		// 查询所有学校信息
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// 查询所有学校信息
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		
		return "exams/exams/exams_update";
	}
	
	@RequestMapping("show.action")
	public String showExam(Integer examid, Model model) {
		
		Exams examtypeInfo = examsService.getExam(examid);
		model.addAttribute("exams", examtypeInfo);
		
		// 查询所有学校信息
		List<Examtypes> listOfExamtypes = examtypesService.getExamtypesList(null);
		model.addAttribute("listOfExamtypes", listOfExamtypes);
		// 查询所有学校信息
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// 查询所有学校信息
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		
		return "exams/exams/exams_show";
	}
}
