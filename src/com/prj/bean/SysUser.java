package com.prj.bean;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private SysRole sysRole;
	private String userLoginname;
	private String userName;
	private String userPassword;
	private Byte userFlag;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(Integer userId, SysRole sysRole, String userLoginname,
			String userName, String userPassword, Byte userFlag) {
		this.userId = userId;
		this.sysRole = sysRole;
		this.userLoginname = userLoginname;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFlag = userFlag;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getUserLoginname() {
		return this.userLoginname;
	}

	public void setUserLoginname(String userLoginname) {
		this.userLoginname = userLoginname;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Byte getUserFlag() {
		return this.userFlag;
	}

	public void setUserFlag(Byte userFlag) {
		this.userFlag = userFlag;
	}

}