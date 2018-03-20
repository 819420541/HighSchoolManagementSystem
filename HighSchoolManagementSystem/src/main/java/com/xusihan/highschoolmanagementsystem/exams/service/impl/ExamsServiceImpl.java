package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamsMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamsService;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample.Criteria;

@Service("examsServiceImpl")
public class ExamsServiceImpl implements ExamsService {

	@Resource(name = "examsMapper")
	private ExamsMapper examsMapper;

	@Override
	public boolean addExam(Exams exams) {

		try {
			int i =examsMapper.insertSelective(exams);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteExam(Integer examid) {

		try {
			int i = examsMapper.deleteByPrimaryKey(examid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateExam(Exams exams) {

		try {
			int i = examsMapper.updateByPrimaryKeySelective(exams);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Exams getExam(Integer examid) {
		
		return examsMapper.selectByPrimaryKey(examid);
	}

	@Override
	public List<Exams> getExamsList(Exams exams) {

		ExamsExample examsExample = new ExamsExample();
		Criteria criteria = examsExample.createCriteria();
		// 查询所有正常考试的数据： 1：正常 ;0：删除.
		criteria.andExamstateEqualTo(1);
		
		if(exams!=null) {
			//根据考试编号查询
			if(exams.getExamid()!=null) {
				criteria.andExamidEqualTo(exams.getExamid());
			}
			
			//根据考试名称查询
			if(exams.getExamname()!=null) {
				exams.setExamname("%"+exams.getExamname()+"%");
				criteria.andExamnameLike(exams.getExamname());
			}
		}
		return examsMapper.selectByExample(examsExample);
	}

}
