package com.prj.bean;

/**
 * CustLinkman entity. @author MyEclipse Persistence Tools
 */

public class CustLinkman implements java.io.Serializable {

	// Fields

	private String linkNo;
	private CustCustomer custCustomer;
	private String linkName;
	private Byte linkSex;
	private String linkPosition;
	private String linkTelephone;
	private Long linkMobile;
	private String linkRemark;
	private Byte linkFlag;

	// Constructors

	/** default constructor */
	public CustLinkman() {
	}

	/** minimal constructor */
	public CustLinkman(String linkNo, CustCustomer custCustomer,
			String linkName, Byte linkFlag) {
		this.linkNo = linkNo;
		this.custCustomer = custCustomer;
		this.linkName = linkName;
		this.linkFlag = linkFlag;
	}

	/** full constructor */
	public CustLinkman(String linkNo, CustCustomer custCustomer,
			String linkName, Byte linkSex, String linkPosition,
			String linkTelephone, Long linkMobile, String linkRemark,
			Byte linkFlag) {
		this.linkNo = linkNo;
		this.custCustomer = custCustomer;
		this.linkName = linkName;
		this.linkSex = linkSex;
		this.linkPosition = linkPosition;
		this.linkTelephone = linkTelephone;
		this.linkMobile = linkMobile;
		this.linkRemark = linkRemark;
		this.linkFlag = linkFlag;
	}

	// Property accessors

	public String getLinkNo() {
		return this.linkNo;
	}

	public void setLinkNo(String linkNo) {
		this.linkNo = linkNo;
	}

	public CustCustomer getCustCustomer() {
		return this.custCustomer;
	}

	public void setCustCustomer(CustCustomer custCustomer) {
		this.custCustomer = custCustomer;
	}

	public String getLinkName() {
		return this.linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public Byte getLinkSex() {
		return this.linkSex;
	}

	public void setLinkSex(Byte linkSex) {
		this.linkSex = linkSex;
	}

	public String getLinkPosition() {
		return this.linkPosition;
	}

	public void setLinkPosition(String linkPosition) {
		this.linkPosition = linkPosition;
	}

	public String getLinkTelephone() {
		return this.linkTelephone;
	}

	public void setLinkTelephone(String linkTelephone) {
		this.linkTelephone = linkTelephone;
	}

	public Long getLinkMobile() {
		return this.linkMobile;
	}

	public void setLinkMobile(Long linkMobile) {
		this.linkMobile = linkMobile;
	}

	public String getLinkRemark() {
		return this.linkRemark;
	}

	public void setLinkRemark(String linkRemark) {
		this.linkRemark = linkRemark;
	}

	public Byte getLinkFlag() {
		return this.linkFlag;
	}

	public void setLinkFlag(Byte linkFlag) {
		this.linkFlag = linkFlag;
	}

}