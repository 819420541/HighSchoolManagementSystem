package com.xusihan.highschoolmanagementsystem.po;

public class StudentcontactCustom {

	// 基础属性
	private Studentcontact studentcontact;
	
	// 扩展属性
	/**
	 * 学生名称
	 */
	private String studentname;

	public Studentcontact getStudentcontact() {
		return studentcontact;
	}

	public void setStudentcontact(Studentcontact studentcontact) {
		this.studentcontact = studentcontact;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public StudentcontactCustom() {
		super();
	}

	public StudentcontactCustom(Studentcontact studentcontact, String studentname) {
		super();
		this.studentcontact = studentcontact;
		this.studentname = studentname;
	}
	
}
