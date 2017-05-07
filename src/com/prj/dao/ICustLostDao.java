package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.CustLost;

public interface ICustLostDao {
	//模糊多条件查询与分页进行结合的方法,可以查询任何数据
	public List<CustLost> queryCustLostLike(String custCustomer,String lostManagerName,Byte lostStatus,int page,int pagesize);
	//根据相关条件查询所有数据
	public List<CustLost> queryAllCustLost(String  custCustomer,String lostManagerName,Byte lostStatus);
	//通过id得到对象
	public CustLost getCustLost(Long lostNo);
	//修改
	public boolean update(CustLost custLost);
	//根据客户名称和客户经理名称查询
	public List<CustLost> queryAllCustLost(String custName,String lostManagerName);
	public List<CustLost> queryAllCustLostPage(String custName,String lostManagerName,int page,int pagesize);
}
