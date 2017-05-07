package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRight;

public interface ISysRightBiz {
	//获取所有的权限
	public List<SysRight> showAllSysRight();
	//通过rightCodes获取对象
	public SysRight findSysRightById(String rightCode);
}
