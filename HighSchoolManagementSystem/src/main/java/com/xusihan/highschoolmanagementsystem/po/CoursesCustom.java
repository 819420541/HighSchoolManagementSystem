package com.xusihan.highschoolmanagementsystem.po;

public class CoursesCustom{

	// 基础属性
	private Course course;
	
	// 扩展属性
	/**
	 * 学校名称
	 */
	private String schoolname;
	
	/**
	 * 学期名称
	 */
	private String semestername;
	
	/**
	 * 教材名称
	 */
	private String coursebookname;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getSemestername() {
		return semestername;
	}

	public void setSemestername(String semestername) {
		this.semestername = semestername;
	}

	public String getCoursebookname() {
		return coursebookname;
	}

	public void setCoursebookname(String coursebookname) {
		this.coursebookname = coursebookname;
	}

	public CoursesCustom() {
		super();
	}

	public CoursesCustom(Course course, String schoolname, String semestername, String coursebookname) {
		super();
		this.course = course;
		this.schoolname = schoolname;
		this.semestername = semestername;
		this.coursebookname = coursebookname;
	}

}
