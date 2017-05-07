package com.prj.dao.impl;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.CustCustomer;
import com.prj.bean.Orders;
import com.prj.dao.IOrdersDao;

public class OrdersDao extends BaseDao implements IOrdersDao {

	public boolean add(Orders order) {
		return super.addT(order);
	}

	public boolean delete(Orders order) {
		return super.updateT(order);
	}

	public boolean update(Orders order) {
		return super.updateT(order);
	}

	public Orders get(Long ordeNo) {
		return (Orders) super.getT(Orders.class, ordeNo);
	}

	public List<Orders> queryOrdersByPage(CustCustomer custCustomer,int page, int pagesize) {
		StringBuffer str=new StringBuffer("from Orders where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(custCustomer!=null&&!custCustomer.equals("")){
			str.append("and custCustomer =:custCustomer ");
			maps.put("custCustomer", custCustomer);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

}
