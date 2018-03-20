package com.xusihan.highschoolmanagementsystem.exams.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsCustomService;
import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamplansService;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamsService;
import com.xusihan.highschoolmanagementsystem.po.Achievements;
import com.xusihan.highschoolmanagementsystem.po.AchievementsCustom;
import com.xusihan.highschoolmanagementsystem.po.Examplans;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseService;

@Controller
@RequestMapping("/exams/achievements/")
public class AchievementsController {

	@Resource(name = "achievementsServiceImpl")
	private AchievementsService achievementsService;

	@Resource(name = "achievementsCustomServiceImpl")
	private AchievementsCustomService achievementsCustomService;
	
	@Resource(name = "examplansServiceImpl")
	private ExamplansService examplansService;
	
	@Resource(name = "examsServiceImpl")
	private ExamsService examsService;
	
	@Resource(name = "studentsbaseServiceImpl")
	private StudentsbaseService studentsbaseService;
	
	@RequestMapping("list.action")
	private String listAchievements(AchievementsCustom achievementsCustom, Model model) throws Exception {
		
		List<AchievementsCustom> list = achievementsCustomService.getAchievementsCustomList(achievementsCustom);
		model.addAttribute("list", list);
		return "exams/achievements/achievements_list";
	}
	
	@RequestMapping("add.action")
	private String addAchievement(@Validated Achievements achievements, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// 查询所有成绩信息
			model.addAttribute("achievementInfo", achievements);
			// 查询所有考试安排信息
			List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
			model.addAttribute("listOfExamplans", listOfExamplans);
			// 查询所有考试信息
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// 查询所有班级信息
			List<Studentsbase> listOfStudents = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudents", listOfStudents);
			
			return "exams/achievements/achievements_add";
		}
		boolean result = achievementsService.addAchievement(achievements);
		if(result) {
			model.addAttribute("info", "添加成功");
		}else {
			model.addAttribute("info","添加失败");
		}
		return this.listAchievements(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadAchievement(Integer achievementid,Model model) {
		// 查询所有成绩信息
		Achievements achievementInfo =achievementsService.getAchievement(achievementid);
		model.addAttribute("achievementInfo", achievementInfo);
		// 查询所有考试安排信息
		List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
		model.addAttribute("listOfExamplans", listOfExamplans);
		// 查询所有考试信息
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// 查询所有班级信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		return "exams/achievements/achievements_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteAchievement(Achievements achievements, Model model) throws Exception {
	    
		boolean result =achievementsService.deleteAchievement(achievements.getAchievementid());
		if(result) {
		    model.addAttribute("info", "删除成功");
		}else {
		    model.addAttribute("info", "删除失败");
		}
		return this.listAchievements(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateAchievement(@Validated Achievements achievements, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			// 查询所有成绩信息
			model.addAttribute("achievementInfo", achievements);
			// 查询所有考试安排信息
			List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
			model.addAttribute("listOfExamplans", listOfExamplans);
			// 查询所有考试信息
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// 查询所有班级信息
			List<Studentsbase> listOfStudents = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudents", listOfStudents);
			
			return "exams/achievements/achievements_update";
		}
		
		boolean result=achievementsService.updateAchievement(achievements);
		if(result) {
		    model.addAttribute("info", "修改成功");
		}else {
			model.addAttribute("info", "修改失败");
		}
		return this.listAchievements(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadAchievement(Integer achievementid, Model model) {
		
		// 查询所有成绩信息
		Achievements achievementInfo =achievementsService.getAchievement(achievementid);
		model.addAttribute("achievementInfo", achievementInfo);
		// 查询所有考试安排信息
		List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
		model.addAttribute("listOfExamplans", listOfExamplans);
		// 查询所有考试信息
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// 查询所有班级信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "exams/achievements/achievements_update";
	}
	
	@RequestMapping("show.action")
	public String showAchievement(Integer achievementid, Model model) {
		
		// 查询所有成绩信息
		Achievements achievementsInfo =achievementsService.getAchievement(achievementid);
		model.addAttribute("achievementsInfo", achievementsInfo);
		// 查询所有考试安排信息
		List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
		model.addAttribute("listOfExamplans", listOfExamplans);
		// 查询所有考试信息
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// 查询所有班级信息
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
				
		return "exams/achievements/achievements_show";
	}
}
