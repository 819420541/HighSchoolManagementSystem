package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ExamtypesCustom;

public interface ExamtypesCustomService {

	/**
	 * getExamtypesCustom:��ѯ����������Ϣ
	 * @param examtypeid
	 * @return
	 */
	public ExamtypesCustom getExamtypesCustom(Integer examtypeid);
	
	/**
	 * getExamtypesCustomList:��ѯ����������Ϣ
	 * @param examtypesCustom
	 * @return
	 */
	public List<ExamtypesCustom> getExamtypesCustomList(ExamtypesCustom examtypesCustom);
}
