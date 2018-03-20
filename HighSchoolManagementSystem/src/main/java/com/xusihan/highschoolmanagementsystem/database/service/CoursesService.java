package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Course;
import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;

public interface CoursesService {
	
	/**
	 * addCourse:添加课程信息
	 * @param course
	 * @return
	 */
	public boolean addCourse(Course course);
	
	/**
	 * deleteCourse:删除课程信息
	 * @param courseid
	 * @return
	 */
	public boolean deleteCourse(Integer courseid);
	
	/**
	 * updateCourse:更新课程数据
	 * @param course
	 * @return
	 */
	public boolean updateCourse(Course course);

	/**
	 * getCourses:根据课程编号查询课程信息
	 * @param courseid
	 * @return
	 */
	public Course getCourses(Integer courseid);
	
	/**
	 * getCoursesList:根据相关条件查询课程信息
	 * @param course
	 * @return
	 */
	public List<Course> getCoursesList(Course course);
	
	/**
	 * findCoursesCustomList: 查询课程关联信息
	 * @param coursesCustom
	 * @return
	 */
	public List<CoursesCustom> findCoursesCustomList(CoursesCustom coursesCustom) throws Exception;

}
