package com.xusihan.highschoolmanagementsystem.po;

public class StudentstudyrecordCustom {

	// 基础属性
	private Studentstudyrecord studentstudyrecord;
	
	// 扩展属性
	/**
	 * 学生名称
	 */
	private String studentname;

	public Studentstudyrecord getStudentstudyrecord() {
		return studentstudyrecord;
	}

	public void setStudentstudyrecord(Studentstudyrecord studentstudyrecord) {
		this.studentstudyrecord = studentstudyrecord;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public StudentstudyrecordCustom() {
		super();
	}

	public StudentstudyrecordCustom(Studentstudyrecord studentstudyrecord, String studentname) {
		super();
		this.studentstudyrecord = studentstudyrecord;
		this.studentname = studentname;
	}
	
}
