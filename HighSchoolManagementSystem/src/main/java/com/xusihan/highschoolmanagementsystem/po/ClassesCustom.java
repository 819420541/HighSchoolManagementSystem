package com.xusihan.highschoolmanagementsystem.po;

public class ClassesCustom {

	// ��������
	private Classes classes;
	
	// ��չ����
	/**
	 * ѧУ����
	 */
	private String schoolname;
	
	/**
	 * ѧ������
	 */
	private String semestername;

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
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

	public ClassesCustom() {
		super();
	}

	public ClassesCustom(Classes classes, String schoolname, String semestername) {
		super();
		this.classes = classes;
		this.schoolname = schoolname;
		this.semestername = semestername;
	}
	
	
}
