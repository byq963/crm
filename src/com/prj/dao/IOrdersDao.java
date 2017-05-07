package com.prj.dao;

import java.util.List;

import com.prj.bean.CustCustomer;
import com.prj.bean.Orders;

public interface IOrdersDao {
	//��Ӷ���
	public boolean add(Orders order);
	//ɾ������
	public boolean delete(Orders order);
	//�޸Ķ���
	public boolean update(Orders order);
	//ͨ��id���Ҷ���
	public Orders get(Long ordeNo);
	//��ҳ
	public List<Orders> queryOrdersByPage(CustCustomer custCustomer,int page,int pagesize);
}
