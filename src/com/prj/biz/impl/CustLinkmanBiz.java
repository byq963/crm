package com.prj.biz.impl;

import com.prj.bean.CustLinkman;
import com.prj.biz.ICustLinkmanBiz;
import com.prj.dao.ICustLinkmanDao;

public class CustLinkmanBiz implements ICustLinkmanBiz {
	private ICustLinkmanDao custLinkmanDao;
	public boolean addLinkman(CustLinkman custLinkman) {
		return custLinkmanDao.add(custLinkman);
	}

	public boolean deleteLinkman(CustLinkman custLinkman) {
		return custLinkmanDao.delete(custLinkman);
	}

	public boolean updateLinkman(CustLinkman custLinkman) {
		return custLinkmanDao.update(custLinkman);
	}

	public CustLinkman findLinkman(String linkNo) {
		return custLinkmanDao.get(linkNo);
	}

	public ICustLinkmanDao getCustLinkmanDao() {
		return custLinkmanDao;
	}

	public void setCustLinkmanDao(ICustLinkmanDao custLinkmanDao) {
		this.custLinkmanDao = custLinkmanDao;
	}

}
