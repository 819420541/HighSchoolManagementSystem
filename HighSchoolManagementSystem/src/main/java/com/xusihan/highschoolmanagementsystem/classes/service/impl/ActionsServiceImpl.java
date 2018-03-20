package com.xusihan.highschoolmanagementsystem.classes.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xusihan.highschoolmanagementsystem.classes.mapper.ActionsMapper;
import com.xusihan.highschoolmanagementsystem.classes.service.ActionsService;
import com.xusihan.highschoolmanagementsystem.po.Actions;
import com.xusihan.highschoolmanagementsystem.po.ActionsExample;
import com.xusihan.highschoolmanagementsystem.po.ActionsExample.Criteria;

@Service("actionsServiceImpl")
public class ActionsServiceImpl implements ActionsService {

	@Resource(name = "actionsMapper")
	private ActionsMapper actionsMapper;
	
	@Override
	public boolean addAction(Actions actions) {

		try {
			int i =actionsMapper.insertSelective(actions);
			if(i > 0) {
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public boolean deleteAction(Integer actionid) {

		try {
			int i = actionsMapper.deleteByPrimaryKey(actionid);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public boolean updateAction(Actions actions) {

		try {
			int i = actionsMapper.updateByPrimaryKeySelective(actions);
			if(i > 0) {
				return true;
			}
		} catch (Exception e){
			
		}
		return false;
	}

	@Override
	public Actions getAction(Integer actionid) {
		
		return actionsMapper.selectByPrimaryKey(actionid);
	}

	@Override
	public List<Actions> getActionsList(Actions actions) {
		
		ActionsExample actionsExample = new ActionsExample();
		Criteria criteria = actionsExample.createCriteria();
		
		if(actions!=null) {
			//根据班级编号查询
			if(actions.getActionid()!=null) {
				criteria.andClassidEqualTo(actions.getActionid());
			}
		}
		return actionsMapper.selectByExample(actionsExample);
	
	}

}
