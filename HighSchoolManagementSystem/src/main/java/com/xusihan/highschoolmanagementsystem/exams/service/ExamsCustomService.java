package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ExamsCustom;

public interface ExamsCustomService {

	/**
	 * getExamsCustom:查询考试类型信息
	 * @param examid
	 * @return
	 */
	public ExamsCustom getExamsCustom(Integer examid);
	
	/**
	 * getExamsCustomList:查询考试类型信息
	 * @param examsCustom
	 * @return
	 */
	public List<ExamsCustom> getExamsCustomList(ExamsCustom examsCustom);
}
