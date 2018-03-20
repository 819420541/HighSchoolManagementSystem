package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.SemestersMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamsMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamtypesMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamsCustomService;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsCustom;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample;
import com.xusihan.highschoolmanagementsystem.po.Semesters;
import com.xusihan.highschoolmanagementsystem.po.SemestersExample;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample;

@Service("examsCustomServiceImpl")
public class ExamsCustomServiceImpl implements ExamsCustomService {

	@Resource(name = "examsMapper")
	private ExamsMapper examsMapper;
	
	@Resource(name = "examtypesMapper")
	private ExamtypesMapper examtypesMapper;
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;
	
	@Resource(name = "semestersMapper")
	private SemestersMapper semestersMapper;
	
	@Override
	public ExamsCustom getExamsCustom(Integer examid) {
		
		// ��Ҫ��װ������
		ExamsCustom examsCustom = new ExamsCustom();
		
		// ��ѯ�뿼�Ա�����Ӧ�Ŀ�����Ϣ����װ
		Exams exams = examsMapper.selectByPrimaryKey(examid);
		examsCustom.setExams(exams);

		// ��ѯ�����ͱ�����Ӧ���������Ʋ���װ
		Integer examtypeId = exams.getExamtypeid();
		Examtypes examtypeInfo = examtypesMapper.selectByPrimaryKey(examtypeId);
		String examtypeName = examtypeInfo.getExamtypename();
		examsCustom.setExamtypename(examtypeName);
		
		// ��ѯ��ѧУ������Ӧ��ѧУ���Ʋ���װ
		Integer schoolId = exams.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		examsCustom.setSchoolname(schoolName);
		
		// ��ѯ��ѧ�ڱ�����Ӧ��ѧ�����Ʋ���װ
		Integer semesterId = exams.getSemesterid();
		Semesters semesterInfo = semestersMapper.selectByPrimaryKey(semesterId);
		String semesterName = semesterInfo.getSemestername();
		examsCustom.setSemestername(semesterName);
		
		return examsCustom;
	}

