package com.xusihan.highschoolmanagementsystem.database.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.CourseMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.CoursesCustomMapper;
import com.xusihan.highschoolmanagementsystem.database.service.CoursesService;
import com.xusihan.highschoolmanagementsystem.po.Course;
import com.xusihan.highschoolmanagementsystem.po.CourseExample;
import com.xusihan.highschoolmanagementsystem.po.CourseExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;

@Service("coursesServiceImpl")
public class CoursesServiceImpl implements CoursesService {

	@Resource(name = "courseMapper")
	private CourseMapper coursesMapper;
	
	@Resource(name = "coursesCustomMapper")
	private CoursesCustomMapper coursesCustomMapper;
	
	@Override
	public boolean addCourse(Course course) {

		try {
			int i =coursesMapper.insertSelective(course);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteCourse(Integer courseid) {

		try {
			int i = coursesMapper.deleteByPrimaryKey(courseid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateCourse(Course course) {
		
		try {
			int i = coursesMapper.updateByPrimaryKeySelective(course);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Course getCourses(Integer courseid) {
		
		return coursesMapper.selectByPrimaryKey(courseid);
	}

	@Override
	public List<Course> getCoursesList(Course course) {
		
		CourseExample courseExample = new CourseExample();
		Criteria criteria = courseExample.createCriteria();
		// 查询所有正常的学校的数据： 1：正常 ;0：删除.
		criteria.andCoursestateEqualTo(1);
		
		if(course!=null) {
			//根据学校编号查询
			if(course.getSchoolid()!=null) {
				criteria.andCourseidEqualTo(course.getSchoolid());
			}
			
		}
		return coursesMapper.selectByExample(courseExample);
	}

	@Override
	public List<CoursesCustom> findCoursesCustomList(CoursesCustom coursesCustom) throws Exception {
		if(coursesCustom != null) {
			return coursesCustomMapper.findCoursesCustomList(null);
		}else {
			return coursesCustomMapper.findCoursesCustomList(coursesCustom);
		}
	}

	
}
