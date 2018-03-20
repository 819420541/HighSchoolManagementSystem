package com.xusihan.highschoolmanagementsystem.exams.service;

import java.util.List;

import com.xusihan.highschoolmanagementsystem.po.Examplans;

public interface ExamplansService {

	/**
	 * addExamplan:��ӿ��԰�����Ϣ
	 * @param examplans
	 * @return
	 */
	public boolean addExamplan(Examplans examplans);
	
	/**
	 * deleteExamplan:ɾ�����԰�����Ϣ
	 * @param examplanid
	 * @return
	 */
	public boolean deleteExamplan(Integer examplanid);
	
	/**
	 * updateExamplan:���¿��԰�������
	 * @param examplans
	 * @return
	 */
	public boolean updateExamplan(Examplans examplans);
	
	/**
	 * getExamplans:���ݿ��԰��ű�Ų�ѯ���԰��Ű�����Ϣ
	 * @param examplanid
	 * @return
	 */
	public Examplans getExamplans(Integer examplanid);
	
	/**
	 * getExamplanList:�������������ѯ���԰��Ű�����Ϣ
	 * @param examplans
	 * @return
	 */
	public List<Examplans> getExamplanList(Examplans examplans);

}
