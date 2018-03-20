package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamplansMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamplansService;
import com.xusihan.highschoolmanagementsystem.po.Examplans;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample.Criteria;

@Service("examplansServiceImpl")
public class ExamplansServiceImpl implements ExamplansService {

	@Resource(name = "examplansMapper")
	private ExamplansMapper examplansMapper;
	
	@Override
	public boolean addExamplan(Examplans examplans) {
		
		try {
			int i =examplansMapper.insertSelective(examplans);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteExamplan(Integer examplanid) {

		try {
			int i = examplansMapper.deleteByPrimaryKey(examplanid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateExamplan(Examplans examplans) {

		try {
			int i = examplansMapper.updateByPrimaryKeySelective(examplans);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Examplans getExamplans(Integer examplanid) {

		return examplansMapper.selectByPrimaryKey(examplanid);
	}

	@Override
	public List<Examplans> getExamplanList(Examplans examplans) {

		ExamplansExample examplansExample = new ExamplansExample();
		Criteria criteria = examplansExample.createCriteria();
		
		// 查询所有正常的考试安排的数据： 1：正常 ;0：删除.
		criteria.andExamplanstateEqualTo(1);
		
		if(examplans!=null) {
			//根据考试安排编号查询
			if(examplans.getExamplanid()!=null) {
				criteria.andExamplanidEqualTo(examplans.getExamplanid());
			}
			
			//根据考试安排名称查询
			if(examplans.getExamplanid()!=null) {
				examplans.setExamplanname("%"+examplans.getExamplanid()+"%");
				criteria.andExamplannameLike(examplans.getExamplanname());
			}
		}
		return examplansMapper.selectByExample(examplansExample);
	}

}
