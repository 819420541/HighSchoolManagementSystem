package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.database.mapper.SchoolsMapper;
import com.xusihan.highschoolmanagementsystem.database.mapper.SemestersMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamsMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamtypesMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamsCustomService;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsCustom;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample;
import com.xusihan.highschoolmanagementsystem.po.Schools;
import com.xusihan.highschoolmanagementsystem.po.SchoolsExample;
import com.xusihan.highschoolmanagementsystem.po.Semesters;
import com.xusihan.highschoolmanagementsystem.po.SemestersExample;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Examtypes;
import com.xusihan.highschoolmanagementsystem.po.ExamtypesExample;

@Service("examsCustomServiceImpl")
public class ExamsCustomServiceImpl implements ExamsCustomService {

	@Resource(name = "examsMapper")
	private ExamsMapper examsMapper;
	
	@Resource(name = "examtypesMapper")
	private ExamtypesMapper examtypesMapper;
	
	@Resource(name = "schoolsMapper")
	private SchoolsMapper schoolsMapper;
	
	@Resource(name = "semestersMapper")
	private SemestersMapper semestersMapper;
	
	@Override
	public ExamsCustom getExamsCustom(Integer examid) {
		
		// 需要封装的属性
		ExamsCustom examsCustom = new ExamsCustom();
		
		// 查询与考试编号相对应的考试信息并封装
		Exams exams = examsMapper.selectByPrimaryKey(examid);
		examsCustom.setExams(exams);

		// 查询与类型编号相对应的类型名称并封装
		Integer examtypeId = exams.getExamtypeid();
		Examtypes examtypeInfo = examtypesMapper.selectByPrimaryKey(examtypeId);
		String examtypeName = examtypeInfo.getExamtypename();
		examsCustom.setExamtypename(examtypeName);
		
		// 查询与学校编号相对应的学校名称并封装
		Integer schoolId = exams.getSchoolid();
		Schools schoolInfo = schoolsMapper.selectByPrimaryKey(schoolId);
		String schoolName = schoolInfo.getSchoolname();
		examsCustom.setSchoolname(schoolName);
		
		// 查询与学期编号相对应的学期名称并封装
		Integer semesterId = exams.getSemesterid();
		Semesters semesterInfo = semestersMapper.selectByPrimaryKey(semesterId);
		String semesterName = semesterInfo.getSemestername();
		examsCustom.setSemestername(semesterName);
		
		return examsCustom;
	}

