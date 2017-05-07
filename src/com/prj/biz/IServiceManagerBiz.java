package com.prj.biz;

import java.util.List;

import com.prj.bean.ServiceManager;

public interface IServiceManagerBiz {
	//ͨ��id���Ҷ���
		public ServiceManager findServiceManagerById(String servNo);
	//���
	public boolean addServiceManager(ServiceManager serviceManager);
	//ɾ��
	public boolean deleteServiceManager(ServiceManager serviceManager);
	//�޸�
	public boolean updateServiceManager(ServiceManager serviceManager);
	//��ҳ��ѯ
	public List<ServiceManager> showServiceManagerLike(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag,int page,int pagesize);
	//��������ѯ��������ʾ���е�����
	public List<ServiceManager> showAllServiceManager(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag);
	public List<ServiceManager> showAllServiceManager(Byte servType,String servCreateDate,Byte servFlag);
}
