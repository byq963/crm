package com.prj.dao.impl;

import java.util.List;

import com.prj.bean.CustLinkman;
import com.prj.dao.ICustLinkmanDao;

public class CustLinkmanDao extends BaseDao implements ICustLinkmanDao {

	public boolean add(CustLinkman custLinkman) {
		return super.addT(custLinkman);
	}

	public boolean delete(CustLinkman custLinkman) {
		return super.updateT(custLinkman);
	}

	public boolean update(CustLinkman custLinkman) {
		return super.updateT(custLinkman);
	}

	public CustLinkman get(String linkNo) {
		List<CustLinkman> custLinkmanList=super.getHibernateTemplate().find("from CustLinkman where linkNo=?", linkNo);
		if(custLinkmanList.size()>0){
			return custLinkmanList.get(0);
		}
		return null;
	}

}
