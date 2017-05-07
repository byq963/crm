package com.prj.bean;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */

public class Storage implements java.io.Serializable {

	// Fields

	private Long storNo;
	private Product product;
	private String storStorehouse;
	private String storLocation;
	private Long storCount;
	private String storRemark;
	private Byte storFlag;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** minimal constructor */
	public Storage(Long storNo, Product product, String storStorehouse,
			String storLocation, Long storCount, Byte storFlag) {
		this.storNo = storNo;
		this.product = product;
		this.storStorehouse = storStorehouse;
		this.storLocation = storLocation;
		this.storCount = storCount;
		this.storFlag = storFlag;
	}

	/** full constructor */
	public Storage(Long storNo, Product product, String storStorehouse,
			String storLocation, Long storCount, String storRemark,
			Byte storFlag) {
		this.storNo = storNo;
		this.product = product;
		this.storStorehouse = storStorehouse;
		this.storLocation = storLocation;
		this.storCount = storCount;
		this.storRemark = storRemark;
		this.storFlag = storFlag;
	}

	// Property accessors

	public Long getStorNo() {
		return this.storNo;
	}

	public void setStorNo(Long storNo) {
		this.storNo = storNo;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStorStorehouse() {
		return this.storStorehouse;
	}

	public void setStorStorehouse(String storStorehouse) {
		this.storStorehouse = storStorehouse;
	}

	public String getStorLocation() {
		return this.storLocation;
	}

	public void setStorLocation(String storLocation) {
		this.storLocation = storLocation;
	}

	public Long getStorCount() {
		return this.storCount;
	}

	public void setStorCount(Long storCount) {
		this.storCount = storCount;
	}

	public String getStorRemark() {
		return this.storRemark;
	}

	public void setStorRemark(String storRemark) {
		this.storRemark = storRemark;
	}

	public Byte getStorFlag() {
		return this.storFlag;
	}

	public void setStorFlag(Byte storFlag) {
		this.storFlag = storFlag;
	}

}