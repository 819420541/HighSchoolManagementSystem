package com.xusihan.highschoolmanagementsystem.po;

public class ExamplansCustom {

	// ��������
	private Examplans examplans;
	
	// ��չ����
	/**
	 * ��������
	 */
	private String examname;
	
	/**
	 * �༶����
	 */
	private String classname;

	public Examplans getExamplans() {
		return examplans;
	}

	public void setExamplans(Examplans examplans) {
		this.examplans = examplans;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public ExamplansCustom() {
		super();
	}

	public ExamplansCustom(Examplans examplans, String examname, String classname) {
		super();
		this.examplans = examplans;
		this.examname = examname;
		this.classname = classname;
	}
	
}
