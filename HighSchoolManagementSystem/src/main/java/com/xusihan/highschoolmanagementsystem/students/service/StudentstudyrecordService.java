package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;

public interface StudentstudyrecordService {


	/**
	 * addStudentstudyrecord:添加学生学历信息
	 * @param studentstudyrecord
	 * @return
	 */
	public boolean addStudentstudyrecord(Studentstudyrecord studentstudyrecord);
	
	/**
	 * deleteStudentstudyrecord:删除学生学历信息
	 * @param studentstudyrecordid
	 * @return
	 */
	public boolean deleteStudentstudyrecord(Integer studentstudyrecordid);
	
	/**
	 * updateStudentstudyrecord:更新学生学历数据
	 * @param studentstudyrecord
	 * @return
	 */
	public boolean updateStudentstudyrecord(Studentstudyrecord studentstudyrecord);

	/**
	 * getStudentstudyrecord:根据学生编号查询学生学历信息
	 * @param studentstudyrecordid
	 * @return
	 */
	public Studentstudyrecord getStudentstudyrecord(Integer studentstudyrecordid);
	
	/**
	 * getStudentstudyrecordList:根据相关条件查询学生学历信息
	 * @param studentstudyrecord
	 * @return
	 */
	public List<Studentstudyrecord> getStudentstudyrecordsList(Studentstudyrecord studentstudyrecord);
}
