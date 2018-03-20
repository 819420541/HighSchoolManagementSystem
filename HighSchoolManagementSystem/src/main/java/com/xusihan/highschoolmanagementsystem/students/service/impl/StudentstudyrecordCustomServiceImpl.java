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
		
		// 需要封装的属性
		StudentstudyrecordCustom studentstudyrecordCustom = new StudentstudyrecordCustom();
		
		// 查询与联系方式编号相对应的联系方式信息并封装
		Studentstudyrecord studentstudyrecord = studentstudyrecordMapper.selectByPrimaryKey(attendanceid);
		studentstudyrecordCustom.setStudentstudyrecord(studentstudyrecord);
		
		// 查询与学生编号相对应的学生姓名并封装
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
		
		// 通过条件查询符合条件的考勤信息
		StudentsbaseExample studentsbaseExample = new StudentsbaseExample();
		com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample.Criteria criteriaOfStudentsbase = studentsbaseExample.createCriteria();
		criteriaOfStudentsbase.andStudentstateEqualTo(1);
		
		if(studentstudyrecordCustom!=null) {
			//模糊查询学生姓名
			if(studentstudyrecordCustom.getStudentname()!=null && !studentstudyrecordCustom.getStudentname().equals("")) {
				// 通过模糊查询来获得符合条件的学生信息
				studentstudyrecordCustom.setStudentname("%"+studentstudyrecordCustom.getStudentname()+"%");
				criteriaOfStudentsbase.andStudentnameLike(studentstudyrecordCustom.getStudentname());
				List<Studentsbase> listOfStudentsbase = studentsbaseMapper.selectByExample(studentsbaseExample);
				// 查询得到的学生信息对应的学生编号
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Studentsbase studentsbase:listOfStudentsbase) {
					listOfClassIds.add(studentsbase.getClassid());
				}
				if(!listOfClassIds.isEmpty()) {
					criteriaOfStudentstudyrecord.andStudentidIn(listOfClassIds);
				}
			}
	
			if(studentstudyrecordCustom.getStudentstudyrecord()!=null) {
				
				// 查询学历编号
				if(studentstudyrecordCustom.getStudentstudyrecord().getStudyrecordid()!=null){
					criteriaOfStudentstudyrecord.andStudyrecordidEqualTo(studentstudyrecordCustom.getStudentstudyrecord().getStudyrecordid());
				}
				
				// 查询学生编号
				if(studentstudyrecordCustom.getStudentstudyrecord().getStudentid()!=null){
					criteriaOfStudentstudyrecord.andStudentidEqualTo(studentstudyrecordCustom.getStudentstudyrecord().getStudentid());
				}
				
				// 查询计算机基础
				if(studentstudyrecordCustom.getStudentstudyrecord().getComputerlevel()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setComputerlevel("%"+studentstudyrecordCustom.getStudentstudyrecord().getComputerlevel()+"%");					
					criteriaOfStudentstudyrecord.andComputerlevelLike(studentstudyrecordCustom.getStudentstudyrecord().getComputerlevel());
				}
				
				// 查询英语基础
				if(studentstudyrecordCustom.getStudentstudyrecord().getEnglishlevel()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setEnglishlevel("%"+studentstudyrecordCustom.getStudentstudyrecord().getEnglishlevel()+"%");					
					criteriaOfStudentstudyrecord.andEnglishlevelLike(studentstudyrecordCustom.getStudentstudyrecord().getEnglishlevel());
				}
				
				// 查询毕业学校
				if(studentstudyrecordCustom.getStudentstudyrecord().getGraduateschool()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setGraduateschool("%"+studentstudyrecordCustom.getStudentstudyrecord().getGraduateschool()+"%");					
					criteriaOfStudentstudyrecord.andGraduateschoolLike(studentstudyrecordCustom.getStudentstudyrecord().getGraduateschool());
				}
				
				// 查询毕业时间
				if(studentstudyrecordCustom.getStudentstudyrecord().getGradutetime()!=null){				
					criteriaOfStudentstudyrecord.andGradutetimeEqualTo(studentstudyrecordCustom.getStudentstudyrecord().getGradutetime());
				}
				
				// 查询持有证书
				if(studentstudyrecordCustom.getStudentstudyrecord().getCertificate()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setCertificate("%"+studentstudyrecordCustom.getStudentstudyrecord().getCertificate()+"%");					
					criteriaOfStudentstudyrecord.andCertificateLike(studentstudyrecordCustom.getStudentstudyrecord().getCertificate());
				}
				
				// 查询工作单位
				if(studentstudyrecordCustom.getStudentstudyrecord().getJobcompany()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setJobcompany("%"+studentstudyrecordCustom.getStudentstudyrecord().getJobcompany()+"%");					
					criteriaOfStudentstudyrecord.andJobcompanyLike(studentstudyrecordCustom.getStudentstudyrecord().getJobcompany());
				}
				// 查询工作经历
				if(studentstudyrecordCustom.getStudentstudyrecord().getJobcourse()!=null){
					studentstudyrecordCustom.getStudentstudyrecord().setJobcourse("%"+studentstudyrecordCustom.getStudentstudyrecord().getJobcourse()+"%");					
					criteriaOfStudentstudyrecord.andJobcourseLike(studentstudyrecordCustom.getStudentstudyrecord().getJobcourse());
				}
				
			}
		}
		// 查询符合条件的联络方式信息
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
