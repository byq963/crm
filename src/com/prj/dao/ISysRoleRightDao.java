package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRoleRight;

public interface ISysRoleRightDao {
	//添加
	public boolean add(SysRoleRight sysRoleRight);
	//通过角色的id获取相应的中间表对象
	public List<SysRoleRight> querySysRoleRightById(int id);
	//删除
	public boolean delete(SysRoleRight sysRoleRight);
	//通过id查找对象
	public SysRoleRight getById(int id);
}
