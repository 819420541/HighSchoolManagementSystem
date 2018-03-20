package com.xusihan.highschoolmanagementsystem.students.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ClassesMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.CourseMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.SemestersMapper;
import com.xusihan.highschoolmanagementsystem.po.Attendances;
import com.xusihan.highschoolmanagementsystem.po.AttendancesCustom;
import com.xusihan.highschoolmanagementsystem.po.AttendancesExample;
import com.xusihan.highschoolmanagementsystem.po.AttendancesExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample;
import com.xusihan.highschoolmanagementsystem.po.Course;
import com.xusihan.highschoolmanagementsystem.po.Semesters;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.students.mapper.AttendancesMapper;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentsbaseMapper;
import com.xusihan.highschoolmanagementsystem.students.service.AttendancesCustomService;

@Service("attendancesCustomServiceImpl")
public class AttendancesCustomServiceImpl implements AttendancesCustomService {

	@Resource(name = "attendancesMapper")
	private AttendancesMapper attendancesMapper;
	
	@Resource(name = "semestersMapper")
	private SemestersMapper semestersMapper;
	
	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;
	
	@Resource(name = "courseMapper")
	private CourseMapper courseMapper;
	
	@Resource(name = "studentsbaseMapper")
	private StudentsbaseMapper studentsbaseMapper;
	
	@Override
	public AttendancesCustom getAttendancesCustom(Integer attendanceid) {
		
		// 需要封装的属性
		AttendancesCustom attendancesCustom = new AttendancesCustom();
		
		// 查询与考勤编号相对应的考勤信息并封装
		Attendances attendances = attendancesMapper.selectByPrimaryKey(attendanceid);
		attendancesCustom.setAttendances(attendances);
		
		// 查询与学期编号相对应的学期名称并封装
		Integer semesterId = attendances.getSemesterid();
		Semesters semesterInfo = semestersMapper.selectByPrimaryKey(semesterId);
		String semesterName = semesterInfo.getSemestername();
		attendancesCustom.setSemestername(semesterName);
		
		// 查询与班级编号相对应的班级名称并封装
		Integer classId = attendances.getClassid();
		Classes classInfo = classesMapper.selectByPrimaryKey(classId);
		String className = classInfo.getClassname();
		attendancesCustom.setClassname(className);
		
		// 查询与课程编号相对应的班级名称并封装
		Integer courseId = attendances.getCourseid();
		Course courseInfo = courseMapper.selectByPrimaryKey(courseId);
		String courseName = courseInfo.getCoursename();
		attendancesCustom.setCoursename(courseName);
		
		// 查询与课程编号相对应的班级名称并封装
		Integer studentId = attendances.getStudentid();
		Studentsbase studentsbaseInfo = studentsbaseMapper.selectByPrimaryKey(studentId);
		String studentName = studentsbaseInfo.getStudentname();
		attendancesCustom.setStudentname(studentName);
		
		return attendancesCustom;
	}

	@Override
	public List<AttendancesCustom> getAttendancesCustomList(AttendancesCustom attendancesCustom) {
		
		AttendancesExample attendancesExample = new AttendancesExample();
		Criteria criteriaOfAttendances = attendancesExample.createCriteria();
		
		// 通过条件查询符合条件的考勤信息
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		criteriaOfClasses.andClassstateEqualTo(1);
		
		if(attendancesCustom!=null) {
			//模糊查询班级名称
			if(attendancesCustom.getClassname()!=null && !attendancesCustom.getClassname().equals("")) {
				// 通过模糊查询来获得符合条件的班级信息
				attendancesCustom.setClassname("%"+attendancesCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(attendancesCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// 查询得到的班级信息对应的班级编号
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Classes classes:listOfClasses) {
					listOfClassIds.add(classes.getClassid());
				}
				
				if(listOfClassIds.isEmpty()) {
					return null;
				}else {
					criteriaOfAttendances.andClassidIn(listOfClassIds);
				}
			}
	
			if(attendancesCustom.getAttendances()!=null) {
				
				// 查询班级编号
				if(attendancesCustom.getAttendances().getClassid()!=null){
					criteriaOfAttendances.andClassidEqualTo(attendancesCustom.getAttendances().getClassid());
				}
				
				// 查询学生编号
				if(attendancesCustom.getAttendances().getStudentid()!=null){
					criteriaOfAttendances.andStudentidEqualTo(attendancesCustom.getAttendances().getStudentid());
				}
				
			}
		}
		// 查询符合条件的考勤信息
		List<Attendances>listOfAttendances = attendancesMapper.selectByExample(attendancesExample);
		if(listOfAttendances!=null) {
			List<AttendancesCustom> listOfAttendancesCustom = new ArrayList<>();
			for(Attendances attendancesList:listOfAttendances) {
				AttendancesCustom attendancesCustomInfo = this.getAttendancesCustom(attendancesList.getAttendanceid());
				listOfAttendancesCustom.add(attendancesCustomInfo);
			}
			return listOfAttendancesCustom;	
		}else {
			return null;
		}
	}

}
