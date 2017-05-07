package com.prj.bean;

/**
 * ServiceManager entity. @author MyEclipse Persistence Tools
 */

public class ServiceManager implements java.io.Serializable {

	// Fields

	private String servNo;
	private CustCustomer custCustomer;
	private Byte servType;
	private String servTitle;
	private String servCustName;
	private Byte servStatus;
	private String servRequest;
	private String servCreateBy;
	private String servCreateDate;
	private String servDueTo;
	private String servDueDate;
	private String servDeal;
	private String servDealName;
	private String servDealDate;
	private String servResult;
	private Byte servSatisfy;
	private Byte servFlag;

	// Constructors

	/** default constructor */
	public ServiceManager() {
	}

	/** minimal constructor */
	public ServiceManager(String servNo,
			Byte servType, String servTitle, 
			Byte servStatus, String servRequest, String servCreateBy,
			String servCreateDate) {
		this.servNo = servNo;
		this.servType = servType;
		this.servTitle = servTitle;
		
		this.servStatus = servStatus;
		this.servRequest = servRequest;
		this.servCreateBy = servCreateBy;
		this.servCreateDate = servCreateDate;
	}
	/** minimal constructor */
	public ServiceManager(String servNo, CustCustomer custCustomer,
			Byte servType, String servTitle, String servCustName,
			Byte servStatus, String servRequest, String servCreateBy,
			String servCreateDate, Byte servFlag) {
		this.servNo = servNo;
		this.custCustomer = custCustomer;
		this.servType = servType;
		this.servTitle = servTitle;
		this.servCustName = servCustName;
		this.servStatus = servStatus;
		this.servRequest = servRequest;
		this.servCreateBy = servCreateBy;
		this.servCreateDate = servCreateDate;
		this.servFlag = servFlag;
	}

	/** full constructor */
	public ServiceManager(String servNo, CustCustomer custCustomer,
			Byte servType, String servTitle, String servCustName,
			Byte servStatus, String servRequest, String servCreateBy,
			String servCreateDate, String servDueTo, String servDueDate,
			String servDeal, String servDealName, String servDealDate,
			String servResult, Byte servSatisfy, Byte servFlag) {
		this.servNo = servNo;
		this.custCustomer = custCustomer;
		this.servType = servType;
		this.servTitle = servTitle;
		this.servCustName = servCustName;
		this.servStatus = servStatus;
		this.servRequest = servRequest;
		this.servCreateBy = servCreateBy;
		this.servCreateDate = servCreateDate;
		this.servDueTo = servDueTo;
		this.servDueDate = servDueDate;
		this.servDeal = servDeal;
		this.servDealName = servDealName;
		this.servDealDate = servDealDate;
		this.servResult = servResult;
		this.servSatisfy = servSatisfy;
		this.servFlag = servFlag;
	}

	// Property accessors

	public String getServNo() {
		return this.servNo;
	}

	public void setServNo(String servNo) {
		this.servNo = servNo;
	}

	public CustCustomer getCustCustomer() {
		return this.custCustomer;
	}

	public void setCustCustomer(CustCustomer custCustomer) {
		this.custCustomer = custCustomer;
	}

	public Byte getServType() {
		return this.servType;
	}

	public void setServType(Byte servType) {
		this.servType = servType;
	}

	public String getServTitle() {
		return this.servTitle;
	}

	public void setServTitle(String servTitle) {
		this.servTitle = servTitle;
	}

	public String getServCustName() {
		return this.servCustName;
	}

	public void setServCustName(String servCustName) {
		this.servCustName = servCustName;
	}

	public Byte getServStatus() {
		return this.servStatus;
	}

	public void setServStatus(Byte servStatus) {
		this.servStatus = servStatus;
	}

	public String getServRequest() {
		return this.servRequest;
	}

	public void setServRequest(String servRequest) {
		this.servRequest = servRequest;
	}

	public String getServCreateBy() {
		return this.servCreateBy;
	}

	public void setServCreateBy(String servCreateBy) {
		this.servCreateBy = servCreateBy;
	}

	public String getServCreateDate() {
		return this.servCreateDate;
	}

	public void setServCreateDate(String servCreateDate) {
		this.servCreateDate = servCreateDate;
	}

	public String getServDueTo() {
		return this.servDueTo;
	}

	public void setServDueTo(String servDueTo) {
		this.servDueTo = servDueTo;
	}

	public String getServDueDate() {
		return this.servDueDate;
	}

	public void setServDueDate(String servDueDate) {
		this.servDueDate = servDueDate;
	}

	public String getServDeal() {
		return this.servDeal;
	}

	public void setServDeal(String servDeal) {
		this.servDeal = servDeal;
	}

	public String getServDealName() {
		return this.servDealName;
	}

	public void setServDealName(String servDealName) {
		this.servDealName = servDealName;
	}

	public String getServDealDate() {
		return this.servDealDate;
	}

	public void setServDealDate(String servDealDate) {
		this.servDealDate = servDealDate;
	}

	public String getServResult() {
		return this.servResult;
	}

	public void setServResult(String servResult) {
		this.servResult = servResult;
	}

	public Byte getServSatisfy() {
		return this.servSatisfy;
	}

	public void setServSatisfy(Byte servSatisfy) {
		this.servSatisfy = servSatisfy;
	}

	public Byte getServFlag() {
		return this.servFlag;
	}

	public void setServFlag(Byte servFlag) {
		this.servFlag = servFlag;
	}

}