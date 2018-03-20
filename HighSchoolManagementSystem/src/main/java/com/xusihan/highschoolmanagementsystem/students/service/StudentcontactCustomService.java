package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.StudentcontactCustom;

public interface StudentcontactCustomService {

	/**
	 * getStudentscontactCustom:查询学生信息
	 * @param studentcontactid
	 * @return
	 */
	public StudentcontactCustom getStudentcontactCustom(Integer studentcontactid);
	
	/**
	 * getStudentscontactCustomList:查询学生信息
	 * @param studentscontactCustom
	 * @return
	 */
	public List<StudentcontactCustom> getStudentcontactCustomList(StudentcontactCustom studentcontactCustom);

}
