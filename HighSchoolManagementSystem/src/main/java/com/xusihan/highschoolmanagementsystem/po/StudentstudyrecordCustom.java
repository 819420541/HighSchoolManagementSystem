package com.xusihan.highschoolmanagementsystem.po;

public class StudentstudyrecordCustom {

	// ��������
	private Studentstudyrecord studentstudyrecord;
	
	// ��չ����
	/**
	 * ѧ������
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
