package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentsbaseMapper;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseService;

@Service("studentsbaseServiceImpl")
public class StudentsbaseServiceImpl implements StudentsbaseService {

	@Resource(name = "studentsbaseMapper")
	private StudentsbaseMapper studentsbaseMapper;
	
	@Override
	public boolean addStudentsbase(Studentsbase studentsbase) {

		try {
			int i =studentsbaseMapper.insertSelective(studentsbase);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteStudentsbase(Integer studentid) {

		try {
			int i = studentsbaseMapper.deleteByPrimaryKey(studentid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateStudentsbase(Studentsbase studentsbase) {

		try {
			int i = studentsbaseMapper.updateByPrimaryKeySelective(studentsbase);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Studentsbase getStudentsbase(Integer studentid) {
		
		return studentsbaseMapper.selectByPrimaryKey(studentid);
	}

	@Override
	public List<Studentsbase> getStudentsbaseList(Studentsbase studentsbase) {
		
		StudentsbaseExample studentsbaseExample = new StudentsbaseExample();
		Criteria criteria = studentsbaseExample.createCriteria();
		// 查询所有正常的学校的数据： 1：正常 ;0：删除.
		criteria.andStudentstateEqualTo(1);
		
		if(studentsbase!=null) {
			//根据学生编号查询
			if(studentsbase.getStudentid()!=null){
				criteria.andStudentidEqualTo(studentsbase.getStudentid());
			}
		}
		return studentsbaseMapper.selectByExample(studentsbaseExample);
	}

	@Override
	public Integer getStudentsbaseMaxId() {
		Integer studentId = 0;
		List<Studentsbase> listOfAll = this.getStudentsbaseList(null);
		for(Studentsbase studentsbaseList:listOfAll){
			if(studentsbaseList.getStudentid()>studentId) {
				studentId = studentsbaseList.getStudentid();
			}
		}
		return studentId;
	}
}
