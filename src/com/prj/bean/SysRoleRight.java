package com.prj.bean;

/**
 * SysRoleRight entity. @author MyEclipse Persistence Tools
 */

public class SysRoleRight implements java.io.Serializable {

	// Fields

	private Integer rfId;
	private SysRight sysRight;
	private SysRole sysRole;

	// Constructors

	/** default constructor */
	public SysRoleRight() {
	}

	/** minimal constructor */
	public SysRoleRight(Integer rfId) {
		this.rfId = rfId;
	}

	/** full constructor */
	public SysRoleRight(Integer rfId, SysRight sysRight, SysRole sysRole) {
		this.rfId = rfId;
		this.sysRight = sysRight;
		this.sysRole = sysRole;
	}

	// Property accessors

	public Integer getRfId() {
		return this.rfId;
	}

	public void setRfId(Integer rfId) {
		this.rfId = rfId;
	}

	public SysRight getSysRight() {
		return this.sysRight;
	}

	public void setSysRight(SysRight sysRight) {
		this.sysRight = sysRight;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

}