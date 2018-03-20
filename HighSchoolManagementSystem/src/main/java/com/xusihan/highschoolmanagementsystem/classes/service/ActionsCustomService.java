package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.ActionsCustom;

public interface ActionsCustomService {

	/**
	 * getActionCustom:��ѯ���Ϣ
	 * @param actionid
	 * @return
	 */
	public ActionsCustom getActionCustom(Integer actionid);
	
	/**
	 * getActionsCustomList:��ѯ���Ϣ
	 * @param actionsCustom
	 * @return
	 */
	public List<ActionsCustom> getActionsCustomList(ActionsCustom actionsCustom);

}
