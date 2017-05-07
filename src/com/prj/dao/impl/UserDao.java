package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;
import com.prj.dao.IUserDao;

public class UserDao extends BaseDao implements IUserDao {

	public boolean addUser(SysUser sysUser) {
		return super.addT(sysUser);
	}

	public boolean updateUser(SysUser sysUser) {
		return super.addT(sysUser);
	}

	public boolean deleteUser(SysUser sysUser) {
		return super.deleteT(sysUser);
	}

	public SysUser getUserById(int id) {
		return (SysUser) super.getT(SysUser.class, id);
	}

	public List<SysUser> queryUserByCondition(Integer userId, String userName,Byte userFlag) {
		StringBuffer str=new StringBuffer("from SysUser where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(userId!=null&&!userId.equals("")){
			str.append("and userId =:userId ");
			maps.put("userId", userId);
		}
		if(userName!=null&&!userName.equals("")){
			str.append("and userName like :userName ");
			maps.put("userName", userName);
		}
		if(userFlag!=null&&!userFlag.equals("")){
			str.append("and userFlag =:flag ");
			maps.put("flag", userFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	

	public List<SysUser> queryUserByPage(int page, int pagesize,Byte userFlag) {
		StringBuffer str=new StringBuffer("from SysUser where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(userFlag!=null&&!userFlag.equals("")){
			str.append("and userFlag=:flag ");
			maps.put("flag", userFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<SysUser> queryAllUser() {
		return super.queryAllT("from SysUser");
	}
	
	public SysUser validateLogin(String userLoginname, String userPassword) {
		StringBuffer str=new StringBuffer("from SysUser where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(userLoginname!=null&&!userLoginname.equals("")){
			str.append("and userLoginname =:loginname ");
			maps.put("loginname", userLoginname);
		}
		if(userPassword!=null&&!userPassword.equals("")){
			str.append("and userPassword =:password");
			maps.put("password", userPassword);
		}
		if(super.queryByCondition(str.toString(), maps).size()>0){
			return (SysUser) super.queryByCondition(str.toString(), maps).get(0);
		}
		return null;
	}
	//通过登录名查询，此方法用于添加用户时来防止登录名重复
	public SysUser queryUserByLoginname(String userLoginname){
		List<SysUser> userList=super.getHibernateTemplate().find("from SysUser where userLoginname=?", userLoginname);
		if(userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	public List<SysUser> queryAllByFlag(byte userFlag) {
		return super.getHibernateTemplate().find("from SysUser where userFlag=?", userFlag);
	}

	public List<SysUser> queryUserBySysRole(SysRole sysRole) {
		
		return super.getHibernateTemplate().find("from SysUser where sysRole=?",sysRole);
	}

	public List<SysUser> queryUserByPage(Integer userId, String userName,
			Byte userFlag, int page, int pagesize) {
		StringBuffer str=new StringBuffer("from SysUser where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(userId!=null&&!userId.equals("")){
			str.append("and userId =:userId ");
			maps.put("userId", userId);
		}
		if(userName!=null&&!userName.equals("")){
			str.append("and userName like :userName ");
			maps.put("userName", "%"+userName+"%");
		}
		if(userFlag!=null&&!userFlag.equals("")){
			str.append("and userFlag =:userFlag ");
			maps.put("userFlag", userFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	

}
