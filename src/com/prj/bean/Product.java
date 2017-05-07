package com.prj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Long prodNo;
	private String prodName;
	private String prodType;
	private String prodGardeBatch;
	private String prodUnit;
	private String prodPrice;
	private String prodRemark;
	private Byte prodFlag;
	private Set ordersLines = new HashSet(0);
	private Set storages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Long prodNo, String prodName, String prodType,
			String prodGardeBatch, String prodUnit, String prodPrice,
			Byte prodFlag) {
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodGardeBatch = prodGardeBatch;
		this.prodUnit = prodUnit;
		this.prodPrice = prodPrice;
		this.prodFlag = prodFlag;
	}

	/** full constructor */
	public Product(Long prodNo, String prodName, String prodType,
			String prodGardeBatch, String prodUnit, String prodPrice,
			String prodRemark, Byte prodFlag, Set ordersLines, Set storages) {
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodGardeBatch = prodGardeBatch;
		this.prodUnit = prodUnit;
		this.prodPrice = prodPrice;
		this.prodRemark = prodRemark;
		this.prodFlag = prodFlag;
		this.ordersLines = ordersLines;
		this.storages = storages;
	}

	// Property accessors

	public Long getProdNo() {
		return this.prodNo;
	}

	public void setProdNo(Long prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return this.prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdGardeBatch() {
		return this.prodGardeBatch;
	}

	public void setProdGardeBatch(String prodGardeBatch) {
		this.prodGardeBatch = prodGardeBatch;
	}

	public String getProdUnit() {
		return this.prodUnit;
	}

	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}

	public String getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdRemark() {
		return this.prodRemark;
	}

	public void setProdRemark(String prodRemark) {
		this.prodRemark = prodRemark;
	}

	public Byte getProdFlag() {
		return this.prodFlag;
	}

	public void setProdFlag(Byte prodFlag) {
		this.prodFlag = prodFlag;
	}

	public Set getOrdersLines() {
		return this.ordersLines;
	}

	public void setOrdersLines(Set ordersLines) {
		this.ordersLines = ordersLines;
	}

	public Set getStorages() {
		return this.storages;
	}

	public void setStorages(Set storages) {
		this.storages = storages;
	}

}