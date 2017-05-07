package com.prj.bean;

/**
 * SalePlan entity. @author MyEclipse Persistence Tools
 */

public class SalePlan implements java.io.Serializable {

	// Fields

	private Long planNo;
	private SaleChance saleChance;
	private String planDate;
	private String planItem;
	private String planResult;
	private Byte planFlag;

	// Constructors

	/** default constructor */
	public SalePlan() {
	}

	/** minimal constructor */
	public SalePlan(Long planNo, SaleChance saleChance, String planDate,
			String planItem, Byte planFlag) {
		this.planNo = planNo;
		this.saleChance = saleChance;
		this.planDate = planDate;
		this.planItem = planItem;
		this.planFlag = planFlag;
	}

	/** full constructor */
	public SalePlan(Long planNo, SaleChance saleChance, String planDate,
			String planItem, String planResult, Byte planFlag) {
		this.planNo = planNo;
		this.saleChance = saleChance;
		this.planDate = planDate;
		this.planItem = planItem;
		this.planResult = planResult;
		this.planFlag = planFlag;
	}

	// Property accessors

	public Long getPlanNo() {
		return this.planNo;
	}

	public void setPlanNo(Long planNo) {
		this.planNo = planNo;
	}

	public SaleChance getSaleChance() {
		return this.saleChance;
	}

	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}

	public String getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public String getPlanItem() {
		return this.planItem;
	}

	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}

	public String getPlanResult() {
		return this.planResult;
	}

	public void setPlanResult(String planResult) {
		this.planResult = planResult;
	}

	public Byte getPlanFlag() {
		return this.planFlag;
	}

	public void setPlanFlag(Byte planFlag) {
		this.planFlag = planFlag;
	}

}