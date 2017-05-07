package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.SysRight;
import com.prj.biz.ISysRightBiz;
import com.prj.dao.ISysRightDao;

public class SysRightBiz implements ISysRightBiz {
	private ISysRightDao sysRightDao;
	public List<SysRight> showAllSysRight() {
		return sysRightDao.getAllSysRight();
	}
	public SysRight findSysRightById(String rightCode) {
		return sysRightDao.getSysRightById(rightCode);
	}
	public ISysRightDao getSysRightDao() {
		return sysRightDao;
	}
	public void setSysRightDao(ISysRightDao sysRightDao) {
		this.sysRightDao = sysRightDao;
	}
	

}
