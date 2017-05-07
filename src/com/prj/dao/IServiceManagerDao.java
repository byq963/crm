package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.ServiceManager;

public interface IServiceManagerDao {
	//通过id查找对象
	public ServiceManager getServiceManagerById(String servNo);
	//添加
	public boolean add(ServiceManager serviceManager);
	//删除
	public boolean delete(ServiceManager serviceManager);
	//修改
	public boolean update(ServiceManager serviceManager);
	//分页查询
	public List<ServiceManager> queryServiceManagerLike(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag,int page,int pagesize);
	//多条件查询，用于显示所有的条数
	public List<ServiceManager> queryAllServiceManager(String servCustName,String servTitle,Byte servType,String servCreateDate1,String servCreateDate2,Byte servStatus,Byte servFlag);
	public List<ServiceManager> queryAllServiceManager(Byte servType,String servCreateDate,Byte servFlag);
	
}
