package com.prj.dao;

import java.util.List;

import com.prj.bean.SaleChance;

public interface ISalChanceDao {
	//通过chanNo获取对象
	public SaleChance getSaleChance(long chanNo);
	//根据客户名称，概要，联系人进行模糊查询
	public List<SaleChance> queryAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag);
	public List<SaleChance> queryAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus);
	public List<SaleChance> querySaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus,int page,int pagesize);
	//根据销售机会的状态查询并分页
	public List<SaleChance> queryAllByPage(int page, int pagesize);
	//查询所有状态为未删除的方法
	public List<SaleChance> queryAllByFlag(byte chanFlag);
	//添加salechance的方法
	public boolean addChance(SaleChance saleChance);
	//修改
	public boolean updateChance(SaleChance saleChance);
	//删除
	public boolean deleteChance(SaleChance saleChance);
	//根据客户名称，概要，联系人进行模糊查询，并进行分页
	public List<SaleChance> querySaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,int page,int pagesize);
	
}
