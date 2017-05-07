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
	//定义一个对相关属性初始化的方法,结束的时候调用
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
		//获取查询记录的条数
		int count=saleChanceBiz.showAllByThree(chanCustName, chanTitle, chanLinkman,(byte)1).size();
		System.out.println(count);
		//获取分页的数据
		List<SaleChance> saleChanceList=saleChanceBiz.showSaleChanceLike(chanCustName, chanTitle, chanLinkman, (byte)1, page, pagesize);
		//获取总页数
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
		//获取查询记录的条数
		int count=saleChanceBiz.showAllByThree(chanCustName, chanTitle, chanLinkman, (byte)1, (byte)0).size();
		System.out.println(count);
		//获取分页的数据
		List<SaleChance> saleChanceList=saleChanceBiz.showSaleChanceLike(chanCustName, chanTitle, chanLinkman, (byte)1, (byte)0, page, pagesize);
		System.out.println(saleChanceList.size());
		//获取总页数
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
	//制定计划
	public String makePlanInput(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		request.put("saleChance", saleChance);
		return "makePlanInput";
	}
	//保存执行计划中的结果
	public String saveResult(){
		planResult=StringUtil.toUTF(planResult);
		SalePlan salePlan=salePlanBiz.findPlan(planNo);
		salePlan.setPlanResult(planResult);
		salePlanBiz.updatePlan(salePlan);
		return doPlan();
	}
	//执行计划
	public String doPlan(){
		
		makePlanInput();
		return "doPlan";
	}
	//保存开发计划
	public String savePlan(){
		System.out.println(chanNo);
		SalePlan salePlan=new SalePlan();
		salePlan.setPlanDate(planDate);
		salePlan.setPlanItem(planItem);
		//通过chanNo获取对象
		saleChance=saleChanceBiz.findSaleChance(chanNo);
		salePlan.setSaleChance(saleChance);
		salePlan.setPlanFlag((byte) 1);
		salePlanBiz.addPlan(salePlan);
		return makePlanInput();
	}
	//删除开发计划中的某一项
	public String deletePlan(){
		SalePlan salePlan=salePlanBiz.findPlan(planNo);
		salePlan.setPlanFlag((byte) 0);
		return makePlanInput();
	}
	//修改开发计划中的某一项
	public String updatePlan(){
		System.out.println(planItem);
		SalePlan salePlan=salePlanBiz.findPlan(planNo);
		planItem=StringUtil.toUTF(planItem);
		System.out.println(planItem);
		salePlan.setPlanItem(planItem);
		salePlanBiz.updatePlan(salePlan);
		return makePlanInput();
	}
	//终止开发计划
	public String stopSaleChance(){
		saleChance=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanStatus(chanStatus);
		return showSecond();
	}
	//开发计划执行成功
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
	//开发计划中的查看
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
	//指派进入页面
	public String appointInput(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		request.put("saleChance", saleChance);
		SysRole s=new SysRole();
		s.setRoleId(4);
		request.put("userList", userBiz.showUserBySysRole(s));
		return "appointInput";
	}
	//指派完成
	public String appoint(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanDueTo(chanDueTo);
		saleChance.setChanDueDate(chanDueDate);
		saleChance.setChanStatus((byte)1);
		saleChanceBiz.updateChance(saleChance);
		return showFirst();
	}
	//进入修改页面
	public String updateInput(){
		SaleChance saleChance=saleChanceBiz.findSaleChance(chanNo);
		request.put("saleChance", saleChance);
		return "updateInput";
	}
	//修改完成
	public String update(){
		saleChance.setChanFlag((byte)1);
		SaleChance saleChance1=saleChanceBiz.findSaleChance(chanNo);
		saleChance.setChanStatus(saleChance1.getChanStatus());
		saleChanceBiz.updateChance(saleChance);
		return showFirst();
	}
	//删除
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
