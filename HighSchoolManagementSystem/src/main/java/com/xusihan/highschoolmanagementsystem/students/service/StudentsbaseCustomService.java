package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.StudentsbaseCustom;

public interface StudentsbaseCustomService {

	/**
	 * getStudentsbaseCustom:查询学生信息
	 * @param studentid
	 * @return
	 */
	public StudentsbaseCustom getStudentsbaseCustom(Integer studentid);
	
	/**
	 * getStudentsbaseCustomList:查询学生信息
	 * @param studentsbaseCustom
	 * @return
	 */
	public List<StudentsbaseCustom> getStudentsbaseCustomList(StudentsbaseCustom studentsbaseCustom);

}
