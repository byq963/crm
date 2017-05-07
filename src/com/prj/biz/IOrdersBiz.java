package com.prj.biz;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.Orders;

public interface IOrdersBiz {
	//��Ӷ���
	public boolean addOrders(Orders order);
	//ɾ������
	public boolean deleteOrders(Orders order);
	//�޸Ķ���
	public boolean updateOrders(Orders order);
	//ͨ��id���Ҷ���
	public Orders findOrders(Long ordeNo);
	//��ҳ
	public List<Orders> showOrdersByPage(CustCustomer custCustomer,int page,int pagesize);
}
