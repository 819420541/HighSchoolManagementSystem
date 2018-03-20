package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ClassesCustom;

public interface ClassesCustomService {

	/**
	 * getClassCustom:��ѯ�γ���Ϣ
	 * @param courseid
	 * @return
	 */
	public ClassesCustom getClassCustom(Integer classid);
	
	/**
	 * getClassesCustomList:��ѯ�γ���Ϣ
	 * @param classesCustom
	 * @return
	 */
	public List<ClassesCustom> getClassesCustomList(ClassesCustom classesCustom);

}
