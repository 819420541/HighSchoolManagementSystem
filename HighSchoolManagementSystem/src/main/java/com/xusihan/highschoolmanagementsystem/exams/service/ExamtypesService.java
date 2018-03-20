package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Examtypes;

public interface ExamtypesService {

		/**
		 * addExamtype:添加考试类型信息
		 * @param examtypes
		 * @return
		 */
		public boolean addExamtype(Examtypes examtypes);
		
		/**
		 * deleteExamtype:删除考试类型信息
		 * @param examtypeid
		 * @return
		 */
		public boolean deleteExamtype(Integer examtypeid);
		
		/**
		 * updateExamtype:更新考试类型数据
		 * @param examtypes
		 * @return
		 */
		public boolean updateExamtype(Examtypes examtypes);

		/**
		 * getExamtypes:根据考试类型编号查询考试类型信息
		 * @param examtypeid
		 * @return
		 */
		public Examtypes getExamtype(Integer examtypeid);
		
		/**
		 * getExamtypesList:根据相关条件查询考试类型信息
		 * @param examtypes
		 * @return
		 */
		public List<Examtypes> getExamtypesList(Examtypes examtypes);
		
}
