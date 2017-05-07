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
	//������ӽ�ɫҳ��
	public String addRoleInput(){
		
		//��ȡ���е�Ȩ��
		List<SysRight> rightList=sysRightBiz.showAllSysRight();
		request.put("rightList", rightList);
		return "addRoleInput";
	}
	//�����ӽ�ɫ
	public String addRole(){
		System.out.println(sysRole1.getRoleName());
		//�жϽ�ɫ���Ƿ����
		if(sysRoleBiz.showSysRoleByCondition(null, sysRole1.getRoleName(), (byte)1).size()>0){
			request.put("error", "�ý�ɫ���Ѿ�����");
			return addRoleInput();
		}

		sysRole1.setRoleFlag((byte)1);
		sysRoleBiz.addSysRole(sysRole1);
		System.out.println(rightCodes.length);
		for (int i = 0; i < rightCodes.length; i++) {
			String a=rightCodes[i];
			//ͨ��rightCodes��ѯsysright����
			//SysRight sysRight1=sysRightBiz.findSysRightById(a);
			SysRoleRight sysRoleRight1=new SysRoleRight();
			sysRoleRight1.setSysRight(sysRightBiz.findSysRightById(a));
			sysRoleRight1.setSysRole(sysRole1);
			sysRoleRightBiz.add(sysRoleRight1);
		}
		return showRoleFirst();


	}
	//�����޸Ľ�ɫ��ҳ��
	public String updateRoleInput(){
		//��ȡ���е�Ȩ��
		List<SysRight> rightList=sysRightBiz.showAllSysRight();
		//ͨ��id��ȡ��Ӧ��sysrole����
		SysRole sysRole=sysRoleBiz.showSysRoleById(roleId);
		request.put("sysRole", sysRole);
		request.put("rightList", rightList);
		roleId=null;
		return "updateRoleInput";
	}
	//��ɽ�ɫ���޸�
	public String updateSysRole(){
		sysRole1=sysRoleBiz.showSysRoleById(roleId);
		Set<SysRoleRight>  sysRoleRightList=sysRole1.getSysRoleRights();
		for(SysRoleRight sys:sysRoleRightList){
			sysRoleRightBiz.deleteSysRoleRight(sys);
		}
		for (int i = 0; i < rightCodes.length; i++) {
			String a=rightCodes[i];
			//ͨ��rightCodes��ѯsysright����
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
			map.put("msg","��½�ɹ�");
			jo=JSONObject.fromObject(map);
			//�ͻ�����Ľ�ɫ���������sysuser����ļ���
			SysRole sysRole=sysRoleBiz.showSysRoleById(4);
			session.setAttribute("sysUser", sysUser);
			session.setAttribute("sysRole", sysRole);
		}else{
			map.put("msg","��½ʧ��");
			jo=JSONObject.fromObject(map);
		}
		out.print(jo);
		return null;
	}
	//�˳�ϵͳ
	public String exit(){
		ActionContext.getContext().getSession().clear();
		return "exit";
	}
	//�����û��б���ʾ
	public String showUserFirst(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//��ʾ���з������������ݵ�����
		int count=userBiz.showUserByCondition(userId, userName, (byte)1).size();
		System.out.println("userid"+userId);
		System.out.println("username"+userName);
		System.out.println("count"+count);
		//��ҳ��ʾ������
		List<SysUser> userList=userBiz.showUserByPage(userId, userName, (byte)1, page, pagesize);
		System.out.println(userList.size());
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("userList", userList);
		request.put("allpage", allpage);
		return "showUserFirst";
	}
	//ɾ���û�
	public String deleteUser(){
		user=userBiz.findUserById(userId);
		user.setUserFlag((byte) 0);
		userBiz.updateUser(user);
		userId=null;

		return showUserFirst();
	}
	//�����޸�user��ҳ��
	public String updateUserInput(){
		user=userBiz.findUserById(userId);
		//��ȡ���еĽ�ɫ
		List<SysRole> roleList=sysRoleBiz.showSysRoleByCondition(null, null, (byte) 1);
		request.put("roleList", roleList);
		userId=null;
		userName=null;
		return "updateUserInput";
	}
	//��ɶ�user���޸�
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
	//����user�����ҳ��
	public String addUserInput(){
		//��ȡ���еĽ�ɫ
		List<SysRole> roleList=sysRoleBiz.showSysRoleByCondition(null, null, (byte) 1);
		request.put("roleList", roleList);
		return "addUserInput";
	}
	//��ɶ�user�����
	public String addUser(){
		SysRole role=sysRoleBiz.showSysRoleById(roleId);
		user.setSysRole(role);
		user.setUserFlag((byte) 1);
		userBiz.addUser(user);
		userId=null;
		return showUserFirst();
	}
	//�����ɫ�б���ʾ
	public String showRoleFirst(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//��ʾ���з������������ݵ�����
		int count=sysRoleBiz.showSysRoleByCondition(roleId, roleName, (byte)1).size();
		//��ҳ��ʾ������
		List<SysRole> sysRoleList=sysRoleBiz.showSysRoleByPage(roleId, roleName,  (byte)1, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("sysRoleList", sysRoleList);
		request.put("allpage", allpage);
		return "showRoleFirst";
	}
	//ɾ����ɫ
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
