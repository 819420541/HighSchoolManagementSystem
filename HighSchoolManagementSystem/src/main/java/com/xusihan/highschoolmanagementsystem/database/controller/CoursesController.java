package com.xusihan.highschoolmanagementsystem.database.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xusihan.highschoolmanagementsystem.database.service.CoursebooksService;
import com.xusihan.highschoolmanagementsystem.database.service.CoursesCustomService;
import com.xusihan.highschoolmanagementsystem.database.service.CoursesService;
import com.xusihan.highschoolmanagementsystem.database.service.SchoolsService;
import com.xusihan.highschoolmanagementsystem.database.service.SemestersService;
import com.xusihan.highschoolmanagementsystem.po.Course;
import com.xusihan.highschoolmanagementsystem.po.Coursebooks;
import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.Semesters;

@Controller
@RequestMapping("/database/courses/")
public class CoursesController {

	@Resource(name = "coursesServiceImpl")
	private CoursesService coursesService;
	
	@Resource(name = "coursesCustomServiceImpl")
	private CoursesCustomService coursesCustomService;
	
	@Resource(name = "schoolsServiceImpl")
	private SchoolsService schoolsService;
	
	@Resource(name = "semestersServiceImpl")
	private SemestersService semestersService;
	
	@Resource(name = "coursebooksServiceImpl")
	private CoursebooksService coursebooksService;
	
	
	@RequestMapping("list.action")
	private String listCourses(CoursesCustom coursesCustom, Model model) throws Exception {
		
		List<CoursesCustom> list = coursesCustomService.getCoursesCustomList(coursesCustom);
		model.addAttribute("list", list);
		return "database/courses/courses_list";
	}
	
	@RequestMapping("add.action")
	private String addCourse(@Validated Course courses, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);

			// ��ѯ���пγ���Ϣ
			Course coursesInfo =coursesService.getCourses(courses.getCourseid());
			model.addAttribute("courses", coursesInfo);
			// ��ѯ����ѧУ��Ϣ
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// ��ѯ����ѧ����Ϣ
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			// ��ѯ���еĽ̲���Ϣ
			List<Coursebooks> listOfCourseBooks = coursebooksService.getCoursebookList(null);
			model.addAttribute("listOfCourseBooks", listOfCourseBooks);
			
			return "database/courses/courses_add";
		}
		courses.setCoursestate(1);
		boolean result = coursesService.addCourse(courses);
		if(result) {
			model.addAttribute("info", "��ӳɹ�");
		}else {
			model.addAttribute("info","���ʧ��");
		}
		return this.listCourses(null, model);
	}
	
	@RequestMapping("addLoad.action")
	public String addLoadCourse(Integer courseid,Model model) {
		// ��ѯ���пγ���Ϣ
		Course coursesInfo =coursesService.getCourses(courseid);
		model.addAttribute("courses", coursesInfo);
		// ��ѯ����ѧУ��Ϣ
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// ��ѯ����ѧ����Ϣ
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		// ��ѯ���н̲���Ϣ
		List<Coursebooks> listOfCoursebooks = coursebooksService.getCoursebookList(null);
		model.addAttribute("listOfCoursebooks", listOfCoursebooks);
		return "database/courses/courses_add";
	}
	
	@RequestMapping("delete.action")
	public String deleteCourse(Course courses, Model model) throws Exception {
	    
		//��״̬����Ϊ 0   ������Ч
		courses.setCoursestate(0);
		
		boolean result =coursesService.updateCourse(courses);
		if(result) {
		    model.addAttribute("info", "ɾ���ɹ�");
		}else {
		    model.addAttribute("info", "ɾ��ʧ��");
		}
		return this.listCourses(null, model);
	}
	
	@RequestMapping("update.action")
	public String updateCourse(@Validated Course courses, BindingResult bindingResult, 
			Model model) throws Exception {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			
			// ��ѯ���пγ���Ϣ
			Course coursesInfo =coursesService.getCourses(courses.getCourseid());
			model.addAttribute("courses", coursesInfo);
			// ��ѯ����ѧУ��Ϣ
			List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
			model.addAttribute("listOfSchools", listOfSchools);
			// ��ѯ����ѧ����Ϣ
			List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
			model.addAttribute("listOfSemesters", listOfSemesters);
			// ��ѯ���н̲���Ϣ
			List<Coursebooks> listOfCoursebooks = coursebooksService.getCoursebookList(null);
			model.addAttribute("listOfCoursebooks", listOfCoursebooks);
			
			return "database/courses/courses_update";
		}
		
		boolean result=coursesService.updateCourse(courses);
		if(result) {
		    model.addAttribute("info", "�޸ĳɹ�");
		}else {
			model.addAttribute("info", "�޸�ʧ��");
		}
		return this.listCourses(null, model);
	}
	
	@RequestMapping("updateLoad.action")
	public String updateLoadCourse(Integer courseid, Model model) {
		
		Course coursesInfo =coursesService.getCourses(courseid);
		model.addAttribute("courses", coursesInfo);
		// ��ѯ����ѧ����Ϣ
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// ��ѯ����ѧ����Ϣ
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		// ��ѯ���н̲���Ϣ
		List<Coursebooks> listOfCoursebooks = coursebooksService.getCoursebookList(null);
		model.addAttribute("listOfCoursebooks", listOfCoursebooks);
		
		
		return "database/courses/courses_update";
	}
	
	@RequestMapping("show.action")
	public String showCourse(Integer courseid, Model model) {
		
		Course coursesInfo =coursesService.getCourses(courseid);
		model.addAttribute("courses", coursesInfo);
		// ��ѯ����ѧ����Ϣ
		List<Schools> listOfSchools = schoolsService.getSchoolsList(null);
		model.addAttribute("listOfSchools", listOfSchools);
		// ��ѯ����ѧ����Ϣ
		List<Semesters> listOfSemesters = semestersService.getSemestersList(null);
		model.addAttribute("listOfSemesters", listOfSemesters);
		// ��ѯ���н̲���Ϣ
		List<Coursebooks> listOfCoursebooks = coursebooksService.getCoursebookList(null);
		model.addAttribute("listOfCoursebooks", listOfCoursebooks);
		
		return "database/courses/courses_show";
	}
}
