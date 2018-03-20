package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.CoursesCustom;

public interface CoursesCustomService {

	/**
	 * getCoursesCustom:��ѯ�γ���Ϣ
	 * @param courseid
	 * @return
	 */
	public CoursesCustom getCoursesCustom(Integer courseid);
	
	/**
	 * getCoursesCustomList:��ѯ�γ���Ϣ
	 * @param coursesCustom
	 * @return
	 */
	public List<CoursesCustom> getCoursesCustomList(CoursesCustom coursesCustom);
	
}
