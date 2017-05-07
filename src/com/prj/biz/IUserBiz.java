package com.prj.biz;

import java.util.List;

import com.prj.bean.SysRole;
import com.prj.bean.SysUser;

public interface IUserBiz {
	//登陆时对用户进行验证
	public SysUser valUser(String userLoginname,String userPassword);
	//显示状态是未被删除的用户
	public List<SysUser> showUserByFlag(byte userFlag);
	//新建用户（添加新用户）,需要判定登录名是否存在
	public boolean addUser(SysUser sysUser);
	//通过编号，用户名（相当于表中的登录名），这里还有一个默认参数便是用户的状态
	public List<SysUser> showUserByCondition(Integer userId,String userName,Byte userFlag);
	//分页
	public List<SysUser> showUserByPage(int page,int pagesize,Byte userFlag);
	//修改用户的信息
	public boolean updateUser(SysUser sysUser);
	//删除用户，在这里的删除时软删除,相当于修改用户的状态
	public boolean deleteUser(SysUser sysUser);
	//通过sysRole查询相关用户
	public List<SysUser> showUserBySysRole(SysRole sysRole);
	//多条件查询与分页的结合
	public List<SysUser> showUserByPage(Integer userId,String userName,Byte userFlag,int page,int pagesize);
	//通过id查询
			public SysUser findUserById(int id);
}
