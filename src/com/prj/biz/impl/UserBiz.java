package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;
import com.prj.biz.IUserBiz;
import com.prj.dao.IUserDao;

public class UserBiz implements IUserBiz{
	private IUserDao userDao;
	
	//显示状态是未被删除的用户
	public List<SysUser> showUserByFlag(byte userFlag) {
		return userDao.queryAllByFlag(userFlag);
	}
	//新建用户（添加新用户）,需要判定登录名是否存在
	public boolean addUser(SysUser sysUser) {
		boolean flag=false;
		if(userDao.queryUserByLoginname(sysUser.getUserLoginname())==null){
			flag=userDao.addUser(sysUser);
		}
		return flag;
	}
	//通过编号，用户名（相当于表中的登录名），这里还有一个默认参数便是用户的状态,查询相关信息
	public List<SysUser> showUserByCondition(Integer userId, String userName,
			Byte userFlag) {
		return userDao.queryUserByCondition(userId, userName, userFlag);
	}
	//分页
	public List<SysUser> showUserByPage(int page, int pagesize, Byte userFlag) {
		return userDao.queryUserByPage(page, pagesize, userFlag);
	}
	//修改用户的信息
	public boolean updateUser(SysUser sysUser) {
		return userDao.updateUser(sysUser);
	}
	//删除用户，在这里的删除时软删除,相当于修改用户的状态
	public boolean deleteUser(SysUser sysUser) {
		return userDao.updateUser(sysUser);
	}
	//验证登陆的方法
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
