package com.prj.bean;

/**
 * OrdersLine entity. @author MyEclipse Persistence Tools
 */

public class OrdersLine implements java.io.Serializable {

	// Fields

	private Long lineNo;
	private Product product;
	private Orders orders;
	private Long lineCount;
	private String lineUnit;
	private Byte lineFlag;

	// Constructors

	/** default constructor */
	public OrdersLine() {
	}

	/** full constructor */
	public OrdersLine(Long lineNo, Product product, Orders orders,
			Long lineCount, String lineUnit, Byte lineFlag) {
		this.lineNo = lineNo;
		this.product = product;
		this.orders = orders;
		this.lineCount = lineCount;
		this.lineUnit = lineUnit;
		this.lineFlag = lineFlag;
	}

	// Property accessors

	public Long getLineNo() {
		return this.lineNo;
	}

	public void setLineNo(Long lineNo) {
		this.lineNo = lineNo;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Long getLineCount() {
		return this.lineCount;
	}

	public void setLineCount(Long lineCount) {
		this.lineCount = lineCount;
	}

	public String getLineUnit() {
		return this.lineUnit;
	}

	public void setLineUnit(String lineUnit) {
		this.lineUnit = lineUnit;
	}

	public Byte getLineFlag() {
		return this.lineFlag;
	}

	public void setLineFlag(Byte lineFlag) {
		this.lineFlag = lineFlag;
	}

}