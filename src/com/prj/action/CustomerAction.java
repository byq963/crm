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
	//用来判断到底是等级还是满意度或信誉度
	private int constitute;
	Map<String,Double> mapContri=new HashMap<String, Double>();
	//定义一个对相关属性初始化的方法,结束的时候调用
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
		//显示所有符合条件的数据的条数
		int count=custBiz.showAllCustCustomer(custNo, custName, custRegion, custManagerName, custLevel, (byte) 1).size();
		//分页显示的数据
		List<CustCustomer> custList=custBiz.showCustCustomerLike(custNo, custName, custRegion, custManagerName, custLevel, (byte) 1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		//获取地区信息
		List<BasicDictionary> regList=dictionaryBiz.showDictionaryByType("地区");
		//获取客户等级信息
		List<BasicDictionary> levList=dictionaryBiz.showDictionaryByType("企业客户等级");
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
	//进入编辑页面
	public String updateInput(){
		//通过id查找相应的客户
		CustCustomer cust=custBiz.findCustomer(custNo);
		request.put("cust", cust);
		//获取地区信息
		List<BasicDictionary> regList=dictionaryBiz.showDictionaryByType("地区");
		//获取客户等级信息
		List<BasicDictionary> levList=dictionaryBiz.showDictionaryByType("企业客户等级");
		//获取客户满意度信息
		List<BasicDictionary> satiList=dictionaryBiz.showDictionaryByType("客户满意程度");
		//客户信誉度
		List<BasicDictionary> conList=dictionaryBiz.showDictionaryByType("客户信誉程度");
		//客户经理的角色，里面包含sysuser对象的集合
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
	//编辑完成，进入首页
	public String updateCust(){
		customer.setCustFlag((byte) 1);
		custBiz.update(customer);
		initialize();
		return showQuery();
	}
	//删除客户
	public String deleteCust(){

		//通过id查找相应的客户
		CustCustomer cust=custBiz.findCustomer(custNo);
		cust.setCustFlag((byte) 0);
		custNo=null;
		return showFirst();

	}
	//查看联系人
	public String checkLinkman(){
		//通过id查找相应的客户
		CustCustomer cust=custBiz.findCustomer(custNo);
		request.put("cust", cust);
		custNo=null;
		return "checkLinkman";
	}
	//删除联系人
	public String deleteLinkman(){
		CustLinkman custLinkman=custLinkmanBiz.findLinkman(linkNo);
		custLinkman.setLinkFlag((byte)0);
		return checkLinkman();
	}
	//编辑联系人,进入编辑页面
	public String updateInputLinkman(){
		CustLinkman custLinkman=custLinkmanBiz.findLinkman(linkNo);
		request.put("custLinkman", custLinkman);
		return "updateInputLinkman";
	}
	//保存编辑好的联系人
	public String saveCustLinkman(){
		//通过id查找相应的客户
		CustCustomer cust=custBiz.findCustomer(custNo);
		custLinkman.setLinkFlag((byte) 1);
		custLinkman.setCustCustomer(cust);
		custLinkmanBiz.updateLinkman(custLinkman);
		return checkLinkman();
	}
	//进入添加联系人页面
	public String addInputLinkman(){
		//自动产生id
		request.put("myid", ProduceId.produceString("CL"));
		return "addInputLinkman";
	}
	//成功添加联系人
	public String addLinkman(){
		System.out.println(custNo);
		System.out.println(custLinkman);
		CustCustomer cust=custBiz.findCustomer(custNo);
		custLinkman.setLinkFlag((byte) 1);
		custLinkman.setCustCustomer(cust);
		custLinkmanBiz.addLinkman(custLinkman);
		return checkLinkman();
	}
	//查看交往记录
	public String checkRecord(){
		checkLinkman();
		return "checkRecord";
	}
	//删除交往记录
	public String deleteRecord(){
		record=recordBiz.find(commNo);
		record.setCommFlag((byte) 0);
		return checkRecord();
	}
	//进入交往记录编辑页面
	public String updateInputRecord(){
		record=recordBiz.find(commNo);
		request.put("record", record);
		return "updateInputRecord";

	}
	//编辑完成进入初始页面，保存成功
	public String saveRecord(){

		CustCustomer cust=custBiz.findCustomer(custNo);
		record.setCommFlag((byte) 1);
		record.setCustCustomer(cust);
		recordBiz.update(record);
		return checkRecord();

	}
	//进入添加页面
	public String addInputrecord(){
		//自动产生id
		request.put("myid", ProduceId.produceString("CR"));
		return "addInputrecord";
	}
	//完成交往记录的添加
	public String addRecord(){
		CustCustomer cust=custBiz.findCustomer(custNo);
		record.setCommFlag((byte) 1);
		record.setCustCustomer(cust);
		recordBiz.add(record);
		return checkRecord();

	}
	//查看历史订单
	public String checkOrders(){
		//通过id查找相应的客户
		CustCustomer cust=custBiz.findCustomer(custNo);
		//获取记录的条数
		int count=cust.getOrderses().size();
		//获取分页的数据
		List<Orders> ordersList=ordersBiz.showOrdersByPage(cust, page, pagesize);

		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("cust", cust);
		request.put("count", count);
		request.put("allpage", allpage);
		request.put("ordersList", ordersList);
		custNo=null;
		return "checkOrders";
	}
	//查看订单明细
	public String checkOrdersLine(){
		System.out.println(ordeNo);
		Orders order=ordersBiz.findOrders(ordeNo);
		//计算每种商品的总金额
		double allMoney=0;//每种商品的总金额
		for(Object ordersLines:order.getOrdersLines()){
			if(ordersLines instanceof OrdersLine){
				OrdersLine orderline=(OrdersLine)ordersLines;
				allMoney=allMoney+(Double.parseDouble(orderline.getProduct().getProdPrice())*(orderline.getLineCount()));
			}

		}
		System.out.println(allMoney);
		//计算所有订单中商品的总金额
		request.put("allMoney", allMoney);
		request.put("order", order);

		return "checkOrdersLine";
	}
	//进入客户贡献分析的首页
	public String contribution(){
		mapContri.clear();
		System.out.println(custName);
		if(ordeDate!=null&&ordeDate.equals("我的天")){
			ordeDate=null;
		}
		//根据客户名称获取客户信息，然后判断其中的订单的年份，将其计算订单总价后保存在map集合中，其中客户名称为key，订单总金额为值
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
	//客户构成分析
	public String constitute(){
		mapContri.clear();
		//获取客户等级信息
		List<BasicDictionary> levList=dictionaryBiz.showDictionaryByType("企业客户等级");
		//获取客户满意度信息
		List<BasicDictionary> satiList=dictionaryBiz.showDictionaryByType("客户满意程度");
		//客户信誉度
		List<BasicDictionary> conList=dictionaryBiz.showDictionaryByType("客户信誉程度");
		//根据客户等级来计算客户分类总数
		if(constitute==0){
			for(BasicDictionary lev:levList){
				List<CustCustomer> custList=custBiz.showAllCustCustomer(null, null, null, null, Byte.parseByte(lev.getBasiValue()), (byte) 1);
				mapContri.put(lev.getBasiItem(), (double) custList.size());
			}
		}

		//通过客户满意度来计算客户分类的总数
		if(constitute==1){
			for(BasicDictionary sati:satiList){
				List<CustCustomer> custList=custBiz.showAllCustCustomer(null, null, null, null, null, Byte.parseByte(sati.getBasiValue()), null, (byte) 1);

				System.out.println(sati.getBasiItem()+"***"+(double) custList.size());
				mapContri.put(sati.getBasiItem(), (double) custList.size());
			}
		}
		if(constitute==2){
			//根据客户的信誉度来计算客户分类的总数
			for(BasicDictionary con:conList){
				List<CustCustomer> custList=custBiz.showAllCustCustomer(null, null, null, null, null, null, Byte.parseByte(con.getBasiValue()), (byte) 1);
				mapContri.put(con.getBasiItem(), (double) custList.size());
			}
		}

		return "constitute";
	}
	//根据服务类型和服务时间获取服务的集合然后获取相应的集合的大小
	public String serviceAnalysis(){
		if(servCreateDate!=null&&servCreateDate.equals("我的天")){
			servCreateDate=null;
		}
		mapContri.clear();
		//获取客户服务类型信息
		List<BasicDictionary> serviceList=dictionaryBiz.showDictionaryByType("服务类型");
		for(BasicDictionary service:serviceList){
			List<ServiceManager> allList=serviceManagerBiz.showAllServiceManager(Byte.parseByte(service.getBasiValue()), servCreateDate, (byte)1);
			mapContri.put(service.getBasiItem(), (double) allList.size());
		}
		return "serviceAnalysis";
	}
	//客户流失分析
	public String lostAnalysis(){
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		//显示所有符合条件的数据
		int count= custLostBiz.showAllCustLost(custName, lostManagerName).size();
		//获取分页显示的数据
		List<CustLost>  custLostList=custLostBiz.showAllCustLostPage(custName, lostManagerName, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("custLostList", custLostList);
		request.put("allpage", allpage);
		return "lostAnalysis";
	}
	//生成客户贡献统计图
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
	//生成客户构成统计图
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
	//生成服务分析统计图
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
	//导出客户贡献分析excel数据
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
	//导出客户构成分析的表格
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
	//导出service的数据表格
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
