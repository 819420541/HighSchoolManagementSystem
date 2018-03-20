package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Semesters;

public interface SemestersService {
	
	/**
	 * addSemester:���ѧ����Ϣ
	 * @param semesters
	 * @return
	 */
	public boolean addSemester(Semesters semesters);
	
	/**
	 * deleteSemester��ɾ��ѧ����Ϣ
	 * @param semesterid
	 * @return
	 */
	public boolean deleteSemester(Integer semesterid);
	
	/**
	 * updateSemester������ѧ����Ϣ
	 * @param semesters
	 * @return
	 */
	public boolean updateSemester(Semesters semesters);

	/**
	 * getSemesters:����ѧ�ڱ�Ų�ѯѧ����Ϣ
	 * @param semesterid
	 * @return
	 */
	public Semesters getSemesters(Integer semesterid);
	
	/**
	 * getSemestersList:�������������ѯѧ����Ϣ
	 * @param semesters
	 * @return
	 */
	public List<Semesters> getSemestersList(Semesters semesters);
	
	
}
