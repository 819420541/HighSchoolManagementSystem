package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ActionsCustom;

public interface ActionsCustomService {

	/**
	 * getActionCustom:查询活动信息
	 * @param actionid
	 * @return
	 */
	public ActionsCustom getActionCustom(Integer actionid);
	
	/**
	 * getActionsCustomList:查询活动信息
	 * @param actionsCustom
	 * @return
	 */
	public List<ActionsCustom> getActionsCustomList(ActionsCustom actionsCustom);

}
