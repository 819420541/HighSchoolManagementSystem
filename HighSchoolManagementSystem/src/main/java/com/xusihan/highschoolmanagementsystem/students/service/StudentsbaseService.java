package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Studentsbase;

public interface StudentsbaseService {

	/**
	 * addStudent:添加学生基础信息
	 * @param studentsbase
	 * @return
	 */
	public boolean addStudentsbase(Studentsbase studentsbase);
	
	/**
	 * deleteStudent:删除学生基础信息
	 * @param studentid
	 * @return
	 */
	public boolean deleteStudentsbase(Integer studentid);
	
	/**
	 * updateStudent:更新学生基础数据
	 * @param studentsbase
	 * @return
	 */
	public boolean updateStudentsbase(Studentsbase studentsbase);

	/**
	 * getStudent:根据学生编号查询学生基础信息
	 * @param studentid
	 * @return
	 */
	public Studentsbase getStudentsbase(Integer studentid);
	
	/**
	 * getStudentsbaseList:根据相关条件查询学生基础信息
	 * @param studentsbase
	 * @return
	 */
	public List<Studentsbase> getStudentsbaseList(Studentsbase studentsbase);

	public Integer getStudentsbaseMaxId();
}
