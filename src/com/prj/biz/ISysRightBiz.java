package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRight;

public interface ISysRightBiz {
	//��ȡ���е�Ȩ��
	public List<SysRight> showAllSysRight();
	//ͨ��rightCodes��ȡ����
	public SysRight findSysRightById(String rightCode);
}
