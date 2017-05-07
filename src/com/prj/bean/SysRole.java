package com.prj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Byte roleFlag;
	private Set sysRoleRights = new HashSet(0);
	private Set sysUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}
	
	public SysRole( String roleName, Byte roleFlag) {
		this.roleName = roleName;
		this.roleFlag = roleFlag;
	}
	
	/** minimal constructor */
	public SysRole(Integer roleId, String roleName, Byte roleFlag) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleFlag = roleFlag;
	}
	
	/** full constructor */
	public SysRole(Integer roleId, String roleName, String roleDesc,
			Byte roleFlag, Set sysRoleRights, Set sysUsers) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.roleFlag = roleFlag;
		this.sysRoleRights = sysRoleRights;
		this.sysUsers = sysUsers;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Byte getRoleFlag() {
		return this.roleFlag;
	}

	public void setRoleFlag(Byte roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Set getSysRoleRights() {
		return this.sysRoleRights;
	}

	public void setSysRoleRights(Set sysRoleRights) {
		this.sysRoleRights = sysRoleRights;
	}

	public Set getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set sysUsers) {
		this.sysUsers = sysUsers;
	}

}