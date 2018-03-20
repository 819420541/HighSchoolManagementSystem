package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ExamplansCustom;

public interface ExamplansCustomService {

	/**
	 * getExamplansCustom:查询考试安排信息
	 * @param examplanid
	 * @return
	 */
	public ExamplansCustom getExamplansCustom(Integer examplanid);
	
	/**
	 * getExamplansCustomList:查询考试安排信息
	 * @param examplansCustom
	 * @return
	 */
	public List<ExamplansCustom> getExamplansCustomList(ExamplansCustom examplansCustom);
	
}
