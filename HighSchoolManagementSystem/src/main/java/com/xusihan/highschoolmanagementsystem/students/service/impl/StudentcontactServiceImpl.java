package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.po.Studentcontact;
import com.xusihan.highschoolmanagementsystem.po.StudentcontactExample;
import com.xusihan.highschoolmanagementsystem.po.StudentcontactExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentcontactMapper;
import com.xusihan.highschoolmanagementsystem.students.service.StudentcontactService;

@Service("studentcontactServiceImpl")
public class StudentcontactServiceImpl implements StudentcontactService {

	@Resource(name = "studentcontactMapper")
	private StudentcontactMapper studentcontactMapper;
	
	@Override
	public boolean addStudentcontact(Studentcontact studentcontact) {

		try {
			int i =studentcontactMapper.insertSelective(studentcontact);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteStudentcontact(Integer studentcontactid) {

		try {
			int i = studentcontactMapper.deleteByPrimaryKey(studentcontactid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateStudentcontact(Studentcontact studentcontact) {

		try {
			int i = studentcontactMapper.updateByPrimaryKeySelective(studentcontact);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Studentcontact getStudentcontact(Integer studentcontactid) {
		
		return studentcontactMapper.selectByPrimaryKey(studentcontactid);
		
	}

	@Override
	public List<Studentcontact> getStudentcontactsList(Studentcontact studentcontact) {

		StudentcontactExample studentcontactExample = new StudentcontactExample();
		Criteria criteria = studentcontactExample.createCriteria();
		
		if(studentcontact!=null) {
			//¸ù¾Ý¿¼ÇÚ±àºÅ²éÑ¯
			if(studentcontact.getStudentcontactid()!=null){
				criteria.andStudentidEqualTo(studentcontact.getStudentcontactid());
			}
		}
		return studentcontactMapper.selectByExample(studentcontactExample);	
	}

}
