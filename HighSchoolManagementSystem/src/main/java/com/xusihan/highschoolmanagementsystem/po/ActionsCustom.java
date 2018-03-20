package com.xusihan.highschoolmanagementsystem.po;

public class ActionsCustom {
	
	// 基础属性
	private Actions actions;
	
	// 扩展属性
	/**
	 * 班级名称
	 */
	private String classname;

	public Actions getActions() {
		return actions;
	}

	public void setActions(Actions actions) {
		this.actions = actions;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public ActionsCustom() {
		super();
	}

	public ActionsCustom(Actions actions, String classname) {
		super();
		this.actions = actions;
		this.classname = classname;
	}
	
}
