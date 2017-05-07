package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.ServiceManager;

public interface IServiceManagerDao {
	//ͨ��id���Ҷ���
	public ServiceManager getServiceManagerById(String servNo);
	//���
	public boolean add(ServiceManager serviceManager);
	//ɾ��
	public boolean delete(ServiceManager serviceManager);
	//�޸�
	public boolean update(ServiceManager serviceManager);
	//��ҳ��ѯ
	public List<ServiceManager> queryServiceManagerLike(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag,int page,int pagesize);
	//��������ѯ��������ʾ���е�����
	public List<ServiceManager> queryAllServiceManager(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag);
	public List<ServiceManager> queryAllServiceManager(Byte servType,String servCreateDate,Byte servFlag);
	
}
