package com.prj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.CustCustomer;
import com.prj.bean.SaleChance;
import com.prj.bean.SalePlan;
import com.prj.bean.SysRole;
import com.prj.biz.ICustomerBiz;
import com.prj.biz.ISaleChanceBiz;
import com.prj.biz.ISalePlanBiz;
import com.prj.biz.IUserBiz;
import com.prj.util.PageUtil;
import com.prj.util.StringUtil;

public class SaleChanceAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private ISaleChanceBiz saleChanceBiz;
	private IUserBiz userBiz;
	private ISalePlanBiz salePlanBiz;
	private ICustomerBiz custBiz;
	private String chanCustName;
	private String chanTitle;
	private String chanLinkman;
	private SaleChance saleChance;
	private long chanNo;
	private Long planNo;
	private String planDate;
	private String planItem;
	private String chanDueTo;
	private Byte chanStatus;
	private String planResult;
	private int page;
	private int pagesize;
	private String chanDueDate;
	//����һ����������Գ�ʼ���ķ���,������ʱ�����
	public void initialize(){
		chanCustName=null;
		chanTitle=null;
		chanLinkman=null;
	}
	public String showFirst(){
		if(page==0){
			page=1;
		}
		if(pagesize==0){
			pagesize=PageUtil.pagesize;
		}
		System.out.println(page);
		System.out.println(pagesize);
		//��ȡ��ѯ��¼������
		int count=saleChanceBiz.showAllByThree(chanCustName, chanTitle, chanLinkman,(byte)1).size();
		System.out.println(count);
		//��ȡ��ҳ������
		List<SaleChance> saleChanceList=saleChanceBiz.showSaleChanceLike(chanCustName, chanTitle, chanLinkman, (byte)1, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("saleChanceList", saleChanceList);
		request.put("allpage", allpage);
		return "showFirst";
	}
	public String showQuery(){
		page=PageUtil.page;
		pagesize=PageUtil.pagesize;
		return showFirst();
		
	}
	public String showSecond(){
		if(page==0){
			page=1;
		}
		if(pagesize==0){
			pagesize=PageUtil.pagesize;
		}
		//��ȡ��ѯ��¼������
		int count=saleChanceBiz.showAllByThree(chanCustName, chanTitle, chanLinkman, (byte)1, (byte)0).size();
		System.out.println(count);
		//��ȡ��ҳ������
		List<SaleChance> saleChanceList=saleChanceBiz.showSaleChanceLike(chanCustName, chanTitle, chanLinkman, (byte)1, (byte)0, page, pagesize);
		System.out.println(saleChanceList.size());
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("saleChanceList", saleChanceList);
		request.put("allpage", allpage);
		return "showSecond";
	}
	public String showSecondQuery(){
		page=PageUtil.page;
		pagesize=PageUtil.pagesize;
		return showSecond();
		
		
	}
	//�ƶ��ƻ�
	public String makePlanInput(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		request.put("saleChance", saleChance);
		return "makePlanInput";
	}
	//����ִ�мƻ��еĽ��
	public String saveResult(){
		planResult=StringUtil.toUTF(planResult);
		SalePlan salePlan=salePlanBiz.findPlan(planNo);
		salePlan.setPlanResult(planResult);
		salePlanBiz.updatePlan(salePlan);
		return doPlan();
	}
	//ִ�мƻ�
	public String doPlan(){
		
		makePlanInput();
		return "doPlan";
	}
	//���濪���ƻ�
	public String savePlan(){
		System.out.println(chanNo);
		SalePlan salePlan=new SalePlan();
		salePlan.setPlanDate(planDate);
		salePlan.setPlanItem(planItem);
		//ͨ��chanNo��ȡ����
		saleChance=saleChanceBiz.findSaleChance(chanNo);
		salePlan.setSaleChance(saleChance);
		salePlan.setPlanFlag((byte) 1);
		salePlanBiz.addPlan(salePlan);
		return makePlanInput();
	}
	//ɾ�������ƻ��е�ĳһ��
	public String deletePlan(){
		SalePlan salePlan=salePlanBiz.findPlan(planNo);
		salePlan.setPlanFlag((byte) 0);
		return makePlanInput();
	}
	//�޸Ŀ����ƻ��е�ĳһ��
	public String updatePlan(){
		System.out.println(planItem);
		SalePlan salePlan=salePlanBiz.findPlan(planNo);
		planItem=StringUtil.toUTF(planItem);
		System.out.println(planItem);
		salePlan.setPlanItem(planItem);
		salePlanBiz.updatePlan(salePlan);
		return makePlanInput();
	}
	//��ֹ�����ƻ�
	public String stopSaleChance(){
		saleChance=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanStatus(chanStatus);
		return showSecond();
	}
	//�����ƻ�ִ�гɹ�
	public String sucSaleChance(){
		saleChance=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanStatus(chanStatus);
		CustCustomer cust=new CustCustomer();
		cust.setCustNo(saleChance.getChanNo().toString());
		cust.setCustName(saleChance.getChanCustName());
		cust.setCustManagerName(saleChance.getChanDueTo());
		cust.setCustFlag(saleChance.getChanFlag());
		cust.setCustTelephone(saleChance.getChanTelephone());
		cust.setCustCorporation(saleChance.getChanLinkman());
		custBiz.addCust(cust);
		return showSecond();
	}
	//�����ƻ��еĲ鿴
	public String look(){
		saleChance=saleChanceBiz.findSaleChance(chanNo);
		request.put("saleChance", saleChance);
		return "look";
	}
	public String addChance(){
		saleChance.setChanFlag((byte)1);
		saleChance.setChanStatus((byte)0);
		System.out.println(saleChance.getChanTitle());
		saleChanceBiz.addChance(saleChance);
		System.out.println(page);
		return showFirst();
	}
	//ָ�ɽ���ҳ��
	public String appointInput(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		request.put("saleChance", saleChance);
		SysRole s=new SysRole();
		s.setRoleId(4);
		request.put("userList", userBiz.showUserBySysRole(s));
		return "appointInput";
	}
	//ָ�����
	public String appoint(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanDueTo(chanDueTo);
		saleChance.setChanDueDate(chanDueDate);
		saleChance.setChanStatus((byte)1);
		saleChanceBiz.updateChance(saleChance);
		return showFirst();
	}
	//�����޸�ҳ��
	public String updateInput(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		request.put("saleChance", saleChance);
		return "updateInput";
	}
	//�޸����
	public String update(){
		saleChance.setChanFlag((byte)1);
		SaleChance saleChance1=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanStatus(saleChance1.getChanStatus());
		saleChanceBiz.updateChance(saleChance);
		return showFirst();
	}
	//ɾ��
	public String delete(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanFlag((byte)0);
		saleChanceBiz.updateChance(saleChance);
		return showFirst();
	}
	
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	public ISaleChanceBiz getSaleChanceBiz() {
		return saleChanceBiz;
	}
	public void setSaleChanceBiz(ISaleChanceBiz saleChanceBiz) {
		this.saleChanceBiz = saleChanceBiz;
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
	public String getChanCustName() {
		return chanCustName;
	}
	public void setChanCustName(String chanCustName) {
		this.chanCustName = chanCustName;
	}
	public String getChanTitle() {
		return chanTitle;
	}
	public void setChanTitle(String chanTitle) {
		this.chanTitle = chanTitle;
	}
	public String getChanLinkman() {
		return chanLinkman;
	}
	public void setChanLinkman(String chanLinkman) {
		this.chanLinkman = chanLinkman;
	}
	public SaleChance getSaleChance() {
		return saleChance;
	}
	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}
	public long getChanNo() {
		return chanNo;
	}
	public void setChanNo(long chanNo) {
		this.chanNo = chanNo;
	}
	public IUserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String getChanDueTo() {
		return chanDueTo;
	}
	public void setChanDueTo(String chanDueTo) {
		this.chanDueTo = chanDueTo;
	}
	public Long getPlanNo() {
		return planNo;
	}
	public void setPlanNo(Long planNo) {
		this.planNo = planNo;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public String getPlanItem() {
		return planItem;
	}
	public void setPlanItem(String planItem) {
		this.planItem = planItem;
	}
	public ISalePlanBiz getSalePlanBiz() {
		return salePlanBiz;
	}
	public void setSalePlanBiz(ISalePlanBiz salePlanBiz) {
		this.salePlanBiz = salePlanBiz;
	}

	public Byte getChanStatus() {
		return chanStatus;
	}

	public void setChanStatus(Byte chanStatus) {
		this.chanStatus = chanStatus;
	}

	public ICustomerBiz getCustBiz() {
		return custBiz;
	}

	public void setCustBiz(ICustomerBiz custBiz) {
		this.custBiz = custBiz;
	}

	public String getPlanResult() {
		return planResult;
	}

	public void setPlanResult(String planResult) {
		this.planResult = planResult;
	}
	public String getChanDueDate() {
		return chanDueDate;
	}
	public void setChanDueDate(String chanDueDate) {
		this.chanDueDate = chanDueDate;
	}

}
