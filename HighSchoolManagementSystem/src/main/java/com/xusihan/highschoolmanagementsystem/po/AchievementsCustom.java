package com.xusihan.highschoolmanagementsystem.po;

public class AchievementsCustom {

	// ��������
	private Achievements achievements;
	
	// ��չ����
	/**
	 * ���԰�������
	 */
	private String examplanname;
	
	/**
	 * ��������
	 */
	private String examname;
	
	/**
	 * ѧ������
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
