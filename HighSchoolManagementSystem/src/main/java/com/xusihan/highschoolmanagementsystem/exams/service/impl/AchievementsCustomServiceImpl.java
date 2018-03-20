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
		
		// ��Ҫ��װ������
		AchievementsCustom achievementsCustom = new AchievementsCustom();
		
		// ��ѯ��γ̱�����Ӧ�Ŀγ���Ϣ����װ
		Achievements achievements = achievementsMapper.selectByPrimaryKey(achievementid);
		achievementsCustom.setAchievements(achievements);
		
		// ��ѯ�뿼�Ա�����Ӧ�Ŀ��԰������Ʋ���װ
		Integer examplanId = achievements.getExamplanid();
		Examplans examplanInfo = examplansMapper.selectByPrimaryKey(examplanId);
		String examplanName = examplanInfo.getExamplanname();
		achievementsCustom.setExamplanname(examplanName);
		
		// ��ѯ�뿼�Ա�����Ӧ�Ŀ������Ʋ���װ
		Integer examId = achievements.getExamid();
		Exams examInfo = examsMapper.selectByPrimaryKey(examId);
		String examName = examInfo.getExamname();
		achievementsCustom.setExamname(examName);
		
		// ��ѯ��༶������Ӧ�İ༶���Ʋ���װ
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
		
		//ͨ��������ѯ���������Ŀ��԰�����Ϣ
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
			// ģ����ѯ���԰�������
			if(achievementsCustom.getExamplanname()!= null && !achievementsCustom.getExamplanname().equals("") ) {
				// ͨ��ģ����ѯ����÷��������Ŀ��԰��ű��
				achievementsCustom.setExamplanname("%"+achievementsCustom.getExamplanname()+"%");
				criteriaOfExamplans.andExamplannameLike(achievementsCustom.getExamplanname());
				List<Examplans> listOfExamplans = examplansMapper.selectByExample(examplansExample);
				// ��ѯ�õ��Ŀ��԰�����Ϣ��Ӧ�Ŀ��԰��ű��
				List<Integer> listOfAchievementBookIds = new ArrayList<>();
				for(Examplans examplans:listOfExamplans) {
					listOfAchievementBookIds.add(examplans.getExamplanid());
				}
				if(!listOfAchievementBookIds.isEmpty()) {
					criteriaOfAchievements.andExamplanidIn(listOfAchievementBookIds);
				}
			}
			// ģ����ѯ��������
			if(achievementsCustom.getExamname()!= null && !achievementsCustom.getExamname().equals("") ) {
				// ͨ��ģ����ѯ����÷��������Ŀ��Ա��
				achievementsCustom.setExamname("%"+achievementsCustom.getExamname()+"%");
				criteriaOfExams.andExamnameLike(achievementsCustom.getExamname());
				List<Exams> listOfExams = examsMapper.selectByExample(examsExample);
				// ��ѯ�õ��Ŀ�����Ϣ��Ӧ�Ŀ��Ա��
				List<Integer> listOfAchievementBookIds = new ArrayList<>();
				for(Exams exams:listOfExams) {
					listOfAchievementBookIds.add(exams.getExamid());
				}
				if(!listOfAchievementBookIds.isEmpty()) {
					criteriaOfAchievements.andExamidIn(listOfAchievementBookIds);
				}
			}
			// ģ����ѯѧ������
			if(achievementsCustom.getStudentname()!= null && !achievementsCustom.getStudentname().equals("") ) {
				// ͨ��ģ����ѯ����÷���������ѧ�����
				achievementsCustom.setStudentname("%"+achievementsCustom.getStudentname()+"%");
				criteriaOfStudents.andStudentnameLike(achievementsCustom.getStudentname());
				List<Studentsbase> listOfStudents = studentsbaseMapper.selectByExample(studentsbaseExample);
				// ��ѯ�õ��İ༶��Ϣ��Ӧ��ѧ�����
				List<Integer> listOfStudentIds = new ArrayList<>();
				for(Studentsbase studentes:listOfStudents) {
					listOfStudentIds.add(studentes.getStudentid());
				}
				if(!listOfStudentIds.isEmpty()) {
					criteriaOfAchievements.andExamidIn(listOfStudentIds);
				}
			}
			
			if(achievementsCustom.getAchievements()!=null) {
				
				// ��ѯ�ɼ����
				if(achievementsCustom.getAchievements().getAchievementid()!= null ) {
					criteriaOfAchievements.andAchievementidEqualTo(achievementsCustom.getAchievements().getAchievementid());
				}
				
				// ��ѯ���԰��ű��
				if(achievementsCustom.getAchievements().getExamplanid()!= null ) {
					criteriaOfExamplans.andExamplanidEqualTo(achievementsCustom.getAchievements().getExamplanid());
				}
				
				// ��ѯ���Ա��
				if(achievementsCustom.getAchievements().getExamid()!=null ) {
					criteriaOfAchievements.andExamidEqualTo(achievementsCustom.getAchievements().getExamid());
				}
				
				// ��ѯѧ�����
				if(achievementsCustom.getAchievements().getStudentid()!=null ) {
					criteriaOfAchievements.andStudentidEqualTo(achievementsCustom.getAchievements().getStudentid());
				}
			}
		}
		// ��ѯ���������Ŀγ���Ϣ
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
