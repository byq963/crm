package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRole;

public interface ISysRoleBiz {
	
		//����id��ȡ����
		public SysRole showSysRoleById(int id);
		//��������ѯ ͨ��id���û�������ѯ�������
		public List<SysRole> showSysRoleByCondition(Integer roleId,String roleName,Byte roleFlag);
		//��������ѯ���ҳ�Ľ��
		public List<SysRole> showSysRoleByPage(Integer roleId,String roleName,Byte roleFlag,int page,int pagesize);
		//�޸�
		public boolean updateSysRole(SysRole sysRole);
		//���
		public boolean addSysRole(SysRole sysRole);
}
