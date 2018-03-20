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
		
		// 需要封装的属性
		StudentcontactCustom studentcontactCustom = new StudentcontactCustom();
		
		// 查询与联系方式编号相对应的联系方式信息并封装
		Studentcontact studentcontact = studentcontactMapper.selectByPrimaryKey(attendanceid);
		studentcontactCustom.setStudentcontact(studentcontact);
		
		// 查询与学生编号相对应的学生姓名并封装
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
		
		// 通过条件查询符合条件的考勤信息
		StudentsbaseExample studentsbaseExample = new StudentsbaseExample();
		com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample.Criteria criteriaOfStudentsbase = studentsbaseExample.createCriteria();
		criteriaOfStudentsbase.andStudentstateEqualTo(1);
		
		if(studentcontactCustom!=null) {
			//模糊查询学生姓名
			if(studentcontactCustom.getStudentname()!=null && !studentcontactCustom.getStudentname().equals("")) {
				// 通过模糊查询来获得符合条件的学生信息
				studentcontactCustom.setStudentname("%"+studentcontactCustom.getStudentname()+"%");
				criteriaOfStudentsbase.andStudentnameLike(studentcontactCustom.getStudentname());
				List<Studentsbase> listOfStudentsbase = studentsbaseMapper.selectByExample(studentsbaseExample);
				// 查询得到的学生信息对应的学生编号
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Studentsbase studentsbase:listOfStudentsbase) {
					listOfClassIds.add(studentsbase.getClassid());
				}
				if(!listOfClassIds.isEmpty()) {
					criteriaOfStudentcontact.andStudentidIn(listOfClassIds);
				}
			}
	
			if(studentcontactCustom.getStudentcontact()!=null) {
				
				// 查询联系方式编号
				if(studentcontactCustom.getStudentcontact().getStudentcontactid()!=null){
					criteriaOfStudentcontact.andStudentcontactidEqualTo(studentcontactCustom.getStudentcontact().getStudentcontactid());
				}
				
				// 查询学生编号
				if(studentcontactCustom.getStudentcontact().getStudentid()!=null){
					criteriaOfStudentcontact.andStudentidEqualTo(studentcontactCustom.getStudentcontact().getStudentid());
				}
				
				// 查询家庭住址
				if(studentcontactCustom.getStudentcontact().getHomeaddress()!=null){
					studentcontactCustom.getStudentcontact().setHomeaddress("%"+studentcontactCustom.getStudentcontact().getHomeaddress()+"%");					
					criteriaOfStudentcontact.andHomeaddressLike(studentcontactCustom.getStudentcontact().getHomeaddress());
				}
				
				// 查询家庭成员
				if(studentcontactCustom.getStudentcontact().getFamily()!=null){
					studentcontactCustom.getStudentcontact().setFamily("%"+studentcontactCustom.getStudentcontact().getFamily()+"%");					
					criteriaOfStudentcontact.andFamilyLike(studentcontactCustom.getStudentcontact().getFamily());
				}
				
				// 查询宅电
				if(studentcontactCustom.getStudentcontact().getPhone()!=null){
					studentcontactCustom.getStudentcontact().setPhone("%"+studentcontactCustom.getStudentcontact().getPhone()+"%");					
					criteriaOfStudentcontact.andPhoneLike(studentcontactCustom.getStudentcontact().getPhone());
				}
				
				// 查询移动电话
				if(studentcontactCustom.getStudentcontact().getMobilephone()!=null){
					studentcontactCustom.getStudentcontact().setMobilephone("%"+studentcontactCustom.getStudentcontact().getMobilephone()+"%");					
					criteriaOfStudentcontact.andMobilephoneLike(studentcontactCustom.getStudentcontact().getMobilephone());
				}
				
				// 查询电子邮件
				if(studentcontactCustom.getStudentcontact().getEmail()!=null){
					studentcontactCustom.getStudentcontact().setEmail("%"+studentcontactCustom.getStudentcontact().getEmail()+"%");					
					criteriaOfStudentcontact.andEmailLike(studentcontactCustom.getStudentcontact().getEmail());
				}

			}
		}
		// 查询符合条件的联络方式信息
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
