package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Exams;

public interface ExamsService {

	/**
	 * addExam:添加考试信息
	 * @param exams
	 * @return
	 */
	public boolean addExam(Exams exams);
	
	/**
	 * deleteExam:删除考试信息
	 * @param examid
	 * @return
	 */
	public boolean deleteExam(Integer examid);
	
	/**
	 * updateExam:更新考试数据
	 * @param exams
	 * @return
	 */
	public boolean updateExam(Exams exams);

	/**
	 * getExams:根据考试编号查询考试信息
	 * @param examid
	 * @return
	 */
	public Exams getExam(Integer examid);
	
	/**
	 * getExamsList:根据相关条件查询考试信息
	 * @param exams
	 * @return
	 */
	public List<Exams> getExamsList(Exams exams);
	
}
