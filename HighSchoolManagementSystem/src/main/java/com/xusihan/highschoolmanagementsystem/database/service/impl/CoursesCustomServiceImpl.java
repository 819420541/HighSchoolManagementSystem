package com.xusihan.highschoolmanagementsystem.database.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.CourseMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.CoursebooksMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.SemestersMapper;
import com.xusihan.highschoolmanagementsystem.database.service.CoursesCustomService;
import com.xusihan.highschoolmanagementsystem.po.Course;
import com.xusihan.highschoolmanagementsystem.po.CourseExample;
import com.xusihan.highschoolmanagementsystem.po.CourseExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Coursebooks;
import com.xusihan.highschoolmanagementsystem.po.CoursebooksExample;
import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.Semesters;

@Service("coursesCustomServiceImpl")
public class CoursesCustomServiceImpl implements CoursesCustomService{

	@Resource(name = "courseMapper")
	private CourseMapper courseMapper;
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;
	
	@Resource(name = "semestersMapper")
	private SemestersMapper semestersMapper;
	
	@Resource(name = "coursebooksMapper")
	private CoursebooksMapper coursebooksMapper;
	
	@Override
	public CoursesCustom getCoursesCustom(Integer courseid) {
		
		// ��Ҫ��װ������
		CoursesCustom coursesCustom = new CoursesCustom();
		
		// ��ѯ��γ̱�����Ӧ�Ŀγ���Ϣ����װ
		Course courses = courseMapper.selectByPrimaryKey(courseid);
		coursesCustom.setCourse(courses);
		
		// ��ѯ��ѧУ������Ӧ��ѧУ���Ʋ���װ
		Integer schoolId = courses.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		coursesCustom.setSchoolname(schoolName);
		
		// ��ѯ��ѧ�ڱ�����Ӧ��ѧ�����Ʋ���װ
		Integer semesterId = courses.getSemesterid();
		Semesters semesterInfo = semestersMapper.selectByPrimaryKey(semesterId);
		String semesterName = semesterInfo.getSemestername();
		coursesCustom.setSemestername(semesterName);
		
		// ��ѯ��̲ı�����Ӧ�Ľ̲����Ʋ���װ
		Integer courseBookId = courses.getCoursebookid();
		Coursebooks coursebookInfo = coursebooksMapper.selectByPrimaryKey(courseBookId);
		String courseBookName = coursebookInfo.getCoursebookname();
		coursesCustom.setCoursebookname(courseBookName);
		
		return coursesCustom;
	}

	@Override
	public List<CoursesCustom> getCoursesCustomList(CoursesCustom coursesCustom) {
		
		CourseExample courseExample = new CourseExample();
		Criteria criteriaOfCourses = courseExample.createCriteria();
		criteriaOfCourses.andCoursestateEqualTo(1);
		//ͨ��������ѯ���������Ľ̲���Ϣ
		CoursebooksExample coursebooksExample = new CoursebooksExample();
		com.xusihan.highschoolmanagementsystem.po.CoursebooksExample.Criteria criteriaOfCoursebooks = coursebooksExample.createCriteria();
		criteriaOfCoursebooks.andCoursebookstateEqualTo(1);
		if(coursesCustom!=null) {
			// ģ����ѯ�̲�����
			if(coursesCustom.getCoursebookname()!= null && !coursesCustom.getCoursebookname().equals("") ) {
				// ͨ��ģ����ѯ����÷��������Ľ̲ı��
				coursesCustom.setCoursebookname("%"+coursesCustom.getCoursebookname()+"%");
				criteriaOfCoursebooks.andCoursebooknameLike(coursesCustom.getCoursebookname());
				List<Coursebooks> listOfCoursebooks = coursebooksMapper.selectByExample(coursebooksExample);
				// ��ѯ�õ��Ľ̲���Ϣ��Ӧ�Ľ̲ı��
				List<Integer> listOfCourseBookIds = new ArrayList<>();
				for(Coursebooks coursebooks:listOfCoursebooks) {
					listOfCourseBookIds.add(coursebooks.getCoursebookid());
				}
				
				if(listOfCourseBookIds.isEmpty()) {
					return null;
				}else {
					criteriaOfCourses.andCoursebookidIn(listOfCourseBookIds);
				}
			}
			if(coursesCustom.getCourse()!=null) {
				
				// ��ѯ�̲ı��
				if(coursesCustom.getCourse().getCoursebookid()!=null ) {
					criteriaOfCourses.andCoursebookidEqualTo(coursesCustom.getCourse().getCoursebookid());
				}
				
				// ��ѯ�γ̱��
				if(coursesCustom.getCourse().getCourseid()!= null ) {
					criteriaOfCourses.andCourseidEqualTo(coursesCustom.getCourse().getCourseid());
				}
				
				// ��ѯ�γ�����
				if(coursesCustom.getCourse().getCoursename()!=null && !coursesCustom.getCourse().getCoursename().equals("")) {
					coursesCustom.getCourse().setCoursename("%"+coursesCustom.getCourse().getCoursename()+"%");
					criteriaOfCourses.andCoursenameLike(coursesCustom.getCourse().getCoursename());
				}
			}
		}
		// ��ѯ���������Ŀγ���Ϣ
		List<Course> listOfCourses = courseMapper.selectByExample(courseExample);
		if(listOfCourses!=null) {
			List<CoursesCustom> listOfCoursesCustom = new ArrayList<>();
			for(Course coursesList:listOfCourses) {
				CoursesCustom coursesCustomInfo = this.getCoursesCustom(coursesList.getCourseid());
				listOfCoursesCustom.add(coursesCustomInfo);
			}
			return listOfCoursesCustom;
		}else {
			return null;
		}
		
	}

}
