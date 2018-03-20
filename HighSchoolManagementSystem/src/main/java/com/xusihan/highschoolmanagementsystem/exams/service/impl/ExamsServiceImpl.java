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
		// ��ѯ�����������Ե����ݣ� 1������ ;0��ɾ��.
		criteria.andExamstateEqualTo(1);
		
		if(exams!=null) {
			//���ݿ��Ա�Ų�ѯ
			if(exams.getExamid()!=null) {
				criteria.andExamidEqualTo(exams.getExamid());
			}
			
			//���ݿ������Ʋ�ѯ
			if(exams.getExamname()!=null) {
				exams.setExamname("%"+exams.getExamname()+"%");
				criteria.andExamnameLike(exams.getExamname());
			}
		}
		return examsMapper.selectByExample(examsExample);
	}

}
