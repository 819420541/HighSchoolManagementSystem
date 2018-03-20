package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ExamtypesCustom;

public interface ExamtypesCustomService {

	/**
	 * getExamtypesCustom:查询考试类型信息
	 * @param examtypeid
	 * @return
	 */
	public ExamtypesCustom getExamtypesCustom(Integer examtypeid);
	
	/**
	 * getExamtypesCustomList:查询考试类型信息
	 * @param examtypesCustom
	 * @return
	 */
	public List<ExamtypesCustom> getExamtypesCustomList(ExamtypesCustom examtypesCustom);
}
