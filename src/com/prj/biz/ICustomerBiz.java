package com.prj.biz;

import java.util.List;

import com.prj.bean.CustCustomer;

public interface ICustomerBiz {
	public boolean addCust(CustCustomer cust);
	//分页
		public List<CustCustomer> showCustCustomerLike(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag,int page,int pagesize);
		//根据客户编号，名称，地区，客户经理名称，客户等级，客户状态进行查询
		public List<CustCustomer> showAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag);
		//通过id查找对象
		public CustCustomer findCustomer(String custNo);
		//修改
		public boolean update(CustCustomer cust);
		public CustCustomer findCustCustomerByName(String custName);
		public List<CustCustomer> showAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custSatisfy,Byte custCredit,Byte custFlag);
}
