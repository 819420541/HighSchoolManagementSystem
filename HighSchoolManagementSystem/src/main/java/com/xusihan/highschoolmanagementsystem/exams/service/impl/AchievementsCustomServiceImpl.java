package com.xusihan.highschoolmanagementsystem.exams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamplansMapper;
import com.xusihan.highschoolmanagementsystem.exams.mapper.ExamsMapper;
import com.xusihan.highschoolmanagementsystem.exams.service.AchievementsCustomService;
import com.xusihan.highschoolmanagementsystem.po.Examplans;
import com.xusihan.highschoolmanagementsystem.po.ExamplansExample;
import com.xusihan.highschoolmanagementsystem.po.Achievements;
import com.xusihan.highschoolmanagementsystem.po.AchievementsCustom;
import com.xusihan.highschoolmanagementsystem.po.AchievementsExample;
import com.xusihan.highschoolmanagementsystem.po.Exams;
import com.xusihan.highschoolmanagementsystem.po.ExamsExample;
import com.xusihan.highschoolmanagementsystem.po.Studentsbase;
import com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample;
import com.xusihan.highschoolmanagementsystem.students.mapper.AchievementsMapper;
import com.xusihan.highschoolmanagementsystem.students.mapper.StudentsbaseMapper;
import com.xusihan.highschoolmanagementsystem.po.AchievementsExample.Criteria;

@Service("achievementsCustomServiceImpl")
public class AchievementsCustomServiceImpl implements AchievementsCustomService {

	@Resource(name = "achievementsMapper")
	private AchievementsMapper achievementsMapper;
	
	@Resource(name = "examplansMapper")
	private ExamplansMapper examplansMapper;
	
	@Resource(name = "examsMapper")
	private ExamsMapper examsMapper;
	
	@Resource(name = "studentsbaseMapper")
	private StudentsbaseMapper studentsbaseMapper;
	
	@Override
	public AchievementsCustom getAchievementsCustom(Integer achievementid) {
		
		// 需要封装的属性
		AchievementsCustom achievementsCustom = new AchievementsCustom();
		
		// 查询与课程编号相对应的课程信息并封装
		Achievements achievements = achievementsMapper.selectByPrimaryKey(achievementid);
		achievementsCustom.setAchievements(achievements);
		
		// 查询与考试编号相对应的考试安排名称并封装
		Integer examplanId = achievements.getExamplanid();
		Examplans examplanInfo = examplansMapper.selectByPrimaryKey(examplanId);
		String examplanName = examplanInfo.getExamplanname();
		achievementsCustom.setExamplanname(examplanName);
		
		// 查询与考试编号相对应的考试名称并封装
		Integer examId = achievements.getExamid();
		Exams examInfo = examsMapper.selectByPrimaryKey(examId);
		String examName = examInfo.getExamname();
		achievementsCustom.setExamname(examName);
		
		// 查询与班级编号相对应的班级名称并封装
		Integer studentId = achievements.getStudentid();
		Studentsbase studentsbaseInfo = studentsbaseMapper.selectByPrimaryKey(studentId);
		String studentName = studentsbaseInfo.getStudentname();
		achievementsCustom.setStudentname(studentName);
		
		return achievementsCustom;
	}

