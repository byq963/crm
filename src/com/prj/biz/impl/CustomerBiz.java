package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.biz.ICustomerBiz;
import com.prj.dao.ICustomerDao;

public class CustomerBiz implements ICustomerBiz {
	private ICustomerDao custDao;
	public boolean addCust(CustCustomer cust) {
		return custDao.add(cust);
	}
	
	public List<CustCustomer> showCustCustomerLike(String custNo,
			String custName, Byte custRegion, String custManagerName,
			Byte custLevel, Byte custFlag, int page, int pagesize) {
		return custDao.queryCustCustomerLike(custNo, custName, custRegion, custManagerName, custLevel, custFlag, page, pagesize);
	}
	public List<CustCustomer> showAllCustCustomer(String custNo,
			String custName, Byte custRegion, String custManagerName,
			Byte custLevel, Byte custFlag) {
		return custDao.queryAllCustCustomer(custNo, custName, custRegion, custManagerName, custLevel, custFlag);
	}
	public boolean update(CustCustomer cust) {
		return custDao.update(cust);
	}
	public CustCustomer findCustCustomerByName(String custName) {
		return custDao.getCustCustomerByName(custName);
	}
	public CustCustomer findCustomer(String custNo) {
		return custDao.getCustomer(custNo);
	}
	public ICustomerDao getCustDao() {
		return custDao;
	}
	
	public void setCustDao(ICustomerDao custDao) {
		this.custDao = custDao;
	}

	public List<CustCustomer> showAllCustCustomer(String custNo,
			String custName, Byte custRegion, String custManagerName,
			Byte custLevel, Byte custSatisfy, Byte custCredit, Byte custFlag) {
		return custDao.queryAllCustCustomer(custNo, custName, custRegion, custManagerName, custLevel, custSatisfy, custCredit, custFlag);
	}

	



	
}
