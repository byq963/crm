package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.Product;


public interface ICustomerDao {
	public boolean add(CustCustomer cust);
	//分页
	public List<CustCustomer> queryCustCustomerLike(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag,int page,int pagesize);
	//根据客户编号，名称，地区，客户经理名称，客户等级，客户状态进行查询
	public List<CustCustomer> queryAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custFlag);
	public List<CustCustomer> queryAllCustCustomer(String custNo,String custName,Byte custRegion,String custManagerName,Byte custLevel,Byte custSatisfy,Byte custCredit,Byte custFlag);
	//通过id查找对象
	public CustCustomer getCustomer(String custNo);
	//修改
	public boolean update(CustCustomer cust);
	//通过名称查询对象
	public CustCustomer getCustCustomerByName(String prodName);
	
}
