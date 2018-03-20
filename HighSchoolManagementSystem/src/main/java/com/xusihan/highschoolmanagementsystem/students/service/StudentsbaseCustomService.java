package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.StudentsbaseCustom;

public interface StudentsbaseCustomService {

	/**
	 * getStudentsbaseCustom:��ѯѧ����Ϣ
	 * @param studentid
	 * @return
	 */
	public StudentsbaseCustom getStudentsbaseCustom(Integer studentid);
	
	/**
	 * getStudentsbaseCustomList:��ѯѧ����Ϣ
	 * @param studentsbaseCustom
	 * @return
	 */
	public List<StudentsbaseCustom> getStudentsbaseCustomList(StudentsbaseCustom studentsbaseCustom);

}
