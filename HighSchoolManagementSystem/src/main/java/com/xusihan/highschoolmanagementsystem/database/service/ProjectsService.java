package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Projects;

public interface ProjectsService {

	/**
	 * addProject:�����Ŀ��Ϣ
	 * @param projects
	 * @return
	 */
	public boolean addProject(Projects projects);
	
	/**
	 * deleteProject��ɾ����Ŀ��Ϣ
	 * @param semesterid
	 * @return
	 */
	public boolean deleteProject(Integer projectid);
	
	/**
	 * updateSemester��������Ŀ��Ϣ
	 * @param semesters
	 * @return
	 */
	public boolean updateProject(Projects projects);

	/**
	 * getProjects:������Ŀ��Ų�ѯ��Ŀ��Ϣ
	 * @param projectid
	 * @return
	 */
	public Projects getProjects(Integer projectid);
	
	/**
	 * getProjectsList:�������������ѯ��Ŀ��Ϣ
	 * @param projects
	 * @return
	 */
	public List<Projects> getProjectsList(Projects projects);
}
