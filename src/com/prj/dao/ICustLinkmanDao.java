package com.prj.dao;

import com.prj.bean.CustLinkman;

public interface ICustLinkmanDao {
	//��Ӷ���
	public boolean add(CustLinkman custLinkman);
	//ɾ������
	public boolean delete(CustLinkman custLinkman);
	//�޸Ķ���
	public boolean update(CustLinkman custLinkman);
	//ͨ��id���Ҷ���
	public CustLinkman get(String linkNo);
}
