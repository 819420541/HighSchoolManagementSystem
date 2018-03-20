package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.StudentcontactCustom;

public interface StudentcontactCustomService {

	/**
	 * getStudentscontactCustom:��ѯѧ����Ϣ
	 * @param studentcontactid
	 * @return
	 */
	public StudentcontactCustom getStudentcontactCustom(Integer studentcontactid);
	
	/**
	 * getStudentscontactCustomList:��ѯѧ����Ϣ
	 * @param studentscontactCustom
	 * @return
	 */
	public List<StudentcontactCustom> getStudentcontactCustomList(StudentcontactCustom studentcontactCustom);

}
