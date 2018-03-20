package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamtypesMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamtypesService;
import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample.Criteria;

@Service("examtypesServiceImpl")
public class ExamtypesServiceImpl implements ExamtypesService {

	@Resource(name = "examtypesMapper")
	private ExamtypesMapper examtypesMapper;

	@Override
	public boolean addExamtype(Examtypes examtypes) {

		try {
			int i =examtypesMapper.insertSelective(examtypes);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteExamtype(Integer examtypeid) {

		try {
			int i = examtypesMapper.deleteByPrimaryKey(examtypeid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateExamtype(Examtypes examtypes) {

		try {
			int i = examtypesMapper.updateByPrimaryKeySelective(examtypes);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Examtypes getExamtype(Integer examtypeid) {
		
		return examtypesMapper.selectByPrimaryKey(examtypeid);
	}

	@Override
	public List<Examtypes> getExamtypesList(Examtypes examtypes) {

		ExamtypesExample examtypesExample = new ExamtypesExample();
		Criteria criteria = examtypesExample.createCriteria();
		// ��ѯ�����������Ե����ݣ� 1������ ;0��ɾ��.
		criteria.andExamtypestateEqualTo(1);
		
		if(examtypes!=null) {
			//���ݿ������ͱ�Ų�ѯ
			if(examtypes.getExamtypeid()!=null) {
				criteria.andExamtypeidEqualTo(examtypes.getExamtypeid());
			}
			
			//���ݿ����������Ʋ�ѯ
			if(examtypes.getExamtypename()!=null) {
				examtypes.setExamtypename("%"+examtypes.getExamtypename()+"%");
				criteria.andExamtypenameLike(examtypes.getExamtypename());
			}
		}
		return examtypesMapper.selectByExample(examtypesExample);
	}
	
}
