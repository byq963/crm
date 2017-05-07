package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;

public interface IUserDao {
		//���
		public boolean addUser(SysUser sysUser);
		//�޸�
		public boolean updateUser(SysUser sysUser);
		//ɾ��
		public boolean deleteUser(SysUser sysUser);
		//ͨ��id��ѯ
		public SysUser getUserById(int id);
		//��������ѯ ͨ��id���û�������ѯ�������
		public List<SysUser> queryUserByCondition(Integer userId,String userName,Byte userFlag);
		//��������ѯ���ҳ�Ľ��
		public List<SysUser> queryUserByPage(Integer userId,String userName,Byte userFlag,int page,int pagesize);
		//ͨ����¼������������ѯ��������֤��½��Ϣ
		public SysUser validateLogin(String userLoginname,String userPassword);
		//��ҳ
		public List<SysUser> queryUserByPage(int page,int pagesize,Byte userFlag);
		//��ѯ����
		public List<SysUser> queryAllUser();
		//�����û�״̬��ѯ
		public List<SysUser> queryAllByFlag(byte flag);
		//ͨ����¼����ѯ���˷�����������û�ʱ����ֹ��¼���ظ�
		public SysUser queryUserByLoginname(String userLoginname);
		//ͨ��sysRole��ѯ����û�
		public List<SysUser> queryUserBySysRole(SysRole sysRole);
}
