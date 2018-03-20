package com.xusihan.highschoolmanagementsystem.database.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.database.service.SchoolsService;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample.Criteria;

@Service("schoolsServiceImpl")
public class SchoolsServiceImpl implements SchoolsService{
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;

	@Override
	public boolean addSchool(Schools schools) {
		
		try {
			int i =schoolsMapper.insertSelective(schools);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteSchool(Integer schoolid) {
		
		try {
			int i = schoolsMapper.deleteByPrimaryKey(schoolid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}
	
	@Override
	public boolean updateSchool(Schools schools) {
		
		try {
			int i = schoolsMapper.updateByPrimaryKeySelective(schools);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}
	
	@Override
	public Schools getSchools(Integer schoolid) {
		
		return schoolsMapper.selectByPrimaryKey(schoolid);
	}

	@Override
	public List<Schools> getSchoolsList(Schools schools) {
		
		SchoolsExample schoolsExample = new SchoolsExample();
		Criteria criteria = schoolsExample.createCriteria();
		// 查询所有正常的学校的数据： 1：正常 ;0：删除.
		criteria.andSchoolstateEqualTo(1);
		
		if(schools!=null) {
			//根据学校编号查询
			if(schools.getSchoolid()!=null) {
				criteria.andSchoolidEqualTo(schools.getSchoolid());
			}
			
			//根据学校名称查询
			if(schools.getSchoolname()!=null) {
				schools.setSchoolname("%"+schools.getSchoolname()+"%");
				criteria.andSchoolnameLike(schools.getSchoolname());
			}
		}
		return schoolsMapper.selectByExample(schoolsExample);
	}
	
}
