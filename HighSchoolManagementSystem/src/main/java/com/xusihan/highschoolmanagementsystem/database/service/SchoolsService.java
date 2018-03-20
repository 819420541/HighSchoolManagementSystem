package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Schools;

public interface SchoolsService {

	/**
	 * addSchool:添加学校信息
	 * @param schools
	 * @return
	 */
	public boolean addSchool(Schools schools);
	
	/**
	 * deleteSchool:删除学校信息
	 * @param schoolid
	 * @return
	 */
	public boolean deleteSchool(Integer schoolid);
	
	/**
	 * updateSchool:更新学校数据
	 * @param schools
	 * @return
	 */
	public boolean updateSchool(Schools schools);

	/**
	 * getSchools:根据学校编号查询学校信息
	 * @param schoolid
	 * @return
	 */
	public Schools getSchools(Integer schoolid);
	
	/**
	 * getSchoolsList:根据相关条件查询学校信息
	 * @param schools
	 * @return
	 */
	public List<Schools> getSchoolsList(Schools schools);
	
}
