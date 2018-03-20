package com.xusihan.highschoolmanagementsystem.database.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.ProjectsMapper;
import com.xusihan.highschoolmanagementsystem.database.service.ProjectsService;
import com.xusihan.highschoolmanagementsystem.po.Projects;
import com.xusihan.highschoolmanagementsystem.po.ProjectsExample;
import com.xusihan.highschoolmanagementsystem.po.ProjectsExample.Criteria;

@Service("projectsServiceImpl")
public class ProjectsServiceImpl implements ProjectsService {

	@Resource(name = "projectsMapper")
	private ProjectsMapper projectsMapper;
	
	@Override
	public boolean addProject(Projects projects) {

		try {
			int i =projectsMapper.insertSelective(projects);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteProject(Integer projectid) {

		try {
			int i = projectsMapper.deleteByPrimaryKey(projectid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateProject(Projects projects) {

		try {
			int i = projectsMapper.updateByPrimaryKeySelective(projects);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Projects getProjects(Integer projectid) {

		return projectsMapper.selectByPrimaryKey(projectid);
	}

	@Override
	public List<Projects> getProjectsList(Projects projects) {

		ProjectsExample projectsExample = new ProjectsExample();
		Criteria criteria = projectsExample.createCriteria();
		
		// 查询所有正常的项目的数据： 1：正常 ;0：删除.
		criteria.andProjectstateEqualTo(1);
		
		if(projects!=null) {
			//根据项目编号查询
			if(projects.getProjectid()!=null) {
				criteria.andProjectidEqualTo(projects.getProjectid());
			}
			
			//根据项目名称查询
			if(projects.getProjectname()!=null) {
				projects.setProjectname("%"+projects.getProjectname()+"%");
				criteria.andProjectnameLike(projects.getProjectname());
			}
		}
		
		return projectsMapper.selectByExample(projectsExample);
	}

}
