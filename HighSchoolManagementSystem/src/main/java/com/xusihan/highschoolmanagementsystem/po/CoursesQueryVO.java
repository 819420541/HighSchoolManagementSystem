package com.xusihan.highschoolmanagementsystem.po;

import java.util.List;

public class CoursesQueryVO {

	/**
	 * 课程信息
	 */
	private Course course;
	
	/**
	 * 对原始的POJO进行扩展
	 */
	private CoursesCustom courseCustom;
	
	private List<CoursesCustom> coursesList;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CoursesCustom getCourseCustom() {
		return courseCustom;
	}

	public void setCourseCustom(CoursesCustom courseCustom) {
		this.courseCustom = courseCustom;
	}

	public List<CoursesCustom> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(List<CoursesCustom> coursesList) {
		this.coursesList = coursesList;
	}
	
}
