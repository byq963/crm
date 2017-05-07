package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.Orders;

public interface IOrdersDao {
	//添加对象
	public boolean add(Orders order);
	//删除对象
	public boolean delete(Orders order);
	//修改对象
	public boolean update(Orders order);
	//通过id查找对象
	public Orders get(Long ordeNo);
	//分页
	public List<Orders> queryOrdersByPage(CustCustomer custCustomer,int page,int pagesize);
}
