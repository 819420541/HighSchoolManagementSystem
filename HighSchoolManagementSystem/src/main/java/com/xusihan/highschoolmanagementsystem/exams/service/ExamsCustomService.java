package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ExamsCustom;

public interface ExamsCustomService {

	/**
	 * getExamsCustom:��ѯ����������Ϣ
	 * @param examid
	 * @return
	 */
	public ExamsCustom getExamsCustom(Integer examid);
	
	/**
	 * getExamsCustomList:��ѯ����������Ϣ
	 * @param examsCustom
	 * @return
	 */
	public List<ExamsCustom> getExamsCustomList(ExamsCustom examsCustom);
}
