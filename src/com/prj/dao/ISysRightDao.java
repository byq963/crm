package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRight;

public interface ISysRightDao {
	//��ȡ���е�Ȩ��
	public List<SysRight> getAllSysRight();
	//ͨ��rightCodes��ȡ����
	public SysRight getSysRightById(String rightCode);
}
