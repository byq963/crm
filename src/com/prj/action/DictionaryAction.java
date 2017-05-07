package com.prj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.prj.bean.BasicDictionary;
import com.prj.biz.IDictionaryBiz;
import com.prj.util.PageUtil;

public class DictionaryAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private Long basiNo;
	private String basiType;
	private String basiItem;
	private String basiValue;
	private Byte basiEditable;
	private Byte basiFlag;
	private int page;
	private int pagesize;
	private IDictionaryBiz dictionaryBiz;
	private BasicDictionary dictionary;
	public void initialize(){
		basiType=null;
		basiItem=null;
		basiValue=null;
	}
	public String showFirst(){
		System.out.println(page);
		if(page==0){
			page=1;
		}
		if(pagesize==0){
			pagesize=PageUtil.pagesize;
		}
		//显示所有符合条件的数据的条数
		int count=dictionaryBiz.showAllDictionary(basiNo, basiType, basiItem, basiValue, basiEditable, (byte)1).size();
		//分页显示的数据
		List<BasicDictionary> dictionaryList=dictionaryBiz.showDictionaryLike(basiNo, basiType, basiItem, basiValue, basiEditable, (byte)1, page, pagesize);
		//获取总页数
		int allpage=count%pagesize==0?count/pagesize:count/pagesize+1;
		request.put("count", count);
		request.put("dictionaryList", dictionaryList);
		request.put("allpage", allpage);
		return "showFirst";
	}
	public String showQuery(){
		page=PageUtil.page;
		pagesize=PageUtil.pagesize;
		return showFirst();
		
	}
	//删除
	public String delete(){
		dictionary=dictionaryBiz.showAllDictionary(basiNo, null, null, null, null, (byte)1).get(0);
		dictionary.setBasiFlag((byte)0);
		dictionaryBiz.deleteDictionary(dictionary);
		basiNo=null;
		return showFirst();
	}
	//进入添加页面
	public String addDictionaryInput(){
		return "addDictionaryInput";
	}
	//完成字典的添加
	public String addDictionary(){
		dictionary.setBasiFlag((byte) 1);
		dictionaryBiz.addDictionary(dictionary);
		return showFirst();
	}
	//进入字典的编辑页面
	public String updateInput(){
		dictionary=dictionaryBiz.showAllDictionary(basiNo, null, null, null, null, (byte)1).get(0);
		return "updateInput";
	}
	//完成字典的修改
	public String updateDictionary(){
		dictionary.setBasiFlag((byte) 1);
		dictionaryBiz.updateDictionary(dictionary);
		return showFirst();
	}
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	public Long getBasiNo() {
		return basiNo;
	}
	public void setBasiNo(Long basiNo) {
		this.basiNo = basiNo;
	}
	public String getBasiType() {
		return basiType;
	}
	public void setBasiType(String basiType) {
		this.basiType = basiType;
	}
	public String getBasiItem() {
		return basiItem;
	}
	public void setBasiItem(String basiItem) {
		this.basiItem = basiItem;
	}
	public String getBasiValue() {
		return basiValue;
	}
	public void setBasiValue(String basiValue) {
		this.basiValue = basiValue;
	}
	public Byte getBasiEditable() {
		return basiEditable;
	}
	public void setBasiEditable(Byte basiEditable) {
		this.basiEditable = basiEditable;
	}
	public Byte getBasiFlag() {
		return basiFlag;
	}
	public void setBasiFlag(Byte basiFlag) {
		this.basiFlag = basiFlag;
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
	public IDictionaryBiz getDictionaryBiz() {
		return dictionaryBiz;
	}
	public void setDictionaryBiz(IDictionaryBiz dictionaryBiz) {
		this.dictionaryBiz = dictionaryBiz;
	}
	public BasicDictionary getDictionary() {
		return dictionary;
	}
	public void setDictionary(BasicDictionary dictionary) {
		this.dictionary = dictionary;
	}

}
