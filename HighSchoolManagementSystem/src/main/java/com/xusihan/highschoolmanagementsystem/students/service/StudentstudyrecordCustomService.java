package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordCustom;

public interface StudentstudyrecordCustomService {

	/**
	 * getStudentstudyrecordCustom:��ѯѧ����Ϣ
	 * @param studentstudyrecordid
	 * @return
	 */
	public StudentstudyrecordCustom getStudentstudyrecordCustom(Integer studentstudyrecordid);
	
	/**
	 * getStudentstudyrecordCustomList:��ѯѧ����Ϣ
	 * @param studentstudyrecordCustom
	 * @return
	 */
	public List<StudentstudyrecordCustom> getStudentstudyrecordCustomList(StudentstudyrecordCustom studentstudyrecordCustom);

}
