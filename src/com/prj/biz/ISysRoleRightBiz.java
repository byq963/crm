package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRoleRight;

public interface ISysRoleRightBiz {
	//添加
	public boolean add(SysRoleRight sysRoleRight);
	//通过角色的id获取相应的中间表对象
	public List<SysRoleRight> showSysRoleRightById(int id);
	//通过id删除对象
	public boolean deleteSysRoleRight(SysRoleRight sysRoleRight);
}
