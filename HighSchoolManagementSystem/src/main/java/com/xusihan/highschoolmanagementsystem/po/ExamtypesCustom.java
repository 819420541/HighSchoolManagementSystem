package com.xusihan.highschoolmanagementsystem.po;

public class ExamtypesCustom {

	// 基础属性
	private Examtypes examtypes;
	
	// 扩展属性
	
	/**
	 * 学校名称
	 */
	private String schoolname;

	public Examtypes getExamtypes() {
		return examtypes;
	}

	public void setExamtypes(Examtypes examtypes) {
		this.examtypes = examtypes;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public ExamtypesCustom() {
		super();
	}

	public ExamtypesCustom(Examtypes examtypes, String schoolname) {
		super();
		this.examtypes = examtypes;
		this.schoolname = schoolname;
	}
	
}
