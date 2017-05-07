package com.prj.dao.impl;

import java.util.List;

import com.prj.bean.SysRight;
import com.prj.bean.SysRole;
import com.prj.dao.ISysRightDao;

public class SysRightDao extends BaseDao implements ISysRightDao {

	public List<SysRight> getAllSysRight() {
		return super.queryAllT("from SysRight ");
	}

	public SysRight getSysRightById(String rightCode) {
		List<SysRight> rightList=super.getHibernateTemplate().find("from SysRight where rightCode=?", rightCode);
		if(rightList.size()>0){
			return rightList.get(0);
		}
		return null;
	}
}
