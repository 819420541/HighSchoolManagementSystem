package com.xusihan.highschoolmanagementsystem.po;

public class StudentcontactCustom {

	// ��������
	private Studentcontact studentcontact;
	
	// ��չ����
	/**
	 * ѧ������
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
