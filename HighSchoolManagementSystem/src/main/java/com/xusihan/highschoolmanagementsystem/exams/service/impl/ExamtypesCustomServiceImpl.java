package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamtypesMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamtypesCustomService;
import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesCustom;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample;

@Service("examtypesCustomServiceImpl")
public class ExamtypesCustomServiceImpl implements ExamtypesCustomService {

	@Resource(name = "examtypesMapper")
	private ExamtypesMapper examtypesMapper;
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;
	
	@Override
	public ExamtypesCustom getExamtypesCustom(Integer examtypeid) {
		
		// ��Ҫ��װ������
		ExamtypesCustom examtypesCustom = new ExamtypesCustom();
		
		// ��ѯ�뿼�����ͱ�����Ӧ�Ŀ���������Ϣ����װ
		Examtypes examtypes = examtypesMapper.selectByPrimaryKey(examtypeid);
		examtypesCustom.setExamtypes(examtypes);
		
		// ��ѯ��ѧУ������Ӧ��ѧУ���Ʋ���װ
		Integer schoolId = examtypes.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		examtypesCustom.setSchoolname(schoolName);
		
		return examtypesCustom;
	}

	@Override
	public List<ExamtypesCustom> getExamtypesCustomList(ExamtypesCustom examtypesCustom) {
		
		ExamtypesExample examtypesExample = new ExamtypesExample();
		Criteria criteriaOfExamtypes = examtypesExample.createCriteria();
		criteriaOfExamtypes.andExamtypestateEqualTo(1);
		
		//ͨ��������ѯ���������Ŀ���������Ϣ
		SchoolsExample schoolsExample = new SchoolsExample();
		com.xusihan.highschoolmanagementsystem.po.SchoolsExample.Criteria criteriaOfSchools = schoolsExample.createCriteria();
		criteriaOfSchools.andSchoolstateEqualTo(1);
		if(examtypesCustom!=null) {
			// ģ����ѯѧУ����
			if(examtypesCustom.getSchoolname()!= null && !examtypesCustom.getSchoolname().equals("") ) {
				// ͨ��ģ����ѯ����÷��������Ľ̲ı��
				examtypesCustom.setSchoolname("%"+examtypesCustom.getSchoolname()+"%");
				criteriaOfSchools.andSchoolnameLike(examtypesCustom.getSchoolname());
				List<Schools> listOfSchools = schoolsMapper.selectByExample(schoolsExample);
				// ��ѯ�õ��Ľ̲���Ϣ��Ӧ�Ľ̲ı��
				List<Integer> listOfSchoolIds = new ArrayList<>();
				for(Schools schoolsList:listOfSchools) {
					listOfSchoolIds.add(schoolsList.getSchoolid());
				}
				
				if(!listOfSchoolIds.isEmpty()) {
					criteriaOfExamtypes.andSchoolidIn(listOfSchoolIds);
				}
			}
			
			if(examtypesCustom.getExamtypes()!=null) {
				
				// ��ѯѧУ���
				if(examtypesCustom.getExamtypes().getSchoolid()!=null ) {
					criteriaOfExamtypes.andSchoolidEqualTo(examtypesCustom.getExamtypes().getSchoolid());
				}
				
				// ��ѯ�������ͱ��
				if(examtypesCustom.getExamtypes().getExamtypeid()!= null ) {
					criteriaOfExamtypes.andExamtypeidEqualTo(examtypesCustom.getExamtypes().getExamtypeid());
				}
				
				// ��ѯ������������
				if(examtypesCustom.getExamtypes().getExamtypename()!=null && !examtypesCustom.getExamtypes().getExamtypename().equals("")) {
					examtypesCustom.getExamtypes().setExamtypename("%"+examtypesCustom.getExamtypes().getExamtypename()+"%");
					criteriaOfExamtypes.andExamtypenameLike(examtypesCustom.getExamtypes().getExamtypename());
				}
			}
		}
		// ��ѯ���������Ŀ���������Ϣ
		List<Examtypes> listOfExamtypes = examtypesMapper.selectByExample(examtypesExample);
		if(listOfExamtypes!=null) {
			List<ExamtypesCustom> listOfExamtypesCustom = new ArrayList<>();
			for(Examtypes examtypesList:listOfExamtypes) {
				ExamtypesCustom examtypesCustomInfo = this.getExamtypesCustom(examtypesList.getExamtypeid());
				listOfExamtypesCustom.add(examtypesCustomInfo);
			}
			return listOfExamtypesCustom;
		}else {
			return null;
		}
		
	}

}
