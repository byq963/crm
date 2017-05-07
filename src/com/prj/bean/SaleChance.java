package com.prj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SaleChance entity. @author MyEclipse Persistence Tools
 */

public class SaleChance implements java.io.Serializable {

	// Fields

	private Long chanNo;
	private String chanCustName;
	private String chanSource;
	private Short chanRate;
	private String chanTitle;
	private String chanLinkman;
	private String chanTelephone;
	private Long chanMoblie;
	private String chanDescription;
	private String chanCreateBy;
	private String chanCreateDate;
	private String chanDueTo;
	private String chanDueDate;
	private Byte chanStatus;
	private Byte chanFlag;
	private Set salePlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public SaleChance() {
	}
	/** minimal constructor */
	public SaleChance( String chanSource,String chanCustName, Short chanRate,
			String chanTitle, String chanLinkman,String chanTelephone,String chanDescription, String chanCreateBy,
			String chanCreateDate) {
		
		this.chanSource=chanSource;
		this.chanCustName = chanCustName;
		this.chanRate = chanRate;
		this.chanTitle = chanTitle;
		this.chanLinkman=chanLinkman;
		this.chanTelephone=chanTelephone;
		this.chanDescription = chanDescription;
		this.chanCreateBy = chanCreateBy;
		this.chanCreateDate = chanCreateDate;
		
	}
	
	/** minimal constructor */
	public SaleChance(Long chanNo, String chanCustName, Short chanRate,
			String chanTitle, String chanDescription, String chanCreateBy,
			String chanCreateDate, Byte chanStatus, Byte chanFlag) {
		this.chanNo = chanNo;
		this.chanCustName = chanCustName;
		this.chanRate = chanRate;
		this.chanTitle = chanTitle;
		this.chanDescription = chanDescription;
		this.chanCreateBy = chanCreateBy;
		this.chanCreateDate = chanCreateDate;
		this.chanStatus = chanStatus;
		this.chanFlag = chanFlag;
	}

	/** full constructor */
	public SaleChance(Long chanNo, String chanCustName, String chanSource,
			Short chanRate, String chanTitle, String chanLinkman,
			String chanTelephone, Long chanMoblie, String chanDescription,
			String chanCreateBy, String chanCreateDate, String chanDueTo,
			String chanDueDate, Byte chanStatus, Byte chanFlag, Set salePlans) {
		this.chanNo = chanNo;
		this.chanCustName = chanCustName;
		this.chanSource = chanSource;
		this.chanRate = chanRate;
		this.chanTitle = chanTitle;
		this.chanLinkman = chanLinkman;
		this.chanTelephone = chanTelephone;
		this.chanMoblie = chanMoblie;
		this.chanDescription = chanDescription;
		this.chanCreateBy = chanCreateBy;
		this.chanCreateDate = chanCreateDate;
		this.chanDueTo = chanDueTo;
		this.chanDueDate = chanDueDate;
		this.chanStatus = chanStatus;
		this.chanFlag = chanFlag;
		this.salePlans = salePlans;
	}

	// Property accessors

	public Long getChanNo() {
		return this.chanNo;
	}

	public void setChanNo(Long chanNo) {
		this.chanNo = chanNo;
	}

	public String getChanCustName() {
		return this.chanCustName;
	}

	public void setChanCustName(String chanCustName) {
		this.chanCustName = chanCustName;
	}

	public String getChanSource() {
		return this.chanSource;
	}

	public void setChanSource(String chanSource) {
		this.chanSource = chanSource;
	}

	public Short getChanRate() {
		return this.chanRate;
	}

	public void setChanRate(Short chanRate) {
		this.chanRate = chanRate;
	}

	public String getChanTitle() {
		return this.chanTitle;
	}

	public void setChanTitle(String chanTitle) {
		this.chanTitle = chanTitle;
	}

	public String getChanLinkman() {
		return this.chanLinkman;
	}

	public void setChanLinkman(String chanLinkman) {
		this.chanLinkman = chanLinkman;
	}

	public String getChanTelephone() {
		return this.chanTelephone;
	}

	public void setChanTelephone(String chanTelephone) {
		this.chanTelephone = chanTelephone;
	}

	public Long getChanMoblie() {
		return this.chanMoblie;
	}

	public void setChanMoblie(Long chanMoblie) {
		this.chanMoblie = chanMoblie;
	}

	public String getChanDescription() {
		return this.chanDescription;
	}

	public void setChanDescription(String chanDescription) {
		this.chanDescription = chanDescription;
	}

	public String getChanCreateBy() {
		return this.chanCreateBy;
	}

	public void setChanCreateBy(String chanCreateBy) {
		this.chanCreateBy = chanCreateBy;
	}

	public String getChanCreateDate() {
		return this.chanCreateDate;
	}

	public void setChanCreateDate(String chanCreateDate) {
		this.chanCreateDate = chanCreateDate;
	}

	public String getChanDueTo() {
		return this.chanDueTo;
	}

	public void setChanDueTo(String chanDueTo) {
		this.chanDueTo = chanDueTo;
	}

	public String getChanDueDate() {
		return this.chanDueDate;
	}

	public void setChanDueDate(String chanDueDate) {
		this.chanDueDate = chanDueDate;
	}

	public Byte getChanStatus() {
		return this.chanStatus;
	}

	public void setChanStatus(Byte chanStatus) {
		this.chanStatus = chanStatus;
	}

	public Byte getChanFlag() {
		return this.chanFlag;
	}

	public void setChanFlag(Byte chanFlag) {
		this.chanFlag = chanFlag;
	}

	public Set getSalePlans() {
		return this.salePlans;
	}

	public void setSalePlans(Set salePlans) {
		this.salePlans = salePlans;
	}

}