package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Coursebooks;


public interface CoursebooksService {
	
	/**
	 * addCoursebook:添加教材信息
	 * @param coursebooks
	 * @return
	 */
	public boolean addCoursebook(Coursebooks coursebooks);
	
	/**
	 * deleteCoursebook:删除教材信息
	 * @param coursebookid
	 * @return
	 */
	public boolean deleteCoursebook(Integer coursebookid);
	
	/**
	 * updateCoursebook:更新教材数据
	 * @param coursebooks
	 * @return
	 */
	public boolean updateCoursebook(Coursebooks coursebooks);
	
	/**
	 * getCoursebooks:根据学校编号查询教材信息
	 * @param coursebookid
	 * @return
	 */
	public Coursebooks getCoursebooks(Integer coursebookid);
	
	/**
	 * getCoursebookList:根据相关条件查询教材信息
	 * @param coursebooks
	 * @return
	 */
	public List<Coursebooks> getCoursebookList(Coursebooks coursebooks);

}
