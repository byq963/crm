package com.prj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.Product;
import com.prj.biz.IProductBiz;
import com.prj.util.PageUtil;

public class ProductAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private IProductBiz productBiz;
	private String prodName;
	private String prodType;
	private String prodGardeBatch;
	private Byte prodFlag;
	private int page;
	private int pagesize;
	public String showFirst(){
		System.out.println(page);
		if(page==0){
			page=1;
		}
		if(pagesize==0){
			pagesize=PageUtil.pagesize;
		}
		System.out.println(pagesize);
		//显示所有符合条件的数据的条数
		int count=productBiz.showAllProduct(prodName, prodType, prodGardeBatch,(byte) 1).size();
		//分页显示的数据
		List<Product> productList=productBiz.showProductLike(prodName, prodType, prodGardeBatch, (byte)1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("productList", productList);
		request.put("allpage", allpage);
		return "showFirst";
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
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
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdGardeBatch() {
		return prodGardeBatch;
	}
	public void setProdGardeBatch(String prodGardeBatch) {
		this.prodGardeBatch = prodGardeBatch;
	}
	public Byte getProdFlag() {
		return prodFlag;
	}
	public void setProdFlag(Byte prodFlag) {
		this.prodFlag = prodFlag;
	}
	
}
