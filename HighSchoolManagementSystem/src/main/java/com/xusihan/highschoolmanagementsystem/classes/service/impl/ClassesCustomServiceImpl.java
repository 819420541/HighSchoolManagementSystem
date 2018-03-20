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
		// 需要封装的属性
		ClassesCustom classesCustom = new ClassesCustom();
		
		// 查询与班级编号相对应的班级信息并封装
		Classes classes = classesMapper.selectByPrimaryKey(classid);
		classesCustom.setClasses(classes);
		
		// 查询与学校编号相对应的学校名称并封装
		Integer schoolId = classes.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		classesCustom.setSchoolname(schoolName);
		
		// 查询与学期编号相对应的学期名称并封装
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
		// 通过条件查询符合条件的学校信息
		SchoolsExample schoolsExample = new SchoolsExample();
		com.xusihan.highschoolmanagementsystem.po.SchoolsExample.Criteria criteriaOfSchools = schoolsExample.createCriteria();
		criteriaOfSchools.andSchoolstateEqualTo(1);
		if(classesCustom!=null) {
			// 模糊查询学校名称
			if(classesCustom.getSchoolname()!= null && !classesCustom.getSchoolname().equals("") ) {
				// 通过模糊查询来获得符合条件的学校编号
				classesCustom.setSchoolname("%"+classesCustom.getSchoolname()+"%");
				criteriaOfSchools.andSchoolnameLike(classesCustom.getSchoolname());
				List<Schools> listOfSchools = schoolsMapper.selectByExample(schoolsExample);
				// 查询得到的学校信息对应的学校编号
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

				// 查询学校编号
				if(classesCustom.getClasses().getSchoolid()!=null ) {
					criteriaOfClasses.andSchoolidEqualTo(classesCustom.getClasses().getSchoolid());
				}
				
				// 查询学期编号
				if(classesCustom.getClasses().getSemesterid()!= null ) {
					criteriaOfClasses.andSemesteridEqualTo(classesCustom.getClasses().getSemesterid());
				}
				
				// 查询班级编号
				if(classesCustom.getClasses().getClassid()!= null ) {
					criteriaOfClasses.andClassidEqualTo(classesCustom.getClasses().getClassid());
				}
				
				// 查询课程名称
				if(classesCustom.getClasses().getClassname()!=null && 
						!classesCustom.getClasses().getClassname().equals("")) {
					classesCustom.getClasses().setClassname("%"+classesCustom.getClasses().getClassname()+"%");
					criteriaOfClasses.andClassnameLike(classesCustom.getClasses().getClassname());
				}
			}
		}
		// 查询符合条件的班级信息
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
