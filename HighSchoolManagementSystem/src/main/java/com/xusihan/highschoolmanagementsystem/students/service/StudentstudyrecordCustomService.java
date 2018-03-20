package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordCustom;

public interface StudentstudyrecordCustomService {

	/**
	 * getStudentstudyrecordCustom:查询学历信息
	 * @param studentstudyrecordid
	 * @return
	 */
	public StudentstudyrecordCustom getStudentstudyrecordCustom(Integer studentstudyrecordid);
	
	/**
	 * getStudentstudyrecordCustomList:查询学历信息
	 * @param studentstudyrecordCustom
	 * @return
	 */
	public List<StudentstudyrecordCustom> getStudentstudyrecordCustomList(StudentstudyrecordCustom studentstudyrecordCustom);

}
