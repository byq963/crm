package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.SysRoleRight;
import com.prj.biz.ISysRoleRightBiz;
import com.prj.dao.ISysRoleRightDao;

public class SysRoleRightBiz implements ISysRoleRightBiz{
	private ISysRoleRightDao sysRoleRightDao;
	public boolean add(SysRoleRight sysRoleRight) {
		return sysRoleRightDao.add(sysRoleRight);
	}
	public ISysRoleRightDao getSysRoleRightDao() {
		return sysRoleRightDao;
	}
	public void setSysRoleRightDao(ISysRoleRightDao sysRoleRightDao) {
		this.sysRoleRightDao = sysRoleRightDao;
	}
	public List<SysRoleRight> showSysRoleRightById(int id) {
		return sysRoleRightDao.querySysRoleRightById(id);
	}
	public boolean deleteSysRoleRight(SysRoleRight sysRoleRight) {
		
		return sysRoleRightDao.delete(sysRoleRight);
	}

}
