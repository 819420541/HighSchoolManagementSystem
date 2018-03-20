package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Studentstudyrecord;

public interface StudentstudyrecordService {


	/**
	 * addStudentstudyrecord:���ѧ��ѧ����Ϣ
	 * @param studentstudyrecord
	 * @return
	 */
	public boolean addStudentstudyrecord(Studentstudyrecord studentstudyrecord);
	
	/**
	 * deleteStudentstudyrecord:ɾ��ѧ��ѧ����Ϣ
	 * @param studentstudyrecordid
	 * @return
	 */
	public boolean deleteStudentstudyrecord(Integer studentstudyrecordid);
	
	/**
	 * updateStudentstudyrecord:����ѧ��ѧ������
	 * @param studentstudyrecord
	 * @return
	 */
	public boolean updateStudentstudyrecord(Studentstudyrecord studentstudyrecord);

	/**
	 * getStudentstudyrecord:����ѧ����Ų�ѯѧ��ѧ����Ϣ
	 * @param studentstudyrecordid
	 * @return
	 */
	public Studentstudyrecord getStudentstudyrecord(Integer studentstudyrecordid);
	
	/**
	 * getStudentstudyrecordList:�������������ѯѧ��ѧ����Ϣ
	 * @param studentstudyrecord
	 * @return
	 */
	public List<Studentstudyrecord> getStudentstudyrecordsList(Studentstudyrecord studentstudyrecord);
}
