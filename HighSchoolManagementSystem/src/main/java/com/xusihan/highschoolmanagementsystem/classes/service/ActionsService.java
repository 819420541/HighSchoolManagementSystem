package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Actions;

public interface ActionsService {

	/**
	 * addAction:添加活动信息
	 * @param actions
	 * @return
	 */
	public boolean addAction(Actions actions);
	
	/**
	 * deleteAction:删除活动信息
	 * @param actionid
	 * @return
	 */
	public boolean deleteAction(Integer actionid);
	
	/**
	 * updateAction:更新活动信息
	 * @param actions
	 * @return
	 */
	public boolean updateAction(Actions actions);

	/**
	 * getAction:根据活动编号查询活动信息
	 * @param actionid
	 * @return
	 */
	public Actions getAction(Integer actionid);
	
	/**
	 * getActionsList:根据相关条件查询活动信息
	 * @param actions
	 * @return
	 */
	public List<Actions> getActionsList(Actions actions);
	
}
