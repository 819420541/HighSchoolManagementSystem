package com.xusihan.highschoolmanagementsystem.po;

public class ExamsCustom {

	// ��������
	private Exams exams;
	
	// ��չ����
	/**
	 * ��������
	 */
	private String examtypename;
	
	/**
	 * ѧУ����
	 */
	private String schoolname;
	
	/**
	 * ѧ������
	 */
	private String semestername;
	
	public String getExamtypename() {
		return examtypename;
	}

	public void setExamtypename(String examtypename) {
		this.examtypename = examtypename;
	}
	
	public Exams getExams() {
		return exams;
	}

	public void setExams(Exams exams) {
		this.exams = exams;
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

	public ExamsCustom() {
		super();
	}

	public ExamsCustom(Exams exams, String examtypename, String schoolname, String semestername) {
		super();
		this.exams = exams;
		this.examtypename = examtypename;
		this.schoolname = schoolname;
		this.semestername = semestername;
		
	}
	
}
