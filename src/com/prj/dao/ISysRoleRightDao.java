package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRoleRight;

public interface ISysRoleRightDao {
	//���
	public boolean add(SysRoleRight sysRoleRight);
	//ͨ����ɫ��id��ȡ��Ӧ���м�����
	public List<SysRoleRight> querySysRoleRightById(int id);
	//ɾ��
	public boolean delete(SysRoleRight sysRoleRight);
	//ͨ��id���Ҷ���
	public SysRoleRight getById(int id);
}
