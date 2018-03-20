package com.xusihan.highschoolmanagementsystem.database.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.SemestersMapper;
import com.xusihan.highschoolmanagementsystem.database.service.SemestersService;
import com.xusihan.highschoolmanagementsystem.po.Semesters;
import com.xusihan.highschoolmanagementsystem.po.SemestersExample;
import com.xusihan.highschoolmanagementsystem.po.SemestersExample.Criteria;

@Service("semestersServiceImpl")
public class SemestersServiceImpl implements SemestersService {

	@Resource(name = "semestersMapper")
	private SemestersMapper semestersMapper;
	
	@Override
	public boolean addSemester(Semesters semesters) {
		
		try {
			int i =semestersMapper.insertSelective(semesters);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteSemester(Integer semesterid) {
		
		try {
			int i = semestersMapper.deleteByPrimaryKey(semesterid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateSemester(Semesters semesters) {
		
		try {
			int i = semestersMapper.updateByPrimaryKeySelective(semesters);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Semesters getSemesters(Integer semesterid) {
		
		return semestersMapper.selectByPrimaryKey(semesterid);
	}
	
	@Override
	public List<Semesters> getSemestersList(Semesters semesters) {

		SemestersExample semestersExample = new SemestersExample();
		Criteria criteria = semestersExample.createCriteria();
		
		// ��ѯ����������ѧ�ڵ����ݣ� 1������ ;0��ɾ��.
		criteria.andSemesterstateEqualTo(1);
		
		if(semesters!=null) {
			//����ѧ�ڱ�Ų�ѯ
			if(semesters.getSemesterid()!=null) {
				criteria.andSemesteridEqualTo(semesters.getSemesterid());
			}
			
			//����ѧ�����Ʋ�ѯ
			if(semesters.getSemestername()!=null) {
				semesters.setSemestername("%"+semesters.getSemestername()+"%");
				criteria.andSemesternameLike(semesters.getSemestername());
			}
		}
		return semestersMapper.selectByExample(semestersExample);
	}

}
