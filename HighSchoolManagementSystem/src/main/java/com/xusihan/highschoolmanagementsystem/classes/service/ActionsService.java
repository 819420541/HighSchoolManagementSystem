package com.xusihan.highschoolmanagementsystem.classes.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Actions;

public interface ActionsService {

	/**
	 * addAction:��ӻ��Ϣ
	 * @param actions
	 * @return
	 */
	public boolean addAction(Actions actions);
	
	/**
	 * deleteAction:ɾ�����Ϣ
	 * @param actionid
	 * @return
	 */
	public boolean deleteAction(Integer actionid);
	
	/**
	 * updateAction:���»��Ϣ
	 * @param actions
	 * @return
	 */
	public boolean updateAction(Actions actions);

	/**
	 * getAction:���ݻ��Ų�ѯ���Ϣ
	 * @param actionid
	 * @return
	 */
	public Actions getAction(Integer actionid);
	
	/**
	 * getActionsList:�������������ѯ���Ϣ
	 * @param actions
	 * @return
	 */
	public List<Actions> getActionsList(Actions actions);
	
}
