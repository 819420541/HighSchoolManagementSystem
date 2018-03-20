package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Examplans;

public interface ExamplansService {

	/**
	 * addExamplan:添加考试安排信息
	 * @param examplans
	 * @return
	 */
	public boolean addExamplan(Examplans examplans);
	
	/**
	 * deleteExamplan:删除考试安排信息
	 * @param examplanid
	 * @return
	 */
	public boolean deleteExamplan(Integer examplanid);
	
	/**
	 * updateExamplan:更新考试安排数据
	 * @param examplans
	 * @return
	 */
	public boolean updateExamplan(Examplans examplans);
	
	/**
	 * getExamplans:根据考试安排编号查询考试安排安排信息
	 * @param examplanid
	 * @return
	 */
	public Examplans getExamplans(Integer examplanid);
	
	/**
	 * getExamplanList:根据相关条件查询考试安排安排信息
	 * @param examplans
	 * @return
	 */
	public List<Examplans> getExamplanList(Examplans examplans);

}
