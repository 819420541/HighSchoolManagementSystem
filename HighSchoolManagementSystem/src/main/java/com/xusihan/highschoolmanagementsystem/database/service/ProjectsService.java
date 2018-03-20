package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Projects;

public interface ProjectsService {

	/**
	 * addProject:添加项目信息
	 * @param projects
	 * @return
	 */
	public boolean addProject(Projects projects);
	
	/**
	 * deleteProject：删除项目信息
	 * @param semesterid
	 * @return
	 */
	public boolean deleteProject(Integer projectid);
	
	/**
	 * updateSemester：更新项目信息
	 * @param semesters
	 * @return
	 */
	public boolean updateProject(Projects projects);

	/**
	 * getProjects:根据项目编号查询项目信息
	 * @param projectid
	 * @return
	 */
	public Projects getProjects(Integer projectid);
	
	/**
	 * getProjectsList:根据相关条件查询项目信息
	 * @param projects
	 * @return
	 */
	public List<Projects> getProjectsList(Projects projects);
}
