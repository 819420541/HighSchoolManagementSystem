package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Studentcontact;

public interface StudentcontactService {

	/**
	 * addStudentcontact:���ѧ����ϵ��ʽ��Ϣ
	 * @param studentcontact
	 * @return
	 */
	public boolean addStudentcontact(Studentcontact studentcontact);
	
	/**
	 * deleteStudentcontact:ɾ��ѧ����ϵ��ʽ��Ϣ
	 * @param studentcontactid
	 * @return
	 */
	public boolean deleteStudentcontact(Integer studentcontactid);
	
	/**
	 * updateStudentcontact:����ѧ����ϵ��ʽ����
	 * @param studentcontact
	 * @return
	 */
	public boolean updateStudentcontact(Studentcontact studentcontact);

	/**
	 * getStudentcontact:����ѧ����Ų�ѯѧ����ϵ��ʽ��Ϣ
	 * @param studentcontactid
	 * @return
	 */
	public Studentcontact getStudentcontact(Integer studentcontactid);
	
	/**
	 * getStudentcontactList:�������������ѯѧ����ϵ��ʽ��Ϣ
	 * @param studentcontact
	 * @return
	 */
	public List<Studentcontact> getStudentcontactsList(Studentcontact studentcontact);

}
