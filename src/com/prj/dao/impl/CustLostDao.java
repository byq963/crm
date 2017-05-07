package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.CustCustomer;
import com.prj.bean.CustLost;
import com.prj.dao.ICustLostDao;

public class CustLostDao extends BaseDao implements ICustLostDao {

	public List<CustLost> queryCustLostLike(String custCustomer,
			String lostManagerName, Byte lostStatus, int page, int pagesize) {
		StringBuffer str=new StringBuffer("from CustLost where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(lostManagerName!=null&&!lostManagerName.equals("")){
			str.append("and lostManagerName like :lostManagerName ");
			maps.put("lostManagerName", "%"+lostManagerName+"%");
		}
		if(custCustomer!=null&&!custCustomer.equals("")){
			str.append("and custCustomer.custName like :custCustomer ");
			maps.put("custCustomer", "%"+custCustomer+"%");
		}
		if(lostStatus!=null&&!lostStatus.equals("")){
			str.append("and lostStatus =:lostStatus ");
			maps.put("lostStatus", lostStatus);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<CustLost> queryAllCustLost(String custCustomer,
			String lostManagerName, Byte lostStatus) {
		StringBuffer str=new StringBuffer("from CustLost where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(lostManagerName!=null&&!lostManagerName.equals("")){
			str.append("and lostManagerName like :lostManagerName ");
			maps.put("lostManagerName", "%"+lostManagerName+"%");
		}
		if(custCustomer!=null&&!custCustomer.equals("")){
			str.append("and custCustomer.custName like :custCustomer ");
			maps.put("custCustomer", "%"+custCustomer+"%");
		}
		if(lostStatus!=null&&!lostStatus.equals("")){
			str.append("and lostStatus =:lostStatus ");
			maps.put("lostStatus", lostStatus);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public CustLost getCustLost(Long lostNo) {
		return (CustLost) super.getT(CustLost.class, lostNo);
	}

	public boolean update(CustLost custLost) {
		return super.updateT(custLost);
	}

	public List<CustLost> queryAllCustLost(String custName,
			String lostManagerName) {
		StringBuffer str=new StringBuffer("from CustLost where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(custName!=null&&!custName.equals("")){
			str.append("and custCustomer.custName like :custName ");
			maps.put("custName", "%"+custName+"%");
		}
		if(lostManagerName!=null&&!lostManagerName.equals("")){
			str.append("and lostManagerName like :lostManagerName ");
			maps.put("lostManagerName", "%"+lostManagerName+"%");
		}
		return super.queryByCondition(str.toString(), maps);
	}

	
	public List<CustLost> queryAllCustLostPage(String custName,
			String lostManagerName, int page, int pagesize) {
		StringBuffer str=new StringBuffer("from CustLost where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(custName!=null&&!custName.equals("")){
			str.append("and custCustomer.custName like :custName ");
			maps.put("custName", "%"+custName+"%");
		}
		if(lostManagerName!=null&&!lostManagerName.equals("")){
			str.append("and lostManagerName like :lostManagerName ");
			maps.put("lostManagerName", "%"+lostManagerName+"%");
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

}
