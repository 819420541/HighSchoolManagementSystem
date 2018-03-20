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

			// ��ѯ���п��԰�����Ϣ
			model.addAttribute("examplansInfo", examplans);
			// ��ѯ���п�����Ϣ
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// ��ѯ���а༶��Ϣ
			List<Classes> listOfClasses = classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			
			return "exams/plans/examplans_add";
		}
		examplans.setExamplanstate(1);
		boolean result = examplansService.addExamplan(examplans);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listExamplans(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadExamplan(Integer examplanid,Model model) {
		// ��ѯ���п��԰�����Ϣ
		Examplans examplansInfo =examplansService.getExamplans(examplanid);
		model.addAttribute("examplansInfo", examplansInfo);
		// ��ѯ���п�����Ϣ
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// ��ѯ���а༶��Ϣ
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		return "exams/plans/examplans_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteExamplan(Examplans examplans, Model model) throws Exception {
	    
		//��״̬����Ϊ 0   ������Ч
		examplans.setExamplanstate(0);
		
		boolean result =examplansService.updateExamplan(examplans);
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listExamplans(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateExamplan(@Validated Examplans examplans, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// ��ѯ���п��԰�����Ϣ
			model.addAttribute("examplansInfo", examplans);
			// ��ѯ���п�����Ϣ
			List<Exams> listOfExams = examsService.getExamsList(null);
			model.addAttribute("listOfExams", listOfExams);
			// ��ѯ���а༶��Ϣ
			List<Classes> listOfClasses = classesService.getClassesList(null);
			model.addAttribute("listOfClasses", listOfClasses);
			
			return "exams/plans/examplans_update";
		}
		
		boolean result=examplansService.updateExamplan(examplans);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listExamplans(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadExamplan(Integer examplanid, Model model) {
		
		// ��ѯ���п��԰�����Ϣ
		Examplans examplansInfo =examplansService.getExamplans(examplanid);
		model.addAttribute("examplansInfo", examplansInfo);
		// ��ѯ���п�����Ϣ
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// ��ѯ���а༶��Ϣ
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
		
		return "exams/plans/examplans_update";
	}
	
	@RequestMapping("show.action")
	public String showExamplan(Integer examplanid, Model model) {
		
		// ��ѯ���п��԰�����Ϣ
		Examplans examplansInfo =examplansService.getExamplans(examplanid);
		model.addAttribute("examplansInfo", examplansInfo);
		// ��ѯ���п�����Ϣ
		List<Exams> listOfExams = examsService.getExamsList(null);
		model.addAttribute("listOfExams", listOfExams);
		// ��ѯ���а༶��Ϣ
		List<Classes> listOfClasses = classesService.getClassesList(null);
		model.addAttribute("listOfClasses", listOfClasses);
				
		return "exams/plans/examplans_show";
	}
}
