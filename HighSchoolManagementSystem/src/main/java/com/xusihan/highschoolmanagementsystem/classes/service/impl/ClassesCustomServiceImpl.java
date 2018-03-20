package com.xusihan.highschoolmanagementsystem.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ClassesMapper;
import com.xusihan.highschoolmanagementsystem.classes.service.ClassesCustomService;
import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.SemestersMapper;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesCustom;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample;
import com.xusihan.highschoolmanagementsystem.po.Semesters;

@Service("classesCustomServiceImpl")
public class ClassesCustomServiceImpl implements ClassesCustomService {

	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;
	
	@Resource(name = "semestersMapper")
	private SemestersMapper semestersMapper;
	
	@Override
	public ClassesCustom getClassCustom(Integer classid) {
		// ��Ҫ��װ������
		ClassesCustom classesCustom = new ClassesCustom();
		
		// ��ѯ��༶������Ӧ�İ༶��Ϣ����װ
		Classes classes = classesMapper.selectByPrimaryKey(classid);
		classesCustom.setClasses(classes);
		
		// ��ѯ��ѧУ������Ӧ��ѧУ���Ʋ���װ
		Integer schoolId = classes.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		classesCustom.setSchoolname(schoolName);
		
		// ��ѯ��ѧ�ڱ�����Ӧ��ѧ�����Ʋ���װ
		Integer semesterId = classes.getSemesterid();
		Semesters semesterInfo = semestersMapper.selectByPrimaryKey(semesterId);
		String semesterName = semesterInfo.getSemestername();
		classesCustom.setSemestername(semesterName);
		
		return classesCustom;
	}

	@Override
	public List<ClassesCustom> getClassesCustomList(ClassesCustom classesCustom) {
		
		ClassesExample classesExample = new ClassesExample();
		Criteria criteriaOfClasses = classesExample.createCriteria();
		criteriaOfClasses.andClassstateEqualTo(1);
		// ͨ��������ѯ����������ѧУ��Ϣ
		SchoolsExample schoolsExample = new SchoolsExample();
		com.xusihan.highschoolmanagementsystem.po.SchoolsExample.Criteria criteriaOfSchools = schoolsExample.createCriteria();
		criteriaOfSchools.andSchoolstateEqualTo(1);
		if(classesCustom!=null) {
			// ģ����ѯѧУ����
			if(classesCustom.getSchoolname()!= null && !classesCustom.getSchoolname().equals("") ) {
				// ͨ��ģ����ѯ����÷���������ѧУ���
				classesCustom.setSchoolname("%"+classesCustom.getSchoolname()+"%");
				criteriaOfSchools.andSchoolnameLike(classesCustom.getSchoolname());
				List<Schools> listOfSchools = schoolsMapper.selectByExample(schoolsExample);
				// ��ѯ�õ���ѧУ��Ϣ��Ӧ��ѧУ���
				List<Integer> listOfSchoolIds = new ArrayList<>();
				for(Schools schools:listOfSchools) {
					listOfSchoolIds.add(schools.getSchoolid());
				}
				
				if(listOfSchoolIds.isEmpty()) {
					return null;
				}else {
					criteriaOfClasses.andSchoolidIn(listOfSchoolIds);
				}
			}
			
			if(classesCustom.getClasses()!=null) {

				// ��ѯѧУ���
				if(classesCustom.getClasses().getSchoolid()!=null ) {
					criteriaOfClasses.andSchoolidEqualTo(classesCustom.getClasses().getSchoolid());
				}
				
				// ��ѯѧ�ڱ��
				if(classesCustom.getClasses().getSemesterid()!= null ) {
					criteriaOfClasses.andSemesteridEqualTo(classesCustom.getClasses().getSemesterid());
				}
				
				// ��ѯ�༶���
				if(classesCustom.getClasses().getClassid()!= null ) {
					criteriaOfClasses.andClassidEqualTo(classesCustom.getClasses().getClassid());
				}
				
				// ��ѯ�γ�����
				if(classesCustom.getClasses().getClassname()!=null && 
						!classesCustom.getClasses().getClassname().equals("")) {
					classesCustom.getClasses().setClassname("%"+classesCustom.getClasses().getClassname()+"%");
					criteriaOfClasses.andClassnameLike(classesCustom.getClasses().getClassname());
				}
			}
		}
		// ��ѯ���������İ༶��Ϣ
		List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
		if(listOfClasses!=null) {
			List<ClassesCustom> listOfClassesCustom = new ArrayList<>();
			for(Classes classesList:listOfClasses) {
				ClassesCustom classesCustomInfo = this.getClassCustom(classesList.getClassid());
				listOfClassesCustom.add(classesCustomInfo);
			}
			return listOfClassesCustom;
		}else {
			return null;
		}
	}
	
}
