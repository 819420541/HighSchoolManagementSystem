package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Studentcontact;

public interface StudentcontactService {

	/**
	 * addStudentcontact:添加学生联系方式信息
	 * @param studentcontact
	 * @return
	 */
	public boolean addStudentcontact(Studentcontact studentcontact);
	
	/**
	 * deleteStudentcontact:删除学生联系方式信息
	 * @param studentcontactid
	 * @return
	 */
	public boolean deleteStudentcontact(Integer studentcontactid);
	
	/**
	 * updateStudentcontact:更新学生联系方式数据
	 * @param studentcontact
	 * @return
	 */
	public boolean updateStudentcontact(Studentcontact studentcontact);

	/**
	 * getStudentcontact:根据学生编号查询学生联系方式信息
	 * @param studentcontactid
	 * @return
	 */
	public Studentcontact getStudentcontact(Integer studentcontactid);
	
	/**
	 * getStudentcontactList:根据相关条件查询学生联系方式信息
	 * @param studentcontact
	 * @return
	 */
	public List<Studentcontact> getStudentcontactsList(Studentcontact studentcontact);

}
