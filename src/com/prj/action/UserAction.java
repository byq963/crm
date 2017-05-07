package com.prj.action;





import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.SysRight;
import com.prj.bean.SysRole;
import com.prj.bean.SysRoleRight;
import com.prj.bean.SysUser;
import com.prj.biz.ISysRightBiz;
import com.prj.biz.ISysRoleBiz;
import com.prj.biz.ISysRoleRightBiz;
import com.prj.biz.IUserBiz;
import com.prj.biz.impl.SysRoleRightBiz;
import com.prj.util.PageUtil;

public class UserAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private IUserBiz userBiz;
	private ISysRoleBiz sysRoleBiz;
	private ISysRightBiz sysRightBiz;
	private ISysRoleRightBiz sysRoleRightBiz;

	private String userLoginname;
	private String userPassword;
	private int page;
	private int pagesize;
	private Integer userId;
	private String userName;
	private Byte userFlag;
	private SysUser user;
	private Integer roleId;
	private String roleName;
	private Byte roleFlag;
	private SysRole sysRole1;
	private String[] rightCodes;
	private String roleDesc;
	//进入添加角色页面
	public String addRoleInput(){
		
		//获取所有的权限
		List<SysRight> rightList=sysRightBiz.showAllSysRight();
		request.put("rightList", rightList);
		return "addRoleInput";
	}
	//完成添加角色
	public String addRole(){
		System.out.println(sysRole1.getRoleName());
		//判断角色名是否存在
		if(sysRoleBiz.showSysRoleByCondition(null, sysRole1.getRoleName(), (byte)1).size()>0){
			request.put("error", "该角色名已经存在");
			return addRoleInput();
		}

		sysRole1.setRoleFlag((byte)1);
		sysRoleBiz.addSysRole(sysRole1);
		System.out.println(rightCodes.length);
		for (int i = 0; i < rightCodes.length; i++) {
			String a=rightCodes[i];
			//通过rightCodes查询sysright对象
			//SysRight sysRight1=sysRightBiz.findSysRightById(a);
			SysRoleRight sysRoleRight1=new SysRoleRight();
			sysRoleRight1.setSysRight(sysRightBiz.findSysRightById(a));
			sysRoleRight1.setSysRole(sysRole1);
			sysRoleRightBiz.add(sysRoleRight1);
		}
		return showRoleFirst();


	}
	//进入修改角色的页面
	public String updateRoleInput(){
		//获取所有的权限
		List<SysRight> rightList=sysRightBiz.showAllSysRight();
		//通过id获取相应的sysrole对象
		SysRole sysRole=sysRoleBiz.showSysRoleById(roleId);
		request.put("sysRole", sysRole);
		request.put("rightList", rightList);
		roleId=null;
		return "updateRoleInput";
	}
	//完成角色的修改
	public String updateSysRole(){
		sysRole1=sysRoleBiz.showSysRoleById(roleId);
		Set<SysRoleRight>  sysRoleRightList=sysRole1.getSysRoleRights();
		for(SysRoleRight sys:sysRoleRightList){
			sysRoleRightBiz.deleteSysRoleRight(sys);
		}
		for (int i = 0; i < rightCodes.length; i++) {
			String a=rightCodes[i];
			//通过rightCodes查询sysright对象
			//SysRight sysRight1=sysRightBiz.findSysRightById(a);
			SysRoleRight sysRoleRight1=new SysRoleRight();
			sysRoleRight1.setSysRight(sysRightBiz.findSysRightById(a));
			sysRoleRight1.setSysRole(sysRole1);
			sysRoleRightBiz.add(sysRoleRight1);
		}
		roleId=null;
		return showRoleFirst();

	}
	public String valLogin(){
		System.out.println("jinlaile");
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String,Object> map=new HashMap<String,Object>();
		System.out.println(userLoginname);
		System.out.println(userPassword);
		SysUser sysUser=userBiz.valUser(userLoginname, userPassword);
		JSONObject jo=JSONObject.fromObject(map);
		if(sysUser!=null){ 
			map.put("msg","登陆成功");
			jo=JSONObject.fromObject(map);
			//客户经理的角色，里面包含sysuser对象的集合
			SysRole sysRole=sysRoleBiz.showSysRoleById(4);
			session.setAttribute("sysUser", sysUser);
			session.setAttribute("sysRole", sysRole);
		}else{
			map.put("msg","登陆失败");
			jo=JSONObject.fromObject(map);
		}
		out.print(jo);
		return null;
	}
	//退出系统
	public String exit(){
		ActionContext.getContext().getSession().clear();
		return "exit";
	}
	//进入用户列表显示
	public String showUserFirst(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//显示所有符合条件的数据的条数
		int count=userBiz.showUserByCondition(userId, userName, (byte)1).size();
		System.out.println("userid"+userId);
		System.out.println("username"+userName);
		System.out.println("count"+count);
		//分页显示的数据
		List<SysUser> userList=userBiz.showUserByPage(userId, userName, (byte)1, page, pagesize);
		System.out.println(userList.size());
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("userList", userList);
		request.put("allpage", allpage);
		return "showUserFirst";
	}
	//删除用户
	public String deleteUser(){
		user=userBiz.findUserById(userId);
		user.setUserFlag((byte) 0);
		userBiz.updateUser(user);
		userId=null;

		return showUserFirst();
	}
	//进入修改user的页面
	public String updateUserInput(){
		user=userBiz.findUserById(userId);
		//获取所有的角色
		List<SysRole> roleList=sysRoleBiz.showSysRoleByCondition(null, null, (byte) 1);
		request.put("roleList", roleList);
		userId=null;
		userName=null;
		return "updateUserInput";
	}
	//完成对user的修改
	public String updateUser(){
		user=userBiz.findUserById(userId);
		SysRole role=sysRoleBiz.showSysRoleById(roleId);
		user.setSysRole(role);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		userBiz.updateUser(user);
		userId=null;
		userName=null;
		return showUserFirst();
	}
	//进入user的添加页面
	public String addUserInput(){
		//获取所有的角色
		List<SysRole> roleList=sysRoleBiz.showSysRoleByCondition(null, null, (byte) 1);
		request.put("roleList", roleList);
		return "addUserInput";
	}
	//完成对user的添加
	public String addUser(){
		SysRole role=sysRoleBiz.showSysRoleById(roleId);
		user.setSysRole(role);
		user.setUserFlag((byte) 1);
		userBiz.addUser(user);
		userId=null;
		return showUserFirst();
	}
	//进入角色列表显示
	public String showRoleFirst(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//显示所有符合条件的数据的条数
		int count=sysRoleBiz.showSysRoleByCondition(roleId, roleName, (byte)1).size();
		//分页显示的数据
		List<SysRole> sysRoleList=sysRoleBiz.showSysRoleByPage(roleId, roleName,  (byte)1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("sysRoleList", sysRoleList);
		request.put("allpage", allpage);
		return "showRoleFirst";
	}
	//删除角色
	public String deleteRole(){
		sysRole1=sysRoleBiz.showSysRoleById(roleId);
		sysRole1.setRoleFlag((byte)0);
		sysRoleBiz.updateSysRole(sysRole1);
		roleId=null;
		return showRoleFirst();
	}
	public IUserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String getUserLoginname() {
		return userLoginname;
	}
	public void setUserLoginname(String userLoginname) {
		this.userLoginname = userLoginname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Byte getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(Byte userFlag) {
		this.userFlag = userFlag;
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public ISysRoleBiz getSysRoleBiz() {
		return sysRoleBiz;
	}
	public void setSysRoleBiz(ISysRoleBiz sysRoleBiz) {
		this.sysRoleBiz = sysRoleBiz;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Byte getRoleFlag() {
		return roleFlag;
	}
	public void setRoleFlag(Byte roleFlag) {
		this.roleFlag = roleFlag;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public ISysRightBiz getSysRightBiz() {
		return sysRightBiz;
	}
	public void setSysRightBiz(ISysRightBiz sysRightBiz) {
		this.sysRightBiz = sysRightBiz;
	}
	public String[] getRightCodes() {
		return rightCodes;
	}
	public void setRightCodes(String[] rightCodes) {
		this.rightCodes = rightCodes;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public ISysRoleRightBiz getSysRoleRightBiz() {
		return sysRoleRightBiz;
	}
	public void setSysRoleRightBiz(ISysRoleRightBiz sysRoleRightBiz) {
		this.sysRoleRightBiz = sysRoleRightBiz;
	}
	public SysRole getSysRole1() {
		return sysRole1;
	}
	public void setSysRole1(SysRole sysRole1) {
		this.sysRole1 = sysRole1;
	}


}
