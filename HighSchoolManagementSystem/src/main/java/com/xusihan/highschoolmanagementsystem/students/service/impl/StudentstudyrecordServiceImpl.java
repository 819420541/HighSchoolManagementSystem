package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;
import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordExample;
import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentstudyrecordMapper;
import com.xusihan.highschoolmanagementsystem.students.service.StudentstudyrecordService;

@Service("studentstudyrecordServiceImpl")
public class StudentstudyrecordServiceImpl implements StudentstudyrecordService {


	@Resource(name = "studentstudyrecordMapper")
	private StudentstudyrecordMapper studentstudyrecordMapper;
	
	@Override
	public boolean addStudentstudyrecord(Studentstudyrecord studentstudyrecord) {

		try {
			int i =studentstudyrecordMapper.insertSelective(studentstudyrecord);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteStudentstudyrecord(Integer studentstudyrecordid) {

		try {
			int i = studentstudyrecordMapper.deleteByPrimaryKey(studentstudyrecordid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateStudentstudyrecord(Studentstudyrecord studentstudyrecord) {

		try {
			int i = studentstudyrecordMapper.updateByPrimaryKeySelective(studentstudyrecord);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Studentstudyrecord getStudentstudyrecord(Integer studentstudyrecordid) {
		
		return studentstudyrecordMapper.selectByPrimaryKey(studentstudyrecordid);
		
	}

	@Override
	public List<Studentstudyrecord> getStudentstudyrecordsList(Studentstudyrecord studentstudyrecord) {

		StudentstudyrecordExample studentstudyrecordExample = new StudentstudyrecordExample();
		Criteria criteria = studentstudyrecordExample.createCriteria();
		
		if(studentstudyrecord!=null) {
			//¸ù¾Ý¿¼ÇÚ±àºÅ²éÑ¯
			if(studentstudyrecord.getStudyrecordid()!=null){
				criteria.andStudentidEqualTo(studentstudyrecord.getStudyrecordid());
			}
		}
		return studentstudyrecordMapper.selectByExample(studentstudyrecordExample);	
	}

}
