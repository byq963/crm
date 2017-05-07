package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.ServiceManager;
import com.prj.dao.IServiceManagerDao;

public class ServiceManagerDao extends BaseDao implements IServiceManagerDao {

	public boolean add(ServiceManager serviceManager) {
		return super.addT(serviceManager);
	}

	public boolean delete(ServiceManager serviceManager) {
		return super.updateT(serviceManager);
	}

	public boolean update(ServiceManager serviceManager) {
		return super.updateT(serviceManager);
	}

	public List<ServiceManager> queryServiceManagerLike(String servCustName,
			String servTitle, Byte servType, String servCreateDate1,
			String servCreateDate2, Byte servStatus, Byte servFlag, int page,
			int pagesize) {
		StringBuffer str=new StringBuffer("from ServiceManager where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(servCustName!=null&&!servCustName.equals("")){
			str.append("and servCustName like :servCustName ");
			maps.put("servCustName", "%"+servCustName+"%");
		}
		if(servTitle!=null&&!servTitle.equals("")){
			str.append("and servTitle like :servTitle ");
			maps.put("servTitle", "%"+servTitle+"%");
		}
		if(servType!=null&&!servType.equals("")){
			str.append("and servType =:servType ");
			maps.put("servType", servType);
		}
		if(servCreateDate1!=null&&!servCreateDate1.equals("")){
			str.append("and servCreateDate > :servCreateDate1 ");
			maps.put("servCreateDate1", servCreateDate1);
		}
		if(servCreateDate2!=null&&!servCreateDate2.equals("")){
			str.append("and servCreateDate < :servCreateDate2 ");
			maps.put("servCreateDate2", servCreateDate2);
		}
		if(servStatus!=null&&!servStatus.equals("")){
			str.append("and servStatus =:servStatus ");
			maps.put("servStatus", servStatus);
		}
		if(servFlag!=null&&!servFlag.equals("")){
			str.append("and servFlag =:servFlag ");
			maps.put("servFlag", servFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<ServiceManager> queryAllServiceManager(String servCustName,
			String servTitle, Byte servType, String servCreateDate1,
			String servCreateDate2, Byte servStatus, Byte servFlag) {
		StringBuffer str=new StringBuffer("from ServiceManager where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(servCustName!=null&&!servCustName.equals("")){
			str.append("and servCustName like :servCustName ");
			maps.put("servCustName", "%"+servCustName+"%");
		}
		if(servTitle!=null&&!servTitle.equals("")){
			str.append("and servTitle like :servTitle ");
			maps.put("servTitle", "%"+servTitle+"%");
		}
		if(servType!=null&&!servType.equals("")){
			str.append("and servType =:servType ");
			maps.put("servType", servType);
		}
		if(servCreateDate1!=null&&!servCreateDate1.equals("")){
			str.append("and servCreateDate >= :servCreateDate1 ");
			maps.put("servCreateDate1", servCreateDate1);
		}
		if(servCreateDate2!=null&&!servCreateDate2.equals("")){
			str.append("and servCreateDate <= :servCreateDate2 ");
			maps.put("servCreateDate2", servCreateDate2);
		}
		if(servStatus!=null&&!servStatus.equals("")){
			str.append("and servStatus =:servStatus ");
			maps.put("servStatus", servStatus);
		}
		if(servFlag!=null&&!servFlag.equals("")){
			str.append("and servFlag =:servFlag ");
			maps.put("servFlag", servFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public ServiceManager getServiceManagerById(String servNo) {
		List<ServiceManager> serviceManagerList=super.getHibernateTemplate().find("from ServiceManager where servNo=?", servNo);
		if(serviceManagerList.size()>0){
			
			return serviceManagerList.get(0);
		}
		return null;
	}

	public List<ServiceManager> queryAllServiceManager(Byte servType,
			String servCreateDate, Byte servFlag) {
		StringBuffer str=new StringBuffer("from ServiceManager where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(servCreateDate!=null&&!servCreateDate.equals("")){
			str.append("and servCreateDate like :servCreateDate ");
			maps.put("servCreateDate", "%"+servCreateDate+"%");
		}
		
		if(servType!=null&&!servType.equals("")){
			str.append("and servType =:servType ");
			maps.put("servType", servType);
		}
		
		if(servFlag!=null&&!servFlag.equals("")){
			str.append("and servFlag =:servFlag ");
			maps.put("servFlag", servFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

}
