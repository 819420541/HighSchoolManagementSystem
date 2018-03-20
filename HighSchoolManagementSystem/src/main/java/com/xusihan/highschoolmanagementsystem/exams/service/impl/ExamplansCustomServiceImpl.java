package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ClassesMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamplansMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamsMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.ExamplansCustomService;
import com.xusihan.highschoolmanagementsystem.po.Examplans;
import com.xusihan.highschoolmanagementsystem.po.ExamplansCustom;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample.Criteria;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample;
import com.xusihan.highschoolmanagementsystem.po.Classes;
import com.xusihan.highschoolmanagementsystem.po.ClassesExample;

@Service("examplansCustomServiceImpl")
public class ExamplansCustomServiceImpl implements ExamplansCustomService {

	@Resource(name = "examplansMapper")
	private ExamplansMapper examplansMapper;
	
	@Resource(name = "examsMapper")
	private ExamsMapper examsMapper;
	
	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;
	
	@Override
	public ExamplansCustom getExamplansCustom(Integer examplanid) {
		
		// 需要封装的属性
		ExamplansCustom examplansCustom = new ExamplansCustom();
		
		// 查询与课程编号相对应的课程信息并封装
		Examplans examplans = examplansMapper.selectByPrimaryKey(examplanid);
		examplansCustom.setExamplans(examplans);
		
		// 查询与考试编号相对应的考试名称并封装
		Integer examId = examplans.getExamid();
		Exams examInfo = examsMapper.selectByPrimaryKey(examId);
		String examName = examInfo.getExamname();
		examplansCustom.setExamname(examName);
		
		// 查询与班级编号相对应的班级名称并封装
		Integer classId = examplans.getClassid();
		Classes classInfo = classesMapper.selectByPrimaryKey(classId);
		String className = classInfo.getClassname();
		examplansCustom.setClassname(className);
		
		return examplansCustom;
	}

	@Override
	public List<ExamplansCustom> getExamplansCustomList(ExamplansCustom examplansCustom) {
		
		ExamplansExample examplansExample = new ExamplansExample();
		Criteria criteriaOfExamplans = examplansExample.createCriteria();
		criteriaOfExamplans.andExamplanstateEqualTo(1);
		
		//通过条件查询符合条件的考试安排信息
		ExamsExample examsExample = new ExamsExample();
		com.xusihan.highschoolmanagementsystem.po.ExamsExample.Criteria criteriaOfExams = examsExample.createCriteria();
		criteriaOfExams.andExamstateEqualTo(1);
		
		ClassesExample classesExample = new ClassesExample();
		com.xusihan.highschoolmanagementsystem.po.ClassesExample.Criteria criteriaOfClasses = classesExample.createCriteria();
		criteriaOfClasses.andClassstateEqualTo(1);
		
		if(examplansCustom!=null) {
			// 模糊查询考试名称
			if(examplansCustom.getExamname()!= null && !examplansCustom.getExamname().equals("") ) {
				// 通过模糊查询来获得符合条件的考试编号
				examplansCustom.setExamname("%"+examplansCustom.getExamname()+"%");
				criteriaOfExams.andExamnameLike(examplansCustom.getExamname());
				List<Exams> listOfExams = examsMapper.selectByExample(examsExample);
				// 查询得到的考试信息对应的考试编号
				List<Integer> listOfExamplanBookIds = new ArrayList<>();
				for(Exams exams:listOfExams) {
					listOfExamplanBookIds.add(exams.getExamid());
				}
				if(!listOfExamplanBookIds.isEmpty()) {
					criteriaOfExamplans.andExamidIn(listOfExamplanBookIds);
				}
			}
			// 模糊查询班级名称
			if(examplansCustom.getClassname()!= null && !examplansCustom.getClassname().equals("") ) {
				// 通过模糊查询来获得符合条件的班级编号
				examplansCustom.setClassname("%"+examplansCustom.getClassname()+"%");
				criteriaOfClasses.andClassnameLike(examplansCustom.getClassname());
				List<Classes> listOfClasses = classesMapper.selectByExample(classesExample);
				// 查询得到的班级信息对应的班级编号
				List<Integer> listOfClassIds = new ArrayList<>();
				for(Classes classes:listOfClasses) {
					listOfClassIds.add(classes.getClassid());
				}
				if(!listOfClassIds.isEmpty()) {
					criteriaOfExamplans.andExamidIn(listOfClassIds);
				}
			}
			
			if(examplansCustom.getExamplans()!=null) {
				
				// 查询考试安排编号
				if(examplansCustom.getExamplans().getExamplanid()!= null ) {
					criteriaOfExamplans.andExamplanidEqualTo(examplansCustom.getExamplans().getExamplanid());
				}
				
				// 查询考试安排名称
				if(examplansCustom.getExamplans().getExamplanname()!=null && !examplansCustom.getExamplans().getExamplanname().equals("")) {
					examplansCustom.getExamplans().setExamplanname("%"+examplansCustom.getExamplans().getExamplanname()+"%");
					criteriaOfExamplans.andExamplannameLike(examplansCustom.getExamplans().getExamplanname());
				}
				
				// 查询考试编号
				if(examplansCustom.getExamplans().getExamid()!=null ) {
					criteriaOfExamplans.andExamidEqualTo(examplansCustom.getExamplans().getExamid());
				}
				
				// 查询考试编号
				if(examplansCustom.getExamplans().getClassid()!=null ) {
					criteriaOfExamplans.andClassidEqualTo(examplansCustom.getExamplans().getClassid());
				}
			}
		}
		// 查询符合条件的课程信息
		List<Examplans> listOfExamplans = examplansMapper.selectByExample(examplansExample);
		if(listOfExamplans!=null) {
			List<ExamplansCustom> listOfExamplansCustom = new ArrayList<>();
			for(Examplans examplansList:listOfExamplans) {
				ExamplansCustom examplansCustomInfo = this.getExamplansCustom(examplansList.getExamplanid());
				listOfExamplansCustom.add(examplansCustomInfo);
			}
			return listOfExamplansCustom;
		}else {
			return null;
		}
	}
	
}
