package com.prj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.Product;
import com.prj.bean.Storage;
import com.prj.biz.IProductBiz;
import com.prj.biz.IStorageBiz;
import com.prj.util.PageUtil;

public class StorageAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private IStorageBiz storageBiz;
	private IProductBiz productBiz;
	private int page;
	private int pagesize;
	private String prodName;
	private String storStorehouse;
	private Byte  storFlag;
	
	
	
	public String showFirst(){
		System.out.println(page);
		if(page==0){
			page=1;
		}
		if(pagesize<=0){
			pagesize=PageUtil.pagesize;
		}
		System.out.println(pagesize);
		Product product=productBiz.showAllProduct(prodName);
		System.out.println(product);
		//显示所有符合条件的数据的条数
		int count=storageBiz.showAllStorage(product, storStorehouse, (byte)1).size();
		//分页显示的数据
		List<Storage> storageList=storageBiz.showStorageLike(product, storStorehouse, (byte)1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("storageList", storageList);
		request.put("allpage", allpage);
	
		return "showFirst";
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	public IStorageBiz getStorageBiz() {
		return storageBiz;
	}
	public void setStorageBiz(IStorageBiz storageBiz) {
		this.storageBiz = storageBiz;
	}
	public IProductBiz getProductBiz() {
		return productBiz;
	}
	public void setProductBiz(IProductBiz productBiz) {
		this.productBiz = productBiz;
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
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getStorStorehouse() {
		return storStorehouse;
	}
	public void setStorStorehouse(String storStorehouse) {
		this.storStorehouse = storStorehouse;
	}
	public Byte getStorFlag() {
		return storFlag;
	}
	public void setStorFlag(Byte storFlag) {
		this.storFlag = storFlag;
	}

}
