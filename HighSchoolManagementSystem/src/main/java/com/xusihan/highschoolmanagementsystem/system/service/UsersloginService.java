package com.xusihan.highschoolmanagementsystem.system.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Userslogin;

public interface UsersloginService {


	/**
	 * addUserslogin:添加学生基础信息
	 * @param userslogin
	 * @return
	 */
	public boolean addUserslogin(Userslogin userslogin);
	
	/**
	 * deleteUserslogin:删除学生基础信息
	 * @param account
	 * @return
	 */
	public boolean deleteUserslogin(String account);
	
	/**
	 * updateUserslogin:更新学生基础数据
	 * @param userslogin
	 * @return
	 */
	public boolean updateUserslogin(Userslogin userslogin);

	/**
	 * getUserslogin:根据学生编号查询学生基础信息
	 * @param account
	 * @return
	 */
	public Userslogin getUserslogin(String account);
	
	/**
	 * getUsersloginList:根据相关条件查询学生基础信息
	 * @param userslogin
	 * @return
	 */
	public List<Userslogin> getUsersloginList(Userslogin userslogin);
	
	public String check(String username, String password);
}
