package com.xusihan.highschoolmanagementsystem.students.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Attendances;

public interface AttendancesService {

	/**
	 * addAttendance:添加学生基础信息
	 * @param sttendances
	 * @return
	 */
	public boolean addAttendance(Attendances sttendances);
	
	/**
	 * deleteAttendance:删除学生基础信息
	 * @param attendanceid
	 * @return
	 */
	public boolean deleteAttendance(Integer attendanceid);
	
	/**
	 * updateAttendance:更新学生基础数据
	 * @param Attendances
	 * @return
	 */
	public boolean updateAttendance(Attendances attendances);

	/**
	 * getAttendance:根据学生编号查询学生基础信息
	 * @param attendanceid
	 * @return
	 */
	public Attendances getAttendance(Integer attendanceid);
	
	/**
	 * getAttendancesList:根据相关条件查询学生基础信息
	 * @param attendances
	 * @return
	 */
	public List<Attendances> getAttendancesList(Attendances attendances);

}
