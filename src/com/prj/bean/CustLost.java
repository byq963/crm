package com.prj.bean;

/**
 * CustLost entity. @author MyEclipse Persistence Tools
 */

public class CustLost implements java.io.Serializable {

	// Fields

	private Long lostNo;
	private CustCustomer custCustomer;
	private String lostManagerName;
	private String lostLastOrderDate;
	private String lostLastDate;
	private String lostDelay;
	private String lostReason;
	private Byte lostStatus;

	// Constructors

	/** default constructor */
	public CustLost() {
	}

	/** minimal constructor */
	public CustLost(Long lostNo, CustCustomer custCustomer,
			String lostManagerName, String lostLastOrderDate, Byte lostStatus) {
		this.lostNo = lostNo;
		this.custCustomer = custCustomer;
		this.lostManagerName = lostManagerName;
		this.lostLastOrderDate = lostLastOrderDate;
		this.lostStatus = lostStatus;
	}

	/** full constructor */
	public CustLost(Long lostNo, CustCustomer custCustomer,
			String lostManagerName, String lostLastOrderDate,
			String lostLastDate, String lostDelay, String lostReason,
			Byte lostStatus) {
		this.lostNo = lostNo;
		this.custCustomer = custCustomer;
		this.lostManagerName = lostManagerName;
		this.lostLastOrderDate = lostLastOrderDate;
		this.lostLastDate = lostLastDate;
		this.lostDelay = lostDelay;
		this.lostReason = lostReason;
		this.lostStatus = lostStatus;
	}

	// Property accessors

	public Long getLostNo() {
		return this.lostNo;
	}

	public void setLostNo(Long lostNo) {
		this.lostNo = lostNo;
	}

	public CustCustomer getCustCustomer() {
		return this.custCustomer;
	}

	public void setCustCustomer(CustCustomer custCustomer) {
		this.custCustomer = custCustomer;
	}

	public String getLostManagerName() {
		return this.lostManagerName;
	}

	public void setLostManagerName(String lostManagerName) {
		this.lostManagerName = lostManagerName;
	}

	public String getLostLastOrderDate() {
		return this.lostLastOrderDate;
	}

	public void setLostLastOrderDate(String lostLastOrderDate) {
		this.lostLastOrderDate = lostLastOrderDate;
	}

	public String getLostLastDate() {
		return this.lostLastDate;
	}

	public void setLostLastDate(String lostLastDate) {
		this.lostLastDate = lostLastDate;
	}

	public String getLostDelay() {
		return this.lostDelay;
	}

	public void setLostDelay(String lostDelay) {
		this.lostDelay = lostDelay;
	}

	public String getLostReason() {
		return this.lostReason;
	}

	public void setLostReason(String lostReason) {
		this.lostReason = lostReason;
	}

	public Byte getLostStatus() {
		return this.lostStatus;
	}

	public void setLostStatus(Byte lostStatus) {
		this.lostStatus = lostStatus;
	}

}