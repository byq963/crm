package com.prj.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.prj.bean.SysRoleRight;
import com.prj.dao.ISysRoleRightDao;

public class SysRoleRightDao extends BaseDao implements ISysRoleRightDao{

	public boolean add(SysRoleRight sysRoleRight) {
		return super.addT(sysRoleRight);
	}

	public List<SysRoleRight> querySysRoleRightById(int id) {
		return super.getHibernateTemplate().find("from SysRoleRight where sysRole.roleId=?", id);
	}

	public boolean delete(SysRoleRight sysRoleRight) {
		return super.deleteT(sysRoleRight);
	}

	public SysRoleRight getById(int id) {
		return (SysRoleRight) super.getT(SysRoleRight.class, id);
	}

}
