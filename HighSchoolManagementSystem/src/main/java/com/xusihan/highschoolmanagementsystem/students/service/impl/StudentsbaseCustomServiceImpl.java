package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ClassesMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseCustom;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample.Criteria;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentsbaseMapper;
import com.xusihan.highschoolmanagementsystem.students.service.StudentsbaseCustomService;

@Service("studentsbaseCustomServiceImpl")
public class StudentsbaseCustomServiceImpl implements StudentsbaseCustomService {

	@Resource(name = "studentsbaseMapper")
	private StudentsbaseMapper studentsbaseMapper;
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;
	
	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;
	
	@Override
	public StudentsbaseCustom getStudentsbaseCustom(Integer studentid) {
		
		// ��Ҫ��װ������
		StudentsbaseCustom studentsbaseCustom = new StudentsbaseCustom();
		
		// ��ѯ��ѧ��������Ӧ��ѧ����Ϣ����װ
		Studentsbase studentsbase =  studentsbaseMapper.selectByPrimaryKey(studentid);
		studentsbaseCustom.setStudentsbase(studentsbase);
		
		// ��ѯ��ѧУ������Ӧ��ѧУ���Ʋ���װ
		Integer schoolId = studentsbase.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		studentsbaseCustom.setSchoolname(schoolName);
				
		// ��ѯ��༶������Ӧ�İ༶���Ʋ���װ
		Integer classId = studentsbase.getClassid();
		Classes classInfo = classesMapper.selectByPrimaryKey(classId);
		String className = classInfo.getClassname();
		studentsbaseCustom.setClassname(className);
		
		return studentsbaseCustom;
	}

	@Override
	public List<StudentsbaseCustom> getStudentsbaseCustomList(StudentsbaseCustom studentsbaseCustom) {
		
		StudentsbaseExample studentsbaseExample = new StudentsbaseExample();
		Criteria criteriaOfStudentsbase = studentsbaseExample.createCriteria();
		criteriaOfStudentsbase.andStudentstateEqualTo(1);
		
		// ͨ��������ѯ���������İ༶��Ϣ
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		criteriaOfClasses.andClassstateEqualTo(1);
		
		if(studentsbaseCustom!=null) {
			//ģ����ѯ�༶����
			if(studentsbaseCustom.getClassname()!=null && !studentsbaseCustom.getClassname().equals("")) {
				// ͨ��ģ����ѯ����÷��������İ༶��Ϣ
				studentsbaseCustom.setClassname("%"+studentsbaseCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(studentsbaseCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// ��ѯ�õ��İ༶��Ϣ��Ӧ�İ༶���
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Classes classes:listOfClasses) {
					listOfClassIds.add(classes.getClassid());
				}
				
				if(listOfClassIds.isEmpty()) {
					return null;
				}else {
					criteriaOfStudentsbase.andClassidIn(listOfClassIds);
				}
			}
	
			if(studentsbaseCustom.getStudentsbase()!=null) {
				
				// ��ѯ�༶���
				if(studentsbaseCustom.getStudentsbase().getClassid()!=null){
					criteriaOfStudentsbase.andClassidEqualTo(studentsbaseCustom.getStudentsbase().getClassid());
				}
				
				// ��ѯѧ�����
				if(studentsbaseCustom.getStudentsbase().getStudentid()!=null){
					criteriaOfStudentsbase.andStudentidEqualTo(studentsbaseCustom.getStudentsbase().getStudentid());
				}
				
				// ��ѯѧ������
				if(studentsbaseCustom.getStudentsbase().getStudentname()!=null &&
						!studentsbaseCustom.getStudentsbase().getStudentname().equals("")) {
					studentsbaseCustom.getStudentsbase().setStudentname("%"+studentsbaseCustom.getStudentsbase().getStudentname()+"%");
					criteriaOfStudentsbase.andStudentnameLike(studentsbaseCustom.getStudentsbase().getStudentname());
				}
			}
		}
		// ��ѯ����������ѧ����Ϣ
		List<Studentsbase>listOfStudentsbase = studentsbaseMapper.selectByExample(studentsbaseExample);
		if(listOfStudentsbase!=null) {
			List<StudentsbaseCustom> listOfStudentsbaseCustom = new ArrayList<>();
			for(Studentsbase studentsbaseList:listOfStudentsbase) {
				StudentsbaseCustom studentsbaseCustomInfo = this.getStudentsbaseCustom(studentsbaseList.getStudentid());
				listOfStudentsbaseCustom.add(studentsbaseCustomInfo);
			}
			return listOfStudentsbaseCustom;	
		}else {
			return null;
		}
	}
}
