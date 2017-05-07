package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;

public interface ISysRoleDao {
	//根据id获取对象
	public SysRole querySysRoleById(int id);
	//多条件查询 通过id和用户名来查询相关数据
	public List<SysRole> querySysRoleByCondition(Integer roleId,String roleName,Byte roleFlag);
	//多条件查询与分页的结合
	public List<SysRole> querySysRoleByPage(Integer roleId,String roleName,Byte roleFlag,int page,int pagesize);
	//修改
	public boolean update(SysRole sysRole);
	//添加
	public boolean add(SysRole sysRole);
}
