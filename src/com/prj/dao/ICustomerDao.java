package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.Product;


public interface ICustomerDao {
	public boolean add(CustCustomer cust);
	//��ҳ
	public List<CustCustomer> queryCustCustomerLike(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag,int page,int pagesize);
	//���ݿͻ���ţ����ƣ��������ͻ��������ƣ��ͻ��ȼ����ͻ�״̬���в�ѯ
	public List<CustCustomer> queryAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag);
	public List<CustCustomer> queryAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custSatisfy,Byte custCredit,Byte custFlag);
	//ͨ��id���Ҷ���
	public CustCustomer getCustomer(String custNo);
	//�޸�
	public boolean update(CustCustomer cust);
	//ͨ�����Ʋ�ѯ����
	public CustCustomer getCustCustomerByName(String prodName);
	
}
