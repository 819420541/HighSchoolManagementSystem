package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.AttendancesCustom;

public interface AttendancesCustomService {

	/**
	 * getAttendancesCustom:��ѯѧ��������Ϣ
	 * @param attendanceid
	 * @return
	 */
	public AttendancesCustom getAttendancesCustom(Integer attendanceid);
	
	/**
	 * getAttendancesCustomList:��ѯѧ��������Ϣ
	 * @param attendancesCustom
	 * @return
	 */
	public List<AttendancesCustom> getAttendancesCustomList(AttendancesCustom attendancesCustom);

}
