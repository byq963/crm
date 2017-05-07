package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRight;

public interface ISysRightDao {
	//获取所有的权限
	public List<SysRight> getAllSysRight();
	//通过rightCodes获取对象
	public SysRight getSysRightById(String rightCode);
}
