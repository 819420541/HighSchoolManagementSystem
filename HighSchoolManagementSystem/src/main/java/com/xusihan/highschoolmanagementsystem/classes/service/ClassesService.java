package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Classes;

public interface ClassesService {

	/**
	 * addClass:��Ӱ༶��Ϣ
	 * @param classes
	 * @return
	 */
	public boolean addClass(Classes classes);
	
	/**
	 * deleteClass:ɾ���༶��Ϣ
	 * @param classid
	 * @return
	 */
	public boolean deleteClass(Integer classid);
	
	/**
	 * updateClass:���°༶��Ϣ
	 * @param classes
	 * @return
	 */
	public boolean updateClass(Classes classes);

	/**
	 * getClass:���ݰ༶��Ų�ѯ�༶��Ϣ
	 * @param classid
	 * @return
	 */
	public Classes getClass(Integer classid);
	
	/**
	 * getClassesList:�������������ѯ�༶��Ϣ
	 * @param classes
	 * @return
	 */
	public List<Classes> getClassesList(Classes classes);
	
}
