package com.prj.biz;

import java.util.List;

import com.prj.bean.SaleChance;

public interface ISaleChanceBiz {
	//通过chanNo获取对象
		public SaleChance findSaleChance(long chanNo);
	//根据客户名称，概要，联系人进行模糊查询
		public List<SaleChance> showAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag);
		//根据销售机会的状态查询并分页
		public List<SaleChance> showAllByPage(int page, int pagesize);
		//查询所有状态为未删除的方法
		public List<SaleChance> showAllByFlag(byte chanFlag);
		//添加salechance的方法
		public boolean addChance(SaleChance saleChance);
		//修改
		public boolean updateChance(SaleChance saleChance);
		//删除
		public boolean deleteChance(SaleChance saleChance);
		//根据客户名称，概要，联系人进行模糊查询，并进行分页
		public List<SaleChance> showSaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,int page,int pagesize);
		public List<SaleChance> showAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus);
		public List<SaleChance> showSaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus,int page,int pagesize);
}
