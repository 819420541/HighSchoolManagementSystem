package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ClassesCustom;

public interface ClassesCustomService {

	/**
	 * getClassCustom:查询课程信息
	 * @param courseid
	 * @return
	 */
	public ClassesCustom getClassCustom(Integer classid);
	
	/**
	 * getClassesCustomList:查询课程信息
	 * @param classesCustom
	 * @return
	 */
	public List<ClassesCustom> getClassesCustomList(ClassesCustom classesCustom);

}
