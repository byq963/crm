package com.prj.biz;

import java.util.List;

import com.prj.bean.CustCustomer;

public interface ICustomerBiz {
	public boolean addCust(CustCustomer cust);
	//��ҳ
		public List<CustCustomer> showCustCustomerLike(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag,int page,int pagesize);
		//���ݿͻ���ţ����ƣ��������ͻ��������ƣ��ͻ��ȼ����ͻ�״̬���в�ѯ
		public List<CustCustomer> showAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag);
		//ͨ��id���Ҷ���
		public CustCustomer findCustomer(String custNo);
		//�޸�
		public boolean update(CustCustomer cust);
		public CustCustomer findCustCustomerByName(String custName);
		public List<CustCustomer> showAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custSatisfy,Byte custCredit,Byte custFlag);
}
