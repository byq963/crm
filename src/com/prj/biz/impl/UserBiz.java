package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;
import com.prj.biz.IUserBiz;
import com.prj.dao.IUserDao;

public class UserBiz implements IUserBiz{
	private IUserDao userDao;
	
	//��ʾ״̬��δ��ɾ�����û�
	public List<SysUser> showUserByFlag(byte userFlag) {
		return userDao.queryAllByFlag(userFlag);
	}
	//�½��û���������û���,��Ҫ�ж���¼���Ƿ����
	public boolean addUser(SysUser sysUser) {
		boolean flag=false;
		if(userDao.queryUserByLoginname(sysUser.getUserLoginname())==null){
			flag=userDao.addUser(sysUser);
		}
		return flag;
	}
	//ͨ����ţ��û������൱�ڱ��еĵ�¼���������ﻹ��һ��Ĭ�ϲ��������û���״̬,��ѯ�����Ϣ
	public List<SysUser> showUserByCondition(Integer userId, String userName,
			Byte userFlag) {
		return userDao.queryUserByCondition(userId, userName, userFlag);
	}
	//��ҳ
	public List<SysUser> showUserByPage(int page, int pagesize, Byte userFlag) {
		return userDao.queryUserByPage(page, pagesize, userFlag);
	}
	//�޸��û�����Ϣ
	public boolean updateUser(SysUser sysUser) {
		return userDao.updateUser(sysUser);
	}
	//ɾ���û����������ɾ��ʱ��ɾ��,�൱���޸��û���״̬
	public boolean deleteUser(SysUser sysUser) {
		return userDao.updateUser(sysUser);
	}
	//��֤��½�ķ���
	public SysUser valUser(String userLoginname, String userPassword) {
		return userDao.validateLogin(userLoginname, userPassword);
	}
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public List<SysUser> showUserBySysRole(SysRole sysRole) {
		return userDao.queryUserBySysRole(sysRole);
	}
	public List<SysUser> showUserByPage(Integer userId, String userName,
			Byte userFlag, int page, int pagesize) {
		return userDao.queryUserByPage(userId, userName, userFlag, page, pagesize);
	}
	public SysUser findUserById(int id) {
		return userDao.getUserById(id);
	}
	
	
	

}
