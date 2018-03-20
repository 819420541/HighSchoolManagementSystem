package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;
import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordCustom;
import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordExample;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample;
import com.xusihan.highschoolmanagementsystem.po.StudentstudyrecordExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentstudyrecordMapper;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentsbaseMapper;
import com.xusihan.highschoolmanagementsystem.students.service.StudentstudyrecordCustomService;

@Service("studentstudyrecordCustomServiceImpl")
public class StudentstudyrecordCustomServiceImpl implements StudentstudyrecordCustomService {

	@Resource(name = "studentstudyrecordMapper")
	private StudentstudyrecordMapper studentstudyrecordMapper;
	
	@Resource(name = "studentsbaseMapper")
	private StudentsbaseMapper studentsbaseMapper;
	
	@Override
	public StudentstudyrecordCustom getStudentstudyrecordCustom(Integer attendanceid) {
		
		// ��Ҫ��װ������
		StudentstudyrecordCustom studentstudyrecordCustom = new StudentstudyrecordCustom();
		
		// ��ѯ����ϵ��ʽ������Ӧ����ϵ��ʽ��Ϣ����װ
		Studentstudyrecord studentstudyrecord = studentstudyrecordMapper.selectByPrimaryKey(attendanceid);
		studentstudyrecordCustom.setStudentstudyrecord(studentstudyrecord);
		
		// ��ѯ��ѧ��������Ӧ��ѧ����������װ
		Integer studentId = studentstudyrecord.getStudentid();
		Studentsbase studentsbaseInfo = studentsbaseMapper.selectByPrimaryKey(studentId);
		String studentName = studentsbaseInfo.getStudentname();
		studentstudyrecordCustom.setStudentname(studentName);
		
		return studentstudyrecordCustom;
	}

	@Override
	public List<StudentstudyrecordCustom> getStudentstudyrecordCustomList(StudentstudyrecordCustom studentstudyrecordCustom) {
		
		StudentstudyrecordExample studentstudyrecordExample = new StudentstudyrecordExample();
		Criteria criteriaOfStudentstudyrecord = studentstudyrecordExample.createCriteria();
		
		// ͨ��������ѯ���������Ŀ�����Ϣ
		StudentsbaseExample studentsbaseExample = new StudentsbaseExample();
		com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample.Criteria criteriaOfStudentsbase = studentsbaseExample.createCriteria();
		criteriaOfStudentsbase.andStudentstateEqualTo(1);
		
		if(studentstudyrecordCustom!=null) {
			//ģ����ѯѧ������
			if(studentstudyrecordCustom.getStudentname()!=null && !studentstudyrecordCustom.getStudentname().equals("")) {
				// ͨ��ģ����ѯ����÷���������ѧ����Ϣ
				studentstudyrecordCustom.setStudentname("%"+studentstudyrecordCustom.getStudentname()+"%");
				criteriaOfStudentsbase.andStudentnameLike(studentstudyrecordCustom.getStudentname());
				List<Studentsbase> listOfStudentsbase = studentsbaseMapper.selectByExample(studentsbaseExample);
				// ��ѯ�õ���ѧ����Ϣ��Ӧ��ѧ�����
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Studentsbase studentsbase:listOfStudentsbase) {
					listOfClassIds.add(studentsbase.getClassid());
				}
				if(!listOfClassIds.isEmpty()) {
					criteriaOfStudentstudyrecord.andStudentidIn(listOfClassIds);
				}
			}
	
			if(studentstudyrecordCustom.getStudentstudyrecord()!=null) {
				
				// ��ѯѧ�����
				if(studentstudyrecordCustom.getStudentstudyrecord().getStudyrecordid()!=null){
					criteriaOfStudentstudyrecord.andStudyrecordidEqualTo(studentstudyrecordCustom.getStudentstudyrecord().getStudyrecordid());
				}
				
				// ��ѯѧ�����
				if(studentstudyrecordCustom.getStudentstudyrecord().getStudentid()!=null){
					criteriaOfStudentstudyrecord.andStudentidEqualTo(studentstudyrecordCustom.getStudentstudyrecord().getStudentid());
				}
				
				// ��ѯ���������
				if(studentstudyrecordCustom.getStudentstudyrecord().getComputerlevel()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setComputerlevel("%"+studentstudyrecordCustom.getStudentstudyrecord().getComputerlevel()+"%");					
					criteriaOfStudentstudyrecord.andComputerlevelLike(studentstudyrecordCustom.getStudentstudyrecord().getComputerlevel());
				}
				
				// ��ѯӢ�����
				if(studentstudyrecordCustom.getStudentstudyrecord().getEnglishlevel()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setEnglishlevel("%"+studentstudyrecordCustom.getStudentstudyrecord().getEnglishlevel()+"%");					
					criteriaOfStudentstudyrecord.andEnglishlevelLike(studentstudyrecordCustom.getStudentstudyrecord().getEnglishlevel());
				}
				
				// ��ѯ��ҵѧУ
				if(studentstudyrecordCustom.getStudentstudyrecord().getGraduateschool()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setGraduateschool("%"+studentstudyrecordCustom.getStudentstudyrecord().getGraduateschool()+"%");					
					criteriaOfStudentstudyrecord.andGraduateschoolLike(studentstudyrecordCustom.getStudentstudyrecord().getGraduateschool());
				}
				
				// ��ѯ��ҵʱ��
				if(studentstudyrecordCustom.getStudentstudyrecord().getGradutetime()!=null){				
					criteriaOfStudentstudyrecord.andGradutetimeEqualTo(studentstudyrecordCustom.getStudentstudyrecord().getGradutetime());
				}
				
				// ��ѯ����֤��
				if(studentstudyrecordCustom.getStudentstudyrecord().getCertificate()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setCertificate("%"+studentstudyrecordCustom.getStudentstudyrecord().getCertificate()+"%");					
					criteriaOfStudentstudyrecord.andCertificateLike(studentstudyrecordCustom.getStudentstudyrecord().getCertificate());
				}
				
				// ��ѯ������λ
				if(studentstudyrecordCustom.getStudentstudyrecord().getJobcompany()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setJobcompany("%"+studentstudyrecordCustom.getStudentstudyrecord().getJobcompany()+"%");					
					criteriaOfStudentstudyrecord.andJobcompanyLike(studentstudyrecordCustom.getStudentstudyrecord().getJobcompany());
				}
				// ��ѯ��������
				if(studentstudyrecordCustom.getStudentstudyrecord().getJobcourse()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setJobcourse("%"+studentstudyrecordCustom.getStudentstudyrecord().getJobcourse()+"%");					
					criteriaOfStudentstudyrecord.andJobcourseLike(studentstudyrecordCustom.getStudentstudyrecord().getJobcourse());
				}
				
			}
		}
		// ��ѯ�������������緽ʽ��Ϣ
		List<Studentstudyrecord>listOfStudentstudyrecord = studentstudyrecordMapper.selectByExample(studentstudyrecordExample);
		if(listOfStudentstudyrecord!=null) {
			List<StudentstudyrecordCustom> listOfStudentstudyrecordCustom = new ArrayList<>();
			for(Studentstudyrecord studentstudyrecordList:listOfStudentstudyrecord) {
				StudentstudyrecordCustom studentstudyrecordCustomInfo = this.getStudentstudyrecordCustom(studentstudyrecordList.getStudyrecordid());
				listOfStudentstudyrecordCustom.add(studentstudyrecordCustomInfo);
			}
			return listOfStudentstudyrecordCustom;	
		}else {
			return null;
		}
	}

}
