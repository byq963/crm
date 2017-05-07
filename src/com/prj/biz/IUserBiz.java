package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;

public interface IUserBiz {
	//��½ʱ���û�������֤
	public SysUser valUser(String userLoginname,String userPassword);
	//��ʾ״̬��δ��ɾ�����û�
	public List<SysUser> showUserByFlag(byte userFlag);
	//�½��û���������û���,��Ҫ�ж���¼���Ƿ����
	public boolean addUser(SysUser sysUser);
	//ͨ����ţ��û������൱�ڱ��еĵ�¼���������ﻹ��һ��Ĭ�ϲ��������û���״̬
	public List<SysUser> showUserByCondition(Integer userId,String userName,Byte userFlag);
	//��ҳ
	public List<SysUser> showUserByPage(int page,int pagesize,Byte userFlag);
	//�޸��û�����Ϣ
	public boolean updateUser(SysUser sysUser);
	//ɾ���û����������ɾ��ʱ��ɾ��,�൱���޸��û���״̬
	public boolean deleteUser(SysUser sysUser);
	//ͨ��sysRole��ѯ����û�
	public List<SysUser> showUserBySysRole(SysRole sysRole);
	//��������ѯ���ҳ�Ľ��
	public List<SysUser> showUserByPage(Integer userId,String userName,Byte userFlag,int page,int pagesize);
	//ͨ��id��ѯ
			public SysUser findUserById(int id);
}
