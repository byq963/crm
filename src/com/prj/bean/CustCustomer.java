package com.prj.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * CustCustomer entity. @author MyEclipse Persistence Tools
 */

public class CustCustomer implements java.io.Serializable {

	// Fields

	private String custNo;
	private String custName;
	private Byte custRegion;
	private String custManagerName;
	private Byte custLevel;
	private Byte custSatisfy;
	private Byte custCredit;
	private String custAddress;
	private Integer custZip;
	private String custFax;
	private String custTelephone;
	private String custWebsite;
	private String custLicencNo;
	private String custCorporation;
	private String custRegisteredCapital;
	private String custTurnover;
	private String custBank;
	private String custBankAccount;
	private String custLocalTaxNo;
	private String custNationalTaxNo;
	private Byte custFlag;
	private Set communicateRecords = new HashSet(0);
	private Set custLinkmans = new HashSet(0);
	private Set orderses = new HashSet(0);
	private Set custLosts = new HashSet(0);
	private Set serviceManagers = new HashSet(0);

	// Constructors

	/** default constructor */
	public CustCustomer() {
	}

	/** minimal constructor */
	public CustCustomer(String custNo, String custName, String custManagerName,
			Byte custFlag) {
		this.custNo = custNo;
		this.custName = custName;
		this.custManagerName = custManagerName;
		this.custFlag = custFlag;
	}

	/** full constructor */
	public CustCustomer(String custNo, String custName, Byte custRegion,
			String custManagerName, Byte custLevel, Byte custSatisfy,
			Byte custCredit, String custAddress, Integer custZip,
			String custFax, String custTelephone, String custWebsite,
			String custLicencNo, String custCorporation,
			String custRegisteredCapital, String custTurnover, String custBank,
			String custBankAccount, String custLocalTaxNo,
			String custNationalTaxNo, Byte custFlag, Set communicateRecords,
			Set custLinkmans, Set orderses, Set custLosts, Set serviceManagers) {
		this.custNo = custNo;
		this.custName = custName;
		this.custRegion = custRegion;
		this.custManagerName = custManagerName;
		this.custLevel = custLevel;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddress = custAddress;
		this.custZip = custZip;
		this.custFax = custFax;
		this.custTelephone = custTelephone;
		this.custWebsite = custWebsite;
		this.custLicencNo = custLicencNo;
		this.custCorporation = custCorporation;
		this.custRegisteredCapital = custRegisteredCapital;
		this.custTurnover = custTurnover;
		this.custBank = custBank;
		this.custBankAccount = custBankAccount;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custFlag = custFlag;
		this.communicateRecords = communicateRecords;
		this.custLinkmans = custLinkmans;
		this.orderses = orderses;
		this.custLosts = custLosts;
		this.serviceManagers = serviceManagers;
	}

	// Property accessors

	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Byte getCustRegion() {
		return this.custRegion;
	}

	public void setCustRegion(Byte custRegion) {
		this.custRegion = custRegion;
	}

	public String getCustManagerName() {
		return this.custManagerName;
	}

	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}

	public Byte getCustLevel() {
		return this.custLevel;
	}

	public void setCustLevel(Byte custLevel) {
		this.custLevel = custLevel;
	}

	public Byte getCustSatisfy() {
		return this.custSatisfy;
	}

	public void setCustSatisfy(Byte custSatisfy) {
		this.custSatisfy = custSatisfy;
	}

	public Byte getCustCredit() {
		return this.custCredit;
	}

	public void setCustCredit(Byte custCredit) {
		this.custCredit = custCredit;
	}

	public String getCustAddress() {
		return this.custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public Integer getCustZip() {
		return this.custZip;
	}

	public void setCustZip(Integer custZip) {
		this.custZip = custZip;
	}

	public String getCustFax() {
		return this.custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public String getCustTelephone() {
		return this.custTelephone;
	}

	public void setCustTelephone(String custTelephone) {
		this.custTelephone = custTelephone;
	}

	public String getCustWebsite() {
		return this.custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	public String getCustLicencNo() {
		return this.custLicencNo;
	}

	public void setCustLicencNo(String custLicencNo) {
		this.custLicencNo = custLicencNo;
	}

	public String getCustCorporation() {
		return this.custCorporation;
	}

	public void setCustCorporation(String custCorporation) {
		this.custCorporation = custCorporation;
	}

	public String getCustRegisteredCapital() {
		return this.custRegisteredCapital;
	}

	public void setCustRegisteredCapital(String custRegisteredCapital) {
		this.custRegisteredCapital = custRegisteredCapital;
	}

	public String getCustTurnover() {
		return this.custTurnover;
	}

	public void setCustTurnover(String custTurnover) {
		this.custTurnover = custTurnover;
	}

	public String getCustBank() {
		return this.custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	public String getCustBankAccount() {
		return this.custBankAccount;
	}

	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}

	public String getCustLocalTaxNo() {
		return this.custLocalTaxNo;
	}

	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}

	public String getCustNationalTaxNo() {
		return this.custNationalTaxNo;
	}

	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}

	public Byte getCustFlag() {
		return this.custFlag;
	}

	public void setCustFlag(Byte custFlag) {
		this.custFlag = custFlag;
	}

	public Set getCommunicateRecords() {
		return this.communicateRecords;
	}

	public void setCommunicateRecords(Set communicateRecords) {
		this.communicateRecords = communicateRecords;
	}

	public Set getCustLinkmans() {
		return this.custLinkmans;
	}

	public void setCustLinkmans(Set custLinkmans) {
		this.custLinkmans = custLinkmans;
	}

	public Set getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set orderses) {
		this.orderses = orderses;
	}

	public Set getCustLosts() {
		return this.custLosts;
	}

	public void setCustLosts(Set custLosts) {
		this.custLosts = custLosts;
	}

	public Set getServiceManagers() {
		return this.serviceManagers;
	}

	public void setServiceManagers(Set serviceManagers) {
		this.serviceManagers = serviceManagers;
	}

}