	@Override
	public List<ExamsCustom> getExamsCustomList(ExamsCustom examsCustom) {
		
		ExamsExample examsExample = new ExamsExample();
		Criteria criteriaOfExams = examsExample.createCriteria();
		criteriaOfExams.andExamstateEqualTo(1);
		
		//通过条件查询符合条件的考试信息
		ExamtypesExample examtypesExample = new ExamtypesExample();
		com.xusihan.highschoolmanagementsystem.po.ExamtypesExample.Criteria criteriaOfExamtypes = examtypesExample.createCriteria();
		criteriaOfExamtypes.andExamtypestateEqualTo(1);
		
		SchoolsExample schoolsExample = new SchoolsExample();
		com.xusihan.highschoolmanagementsystem.po.SchoolsExample.Criteria criteriaOfSchools = schoolsExample.createCriteria();
		criteriaOfSchools.andSchoolstateEqualTo(1);
		
		SemestersExample semestersExample = new SemestersExample();
		com.xusihan.highschoolmanagementsystem.po.SemestersExample.Criteria criteriaOfSemesters = semestersExample.createCriteria();
		criteriaOfSemesters.andSemesterstateEqualTo(1);
		
		if(examsCustom!=null) {
			// 模糊查询类型名称
			if(examsCustom.getExamtypename()!= null && !examsCustom.getExamtypename().equals("") ) {
				// 通过模糊查询来获得符合条件的类型编号
				examsCustom.setExamtypename("%"+examsCustom.getExamtypename()+"%");
				criteriaOfExamtypes.andExamtypenameLike(examsCustom.getExamtypename());
				List<Examtypes> listOfExamtypes = examtypesMapper.selectByExample(examtypesExample);
				// 查询得到的类型信息对应的类型编号
				List<Integer> listOfExamtypeIds = new ArrayList<>();
				for(Examtypes examtypesList:listOfExamtypes) {
					listOfExamtypeIds.add(examtypesList.getExamtypeid());
				}
				if(!listOfExamtypeIds.isEmpty()) {
					criteriaOfExams.andExamtypeidIn(listOfExamtypeIds);
				}
			}
						
			// 模糊查询学校名称
			if(examsCustom.getSchoolname()!= null && !examsCustom.getSchoolname().equals("") ) {
				// 通过模糊查询来获得符合条件的学校编号
				examsCustom.setSchoolname("%"+examsCustom.getSchoolname()+"%");
				criteriaOfSchools.andSchoolnameLike(examsCustom.getSchoolname());
				List<Schools> listOfSchools = schoolsMapper.selectByExample(schoolsExample);
				// 查询得到的学校信息对应的考试1编号
				List<Integer> listOfSchoolIds = new ArrayList<>();
				for(Schools schoolsList:listOfSchools) {
					listOfSchoolIds.add(schoolsList.getSchoolid());
				}
				
				if(!listOfSchoolIds.isEmpty()) {
					criteriaOfExams.andSchoolidIn(listOfSchoolIds);
				}
			}
			
			// 模糊查询学期名称
			if(examsCustom.getSemestername()!= null && !examsCustom.getSemestername().equals("") ) {
				// 通过模糊查询来获得符合条件的学期编号
				examsCustom.setSemestername("%"+examsCustom.getSemestername()+"%");
				criteriaOfSemesters.andSemesternameLike(examsCustom.getSemestername());
				List<Semesters> listOfSemesters = semestersMapper.selectByExample(semestersExample);
				// 查询得到的学期信息对应的学期编号
				List<Integer> listOfSemesterIds = new ArrayList<>();
				for(Semesters semestersList:listOfSemesters) {
					listOfSemesterIds.add(semestersList.getSemesterid());
				}
				if(!listOfSemesterIds.isEmpty()) {
					criteriaOfExams.andSemesteridIn(listOfSemesterIds);
				}
			}
			
			if(examsCustom.getExams()!=null) {
				
				// 查询考试编号
				if(examsCustom.getExams().getExamid()!= null ) {
					criteriaOfExams.andExamidEqualTo(examsCustom.getExams().getExamid());
				}
				
				// 查询类型编号
				if(examsCustom.getExams().getExamtypeid()!= null ) {
					criteriaOfExamtypes.andExamtypeidEqualTo(examsCustom.getExams().getExamtypeid());
				}
				
				// 查询学校编号
				if(examsCustom.getExams().getSchoolid()!=null ) {
					criteriaOfExams.andSchoolidEqualTo(examsCustom.getExams().getSchoolid());
				}
				
				// 查询学期编号
				if(examsCustom.getExams().getSemesterid()!=null ) {
					criteriaOfExams.andSemesteridEqualTo(examsCustom.getExams().getSemesterid());
				}
				
				// 查询考试名称
				if(examsCustom.getExams().getExamname()!=null && !examsCustom.getExams().getExamname().equals("")) {
					examsCustom.getExams().setExamname("%"+examsCustom.getExams().getExamname()+"%");
					criteriaOfExams.andExamnameLike(examsCustom.getExams().getExamname());
				}
				
				
			}
		}
		// 查询符合条件的考试信息
		List<Exams> listOfExams = examsMapper.selectByExample(examsExample);
		if(listOfExams!=null) {
			List<ExamsCustom> listOfExamsCustom = new ArrayList<>();
			for(Exams examsList:listOfExams) {
				ExamsCustom examsCustomInfo = this.getExamsCustom(examsList.getExamid());
				listOfExamsCustom.add(examsCustomInfo);
			}
			return listOfExamsCustom;
		}else {
			return null;
		}
		
	}
}
