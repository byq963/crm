package com.prj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.BasicDictionary;
import com.prj.bean.CommunicateRecord;
import com.prj.bean.CustCustomer;
import com.prj.bean.CustLinkman;
import com.prj.bean.CustLost;
import com.prj.bean.My;
import com.prj.bean.Orders;
import com.prj.bean.OrdersLine;
import com.prj.bean.ServiceManager;
import com.prj.bean.SysRole;
import com.prj.biz.ICustLinkmanBiz;
import com.prj.biz.ICustLostBiz;
import com.prj.biz.ICustomerBiz;
import com.prj.biz.IDictionaryBiz;
import com.prj.biz.IOrdersBiz;
import com.prj.biz.IRecordBiz;
import com.prj.biz.IServiceManagerBiz;
import com.prj.biz.ISysRoleBiz;
import com.prj.util.PageUtil;
import com.prj.util.PoiUtil;
import com.prj.util.ProduceId;

public class CustomerAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private ICustomerBiz custBiz;
	private IDictionaryBiz dictionaryBiz;
	private ISysRoleBiz sysRoleBiz;
	private ICustLinkmanBiz custLinkmanBiz;
	private IRecordBiz recordBiz;
	private IOrdersBiz ordersBiz;
	private IServiceManagerBiz serviceManagerBiz;
	private ICustLostBiz custLostBiz;
	private int page;
	private int pagesize;
	private String custNo;
	private String custName;
	private Byte custRegion;
	private String custManagerName;
	private Byte custLevel;
	private Byte custFlag;
	private String linkNo;
	private CustCustomer customer;
	private CustLinkman custLinkman;
	private CommunicateRecord record;
	private String commNo;
	private Long ordeNo;
	private String ordeDate;
	private Byte servType;
	private String servCreateDate;
	private String lostManagerName;
	//�����жϵ����ǵȼ���������Ȼ�������
	private int constitute;
	Map<String,Double> mapContri=new HashMap<String, Double>();
	//����һ����������Գ�ʼ���ķ���,������ʱ�����
	public void initialize(){
		custNo=null;
		custName=null;
		custRegion=null;
		custManagerName=null;
		custLevel=null;
	}
	public String showFirst(){
		System.out.println(custRegion);
		if(custRegion!=null&&custRegion==0){
			custRegion=null;
		}
		if(custLevel!=null&&custLevel==0){
			custLevel=null;
		}
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//��ʾ���з������������ݵ�����
		int count=custBiz.showAllCustCustomer(custNo, custName, custRegion, custManagerName, custLevel, (byte) 1).size();
		//��ҳ��ʾ������
		List<CustCustomer> custList=custBiz.showCustCustomerLike(custNo, custName, custRegion, custManagerName, custLevel, (byte) 1, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//��ȡ������Ϣ
		List<BasicDictionary> regList=dictionaryBiz.showDictionaryByType("����");
		//��ȡ�ͻ��ȼ���Ϣ
		List<BasicDictionary> levList=dictionaryBiz.showDictionaryByType("��ҵ�ͻ��ȼ�");
		request.put("regList", regList);
		request.put("levList", levList);
		request.put("count", count);
		request.put("custList", custList);
		request.put("allpage", allpage);
		return "showFirst";
	}
	public String showQuery(){
		page=PageUtil.page;
		pagesize=PageUtil.pagesize;
		return showFirst();

	}
	//����༭ҳ��
	public String updateInput(){
		//ͨ��id������Ӧ�Ŀͻ�
		CustCustomer cust=custBiz.findCustomer(custNo);
		request.put("cust", cust);
		//��ȡ������Ϣ
		List<BasicDictionary> regList=dictionaryBiz.showDictionaryByType("����");
		//��ȡ�ͻ��ȼ���Ϣ
		List<BasicDictionary> levList=dictionaryBiz.showDictionaryByType("��ҵ�ͻ��ȼ�");
		//��ȡ�ͻ��������Ϣ
		List<BasicDictionary> satiList=dictionaryBiz.showDictionaryByType("�ͻ�����̶�");
		//�ͻ�������
		List<BasicDictionary> conList=dictionaryBiz.showDictionaryByType("�ͻ������̶�");
		//�ͻ�����Ľ�ɫ���������sysuser����ļ���
		SysRole sysRole=sysRoleBiz.showSysRoleById(4);
		request.put("cust", cust);
		request.put("satiList", satiList);
		request.put("conList", conList);
		request.put("sysRole", sysRole);

		request.put("regList", regList);
		request.put("levList", levList);
		custNo=null;
		return "updateInput";
	}
	//�༭��ɣ�������ҳ
	public String updateCust(){
		customer.setCustFlag((byte) 1);
		custBiz.update(customer);
		initialize();
		return showQuery();
	}
	//ɾ���ͻ�
	public String deleteCust(){

		//ͨ��id������Ӧ�Ŀͻ�
		CustCustomer cust=custBiz.findCustomer(custNo);
		cust.setCustFlag((byte) 0);
		custNo=null;
		return showFirst();

	}
	//�鿴��ϵ��
	public String checkLinkman(){
		//ͨ��id������Ӧ�Ŀͻ�
		CustCustomer cust=custBiz.findCustomer(custNo);
		request.put("cust", cust);
		custNo=null;
		return "checkLinkman";
	}
	//ɾ����ϵ��
	public String deleteLinkman(){
		CustLinkman custLinkman=custLinkmanBiz.findLinkman(linkNo);
		custLinkman.setLinkFlag((byte)0);
		return checkLinkman();
	}
	//�༭��ϵ��,����༭ҳ��
	public String updateInputLinkman(){
		CustLinkman custLinkman=custLinkmanBiz.findLinkman(linkNo);
		request.put("custLinkman", custLinkman);
		return "updateInputLinkman";
	}
	//����༭�õ���ϵ��
	public String saveCustLinkman(){
		//ͨ��id������Ӧ�Ŀͻ�
		CustCustomer cust=custBiz.findCustomer(custNo);
		custLinkman.setLinkFlag((byte) 1);
		custLinkman.setCustCustomer(cust);
		custLinkmanBiz.updateLinkman(custLinkman);
		return checkLinkman();
	}
	//���������ϵ��ҳ��
	public String addInputLinkman(){
		//�Զ�����id
		request.put("myid", ProduceId.produceString("CL"));
		return "addInputLinkman";
	}
	//�ɹ������ϵ��
	public String addLinkman(){
		System.out.println(custNo);
		System.out.println(custLinkman);
		CustCustomer cust=custBiz.findCustomer(custNo);
		custLinkman.setLinkFlag((byte) 1);
		custLinkman.setCustCustomer(cust);
		custLinkmanBiz.addLinkman(custLinkman);
		return checkLinkman();
	}
	//�鿴������¼
	public String checkRecord(){
		checkLinkman();
		return "checkRecord";
	}
	//ɾ��������¼
	public String deleteRecord(){
		record=recordBiz.find(commNo);
		record.setCommFlag((byte) 0);
		return checkRecord();
	}
	//���뽻����¼�༭ҳ��
	public String updateInputRecord(){
		record=recordBiz.find(commNo);
		request.put("record", record);
		return "updateInputRecord";

	}
	//�༭��ɽ����ʼҳ�棬����ɹ�
	public String saveRecord(){

		CustCustomer cust=custBiz.findCustomer(custNo);
		record.setCommFlag((byte) 1);
		record.setCustCustomer(cust);
		recordBiz.update(record);
		return checkRecord();

	}
	//�������ҳ��
	public String addInputrecord(){
		//�Զ�����id
		request.put("myid", ProduceId.produceString("CR"));
		return "addInputrecord";
	}
	//��ɽ�����¼�����
	public String addRecord(){
		CustCustomer cust=custBiz.findCustomer(custNo);
		record.setCommFlag((byte) 1);
		record.setCustCustomer(cust);
		recordBiz.add(record);
		return checkRecord();

	}
	//�鿴��ʷ����
	public String checkOrders(){
		//ͨ��id������Ӧ�Ŀͻ�
		CustCustomer cust=custBiz.findCustomer(custNo);
		//��ȡ��¼������
		int count=cust.getOrderses().size();
		//��ȡ��ҳ������
		List<Orders> ordersList=ordersBiz.showOrdersByPage(cust, page, pagesize);

		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("cust", cust);
		request.put("count", count);
		request.put("allpage", allpage);
		request.put("ordersList", ordersList);
		custNo=null;
		return "checkOrders";
	}
	//�鿴������ϸ
	public String checkOrdersLine(){
		System.out.println(ordeNo);
		Orders order=ordersBiz.findOrders(ordeNo);
		//����ÿ����Ʒ���ܽ��
		double allMoney=0;//ÿ����Ʒ���ܽ��
		for(Object ordersLines:order.getOrdersLines()){
			if(ordersLines instanceof OrdersLine){
				OrdersLine orderline=(OrdersLine)ordersLines;
				allMoney=allMoney+(Double.parseDouble(orderline.getProduct().getProdPrice())*(orderline.getLineCount()));
			}

		}
		System.out.println(allMoney);
		//�������ж�������Ʒ���ܽ��
		request.put("allMoney", allMoney);
		request.put("order", order);

		return "checkOrdersLine";
	}
	//����ͻ����׷�������ҳ
	public String contribution(){
		mapContri.clear();
		System.out.println(custName);
		if(ordeDate!=null&&ordeDate.equals("�ҵ���")){
			ordeDate=null;
		}
		//���ݿͻ����ƻ�ȡ�ͻ���Ϣ��Ȼ���ж����еĶ�������ݣ�������㶩���ܼۺ󱣴���map�����У����пͻ�����Ϊkey�������ܽ��Ϊֵ
		List<CustCustomer> custList=custBiz.showAllCustCustomer(null, custName, null, null, null, (byte) 1);
		System.out.println(custList.size());

		if(ordeDate==null){
			for(CustCustomer cust1:custList){
				double ordersMoney=0;
				Set<Orders> orderSet=cust1.getOrderses();
				if(orderSet.size()>0){
					for(Orders order:orderSet){
						if(order!=null){
							Set<OrdersLine> orderLineSet=order.getOrdersLines();
							if(orderLineSet.size()>0){
								for(OrdersLine orderLine:orderLineSet){
									if(orderLine!=null){
										ordersMoney=ordersMoney+(orderLine.getLineCount())*Double.parseDouble(orderLine.getProduct().getProdPrice());
									}
								}

							}
						}
					}
					mapContri.put(cust1.getCustName(), ordersMoney);
				}
			}

		}else{
			for(CustCustomer cust1:custList){
				double ordersMoney=0;
				Set<Orders> orderSet=cust1.getOrderses();
				if(orderSet.size()>0){
					for(Orders order:orderSet){
						if(order!=null&&order.getOrdeDate().substring(0,4).equals(ordeDate)){
							Set<OrdersLine> orderLineSet=order.getOrdersLines();
							if(orderLineSet.size()>0){
								for(OrdersLine orderLine:orderLineSet){
									if(orderLine!=null){
										ordersMoney=ordersMoney+(orderLine.getLineCount())*Double.parseDouble(orderLine.getProduct().getProdPrice());
									}
								}
							}

						}
					}
					mapContri.put(cust1.getCustName(), ordersMoney);
				}

			}
		}
		return "contribution";
	}
	//�ͻ����ɷ���
	public String constitute(){
		mapContri.clear();
		//��ȡ�ͻ��ȼ���Ϣ
		List<BasicDictionary> levList=dictionaryBiz.showDictionaryByType("��ҵ�ͻ��ȼ�");
		//��ȡ�ͻ��������Ϣ
		List<BasicDictionary> satiList=dictionaryBiz.showDictionaryByType("�ͻ�����̶�");
		//�ͻ�������
		List<BasicDictionary> conList=dictionaryBiz.showDictionaryByType("�ͻ������̶�");
		//���ݿͻ��ȼ�������ͻ���������
		if(constitute==0){
			for(BasicDictionary lev:levList){
				List<CustCustomer> custList=custBiz.showAllCustCustomer(null, null, null, null, Byte.parseByte(lev.getBasiValue()), (byte) 1);
				mapContri.put(lev.getBasiItem(), (double) custList.size());
			}
		}

		//ͨ���ͻ������������ͻ����������
		if(constitute==1){
			for(BasicDictionary sati:satiList){
				List<CustCustomer> custList=custBiz.showAllCustCustomer(null, null, null, null, null, Byte.parseByte(sati.getBasiValue()), null, (byte) 1);

				System.out.println(sati.getBasiItem()+"***"+(double) custList.size());
				mapContri.put(sati.getBasiItem(), (double) custList.size());
			}
		}
		if(constitute==2){
			//���ݿͻ���������������ͻ����������
			for(BasicDictionary con:conList){
				List<CustCustomer> custList=custBiz.showAllCustCustomer(null, null, null, null, null, null, Byte.parseByte(con.getBasiValue()), (byte) 1);
				mapContri.put(con.getBasiItem(), (double) custList.size());
			}
		}

		return "constitute";
	}
	//���ݷ������ͺͷ���ʱ���ȡ����ļ���Ȼ���ȡ��Ӧ�ļ��ϵĴ�С
	public String serviceAnalysis(){
		if(servCreateDate!=null&&servCreateDate.equals("�ҵ���")){
			servCreateDate=null;
		}
		mapContri.clear();
		//��ȡ�ͻ�����������Ϣ
		List<BasicDictionary> serviceList=dictionaryBiz.showDictionaryByType("��������");
		for(BasicDictionary service:serviceList){
			List<ServiceManager> allList=serviceManagerBiz.showAllServiceManager(Byte.parseByte(service.getBasiValue()), servCreateDate, (byte)1);
			mapContri.put(service.getBasiItem(), (double) allList.size());
		}
		return "serviceAnalysis";
	}
	//�ͻ���ʧ����
	public String lostAnalysis(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//��ʾ���з�������������
		int count= custLostBiz.showAllCustLost(custName, lostManagerName).size();
		//��ȡ��ҳ��ʾ������
		List<CustLost>  custLostList=custLostBiz.showAllCustLostPage(custName, lostManagerName, page, pagesize);
		//��ȡ��ҳ��
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("custLostList", custLostList);
		request.put("allpage", allpage);
		return "lostAnalysis";
	}
	//���ɿͻ�����ͳ��ͼ
	public String statistics(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		contribution();
		List<My> myList=new ArrayList<My>();
		Set<String> set=mapContri.keySet();
		for(String str:set){
			My m=new My();
			m.setName(str);
			m.setNumber(mapContri.get(str));
			myList.add(m);
		}
		JSONArray jarry1=JSONArray.fromObject(myList);
		System.out.println(jarry1);
		out.print(jarry1);
		return null;
	}
	//���ɿͻ�����ͳ��ͼ
	public String statisticsCons(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		constitute();
		List<My> myList=new ArrayList<My>();
		Set<String> set=mapContri.keySet();
		for(String str:set){
			My m=new My();
			m.setName(str);
			m.setNumber(mapContri.get(str));
			myList.add(m);
		}
		JSONArray jarry1=JSONArray.fromObject(myList);
		System.out.println(jarry1);
		out.print(jarry1);
		return null;
	}
	//���ɷ������ͳ��ͼ
	public 	String serviceDraw(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		serviceAnalysis();
		List<My> myList=new ArrayList<My>();
		Set<String> set=mapContri.keySet();
		for(String str:set){
			My m=new My();
			m.setName(str);
			m.setNumber(mapContri.get(str));
			myList.add(m);
		}
		JSONArray jarry1=JSONArray.fromObject(myList);
		System.out.println(jarry1);
		out.print(jarry1);
		return null;
	}
	//�����ͻ����׷���excel����
	public String exportExcel(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		contribution();
		List<My> myList=new ArrayList<My>();
		Set<String> set=mapContri.keySet();
		for(String str:set){
			My m=new My();
			m.setName(str);
			m.setNumber(mapContri.get(str));
			myList.add(m);
		}
		try {
			PoiUtil.exportPoi(myList, "d:/contri.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray jarry1=JSONArray.fromObject(myList);
		System.out.println(jarry1);
		out.print(jarry1);
		return null;
	}
	//�����ͻ����ɷ����ı��
	public String exportConsExcel(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		constitute();
		List<My> myList=new ArrayList<My>();
		Set<String> set=mapContri.keySet();
		for(String str:set){
			My m=new My();
			m.setName(str);
			m.setNumber(mapContri.get(str));
			myList.add(m);
		}
		try {
			PoiUtil.exportPoi(myList, "d:/cons.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray jarry1=JSONArray.fromObject(myList);
		System.out.println(jarry1);
		out.print(jarry1);
		return null;
	}
	//����service�����ݱ��
	public String exportSerExcel(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		serviceAnalysis();
		List<My> myList=new ArrayList<My>();
		Set<String> set=mapContri.keySet();
		for(String str:set){
			My m=new My();
			m.setName(str);
			m.setNumber(mapContri.get(str));
			myList.add(m);
		}
		try {
			PoiUtil.exportPoi(myList, "d:/service.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray jarry1=JSONArray.fromObject(myList);
		System.out.println(jarry1);
		out.print(jarry1);
		return null;
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	public ICustomerBiz getCustBiz() {
		return custBiz;
	}
	public void setCustBiz(ICustomerBiz custBiz) {
		this.custBiz = custBiz;
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
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Byte getCustRegion() {
		return custRegion;
	}
	public void setCustRegion(Byte custRegion) {
		this.custRegion = custRegion;
	}
	public String getCustManagerName() {
		return custManagerName;
	}
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}
	public Byte getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(Byte custLevel) {
		this.custLevel = custLevel;
	}
	public Byte getCustFlag() {
		return custFlag;
	}
	public void setCustFlag(Byte custFlag) {
		this.custFlag = custFlag;
	}
	public IDictionaryBiz getDictionaryBiz() {
		return dictionaryBiz;
	}
	public void setDictionaryBiz(IDictionaryBiz dictionaryBiz) {
		this.dictionaryBiz = dictionaryBiz;
	}
	public ISysRoleBiz getSysRoleBiz() {
		return sysRoleBiz;
	}
	public void setSysRoleBiz(ISysRoleBiz sysRoleBiz) {
		this.sysRoleBiz = sysRoleBiz;
	}
	public String getLinkNo() {
		return linkNo;
	}
	public void setLinkNo(String linkNo) {
		this.linkNo = linkNo;
	}
	public ICustLinkmanBiz getCustLinkmanBiz() {
		return custLinkmanBiz;
	}
	public void setCustLinkmanBiz(ICustLinkmanBiz custLinkmanBiz) {
		this.custLinkmanBiz = custLinkmanBiz;
	}
	public CustLinkman getCustLinkman() {
		return custLinkman;
	}
	public void setCustLinkman(CustLinkman custLinkman) {
		this.custLinkman = custLinkman;
	}
	public CustCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(CustCustomer customer) {
		this.customer = customer;
	}
	public IRecordBiz getRecordBiz() {
		return recordBiz;
	}
	public void setRecordBiz(IRecordBiz recordBiz) {
		this.recordBiz = recordBiz;
	}
	public String getCommNo() {
		return commNo;
	}
	public void setCommNo(String commNo) {
		this.commNo = commNo;
	}
	public CommunicateRecord getRecord() {
		return record;
	}
	public void setRecord(CommunicateRecord record) {
		this.record = record;
	}
	public IOrdersBiz getOrdersBiz() {
		return ordersBiz;
	}
	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
	}
	public Long getOrdeNo() {
		return ordeNo;
	}
	public void setOrdeNo(Long ordeNo) {
		this.ordeNo = ordeNo;
	}
	public String getOrdeDate() {
		return ordeDate;
	}
	public void setOrdeDate(String ordeDate) {
		this.ordeDate = ordeDate;
	}
	public Map<String, Double> getMapContri() {
		return mapContri;
	}
	public void setMapContri(Map<String, Double> mapContri) {
		this.mapContri = mapContri;
	}
	public int getConstitute() {
		return constitute;
	}
	public void setConstitute(int constitute) {
		this.constitute = constitute;
	}
	public IServiceManagerBiz getServiceManagerBiz() {
		return serviceManagerBiz;
	}
	public void setServiceManagerBiz(IServiceManagerBiz serviceManagerBiz) {
		this.serviceManagerBiz = serviceManagerBiz;
	}
	public Byte getServType() {
		return servType;
	}
	public void setServType(Byte servType) {
		this.servType = servType;
	}
	public String getServCreateDate() {
		return servCreateDate;
	}
	public void setServCreateDate(String servCreateDate) {
		this.servCreateDate = servCreateDate;
	}
	public ICustLostBiz getCustLostBiz() {
		return custLostBiz;
	}
	public void setCustLostBiz(ICustLostBiz custLostBiz) {
		this.custLostBiz = custLostBiz;
	}
	public String getLostManagerName() {
		return lostManagerName;
	}
	public void setLostManagerName(String lostManagerName) {
		this.lostManagerName = lostManagerName;
	}


}
