package com.prj.bean;

/**
 * CommunicateRecord entity. @author MyEclipse Persistence Tools
 */

public class CommunicateRecord implements java.io.Serializable {

	// Fields

	private String commNo;
	private CustCustomer custCustomer;
	private String commDate;
	private String commAddress;
	private String commTitle;
	private String commDetail;
	private String commRemark;
	private Byte commFlag;

	// Constructors

	/** default constructor */
	public CommunicateRecord() {
	}

	/** minimal constructor */
	public CommunicateRecord(String commNo, CustCustomer custCustomer,
			String commDate, String commAddress, String commTitle, Byte commFlag) {
		this.commNo = commNo;
		this.custCustomer = custCustomer;
		this.commDate = commDate;
		this.commAddress = commAddress;
		this.commTitle = commTitle;
		this.commFlag = commFlag;
	}

	/** full constructor */
	public CommunicateRecord(String commNo, CustCustomer custCustomer,
			String commDate, String commAddress, String commTitle,
			String commDetail, String commRemark, Byte commFlag) {
		this.commNo = commNo;
		this.custCustomer = custCustomer;
		this.commDate = commDate;
		this.commAddress = commAddress;
		this.commTitle = commTitle;
		this.commDetail = commDetail;
		this.commRemark = commRemark;
		this.commFlag = commFlag;
	}

	// Property accessors

	public String getCommNo() {
		return this.commNo;
	}

	public void setCommNo(String commNo) {
		this.commNo = commNo;
	}

	public CustCustomer getCustCustomer() {
		return this.custCustomer;
	}

	public void setCustCustomer(CustCustomer custCustomer) {
		this.custCustomer = custCustomer;
	}

	public String getCommDate() {
		return this.commDate;
	}

	public void setCommDate(String commDate) {
		this.commDate = commDate;
	}

	public String getCommAddress() {
		return this.commAddress;
	}

	public void setCommAddress(String commAddress) {
		this.commAddress = commAddress;
	}

	public String getCommTitle() {
		return this.commTitle;
	}

	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}

	public String getCommDetail() {
		return this.commDetail;
	}

	public void setCommDetail(String commDetail) {
		this.commDetail = commDetail;
	}

	public String getCommRemark() {
		return this.commRemark;
	}

	public void setCommRemark(String commRemark) {
		this.commRemark = commRemark;
	}

	public Byte getCommFlag() {
		return this.commFlag;
	}

	public void setCommFlag(Byte commFlag) {
		this.commFlag = commFlag;
	}

}