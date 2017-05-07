package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.Orders;
import com.prj.biz.IOrdersBiz;
import com.prj.dao.IOrdersDao;

public class OrdersBiz implements IOrdersBiz{
	private IOrdersDao ordersDao;
	public boolean addOrders(Orders order) {
		return ordersDao.add(order);
	}

	public boolean deleteOrders(Orders order) {
		return ordersDao.delete(order);
	}

	public boolean updateOrders(Orders order) {
		return ordersDao.update(order);
	}

	public Orders findOrders(Long ordeNo) {
		return ordersDao.get(ordeNo);
	}

	public IOrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	public List<Orders> showOrdersByPage(CustCustomer custCustomer,int page, int pagesize) {
		return ordersDao.queryOrdersByPage(custCustomer,page, pagesize);
	}

}
