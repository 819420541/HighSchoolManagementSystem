package com.xusihan.highschoolmanagementsystem.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.po.UsersloginExample;
import com.xusihan.highschoolmanagementsystem.po.Userslogin;
import com.xusihan.highschoolmanagementsystem.po.UsersloginExample.Criteria;
import com.xusihan.highschoolmanagementsystem.system.mapper.UsersloginMapper;
import com.xusihan.highschoolmanagementsystem.system.service.UsersloginService;

@Service("usersloginServiceImpl")
public class UsersloginServiceImpl implements UsersloginService {

	@Resource(name = "usersloginMapper")
	private UsersloginMapper usersloginMapper;
	
	@Override
	public boolean addUserslogin(Userslogin userslogin) {

		try {
			int i =usersloginMapper.insertSelective(userslogin);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteUserslogin(String account) {

		try {
			int i = usersloginMapper.deleteByPrimaryKey(account);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateUserslogin(Userslogin userslogin) {

		try {
			int i = usersloginMapper.updateByPrimaryKeySelective(userslogin);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Userslogin getUserslogin(String account) {

		return usersloginMapper.selectByPrimaryKey(account);
	}

	@Override
	public List<Userslogin> getUsersloginList(Userslogin userslogin) {
		
		UsersloginExample usersloginExample = new UsersloginExample();
		Criteria criteria = usersloginExample.createCriteria();
		
		if(userslogin!=null) {
			//根据用户账号查询
			if(userslogin.getAccount()!=null){
				criteria.andAccountEqualTo(userslogin.getAccount());
			}
		}
		return usersloginMapper.selectByExample(usersloginExample);
	
	}

	@Override
	public String check(String username, String password) {
		List<Userslogin> usersList = this.getUsersloginList(null);
		for (Userslogin theUser:usersList) {
			if(theUser.getAccount().equals(username)
					&& theUser.getPassword().equals(password)) {
				return theUser.getAccount();
			}
		}
		return null;
	}
}
