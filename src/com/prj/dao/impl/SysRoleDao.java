package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.SysRole;
import com.prj.dao.ISysRoleDao;

public class SysRoleDao extends BaseDao implements ISysRoleDao {

	public SysRole querySysRoleById(int id) {
		return (SysRole) super.getT(SysRole.class, id);
	}

	public List<SysRole> querySysRoleByCondition(Integer roleId,
			String roleName, Byte roleFlag) {
		StringBuffer str=new StringBuffer("from SysRole where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(roleId!=null&&!roleId.equals("")){
			str.append("and roleId =:roleId ");
			maps.put("roleId", roleId);
		}
		if(roleName!=null&&!roleName.equals("")){
			str.append("and roleName like :roleName ");
			maps.put("roleName", "%"+roleName+"%");
		}
		if(roleFlag!=null&&!roleFlag.equals("")){
			str.append("and roleFlag =:roleFlag ");
			maps.put("roleFlag", roleFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public List<SysRole> querySysRoleByPage(Integer roleId, String roleName,
			Byte roleFlag, int page, int pagesize) {
		StringBuffer str=new StringBuffer("from SysRole where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(roleId!=null&&!roleId.equals("")){
			str.append("and roleId =:roleId ");
			maps.put("roleId", roleId);
		}
		if(roleName!=null&&!roleName.equals("")){
			str.append("and roleName like :roleName ");
			maps.put("roleName", "%"+roleName+"%");
		}
		if(roleFlag!=null&&!roleFlag.equals("")){
			str.append("and roleFlag =:roleFlag ");
			maps.put("roleFlag", roleFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public boolean update(SysRole sysRole) {
		return super.updateT(sysRole);
	}

	public boolean add(SysRole sysRole) {
		return super.addT(sysRole);
	}

}
