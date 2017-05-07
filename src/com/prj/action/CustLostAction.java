package com.prj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.BasicDictionary;
import com.prj.bean.CustCustomer;
import com.prj.bean.CustLost;
import com.prj.biz.ICustLostBiz;
import com.prj.biz.ICustomerBiz;
import com.prj.biz.IDictionaryBiz;
import com.prj.util.PageUtil;

public class CustLostAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private ICustLostBiz custLostBiz;
	private IDictionaryBiz dictionaryBiz;
	private ICustomerBiz customerBiz;
	private int page;
	private int pagesize;
	private CustCustomer custCustomer; 
	private String lostManagerName;
	private Byte lostStatus;
	private Long lostNo;
	private CustLost custLost;
	private String lostReason;
	private String lostDelay;
	private String custName;
	public String showFirst(){
		if(lostStatus!=null&&lostStatus==0){
			lostStatus=null;
		}
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//��ʾ���з������������ݵ�����
		int count=custLostBiz.showAllCustLost(custName, lostManagerName, lostStatus).size();
		//��ҳ��ʾ������
		List<CustLost> custLostList=custLostBiz.showCustLostLike(custName, lostManagerName, lostStatus, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//��ȡ�ͻ���ʧ״̬
		List<BasicDictionary> dictionaryList=dictionaryBiz.showDictionaryByType("�ͻ���ʧ״̬");
		request.put("count", count);
		request.put("custLostList", custLostList);
		request.put("allpage", allpage);
		request.put("dictionaryList", dictionaryList);
		return "showFirst";
	}
	public String showQuery(){
		page=PageUtil.page;
		pagesize=PageUtil.pagesize;
		return showFirst();

	}
	//����ȷ����ʧҳ��
	public String confirmInput(){
		custLost=custLostBiz.findCustLost(lostNo);
		request.put("custLost", custLost);
		return "confirmInput";
	}
	//�����ݻ���ʧҳ��
	public String deferInput(){
		confirmInput();
		return "deferInput";
	}
	//����ȷ����ʧ��Ϣ
	public String confirmLost(){
		custLost=custLostBiz.findCustLost(lostNo);
		custLost.setLostReason(lostReason);
		custLost.setLostStatus((byte) 3);
		custLostBiz.updateCustLost(custLost);
		return showFirst();
	}
	//�����ݻ���ʩ����Ϣ
	public String saveDelay(){
		custLost=custLostBiz.findCustLost(lostNo);
		custLost.setLostDelay(lostDelay);
		custLost.setLostStatus((byte) 2);
		custLostBiz.updateCustLost(custLost);
		return showFirst();
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	public ICustLostBiz getCustLostBiz() {
		return custLostBiz;
	}
	public void setCustLostBiz(ICustLostBiz custLostBiz) {
		this.custLostBiz = custLostBiz;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public CustCustomer getCustCustomer() {
		return custCustomer;
	}
	public void setCustCustomer(CustCustomer custCustomer) {
		this.custCustomer = custCustomer;
	}
	public String getLostManagerName() {
		return lostManagerName;
	}
	public void setLostManagerName(String lostManagerName) {
		this.lostManagerName = lostManagerName;
	}
	public Byte getLostStatus() {
		return lostStatus;
	}
	public void setLostStatus(Byte lostStatus) {
		this.lostStatus = lostStatus;
	}
	public IDictionaryBiz getDictionaryBiz() {
		return dictionaryBiz;
	}
	public void setDictionaryBiz(IDictionaryBiz dictionaryBiz) {
		this.dictionaryBiz = dictionaryBiz;
	}
	public Long getLostNo() {
		return lostNo;
	}
	public void setLostNo(Long lostNo) {
		this.lostNo = lostNo;
	}
	public CustLost getCustLost() {
		return custLost;
	}
	public void setCustLost(CustLost custLost) {
		this.custLost = custLost;
	}
	public String getLostReason() {
		return lostReason;
	}
	public void setLostReason(String lostReason) {
		this.lostReason = lostReason;
	}
	public String getLostDelay() {
		return lostDelay;
	}
	public void setLostDelay(String lostDelay) {
		this.lostDelay = lostDelay;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public ICustomerBiz getCustomerBiz() {
		return customerBiz;
	}
	public void setCustomerBiz(ICustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}

}
