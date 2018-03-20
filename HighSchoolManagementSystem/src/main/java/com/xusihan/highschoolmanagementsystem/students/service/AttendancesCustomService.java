package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.AttendancesCustom;

public interface AttendancesCustomService {

	/**
	 * getAttendancesCustom:查询学生考勤信息
	 * @param attendanceid
	 * @return
	 */
	public AttendancesCustom getAttendancesCustom(Integer attendanceid);
	
	/**
	 * getAttendancesCustomList:查询学生考勤信息
	 * @param attendancesCustom
	 * @return
	 */
	public List<AttendancesCustom> getAttendancesCustomList(AttendancesCustom attendancesCustom);

}