	@Override
	public List<ExamsCustom> getExamsCustomList(ExamsCustom examsCustom) {
		
		ExamsExample examsExample = new ExamsExample();
		Criteria criteriaOfExams = examsExample.createCriteria();
		criteriaOfExams.andExamstateEqualTo(1);
		
		//ͨ��������ѯ���������Ŀ�����Ϣ
		ExamtypesExample examtypesExample = new ExamtypesExample();
		com.xusihan.highschoolmanagementsystem.po.ExamtypesExample.Criteria criteriaOfExamtypes = examtypesExample.createCriteria();
		criteriaOfExamtypes.andExamtypestateEqualTo(1);
		
		SchoolsExample schoolsExample = new SchoolsExample();
		com.xusihan.highschoolmanagementsystem.po.SchoolsExample.Criteria criteriaOfSchools = schoolsExample.createCriteria();
		criteriaOfSchools.andSchoolstateEqualTo(1);
		
		SemestersExample semestersExample = new SemestersExample();
		com.xusihan.highschoolmanagementsystem.po.SemestersExample.Criteria criteriaOfSemesters = semestersExample.createCriteria();
		criteriaOfSemesters.andSemesterstateEqualTo(1);
		
		if(examsCustom!=null) {
			// ģ����ѯ��������
			if(examsCustom.getExamtypename()!= null && !examsCustom.getExamtypename().equals("") ) {
				// ͨ��ģ����ѯ����÷������������ͱ��
				examsCustom.setExamtypename("%"+examsCustom.getExamtypename()+"%");
				criteriaOfExamtypes.andExamtypenameLike(examsCustom.getExamtypename());
				List<Examtypes> listOfExamtypes = examtypesMapper.selectByExample(examtypesExample);
				// ��ѯ�õ���������Ϣ��Ӧ�����ͱ��
				List<Integer> listOfExamtypeIds = new ArrayList<>();
				for(Examtypes examtypesList:listOfExamtypes) {
					listOfExamtypeIds.add(examtypesList.getExamtypeid());
				}
				if(!listOfExamtypeIds.isEmpty()) {
					criteriaOfExams.andExamtypeidIn(listOfExamtypeIds);
				}
			}
						
			// ģ����ѯѧУ����
			if(examsCustom.getSchoolname()!= null && !examsCustom.getSchoolname().equals("") ) {
				// ͨ��ģ����ѯ����÷���������ѧУ���
				examsCustom.setSchoolname("%"+examsCustom.getSchoolname()+"%");
				criteriaOfSchools.andSchoolnameLike(examsCustom.getSchoolname());
				List<Schools> listOfSchools = schoolsMapper.selectByExample(schoolsExample);
				// ��ѯ�õ���ѧУ��Ϣ��Ӧ�Ŀ���1���
				List<Integer> listOfSchoolIds = new ArrayList<>();
				for(Schools schoolsList:listOfSchools) {
					listOfSchoolIds.add(schoolsList.getSchoolid());
				}
				
				if(!listOfSchoolIds.isEmpty()) {
					criteriaOfExams.andSchoolidIn(listOfSchoolIds);
				}
			}
			
			// ģ����ѯѧ������
			if(examsCustom.getSemestername()!= null && !examsCustom.getSemestername().equals("") ) {
				// ͨ��ģ����ѯ����÷���������ѧ�ڱ��
				examsCustom.setSemestername("%"+examsCustom.getSemestername()+"%");
				criteriaOfSemesters.andSemesternameLike(examsCustom.getSemestername());
				List<Semesters> listOfSemesters = semestersMapper.selectByExample(semestersExample);
				// ��ѯ�õ���ѧ����Ϣ��Ӧ��ѧ�ڱ��
				List<Integer> listOfSemesterIds = new ArrayList<>();
				for(Semesters semestersList:listOfSemesters) {
					listOfSemesterIds.add(semestersList.getSemesterid());
				}
				if(!listOfSemesterIds.isEmpty()) {
					criteriaOfExams.andSemesteridIn(listOfSemesterIds);
				}
			}
			
			if(examsCustom.getExams()!=null) {
				
				// ��ѯ���Ա��
				if(examsCustom.getExams().getExamid()!= null ) {
					criteriaOfExams.andExamidEqualTo(examsCustom.getExams().getExamid());
				}
				
				// ��ѯ���ͱ��
				if(examsCustom.getExams().getExamtypeid()!= null ) {
					criteriaOfExamtypes.andExamtypeidEqualTo(examsCustom.getExams().getExamtypeid());
				}
				
				// ��ѯѧУ���
				if(examsCustom.getExams().getSchoolid()!=null ) {
					criteriaOfExams.andSchoolidEqualTo(examsCustom.getExams().getSchoolid());
				}
				
				// ��ѯѧ�ڱ��
				if(examsCustom.getExams().getSemesterid()!=null ) {
					criteriaOfExams.andSemesteridEqualTo(examsCustom.getExams().getSemesterid());
				}
				
				// ��ѯ��������
				if(examsCustom.getExams().getExamname()!=null && !examsCustom.getExams().getExamname().equals("")) {
					examsCustom.getExams().setExamname("%"+examsCustom.getExams().getExamname()+"%");
					criteriaOfExams.andExamnameLike(examsCustom.getExams().getExamname());
				}
				
				
			}
		}
		// ��ѯ���������Ŀ�����Ϣ
		List<Exams> listOfExams = examsMapper.selectByExample(examsExample);
		if(listOfExams!=null) {
			List<ExamsCustom> listOfExamsCustom = new ArrayList<>();
			for(Exams examsList:listOfExams) {
				ExamsCustom examsCustomInfo = this.getExamsCustom(examsList.getExamid());
				listOfExamsCustom.add(examsCustomInfo);
			}
			return listOfExamsCustom;
		}else {
			return null;
		}
		
	}
}
