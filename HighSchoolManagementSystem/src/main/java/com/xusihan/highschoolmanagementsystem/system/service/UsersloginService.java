package com.xusihan.highschoolmanagementsystem.system.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Userslogin;

public interface UsersloginService {


	/**
	 * addUserslogin:���ѧ��������Ϣ
	 * @param userslogin
	 * @return
	 */
	public boolean addUserslogin(Userslogin userslogin);
	
	/**
	 * deleteUserslogin:ɾ��ѧ��������Ϣ
	 * @param account
	 * @return
	 */
	public boolean deleteUserslogin(String account);
	
	/**
	 * updateUserslogin:����ѧ����������
	 * @param userslogin
	 * @return
	 */
	public boolean updateUserslogin(Userslogin userslogin);

	/**
	 * getUserslogin:����ѧ����Ų�ѯѧ��������Ϣ
	 * @param account
	 * @return
	 */
	public Userslogin getUserslogin(String account);
	
	/**
	 * getUsersloginList:�������������ѯѧ��������Ϣ
	 * @param userslogin
	 * @return
	 */
	public List<Userslogin> getUsersloginList(Userslogin userslogin);
	
	public String check(String username, String password);
}
