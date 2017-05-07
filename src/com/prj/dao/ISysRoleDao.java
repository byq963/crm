package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;

public interface ISysRoleDao {
	//����id��ȡ����
	public SysRole querySysRoleById(int id);
	//��������ѯ ͨ��id���û�������ѯ�������
	public List<SysRole> querySysRoleByCondition(Integer roleId,String roleName,Byte roleFlag);
	//��������ѯ���ҳ�Ľ��
	public List<SysRole> querySysRoleByPage(Integer roleId,String roleName,Byte roleFlag,int page,int pagesize);
	//�޸�
	public boolean update(SysRole sysRole);
	//���
	public boolean add(SysRole sysRole);
}
