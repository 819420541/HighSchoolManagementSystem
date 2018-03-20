package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ClassesMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamplansMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamsMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamplansCustomService;
import com.xusihan.highschoolmanagementsystem.po.Examplans;
import com.xusihan.highschoolmanagementsystem.po.ExamplansCustom;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample;

@Service("examplansCustomServiceImpl")
public class ExamplansCustomServiceImpl implements ExamplansCustomService {

	@Resource(name = "examplansMapper")
	private ExamplansMapper examplansMapper;
	
	@Resource(name = "examsMapper")
	private ExamsMapper examsMapper;
	
	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;
	
	@Override
	public ExamplansCustom getExamplansCustom(Integer examplanid) {
		
		// ��Ҫ��װ������
		ExamplansCustom examplansCustom = new ExamplansCustom();
		
		// ��ѯ��γ̱�����Ӧ�Ŀγ���Ϣ����װ
		Examplans examplans = examplansMapper.selectByPrimaryKey(examplanid);
		examplansCustom.setExamplans(examplans);
		
		// ��ѯ�뿼�Ա�����Ӧ�Ŀ������Ʋ���װ
		Integer examId = examplans.getExamid();
		Exams examInfo = examsMapper.selectByPrimaryKey(examId);
		String examName = examInfo.getExamname();
		examplansCustom.setExamname(examName);
		
		// ��ѯ��༶������Ӧ�İ༶���Ʋ���װ
		Integer classId = examplans.getClassid();
		Classes classInfo = classesMapper.selectByPrimaryKey(classId);
		String className = classInfo.getClassname();
		examplansCustom.setClassname(className);
		
		return examplansCustom;
	}

	@Override
	public List<ExamplansCustom> getExamplansCustomList(ExamplansCustom examplansCustom) {
		
		ExamplansExample examplansExample = new ExamplansExample();
		Criteria criteriaOfExamplans = examplansExample.createCriteria();
		criteriaOfExamplans.andExamplanstateEqualTo(1);
		
		//ͨ��������ѯ���������Ŀ��԰�����Ϣ
		ExamsExample examsExample = new ExamsExample();
		com.xusihan.highschoolmanagementsystem.po.ExamsExample.Criteria criteriaOfExams = examsExample.createCriteria();
		criteriaOfExams.andExamstateEqualTo(1);
		
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		criteriaOfClasses.andClassstateEqualTo(1);
		
		if(examplansCustom!=null) {
			// ģ����ѯ��������
			if(examplansCustom.getExamname()!= null && !examplansCustom.getExamname().equals("") ) {
				// ͨ��ģ����ѯ����÷��������Ŀ��Ա��
				examplansCustom.setExamname("%"+examplansCustom.getExamname()+"%");
				criteriaOfExams.andExamnameLike(examplansCustom.getExamname());
				List<Exams> listOfExams = examsMapper.selectByExample(examsExample);
				// ��ѯ�õ��Ŀ�����Ϣ��Ӧ�Ŀ��Ա��
				List<Integer> listOfExamplanBookIds = new ArrayList<>();
				for(Exams exams:listOfExams) {
					listOfExamplanBookIds.add(exams.getExamid());
				}
				if(!listOfExamplanBookIds.isEmpty()) {
					criteriaOfExamplans.andExamidIn(listOfExamplanBookIds);
				}
			}
			// ģ����ѯ�༶����
			if(examplansCustom.getClassname()!= null && !examplansCustom.getClassname().equals("") ) {
				// ͨ��ģ����ѯ����÷��������İ༶���
				examplansCustom.setClassname("%"+examplansCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(examplansCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// ��ѯ�õ��İ༶��Ϣ��Ӧ�İ༶���
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Classes classes:listOfClasses) {
					listOfClassIds.add(classes.getClassid());
				}
				if(!listOfClassIds.isEmpty()) {
					criteriaOfExamplans.andExamidIn(listOfClassIds);
				}
			}
			
			if(examplansCustom.getExamplans()!=null) {
				
				// ��ѯ���԰��ű��
				if(examplansCustom.getExamplans().getExamplanid()!= null ) {
					criteriaOfExamplans.andExamplanidEqualTo(examplansCustom.getExamplans().getExamplanid());
				}
				
				// ��ѯ���԰�������
				if(examplansCustom.getExamplans().getExamplanname()!=null && !examplansCustom.getExamplans().getExamplanname().equals("")) {
					examplansCustom.getExamplans().setExamplanname("%"+examplansCustom.getExamplans().getExamplanname()+"%");
					criteriaOfExamplans.andExamplannameLike(examplansCustom.getExamplans().getExamplanname());
				}
				
				// ��ѯ���Ա��
				if(examplansCustom.getExamplans().getExamid()!=null ) {
					criteriaOfExamplans.andExamidEqualTo(examplansCustom.getExamplans().getExamid());
				}
				
				// ��ѯ���Ա��
				if(examplansCustom.getExamplans().getClassid()!=null ) {
					criteriaOfExamplans.andClassidEqualTo(examplansCustom.getExamplans().getClassid());
				}
			}
		}
		// ��ѯ���������Ŀγ���Ϣ
		List<Examplans> listOfExamplans = examplansMapper.selectByExample(examplansExample);
		if(listOfExamplans!=null) {
			List<ExamplansCustom> listOfExamplansCustom = new ArrayList<>();
			for(Examplans examplansList:listOfExamplans) {
				ExamplansCustom examplansCustomInfo = this.getExamplansCustom(examplansList.getExamplanid());
				listOfExamplansCustom.add(examplansCustomInfo);
			}
			return listOfExamplansCustom;
		}else {
			return null;
		}
	}
	
}
