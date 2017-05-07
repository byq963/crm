package com.prj.bean;

/**
 * BasicDictionary entity. @author MyEclipse Persistence Tools
 */

public class BasicDictionary implements java.io.Serializable {

	// Fields

	private Long basiNo;
	private String basiType;
	private String basiItem;
	private String basiValue;
	private Byte basiEditable;
	private Byte basiFlag;

	// Constructors

	/** default constructor */
	public BasicDictionary() {
	}

	/** full constructor */
	public BasicDictionary(Long basiNo, String basiType, String basiItem,
			String basiValue, Byte basiEditable, Byte basiFlag) {
		this.basiNo = basiNo;
		this.basiType = basiType;
		this.basiItem = basiItem;
		this.basiValue = basiValue;
		this.basiEditable = basiEditable;
		this.basiFlag = basiFlag;
	}

	// Property accessors

	public Long getBasiNo() {
		return this.basiNo;
	}

	public void setBasiNo(Long basiNo) {
		this.basiNo = basiNo;
	}

	public String getBasiType() {
		return this.basiType;
	}

	public void setBasiType(String basiType) {
		this.basiType = basiType;
	}

	public String getBasiItem() {
		return this.basiItem;
	}

	public void setBasiItem(String basiItem) {
		this.basiItem = basiItem;
	}

	public String getBasiValue() {
		return this.basiValue;
	}

	public void setBasiValue(String basiValue) {
		this.basiValue = basiValue;
	}

	public Byte getBasiEditable() {
		return this.basiEditable;
	}

	public void setBasiEditable(Byte basiEditable) {
		this.basiEditable = basiEditable;
	}

	public Byte getBasiFlag() {
		return this.basiFlag;
	}

	public void setBasiFlag(Byte basiFlag) {
		this.basiFlag = basiFlag;
	}

}