package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.biz.ISysRoleBiz;
import com.prj.dao.ISysRoleDao;

public class SysRoleBiz implements ISysRoleBiz {
	private ISysRoleDao sysRoleDao;
	public SysRole showSysRoleById(int id) {
		return sysRoleDao.querySysRoleById(id);
	}
	
	public List<SysRole> showSysRoleByCondition(Integer roleId,
			String roleName, Byte roleFlag) {
		return sysRoleDao.querySysRoleByCondition(roleId, roleName, roleFlag);
	}
	public List<SysRole> showSysRoleByPage(Integer roleId, String roleName,
			Byte roleFlag, int page, int pagesize) {
		return sysRoleDao.querySysRoleByPage(roleId, roleName, roleFlag, page, pagesize);
	}
	public ISysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}
	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	public boolean updateSysRole(SysRole sysRole) {
		return sysRoleDao.update(sysRole);
	}

	public boolean addSysRole(SysRole sysRole) {
		return sysRoleDao.add(sysRole);
	}

}
