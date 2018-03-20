package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Semesters;

public interface SemestersService {
	
	/**
	 * addSemester:添加学期信息
	 * @param semesters
	 * @return
	 */
	public boolean addSemester(Semesters semesters);
	
	/**
	 * deleteSemester：删除学期信息
	 * @param semesterid
	 * @return
	 */
	public boolean deleteSemester(Integer semesterid);
	
	/**
	 * updateSemester：更新学期信息
	 * @param semesters
	 * @return
	 */
	public boolean updateSemester(Semesters semesters);

	/**
	 * getSemesters:根据学期编号查询学期信息
	 * @param semesterid
	 * @return
	 */
	public Semesters getSemesters(Integer semesterid);
	
	/**
	 * getSemestersList:根据相关条件查询学期信息
	 * @param semesters
	 * @return
	 */
	public List<Semesters> getSemestersList(Semesters semesters);
	
	
}
