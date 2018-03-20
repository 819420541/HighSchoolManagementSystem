package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Schools;

public interface SchoolsService {

	/**
	 * addSchool:���ѧУ��Ϣ
	 * @param schools
	 * @return
	 */
	public boolean addSchool(Schools schools);
	
	/**
	 * deleteSchool:ɾ��ѧУ��Ϣ
	 * @param schoolid
	 * @return
	 */
	public boolean deleteSchool(Integer schoolid);
	
	/**
	 * updateSchool:����ѧУ����
	 * @param schools
	 * @return
	 */
	public boolean updateSchool(Schools schools);

	/**
	 * getSchools:����ѧУ��Ų�ѯѧУ��Ϣ
	 * @param schoolid
	 * @return
	 */
	public Schools getSchools(Integer schoolid);
	
	/**
	 * getSchoolsList:�������������ѯѧУ��Ϣ
	 * @param schools
	 * @return
	 */
	public List<Schools> getSchoolsList(Schools schools);
	
}
