package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Studentsbase;

public interface StudentsbaseService {

	/**
	 * addStudent:���ѧ��������Ϣ
	 * @param studentsbase
	 * @return
	 */
	public boolean addStudentsbase(Studentsbase studentsbase);
	
	/**
	 * deleteStudent:ɾ��ѧ��������Ϣ
	 * @param studentid
	 * @return
	 */
	public boolean deleteStudentsbase(Integer studentid);
	
	/**
	 * updateStudent:����ѧ����������
	 * @param studentsbase
	 * @return
	 */
	public boolean updateStudentsbase(Studentsbase studentsbase);

	/**
	 * getStudent:����ѧ����Ų�ѯѧ��������Ϣ
	 * @param studentid
	 * @return
	 */
	public Studentsbase getStudentsbase(Integer studentid);
	
	/**
	 * getStudentsbaseList:�������������ѯѧ��������Ϣ
	 * @param studentsbase
	 * @return
	 */
	public List<Studentsbase> getStudentsbaseList(Studentsbase studentsbase);

	public Integer getStudentsbaseMaxId();
}
