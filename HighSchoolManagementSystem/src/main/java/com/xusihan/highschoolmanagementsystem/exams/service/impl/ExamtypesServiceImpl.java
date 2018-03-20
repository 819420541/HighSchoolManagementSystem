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
		// 查询所有正常考试的数据： 1：正常 ;0：删除.
		criteria.andExamtypestateEqualTo(1);
		
		if(examtypes!=null) {
			//根据考试类型编号查询
			if(examtypes.getExamtypeid()!=null) {
				criteria.andExamtypeidEqualTo(examtypes.getExamtypeid());
			}
			
			//根据考试类型名称查询
			if(examtypes.getExamtypename()!=null) {
				examtypes.setExamtypename("%"+examtypes.getExamtypename()+"%");
				criteria.andExamtypenameLike(examtypes.getExamtypename());
			}
		}
		return examtypesMapper.selectByExample(examtypesExample);
	}
	
}
