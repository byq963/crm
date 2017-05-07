package com.prj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.BasicDictionary;
import com.prj.bean.CustCustomer;
import com.prj.bean.ServiceManager;
import com.prj.bean.SysRole;
import com.prj.biz.ICustomerBiz;
import com.prj.biz.IDictionaryBiz;
import com.prj.biz.IServiceManagerBiz;
import com.prj.biz.IUserBiz;
import com.prj.util.PageUtil;
import com.prj.util.ProduceId;
import com.prj.util.StringUtil;

public class ServiceManagerAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private IServiceManagerBiz serviceManagerBiz;
	private IDictionaryBiz dictionaryBiz;
	private ICustomerBiz customerBiz;
	private IUserBiz userBiz;
	private int page;
	private int pagesize;
	private ServiceManager serviceManager;
	private String servNo;
	private String servCustName;
	private String servTitle;
	private Byte servType;
	private String servCreateDate1;
	private String servCreateDate2;
	private Byte servStatus;
	private Byte servFlag;
	private String servDueTo;
	private String servDeal;
	private String servDealName;
	private String servDealDate;
	private String servResult;
	private Byte servSatisfy;
	//进入服务的创建页面
	public String addInput(){
		
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("服务类型");
		request.put("serviceTypeList", serviceTypeList);
		//自动生成id
		request.put("myid", ProduceId.produceString("SE"));
		return "addInput";
	}
	//保存服务
	public String addService(){
		//通过客户名称查到客户对象
		CustCustomer customer=customerBiz.findCustCustomerByName(servCustName);
		serviceManager.setCustCustomer(customer);
		serviceManager.setServFlag((byte) 1);
		serviceManager.setServCustName(servCustName);
		serviceManagerBiz.addServiceManager(serviceManager);
		servCustName=null;
		return addInput();
	}
	//显示所有新创建的服务
	public String showAllCreate(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		if(servType!=null&&servType==3){
			servType=null;
		}
		if(servStatus!=null&&servStatus==0){
			servStatus=null;
		}
		int count=serviceManagerBiz.showAllServiceManager(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 1, (byte) 1).size();
		//显示分页数据
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 1, (byte) 1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//获取客户经理信息
		SysRole s=new SysRole();
		s.setRoleId(4);
		//获取服务类型信息
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("服务类型");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		request.put("userList", userBiz.showUserBySysRole(s));
		return "showAllCreate";
	}
	//删除服务
	public String deleteService(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServFlag((byte) 0);
		serviceManagerBiz.deleteServiceManager(serviceManager);
		return showAllCreate();
	}
	//分配服务
	public String allotService(){
		servDueTo=StringUtil.toUTF(servDueTo);
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServDueTo(servDueTo);
		serviceManager.setServStatus((byte) 2);
		serviceManagerBiz.updateServiceManager(serviceManager);

		return showAllCreate();
	}
	//服务处理
	public String showAllNeadDeal(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		if(servType!=null&&servType==3){
			servType=null;
		}
		if(servStatus!=null&&servStatus==0){
			servStatus=null;
		}
		int count=serviceManagerBiz.showAllServiceManager(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 2, (byte) 1).size();
		//显示分页数据
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 2, (byte) 1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//获取服务类型信息
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("服务类型");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		return "showAllNeadDeal";
	}
	//进入处理页面
	public String dealInput(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		//获取服务类型信息
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("服务类型");
		//获取状态类型信息
		List<BasicDictionary> serviceStatusList=dictionaryBiz.showDictionaryByType("服务状态");
		request.put("serviceTypeList", serviceTypeList);
		request.put("serviceStatusList", serviceStatusList);
		return "dealInput";
	}
	//处理成功
	public String dealSuccess(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServDeal(servDeal);
		serviceManager.setServDealName(servDealName);
		serviceManager.setServDealDate(servDealDate);
		serviceManager.setServStatus((byte) 3);
		serviceManagerBiz.updateServiceManager(serviceManager);
		return showAllNeadDeal();
	}
	//显示所有已经进行处理，需要反馈的页面
	public String feedback(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		if(servType!=null&&servType==3){
			servType=null;
		}
		if(servStatus!=null&&servStatus==0){
			servStatus=null;
		}
		int count=serviceManagerBiz.showAllServiceManager(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 3, (byte) 1).size();
		//显示分页数据
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 3, (byte) 1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//获取服务类型信息
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("服务类型");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		return "feedback";
	}
	//进入反馈结果处理页面
	public String reflectInput(){
		dealInput();
		//获取客户满意度信息
		List<BasicDictionary> satiList=dictionaryBiz.showDictionaryByType("客户满意程度");
		request.put("satiList", satiList);
		return "reflectInput";
	}
	//保存反馈结果成功
	public String reflectSuccess(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServResult(servResult);
		serviceManager.setServSatisfy(servSatisfy);
		serviceManager.setServStatus((byte) 4);
		return feedback();
	}
	//显示已经服务归档的服务
	public String showClassify(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		if(servType!=null&&servType==3){
			servType=null;
		}
		if(servStatus!=null&&servStatus==0){
			servStatus=null;
		}
		int count=serviceManagerBiz.showAllServiceManager(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, servStatus, (byte) 1).size();
		//显示分页数据
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, servStatus, (byte) 1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//获取状态类型信息
		List<BasicDictionary> serviceStatusList=dictionaryBiz.showDictionaryByType("服务状态");
		request.put("serviceStatusList", serviceStatusList);
		//获取服务类型信息
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("服务类型");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		return "showClassify";
	}
	//查看服务信息
	public String checkService(){
		reflectInput();
		return "checkService";
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	public IServiceManagerBiz getServiceManagerBiz() {
		return serviceManagerBiz;
	}
	public void setServiceManagerBiz(IServiceManagerBiz serviceManagerBiz) {
		this.serviceManagerBiz = serviceManagerBiz;
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
	public ServiceManager getServiceManager() {
		return serviceManager;
	}
	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	public String getServNo() {
		return servNo;
	}
	public void setServNo(String servNo) {
		this.servNo = servNo;
	}
	public IDictionaryBiz getDictionaryBiz() {
		return dictionaryBiz;
	}
	public void setDictionaryBiz(IDictionaryBiz dictionaryBiz) {
		this.dictionaryBiz = dictionaryBiz;
	}
	public ICustomerBiz getCustomerBiz() {
		return customerBiz;
	}
	public void setCustomerBiz(ICustomerBiz customerBiz) {
		this.customerBiz = customerBiz;
	}
	public String getServCustName() {
		return servCustName;
	}
	public void setServCustName(String servCustName) {
		this.servCustName = servCustName;
	}
	public String getServTitle() {
		return servTitle;
	}
	public void setServTitle(String servTitle) {
		this.servTitle = servTitle;
	}
	public Byte getServType() {
		return servType;
	}
	public void setServType(Byte servType) {
		this.servType = servType;
	}
	public String getServCreateDate1() {
		return servCreateDate1;
	}
	public void setServCreateDate1(String servCreateDate1) {
		this.servCreateDate1 = servCreateDate1;
	}
	public String getServCreateDate2() {
		return servCreateDate2;
	}
	public void setServCreateDate2(String servCreateDate2) {
		this.servCreateDate2 = servCreateDate2;
	}
	public Byte getServStatus() {
		return servStatus;
	}
	public void setServStatus(Byte servStatus) {
		this.servStatus = servStatus;
	}
	public Byte getServFlag() {
		return servFlag;
	}
	public void setServFlag(Byte servFlag) {
		this.servFlag = servFlag;
	}
	public IUserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String getServDueTo() {
		return servDueTo;
	}
	public void setServDueTo(String servDueTo) {
		this.servDueTo = servDueTo;
	}
	public String getServDeal() {
		return servDeal;
	}
	public void setServDeal(String servDeal) {
		this.servDeal = servDeal;
	}
	public String getServDealName() {
		return servDealName;
	}
	public void setServDealName(String servDealName) {
		this.servDealName = servDealName;
	}
	public String getServDealDate() {
		return servDealDate;
	}
	public void setServDealDate(String servDealDate) {
		this.servDealDate = servDealDate;
	}
	public String getServResult() {
		return servResult;
	}
	public void setServResult(String servResult) {
		this.servResult = servResult;
	}
	public Byte getServSatisfy() {
		return servSatisfy;
	}
	public void setServSatisfy(Byte servSatisfy) {
		this.servSatisfy = servSatisfy;
	}

}
