package com.prj.biz;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.Orders;

public interface IOrdersBiz {
	//添加对象
	public boolean addOrders(Orders order);
	//删除对象
	public boolean deleteOrders(Orders order);
	//修改对象
	public boolean updateOrders(Orders order);
	//通过id查找对象
	public Orders findOrders(Long ordeNo);
	//分页
	public List<Orders> showOrdersByPage(CustCustomer custCustomer,int page,int pagesize);
}
