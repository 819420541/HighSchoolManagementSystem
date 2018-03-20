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
		
		// 需要封装的属性
		CoursesCustom coursesCustom = new CoursesCustom();
		
		// 查询与课程编号相对应的课程信息并封装
		Course courses = courseMapper.selectByPrimaryKey(courseid);
		coursesCustom.setCourse(courses);
		
		// 查询与学校编号相对应的学校名称并封装
		Integer schoolId = courses.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		coursesCustom.setSchoolname(schoolName);
		
		// 查询与学期编号相对应的学期名称并封装
		Integer semesterId = courses.getSemesterid();
		Semesters semesterInfo = semestersMapper.selectByPrimaryKey(semesterId);
		String semesterName = semesterInfo.getSemestername();
		coursesCustom.setSemestername(semesterName);
		
		// 查询与教材编号相对应的教材名称并封装
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
		//通过条件查询符合条件的教材信息
		CoursebooksExample coursebooksExample = new CoursebooksExample();
		com.xusihan.highschoolmanagementsystem.po.CoursebooksExample.Criteria criteriaOfCoursebooks = coursebooksExample.createCriteria();
		criteriaOfCoursebooks.andCoursebookstateEqualTo(1);
		if(coursesCustom!=null) {
			// 模糊查询教材名称
			if(coursesCustom.getCoursebookname()!= null && !coursesCustom.getCoursebookname().equals("") ) {
				// 通过模糊查询来获得符合条件的教材编号
				coursesCustom.setCoursebookname("%"+coursesCustom.getCoursebookname()+"%");
				criteriaOfCoursebooks.andCoursebooknameLike(coursesCustom.getCoursebookname());
				List<Coursebooks> listOfCoursebooks = coursebooksMapper.selectByExample(coursebooksExample);
				// 查询得到的教材信息对应的教材编号
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
				
				// 查询教材编号
				if(coursesCustom.getCourse().getCoursebookid()!=null ) {
					criteriaOfCourses.andCoursebookidEqualTo(coursesCustom.getCourse().getCoursebookid());
				}
				
				// 查询课程编号
				if(coursesCustom.getCourse().getCourseid()!= null ) {
					criteriaOfCourses.andCourseidEqualTo(coursesCustom.getCourse().getCourseid());
				}
				
				// 查询课程名称
				if(coursesCustom.getCourse().getCoursename()!=null && !coursesCustom.getCourse().getCoursename().equals("")) {
					coursesCustom.getCourse().setCoursename("%"+coursesCustom.getCourse().getCoursename()+"%");
					criteriaOfCourses.andCoursenameLike(coursesCustom.getCourse().getCoursename());
				}
			}
		}
		// 查询符合条件的课程信息
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
