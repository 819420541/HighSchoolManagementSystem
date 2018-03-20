package com.xusihan.highschoolmanagementsystem.po;

public class AttendancesCustom {

	// 基础属性
	private Attendances attendances;
	
	// 扩展属性
	/**
	 * 学期名称
	 */
	private String semestername;
	
	/**
	 * 班级名称
	 */
	private String classname;
	
	/**
	 * 课程名称
	 */
	private String coursename;
	
	/**
	 * 学生姓名
	 */
	private String studentname;

	public Attendances getAttendances() {
		return attendances;
	}

	public void setAttendances(Attendances attendances) {
		this.attendances = attendances;
	}

	public String getSemestername() {
		return semestername;
	}

	public void setSemestername(String semestername) {
		this.semestername = semestername;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public AttendancesCustom() {
		super();
	}

	public AttendancesCustom(Attendances attendances, String semestername, String classname, String coursename,
			String studentname) {
		super();
		this.attendances = attendances;
		this.semestername = semestername;
		this.classname = classname;
		this.coursename = coursename;
		this.studentname = studentname;
	}
	
}
