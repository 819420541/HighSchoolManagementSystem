package com.xusihan.highschoolmanagementsystem.po;

public class AchievementsCustom {

	// 基础属性
	private Achievements achievements;
	
	// 扩展属性
	/**
	 * 考试安排名称
	 */
	private String examplanname;
	
	/**
	 * 考试名称
	 */
	private String examname;
	
	/**
	 * 学生姓名
	 */
	private String studentname;

	public Achievements getAchievements() {
		return achievements;
	}

	public void setAchievements(Achievements achievements) {
		this.achievements = achievements;
	}

	public String getExamplanname() {
		return examplanname;
	}

	public void setExamplanname(String examplanname) {
		this.examplanname = examplanname;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public AchievementsCustom() {
		super();
	}

	public AchievementsCustom(Achievements achievements, String examplanname, String examname, String studentname) {
		super();
		this.achievements = achievements;
		this.examplanname = examplanname;
		this.examname = examname;
		this.studentname = studentname;
	}

}
