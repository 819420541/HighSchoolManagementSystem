package com.xusihan.highschoolmanagementsystem.database.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.CoursebooksMapper;
import com.xusihan.highschoolmanagementsystem.database.service.CoursebooksService;
import com.xusihan.highschoolmanagementsystem.po.Coursebooks;
import com.xusihan.highschoolmanagementsystem.po.CoursebooksExample;
import com.xusihan.highschoolmanagementsystem.po.CoursebooksExample.Criteria;

@Service("coursebooksServiceImpl")
public class CoursebooksServiceImpl implements CoursebooksService {

	@Resource(name = "coursebooksMapper")
	private CoursebooksMapper coursebooksMapper;
	
	@Override
	public boolean addCoursebook(Coursebooks coursebooks) {
		
		try {
			int i =coursebooksMapper.insertSelective(coursebooks);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteCoursebook(Integer coursebookid) {

		try {
			int i = coursebooksMapper.deleteByPrimaryKey(coursebookid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateCoursebook(Coursebooks coursebooks) {

		try {
			int i = coursebooksMapper.updateByPrimaryKeySelective(coursebooks);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Coursebooks getCoursebooks(Integer coursebookid) {

		return coursebooksMapper.selectByPrimaryKey(coursebookid);
	}

	@Override
	public List<Coursebooks> getCoursebookList(Coursebooks coursebooks) {

		CoursebooksExample coursebooksExample = new CoursebooksExample();
		Criteria criteria = coursebooksExample.createCriteria();
		
		// 查询所有正常的学校的数据： 1：正常 ;0：删除.
		criteria.andCoursebookstateEqualTo(1);
		
		if(coursebooks!=null) {
			//根据教材编号查询
			if(coursebooks.getCoursebookid()!=null) {
				criteria.andCoursebookidEqualTo(coursebooks.getCoursebookid());
			}
			
			//根据教材名称查询
			if(coursebooks.getCoursebookid()!=null) {
				coursebooks.setCoursebookname("%"+coursebooks.getCoursebookid()+"%");
				criteria.andCoursebooknameLike(coursebooks.getCoursebookname());
			}
		}
		return coursebooksMapper.selectByExample(coursebooksExample);
	}

}
