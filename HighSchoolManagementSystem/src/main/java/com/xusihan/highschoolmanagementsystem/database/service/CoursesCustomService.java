package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;

public interface CoursesCustomService {

	/**
	 * getCoursesCustom:查询课程信息
	 * @param courseid
	 * @return
	 */
	public CoursesCustom getCoursesCustom(Integer courseid);
	
	/**
	 * getCoursesCustomList:查询课程信息
	 * @param coursesCustom
	 * @return
	 */
	public List<CoursesCustom> getCoursesCustomList(CoursesCustom coursesCustom);
	
}
