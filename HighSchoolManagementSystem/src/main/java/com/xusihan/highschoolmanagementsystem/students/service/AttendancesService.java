package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Attendances;

public interface AttendancesService {

	/**
	 * addAttendance:���ѧ��������Ϣ
	 * @param sttendances
	 * @return
	 */
	public boolean addAttendance(Attendances sttendances);
	
	/**
	 * deleteAttendance:ɾ��ѧ��������Ϣ
	 * @param attendanceid
	 * @return
	 */
	public boolean deleteAttendance(Integer attendanceid);
	
	/**
	 * updateAttendance:����ѧ����������
	 * @param Attendances
	 * @return
	 */
	public boolean updateAttendance(Attendances attendances);

	/**
	 * getAttendance:����ѧ����Ų�ѯѧ��������Ϣ
	 * @param attendanceid
	 * @return
	 */
	public Attendances getAttendance(Integer attendanceid);
	
	/**
	 * getAttendancesList:�������������ѯѧ��������Ϣ
	 * @param attendances
	 * @return
	 */
	public List<Attendances> getAttendancesList(Attendances attendances);

}
