package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Exams;

public interface ExamsService {

	/**
	 * addExam:��ӿ�����Ϣ
	 * @param exams
	 * @return
	 */
	public boolean addExam(Exams exams);
	
	/**
	 * deleteExam:ɾ��������Ϣ
	 * @param examid
	 * @return
	 */
	public boolean deleteExam(Integer examid);
	
	/**
	 * updateExam:���¿�������
	 * @param exams
	 * @return
	 */
	public boolean updateExam(Exams exams);

	/**
	 * getExams:���ݿ��Ա�Ų�ѯ������Ϣ
	 * @param examid
	 * @return
	 */
	public Exams getExam(Integer examid);
	
	/**
	 * getExamsList:�������������ѯ������Ϣ
	 * @param exams
	 * @return
	 */
	public List<Exams> getExamsList(Exams exams);
	
}
