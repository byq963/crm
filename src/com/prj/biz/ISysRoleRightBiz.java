package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRoleRight;

public interface ISysRoleRightBiz {
	//���
	public boolean add(SysRoleRight sysRoleRight);
	//ͨ����ɫ��id��ȡ��Ӧ���м�����
	public List<SysRoleRight> showSysRoleRightById(int id);
	//ͨ��idɾ������
	public boolean deleteSysRoleRight(SysRoleRight sysRoleRight);
}
