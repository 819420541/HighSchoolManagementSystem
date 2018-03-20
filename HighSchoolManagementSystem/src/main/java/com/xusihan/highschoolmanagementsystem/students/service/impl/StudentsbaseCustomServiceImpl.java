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
		
		// 需要封装的属性
		StudentsbaseCustom studentsbaseCustom = new StudentsbaseCustom();
		
		// 查询与学生编号相对应的学生信息并封装
		Studentsbase studentsbase =  studentsbaseMapper.selectByPrimaryKey(studentid);
		studentsbaseCustom.setStudentsbase(studentsbase);
		
		// 查询与学校编号相对应的学校名称并封装
		Integer schoolId = studentsbase.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		studentsbaseCustom.setSchoolname(schoolName);
				
		// 查询与班级编号相对应的班级名称并封装
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
		
		// 通过条件查询符合条件的班级信息
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		criteriaOfClasses.andClassstateEqualTo(1);
		
		if(studentsbaseCustom!=null) {
			//模糊查询班级名称
			if(studentsbaseCustom.getClassname()!=null && !studentsbaseCustom.getClassname().equals("")) {
				// 通过模糊查询来获得符合条件的班级信息
				studentsbaseCustom.setClassname("%"+studentsbaseCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(studentsbaseCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// 查询得到的班级信息对应的班级编号
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
				
				// 查询班级编号
				if(studentsbaseCustom.getStudentsbase().getClassid()!=null){
					criteriaOfStudentsbase.andClassidEqualTo(studentsbaseCustom.getStudentsbase().getClassid());
				}
				
				// 查询学生编号
				if(studentsbaseCustom.getStudentsbase().getStudentid()!=null){
					criteriaOfStudentsbase.andStudentidEqualTo(studentsbaseCustom.getStudentsbase().getStudentid());
				}
				
				// 查询学生姓名
				if(studentsbaseCustom.getStudentsbase().getStudentname()!=null &&
						!studentsbaseCustom.getStudentsbase().getStudentname().equals("")) {
					studentsbaseCustom.getStudentsbase().setStudentname("%"+studentsbaseCustom.getStudentsbase().getStudentname()+"%");
					criteriaOfStudentsbase.andStudentnameLike(studentsbaseCustom.getStudentsbase().getStudentname());
				}
			}
		}
		// 查询符合条件的学生信息
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
