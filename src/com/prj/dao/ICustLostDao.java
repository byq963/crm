package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.CustLost;

public interface ICustLostDao {
	//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
	public List<CustLost> queryCustLostLike(String custCustomer,String lostManagerName,Byte lostStatus,int page,int pagesize);
	//�������������ѯ��������
	public List<CustLost> queryAllCustLost(String  custCustomer,String lostManagerName,Byte lostStatus);
	//ͨ��id�õ�����
	public CustLost getCustLost(Long lostNo);
	//�޸�
	public boolean update(CustLost custLost);
	//���ݿͻ����ƺͿͻ��������Ʋ�ѯ
	public List<CustLost> queryAllCustLost(String custName,String lostManagerName);
	public List<CustLost> queryAllCustLostPage(String custName,String lostManagerName,int page,int pagesize);
}
