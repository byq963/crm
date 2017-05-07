package com.prj.dao;

import com.prj.bean.CustLinkman;

public interface ICustLinkmanDao {
	//添加对象
	public boolean add(CustLinkman custLinkman);
	//删除对象
	public boolean delete(CustLinkman custLinkman);
	//修改对象
	public boolean update(CustLinkman custLinkman);
	//通过id查找对象
	public CustLinkman get(String linkNo);
}
