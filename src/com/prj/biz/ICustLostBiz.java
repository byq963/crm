package com.prj.biz;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.CustLost;

public interface ICustLostBiz {
	//模糊多条件查询与分页进行结合的方法,可以查询任何数据
	public List<CustLost> showCustLostLike(String custCustomer,String lostManagerName,Byte lostStatus,int page,int pagesize);
	//根据相关条件查询所有数据
	public List<CustLost> showAllCustLost(String custCustomer,String lostManagerName,Byte lostStatus);
	//通过id得到对象
	public CustLost findCustLost(Long lostNo);
	//修改
	public boolean updateCustLost(CustLost custLost);
	//根据客户名称和客户经理名称查询
		public List<CustLost> showAllCustLost(String custName,String lostManagerName);
		public List<CustLost> showAllCustLostPage(String custName,String lostManagerName,int page,int pagesize);
}
