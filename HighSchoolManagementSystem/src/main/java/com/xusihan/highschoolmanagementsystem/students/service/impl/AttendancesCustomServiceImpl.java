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
		
		// ��Ҫ��װ������
		AttendancesCustom attendancesCustom = new AttendancesCustom();
		
		// ��ѯ�뿼�ڱ�����Ӧ�Ŀ�����Ϣ����װ
		Attendances attendances = attendancesMapper.selectByPrimaryKey(attendanceid);
		attendancesCustom.setAttendances(attendances);
		
		// ��ѯ��ѧ�ڱ�����Ӧ��ѧ�����Ʋ���װ
		Integer semesterId = attendances.getSemesterid();
		Semesters semesterInfo = semestersMapper.selectByPrimaryKey(semesterId);
		String semesterName = semesterInfo.getSemestername();
		attendancesCustom.setSemestername(semesterName);
		
		// ��ѯ��༶������Ӧ�İ༶���Ʋ���װ
		Integer classId = attendances.getClassid();
		Classes classInfo = classesMapper.selectByPrimaryKey(classId);
		String className = classInfo.getClassname();
		attendancesCustom.setClassname(className);
		
		// ��ѯ��γ̱�����Ӧ�İ༶���Ʋ���װ
		Integer courseId = attendances.getCourseid();
		Course courseInfo = courseMapper.selectByPrimaryKey(courseId);
		String courseName = courseInfo.getCoursename();
		attendancesCustom.setCoursename(courseName);
		
		// ��ѯ��γ̱�����Ӧ�İ༶���Ʋ���װ
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
		
		// ͨ��������ѯ���������Ŀ�����Ϣ
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		criteriaOfClasses.andClassstateEqualTo(1);
		
		if(attendancesCustom!=null) {
			//ģ����ѯ�༶����
			if(attendancesCustom.getClassname()!=null && !attendancesCustom.getClassname().equals("")) {
				// ͨ��ģ����ѯ����÷��������İ༶��Ϣ
				attendancesCustom.setClassname("%"+attendancesCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(attendancesCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// ��ѯ�õ��İ༶��Ϣ��Ӧ�İ༶���
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
				
				// ��ѯ�༶���
				if(attendancesCustom.getAttendances().getClassid()!=null){
					criteriaOfAttendances.andClassidEqualTo(attendancesCustom.getAttendances().getClassid());
				}
				
				// ��ѯѧ�����
				if(attendancesCustom.getAttendances().getStudentid()!=null){
					criteriaOfAttendances.andStudentidEqualTo(attendancesCustom.getAttendances().getStudentid());
				}
				
			}
		}
		// ��ѯ���������Ŀ�����Ϣ
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
