package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.ServiceManager;
import com.prj.biz.IServiceManagerBiz;
import com.prj.dao.IServiceManagerDao;

public class ServiceManagerBiz implements IServiceManagerBiz {
	private IServiceManagerDao serviceManagerDao;
	public boolean addServiceManager(ServiceManager serviceManager) {
		return serviceManagerDao.add(serviceManager);
	}

	public boolean deleteServiceManager(ServiceManager serviceManager) {
		return serviceManagerDao.delete(serviceManager);
	}

	public boolean updateServiceManager(ServiceManager serviceManager) {
		return serviceManagerDao.update(serviceManager);
	}

	public List<ServiceManager> showServiceManagerLike(String servCustName,
			String servTitle, Byte servType, String servCreateDate1,
			String servCreateDate2, Byte servStatus, Byte servFlag, int page,
			int pagesize) {
		return serviceManagerDao.queryServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, servStatus, servFlag, page, pagesize);
	}

	public List<ServiceManager> showAllServiceManager(String servCustName,
			String servTitle, Byte servType, String servCreateDate1,
			String servCreateDate2, Byte servStatus, Byte servFlag) {
		return serviceManagerDao.queryAllServiceManager(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, servStatus, servFlag);
	}

	public IServiceManagerDao getServiceManagerDao() {
		return serviceManagerDao;
	}

	public void setServiceManagerDao(IServiceManagerDao serviceManagerDao) {
		this.serviceManagerDao = serviceManagerDao;
	}

	public ServiceManager findServiceManagerById(String servNo) {
		return serviceManagerDao.getServiceManagerById(servNo);
	}

	public List<ServiceManager> showAllServiceManager(Byte servType,
			String servCreateDate, Byte servFlag) {
		return serviceManagerDao.queryAllServiceManager(servType, servCreateDate, servFlag);
	}

}
