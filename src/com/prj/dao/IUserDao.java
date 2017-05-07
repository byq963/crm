package com.prj.dao;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;

public interface IUserDao {
		//添加
		public boolean addUser(SysUser sysUser);
		//修改
		public boolean updateUser(SysUser sysUser);
		//删除
		public boolean deleteUser(SysUser sysUser);
		//通过id查询
		public SysUser getUserById(int id);
		//多条件查询 通过id和用户名来查询相关数据
		public List<SysUser> queryUserByCondition(Integer userId,String userName,Byte userFlag);
		//多条件查询与分页的结合
		public List<SysUser> queryUserByPage(Integer userId,String userName,Byte userFlag,int page,int pagesize);
		//通过登录名和密码来查询，用来验证登陆信息
		public SysUser validateLogin(String userLoginname,String userPassword);
		//分页
		public List<SysUser> queryUserByPage(int page,int pagesize,Byte userFlag);
		//查询所有
		public List<SysUser> queryAllUser();
		//根据用户状态查询
		public List<SysUser> queryAllByFlag(byte flag);
		//通过登录名查询，此方法用于添加用户时来防止登录名重复
		public SysUser queryUserByLoginname(String userLoginname);
		//通过sysRole查询相关用户
		public List<SysUser> queryUserBySysRole(SysRole sysRole);
}
