package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Classes;

public interface ClassesService {

	/**
	 * addClass:添加班级信息
	 * @param classes
	 * @return
	 */
	public boolean addClass(Classes classes);
	
	/**
	 * deleteClass:删除班级信息
	 * @param classid
	 * @return
	 */
	public boolean deleteClass(Integer classid);
	
	/**
	 * updateClass:更新班级信息
	 * @param classes
	 * @return
	 */
	public boolean updateClass(Classes classes);

	/**
	 * getClass:根据班级编号查询班级信息
	 * @param classid
	 * @return
	 */
	public Classes getClass(Integer classid);
	
	/**
	 * getClassesList:根据相关条件查询班级信息
	 * @param classes
	 * @return
	 */
	public List<Classes> getClassesList(Classes classes);
	
}
