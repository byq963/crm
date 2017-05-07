package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRole;

public interface ISysRoleBiz {
	
		//根据id获取对象
		public SysRole showSysRoleById(int id);
		//多条件查询 通过id和用户名来查询相关数据
		public List<SysRole> showSysRoleByCondition(Integer roleId,String roleName,Byte roleFlag);
		//多条件查询与分页的结合
		public List<SysRole> showSysRoleByPage(Integer roleId,String roleName,Byte roleFlag,int page,int pagesize);
		//修改
		public boolean updateSysRole(SysRole sysRole);
		//添加
		public boolean addSysRole(SysRole sysRole);
}
