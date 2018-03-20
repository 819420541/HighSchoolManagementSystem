package com.xusihan.highschoolmanagementsystem.classes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ClassesMapper;
import com.xusihan.highschoolmanagementsystem.classes.service.ClassesService;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria;

@Service("classesServiceImpl")
public class ClassesServiceImpl implements ClassesService{

	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;
	
	@Override
	public boolean addClass(Classes classes) {
		
		try {
			int i =classesMapper.insertSelective(classes);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteClass(Integer classid) {

		try {
			int i = classesMapper.deleteByPrimaryKey(classid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateClass(Classes classes) {
		
		try {
			int i = classesMapper.updateByPrimaryKeySelective(classes);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Classes getClass(Integer classid) {
		
		return classesMapper.selectByPrimaryKey(classid);
	}

	@Override
	public List<Classes> getClassesList(Classes classes) {
		
		ClassesExample classesExample = new ClassesExample();
		Criteria criteria = classesExample.createCriteria();
		// 查询所有正常的学校的数据： 1：正常 ;0：删除.
		criteria.andClassstateEqualTo(1);
		
		if(classes!=null) {
			//根据班级编号查询
			if(classes.getClassid()!=null) {
				criteria.andClassidEqualTo(classes.getClassid());
			}
		}
		return classesMapper.selectByExample(classesExample);
	}

}
