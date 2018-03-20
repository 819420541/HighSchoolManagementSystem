package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.po.Studentcontact;
import com.xusihan.highschoolmanagementsystem.po.StudentcontactCustom;
import com.xusihan.highschoolmanagementsystem.po.StudentcontactExample;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample;
import com.xusihan.highschoolmanagementsystem.po.StudentcontactExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentcontactMapper;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentsbaseMapper;
import com.xusihan.highschoolmanagementsystem.students.service.StudentcontactCustomService;

@Service("studentcontactCustomServiceImpl")
public class StudentcontactCustomServiceImpl implements StudentcontactCustomService {

	@Resource(name = "studentcontactMapper")
	private StudentcontactMapper studentcontactMapper;
	
	@Resource(name = "studentsbaseMapper")
	private StudentsbaseMapper studentsbaseMapper;
	
	@Override
	public StudentcontactCustom getStudentcontactCustom(Integer attendanceid) {
		
		// ��Ҫ��װ������
		StudentcontactCustom studentcontactCustom = new StudentcontactCustom();
		
		// ��ѯ����ϵ��ʽ������Ӧ����ϵ��ʽ��Ϣ����װ
		Studentcontact studentcontact = studentcontactMapper.selectByPrimaryKey(attendanceid);
		studentcontactCustom.setStudentcontact(studentcontact);
		
		// ��ѯ��ѧ��������Ӧ��ѧ����������װ
		Integer studentId = studentcontact.getStudentid();
		Studentsbase studentsbaseInfo = studentsbaseMapper.selectByPrimaryKey(studentId);
		String studentName = studentsbaseInfo.getStudentname();
		studentcontactCustom.setStudentname(studentName);
		
		return studentcontactCustom;
	}

	@Override
	public List<StudentcontactCustom> getStudentcontactCustomList(StudentcontactCustom studentcontactCustom) {
		
		StudentcontactExample studentcontactExample = new StudentcontactExample();
		Criteria criteriaOfStudentcontact = studentcontactExample.createCriteria();
		
		// ͨ��������ѯ���������Ŀ�����Ϣ
		StudentsbaseExample studentsbaseExample = new StudentsbaseExample();
		com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample.Criteria criteriaOfStudentsbase = studentsbaseExample.createCriteria();
		criteriaOfStudentsbase.andStudentstateEqualTo(1);
		
		if(studentcontactCustom!=null) {
			//ģ����ѯѧ������
			if(studentcontactCustom.getStudentname()!=null && !studentcontactCustom.getStudentname().equals("")) {
				// ͨ��ģ����ѯ����÷���������ѧ����Ϣ
				studentcontactCustom.setStudentname("%"+studentcontactCustom.getStudentname()+"%");
				criteriaOfStudentsbase.andStudentnameLike(studentcontactCustom.getStudentname());
				List<Studentsbase> listOfStudentsbase = studentsbaseMapper.selectByExample(studentsbaseExample);
				// ��ѯ�õ���ѧ����Ϣ��Ӧ��ѧ�����
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Studentsbase studentsbase:listOfStudentsbase) {
					listOfClassIds.add(studentsbase.getClassid());
				}
				if(!listOfClassIds.isEmpty()) {
					criteriaOfStudentcontact.andStudentidIn(listOfClassIds);
				}
			}
	
			if(studentcontactCustom.getStudentcontact()!=null) {
				
				// ��ѯ��ϵ��ʽ���
				if(studentcontactCustom.getStudentcontact().getStudentcontactid()!=null){
					criteriaOfStudentcontact.andStudentcontactidEqualTo(studentcontactCustom.getStudentcontact().getStudentcontactid());
				}
				
				// ��ѯѧ�����
				if(studentcontactCustom.getStudentcontact().getStudentid()!=null){
					criteriaOfStudentcontact.andStudentidEqualTo(studentcontactCustom.getStudentcontact().getStudentid());
				}
				
				// ��ѯ��ͥסַ
				if(studentcontactCustom.getStudentcontact().getHomeaddress()!=null){
					studentcontactCustom.getStudentcontact().setHomeaddress("%"+studentcontactCustom.getStudentcontact().getHomeaddress()+"%");					
					criteriaOfStudentcontact.andHomeaddressLike(studentcontactCustom.getStudentcontact().getHomeaddress());
				}
				
				// ��ѯ��ͥ��Ա
				if(studentcontactCustom.getStudentcontact().getFamily()!=null){
					studentcontactCustom.getStudentcontact().setFamily("%"+studentcontactCustom.getStudentcontact().getFamily()+"%");					
					criteriaOfStudentcontact.andFamilyLike(studentcontactCustom.getStudentcontact().getFamily());
				}
				
				// ��ѯլ��
				if(studentcontactCustom.getStudentcontact().getPhone()!=null){
					studentcontactCustom.getStudentcontact().setPhone("%"+studentcontactCustom.getStudentcontact().getPhone()+"%");					
					criteriaOfStudentcontact.andPhoneLike(studentcontactCustom.getStudentcontact().getPhone());
				}
				
				// ��ѯ�ƶ��绰
				if(studentcontactCustom.getStudentcontact().getMobilephone()!=null){
					studentcontactCustom.getStudentcontact().setMobilephone("%"+studentcontactCustom.getStudentcontact().getMobilephone()+"%");					
					criteriaOfStudentcontact.andMobilephoneLike(studentcontactCustom.getStudentcontact().getMobilephone());
				}
				
				// ��ѯ�����ʼ�
				if(studentcontactCustom.getStudentcontact().getEmail()!=null){
					studentcontactCustom.getStudentcontact().setEmail("%"+studentcontactCustom.getStudentcontact().getEmail()+"%");					
					criteriaOfStudentcontact.andEmailLike(studentcontactCustom.getStudentcontact().getEmail());
				}

			}
		}
		// ��ѯ�������������緽ʽ��Ϣ
		List<Studentcontact>listOfStudentcontact = studentcontactMapper.selectByExample(studentcontactExample);
		if(listOfStudentcontact!=null) {
			List<StudentcontactCustom> listOfStudentcontactCustom = new ArrayList<>();
			for(Studentcontact studentcontactList:listOfStudentcontact) {
				StudentcontactCustom studentcontactCustomInfo = this.getStudentcontactCustom(studentcontactList.getStudentcontactid());
				listOfStudentcontactCustom.add(studentcontactCustomInfo);
			}
			return listOfStudentcontactCustom;	
		}else {
			return null;
		}
	}

}
