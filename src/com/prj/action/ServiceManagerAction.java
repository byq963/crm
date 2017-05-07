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
	//�������Ĵ���ҳ��
	public String addInput(){
		
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("��������");
		request.put("serviceTypeList", serviceTypeList);
		//�Զ�����id
		request.put("myid", ProduceId.produceString("SE"));
		return "addInput";
	}
	//�������
	public String addService(){
		//ͨ���ͻ����Ʋ鵽�ͻ�����
		CustCustomer customer=customerBiz.findCustCustomerByName(servCustName);
		serviceManager.setCustCustomer(customer);
		serviceManager.setServFlag((byte) 1);
		serviceManager.setServCustName(servCustName);
		serviceManagerBiz.addServiceManager(serviceManager);
		servCustName=null;
		return addInput();
	}
	//��ʾ�����´����ķ���
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
		//��ʾ��ҳ����
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 1, (byte) 1, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//��ȡ�ͻ�������Ϣ
		SysRole s=new SysRole();
		s.setRoleId(4);
		//��ȡ����������Ϣ
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("��������");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		request.put("userList", userBiz.showUserBySysRole(s));
		return "showAllCreate";
	}
	//ɾ������
	public String deleteService(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServFlag((byte) 0);
		serviceManagerBiz.deleteServiceManager(serviceManager);
		return showAllCreate();
	}
	//�������
	public String allotService(){
		servDueTo=StringUtil.toUTF(servDueTo);
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServDueTo(servDueTo);
		serviceManager.setServStatus((byte) 2);
		serviceManagerBiz.updateServiceManager(serviceManager);

		return showAllCreate();
	}
	//������
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
		//��ʾ��ҳ����
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 2, (byte) 1, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//��ȡ����������Ϣ
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("��������");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		return "showAllNeadDeal";
	}
	//���봦��ҳ��
	public String dealInput(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		//��ȡ����������Ϣ
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("��������");
		//��ȡ״̬������Ϣ
		List<BasicDictionary> serviceStatusList=dictionaryBiz.showDictionaryByType("����״̬");
		request.put("serviceTypeList", serviceTypeList);
		request.put("serviceStatusList", serviceStatusList);
		return "dealInput";
	}
	//����ɹ�
	public String dealSuccess(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServDeal(servDeal);
		serviceManager.setServDealName(servDealName);
		serviceManager.setServDealDate(servDealDate);
		serviceManager.setServStatus((byte) 3);
		serviceManagerBiz.updateServiceManager(serviceManager);
		return showAllNeadDeal();
	}
	//��ʾ�����Ѿ����д�����Ҫ������ҳ��
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
		//��ʾ��ҳ����
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, (byte) 3, (byte) 1, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//��ȡ����������Ϣ
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("��������");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		return "feedback";
	}
	//���뷴���������ҳ��
	public String reflectInput(){
		dealInput();
		//��ȡ�ͻ��������Ϣ
		List<BasicDictionary> satiList=dictionaryBiz.showDictionaryByType("�ͻ�����̶�");
		request.put("satiList", satiList);
		return "reflectInput";
	}
	//���淴������ɹ�
	public String reflectSuccess(){
		serviceManager=serviceManagerBiz.findServiceManagerById(servNo);
		serviceManager.setServResult(servResult);
		serviceManager.setServSatisfy(servSatisfy);
		serviceManager.setServStatus((byte) 4);
		return feedback();
	}
	//��ʾ�Ѿ�����鵵�ķ���
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
		//��ʾ��ҳ����
		List<ServiceManager> serviceList=serviceManagerBiz.showServiceManagerLike(servCustName, servTitle, servType, servCreateDate1, servCreateDate2, servStatus, (byte) 1, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//��ȡ״̬������Ϣ
		List<BasicDictionary> serviceStatusList=dictionaryBiz.showDictionaryByType("����״̬");
		request.put("serviceStatusList", serviceStatusList);
		//��ȡ����������Ϣ
		List<BasicDictionary> serviceTypeList=dictionaryBiz.showDictionaryByType("��������");
		request.put("count", count);
		request.put("serviceList", serviceList);
		request.put("allpage", allpage);
		request.put("serviceTypeList", serviceTypeList);
		return "showClassify";
	}
	//�鿴������Ϣ
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
