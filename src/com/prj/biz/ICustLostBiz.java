package com.prj.biz;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.CustLost;

public interface ICustLostBiz {
	//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
	public List<CustLost> showCustLostLike(String custCustomer,String lostManagerName,Byte lostStatus,int page,int pagesize);
	//�������������ѯ��������
	public List<CustLost> showAllCustLost(String custCustomer,String lostManagerName,Byte lostStatus);
	//ͨ��id�õ�����
	public CustLost findCustLost(Long lostNo);
	//�޸�
	public boolean updateCustLost(CustLost custLost);
	//���ݿͻ����ƺͿͻ��������Ʋ�ѯ
		public List<CustLost> showAllCustLost(String custName,String lostManagerName);
		public List<CustLost> showAllCustLostPage(String custName,String lostManagerName,int page,int pagesize);
}
