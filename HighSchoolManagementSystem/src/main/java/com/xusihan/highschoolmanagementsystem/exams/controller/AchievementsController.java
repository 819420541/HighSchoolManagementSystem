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

			// ��ѯ���гɼ���Ϣ
			model.addAttribute("achievementInfo", achievements);
			// ��ѯ���п��԰�����Ϣ
			List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
			model.addAttribute("listOfExamplans", listOfExamplans);
			// ��ѯ���п�����Ϣ
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// ��ѯ���а༶��Ϣ
			List<Studentsbase> listOfStudents = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudents", listOfStudents);
			
			return "exams/achievements/achievements_add";
		}
		boolean result = achievementsService.addAchievement(achievements);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listAchievements(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadAchievement(Integer achievementid,Model model) {
		// ��ѯ���гɼ���Ϣ
		Achievements achievementInfo =achievementsService.getAchievement(achievementid);
		model.addAttribute("achievementInfo", achievementInfo);
		// ��ѯ���п��԰�����Ϣ
		List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
		model.addAttribute("listOfExamplans", listOfExamplans);
		// ��ѯ���п�����Ϣ
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// ��ѯ���а༶��Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		return "exams/achievements/achievements_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteAchievement(Achievements achievements, Model model) throws Exception {
	    
		boolean result =achievementsService.deleteAchievement(achievements.getAchievementid());
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listAchievements(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateAchievement(@Validated Achievements achievements, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			// ��ѯ���гɼ���Ϣ
			model.addAttribute("achievementInfo", achievements);
			// ��ѯ���п��԰�����Ϣ
			List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
			model.addAttribute("listOfExamplans", listOfExamplans);
			// ��ѯ���п�����Ϣ
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// ��ѯ���а༶��Ϣ
			List<Studentsbase> listOfStudents = studentsbaseService.getStudentsbaseList(null);
			model.addAttribute("listOfStudents", listOfStudents);
			
			return "exams/achievements/achievements_update";
		}
		
		boolean result=achievementsService.updateAchievement(achievements);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listAchievements(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadAchievement(Integer achievementid, Model model) {
		
		// ��ѯ���гɼ���Ϣ
		Achievements achievementInfo =achievementsService.getAchievement(achievementid);
		model.addAttribute("achievementInfo", achievementInfo);
		// ��ѯ���п��԰�����Ϣ
		List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
		model.addAttribute("listOfExamplans", listOfExamplans);
		// ��ѯ���п�����Ϣ
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// ��ѯ���а༶��Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
		
		return "exams/achievements/achievements_update";
	}
	
	@RequestMapping("show.action")
	public String showAchievement(Integer achievementid, Model model) {
		
		// ��ѯ���гɼ���Ϣ
		Achievements achievementsInfo =achievementsService.getAchievement(achievementid);
		model.addAttribute("achievementsInfo", achievementsInfo);
		// ��ѯ���п��԰�����Ϣ
		List<Examplans> listOfExamplans = examplansService.getExamplanList(null);
		model.addAttribute("listOfExamplans", listOfExamplans);
		// ��ѯ���п�����Ϣ
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// ��ѯ���а༶��Ϣ
		List<Studentsbase> listOfStudentsbase = studentsbaseService.getStudentsbaseList(null);
		model.addAttribute("listOfStudentsbase", listOfStudentsbase);
				
		return "exams/achievements/achievements_show";
	}
}
