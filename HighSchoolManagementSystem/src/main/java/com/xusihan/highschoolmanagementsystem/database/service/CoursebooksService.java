package com.xusihan.highschoolmanagementsystem.database.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Coursebooks;


public interface CoursebooksService {
	
	/**
	 * addCoursebook:��ӽ̲���Ϣ
	 * @param coursebooks
	 * @return
	 */
	public boolean addCoursebook(Coursebooks coursebooks);
	
	/**
	 * deleteCoursebook:ɾ���̲���Ϣ
	 * @param coursebookid
	 * @return
	 */
	public boolean deleteCoursebook(Integer coursebookid);
	
	/**
	 * updateCoursebook:���½̲�����
	 * @param coursebooks
	 * @return
	 */
	public boolean updateCoursebook(Coursebooks coursebooks);
	
	/**
	 * getCoursebooks:����ѧУ��Ų�ѯ�̲���Ϣ
	 * @param coursebookid
	 * @return
	 */
	public Coursebooks getCoursebooks(Integer coursebookid);
	
	/**
	 * getCoursebookList:�������������ѯ�̲���Ϣ
	 * @param coursebooks
	 * @return
	 */
	public List<Coursebooks> getCoursebookList(Coursebooks coursebooks);

}
