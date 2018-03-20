package com.xusihan.highschoolmanagementsystem.po;

public class ExamplansCustom {

	// 基础属性
	private Examplans examplans;
	
	// 扩展属性
	/**
	 * 考试名称
	 */
	private String examname;
	
	/**
	 * 班级名称
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
