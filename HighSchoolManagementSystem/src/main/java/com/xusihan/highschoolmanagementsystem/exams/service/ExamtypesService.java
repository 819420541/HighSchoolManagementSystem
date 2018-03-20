package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Examtypes;

public interface ExamtypesService {

		/**
		 * addExamtype:��ӿ���������Ϣ
		 * @param examtypes
		 * @return
		 */
		public boolean addExamtype(Examtypes examtypes);
		
		/**
		 * deleteExamtype:ɾ������������Ϣ
		 * @param examtypeid
		 * @return
		 */
		public boolean deleteExamtype(Integer examtypeid);
		
		/**
		 * updateExamtype:���¿�����������
		 * @param examtypes
		 * @return
		 */
		public boolean updateExamtype(Examtypes examtypes);

		/**
		 * getExamtypes:���ݿ������ͱ�Ų�ѯ����������Ϣ
		 * @param examtypeid
		 * @return
		 */
		public Examtypes getExamtype(Integer examtypeid);
		
		/**
		 * getExamtypesList:�������������ѯ����������Ϣ
		 * @param examtypes
		 * @return
		 */
		public List<Examtypes> getExamtypesList(Examtypes examtypes);
		
}