	@Override
	public List<AchievementsCustom> getAchievementsCustomList(AchievementsCustom achievementsCustom) {
		
		AchievementsExample achievementsExample = new AchievementsExample();
		Criteria criteriaOfAchievements = achievementsExample.createCriteria();
		
		//通过条件查询符合条件的考试安排信息
		ExamplansExample examplansExample = new ExamplansExample();
		com.xusihan.highschoolmanagementsystem.po.ExamplansExample.Criteria criteriaOfExamplans = examplansExample.createCriteria();
		criteriaOfExamplans.andExamplanstateEqualTo(1);
		
		ExamsExample examsExample = new ExamsExample();
		com.xusihan.highschoolmanagementsystem.po.ExamsExample.Criteria criteriaOfExams = examsExample.createCriteria();
		criteriaOfExams.andExamstateEqualTo(1);
		
		StudentsbaseExample studentsbaseExample = new StudentsbaseExample();
		com.xusihan.highschoolmanagementsystem.po.StudentsbaseExample.Criteria criteriaOfStudents = studentsbaseExample.createCriteria();
		criteriaOfStudents.andStudentstateEqualTo(1);
		
		if(achievementsCustom!=null) {
			// 模糊查询考试安排名称
			if(achievementsCustom.getExamplanname()!= null && !achievementsCustom.getExamplanname().equals("") ) {
				// 通过模糊查询来获得符合条件的考试安排编号
				achievementsCustom.setExamplanname("%"+achievementsCustom.getExamplanname()+"%");
				criteriaOfExamplans.andExamplannameLike(achievementsCustom.getExamplanname());
				List<Examplans> listOfExamplans = examplansMapper.selectByExample(examplansExample);
				// 查询得到的考试安排信息对应的考试安排编号
				List<Integer> listOfAchievementBookIds = new ArrayList<>();
				for(Examplans examplans:listOfExamplans) {
					listOfAchievementBookIds.add(examplans.getExamplanid());
				}
				if(!listOfAchievementBookIds.isEmpty()) {
					criteriaOfAchievements.andExamplanidIn(listOfAchievementBookIds);
				}
			}
			// 模糊查询考试名称
			if(achievementsCustom.getExamname()!= null && !achievementsCustom.getExamname().equals("") ) {
				// 通过模糊查询来获得符合条件的考试编号
				achievementsCustom.setExamname("%"+achievementsCustom.getExamname()+"%");
				criteriaOfExams.andExamnameLike(achievementsCustom.getExamname());
				List<Exams> listOfExams = examsMapper.selectByExample(examsExample);
				// 查询得到的考试信息对应的考试编号
				List<Integer> listOfAchievementBookIds = new ArrayList<>();
				for(Exams exams:listOfExams) {
					listOfAchievementBookIds.add(exams.getExamid());
				}
				if(!listOfAchievementBookIds.isEmpty()) {
					criteriaOfAchievements.andExamidIn(listOfAchievementBookIds);
				}
			}
			// 模糊查询学生名称
			if(achievementsCustom.getStudentname()!= null && !achievementsCustom.getStudentname().equals("") ) {
				// 通过模糊查询来获得符合条件的学生编号
				achievementsCustom.setStudentname("%"+achievementsCustom.getStudentname()+"%");
				criteriaOfStudents.andStudentnameLike(achievementsCustom.getStudentname());
				List<Studentsbase> listOfStudents = studentsbaseMapper.selectByExample(studentsbaseExample);
				// 查询得到的班级信息对应的学生编号
				List<Integer> listOfStudentIds = new ArrayList<>();
				for(Studentsbase studentes:listOfStudents) {
					listOfStudentIds.add(studentes.getStudentid());
				}
				if(!listOfStudentIds.isEmpty()) {
					criteriaOfAchievements.andExamidIn(listOfStudentIds);
				}
			}
			
			if(achievementsCustom.getAchievements()!=null) {
				
				// 查询成绩编号
				if(achievementsCustom.getAchievements().getAchievementid()!= null ) {
					criteriaOfAchievements.andAchievementidEqualTo(achievementsCustom.getAchievements().getAchievementid());
				}
				
				// 查询考试安排编号
				if(achievementsCustom.getAchievements().getExamplanid()!= null ) {
					criteriaOfExamplans.andExamplanidEqualTo(achievementsCustom.getAchievements().getExamplanid());
				}
				
				// 查询考试编号
				if(achievementsCustom.getAchievements().getExamid()!=null ) {
					criteriaOfAchievements.andExamidEqualTo(achievementsCustom.getAchievements().getExamid());
				}
				
				// 查询学生编号
				if(achievementsCustom.getAchievements().getStudentid()!=null ) {
					criteriaOfAchievements.andStudentidEqualTo(achievementsCustom.getAchievements().getStudentid());
				}
			}
		}
		// 查询符合条件的课程信息
		List<Achievements> listOfAchievements = achievementsMapper.selectByExample(achievementsExample);
		if(listOfAchievements!=null) {
			List<AchievementsCustom> listOfAchievementsCustom = new ArrayList<>();
			for(Achievements achievementsList:listOfAchievements) {
				AchievementsCustom achievementsCustomInfo = this.getAchievementsCustom(achievementsList.getAchievementid());
				listOfAchievementsCustom.add(achievementsCustomInfo);
			}
			return listOfAchievementsCustom;
		}else {
			return null;
		}
		
	}
	
}
