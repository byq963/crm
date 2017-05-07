package com.prj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Long ordeNo;
	private CustCustomer custCustomer;
	private String ordeDate;
	private String ordeAddress;
	private Byte ordeStatus;
	private Byte ordeFlag;
	private Set ordersLines = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Long ordeNo, CustCustomer custCustomer, String ordeDate,
			String ordeAddress, Byte ordeStatus, Byte ordeFlag) {
		this.ordeNo = ordeNo;
		this.custCustomer = custCustomer;
		this.ordeDate = ordeDate;
		this.ordeAddress = ordeAddress;
		this.ordeStatus = ordeStatus;
		this.ordeFlag = ordeFlag;
	}

	/** full constructor */
	public Orders(Long ordeNo, CustCustomer custCustomer, String ordeDate,
			String ordeAddress, Byte ordeStatus, Byte ordeFlag, Set ordersLines) {
		this.ordeNo = ordeNo;
		this.custCustomer = custCustomer;
		this.ordeDate = ordeDate;
		this.ordeAddress = ordeAddress;
		this.ordeStatus = ordeStatus;
		this.ordeFlag = ordeFlag;
		this.ordersLines = ordersLines;
	}

	// Property accessors

	public Long getOrdeNo() {
		return this.ordeNo;
	}

	public void setOrdeNo(Long ordeNo) {
		this.ordeNo = ordeNo;
	}

	public CustCustomer getCustCustomer() {
		return this.custCustomer;
	}

	public void setCustCustomer(CustCustomer custCustomer) {
		this.custCustomer = custCustomer;
	}

	public String getOrdeDate() {
		return this.ordeDate;
	}

	public void setOrdeDate(String ordeDate) {
		this.ordeDate = ordeDate;
	}

	public String getOrdeAddress() {
		return this.ordeAddress;
	}

	public void setOrdeAddress(String ordeAddress) {
		this.ordeAddress = ordeAddress;
	}

	public Byte getOrdeStatus() {
		return this.ordeStatus;
	}

	public void setOrdeStatus(Byte ordeStatus) {
		this.ordeStatus = ordeStatus;
	}

	public Byte getOrdeFlag() {
		return this.ordeFlag;
	}

	public void setOrdeFlag(Byte ordeFlag) {
		this.ordeFlag = ordeFlag;
	}

	public Set getOrdersLines() {
		return this.ordersLines;
	}

	public void setOrdersLines(Set ordersLines) {
		this.ordersLines = ordersLines;
	}

}