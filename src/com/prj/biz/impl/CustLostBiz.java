package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.CustLost;
import com.prj.biz.ICustLostBiz;
import com.prj.dao.ICustLostDao;

public class CustLostBiz implements ICustLostBiz {
	private ICustLostDao custLostDao;
	public List<CustLost> showCustLostLike(String custCustomer,
			String lostManagerName, Byte lostStatus, int page, int pagesize) {
		return custLostDao.queryCustLostLike(custCustomer, lostManagerName, lostStatus, page, pagesize);
	}

	public List<CustLost> showAllCustLost(String custCustomer,
			String lostManagerName, Byte lostStatus) {
		return custLostDao.queryAllCustLost(custCustomer, lostManagerName, lostStatus);
	}

	public CustLost findCustLost(Long lostNo) {
		return custLostDao.getCustLost(lostNo);
	}

	public boolean updateCustLost(CustLost custLost) {
		return custLostDao.update(custLost);
	}

	public ICustLostDao getCustLostDao() {
		return custLostDao;
	}

	public void setCustLostDao(ICustLostDao custLostDao) {
		this.custLostDao = custLostDao;
	}

	public List<CustLost> showAllCustLost(String custName,
			String lostManagerName) {
		return custLostDao.queryAllCustLost(custName, lostManagerName);
	}

	public List<CustLost> showAllCustLostPage(String custName,
			String lostManagerName, int page, int pagesize) {
		return custLostDao.queryAllCustLostPage(custName, lostManagerName, page, pagesize);
	}

}
