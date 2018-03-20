package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ExamplansCustom;

public interface ExamplansCustomService {

	/**
	 * getExamplansCustom:��ѯ���԰�����Ϣ
	 * @param examplanid
	 * @return
	 */
	public ExamplansCustom getExamplansCustom(Integer examplanid);
	
	/**
	 * getExamplansCustomList:��ѯ���԰�����Ϣ
	 * @param examplansCustom
	 * @return
	 */
	public List<ExamplansCustom> getExamplansCustomList(ExamplansCustom examplansCustom);
	
}
