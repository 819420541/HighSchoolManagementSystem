package com.xusihan.highschoolmanagementsystem.po;

public class StudentsbaseCustom {

	// ��������
	private Studentsbase studentsbase;
	
	// ��չ����
	/**
	 * ѧУ����
	 */
	private String schoolname;
	
	/**
	 * �༶����
	 */
	private String classname;

	public Studentsbase getStudentsbase() {
		return studentsbase;
	}

	public void setStudentsbase(Studentsbase studentsbase) {
		this.studentsbase = studentsbase;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public StudentsbaseCustom() {
		super();
	}

	public StudentsbaseCustom(Studentsbase studentsbase, String schoolname, String classname) {
		super();
		this.studentsbase = studentsbase;
		this.schoolname = schoolname;
		this.classname = classname;
	}

}
