package com.prj.biz;

import java.util.List;

import com.prj.bean.ServiceManager;

public interface IServiceManagerBiz {
	//通过id查找对象
		public ServiceManager findServiceManagerById(String servNo);
	//添加
	public boolean addServiceManager(ServiceManager serviceManager);
	//删除
	public boolean deleteServiceManager(ServiceManager serviceManager);
	//修改
	public boolean updateServiceManager(ServiceManager serviceManager);
	//分页查询
	public List<ServiceManager> showServiceManagerLike(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag,int page,int pagesize);
	//多条件查询，用于显示所有的条数
	public List<ServiceManager> showAllServiceManager(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag);
	public List<ServiceManager> showAllServiceManager(Byte servType,String servCreateDate,Byte servFlag);
}
