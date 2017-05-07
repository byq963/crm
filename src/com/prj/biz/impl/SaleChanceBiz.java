package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.SaleChance;
import com.prj.biz.ISaleChanceBiz;
import com.prj.dao.ISalChanceDao;

public class SaleChanceBiz implements ISaleChanceBiz {
	private ISalChanceDao salChanceDao;
	public List<SaleChance> showAllByPage(int page, int pagesize) {
		return salChanceDao.queryAllByPage(page, pagesize);
	}
	public List<SaleChance> showAllByFlag(byte chanFlag) {
		return salChanceDao.queryAllByFlag(chanFlag);
	}
	public List<SaleChance> showAllByThree(String chanCustName,
			String chanTitle, String chanLinkman,Byte chanFlag) {
		return salChanceDao.queryAllByThree(chanCustName, chanTitle, chanLinkman, chanFlag);
	}
	public List<SaleChance> showSaleChanceLike(String chanCustName,
			String chanTitle, String chanLinkman,Byte chanFlag, int page, int pagesize) {
		return salChanceDao.querySaleChanceLike(chanCustName, chanTitle, chanLinkman, chanFlag, page, pagesize);
	}
	public SaleChance findSaleChance(long chanNo) {
		return salChanceDao.getSaleChance(chanNo);
	}
	public boolean addChance(SaleChance saleChance) {
		return salChanceDao.addChance(saleChance);
	}
	public boolean updateChance(SaleChance saleChance) {
		return salChanceDao.updateChance(saleChance);
	}
	public boolean deleteChance(SaleChance saleChance) {
		return salChanceDao.deleteChance(saleChance);
	}
	public ISalChanceDao getSalChanceDao() {
		return salChanceDao;
	}

	public void setSalChanceDao(ISalChanceDao salChanceDao) {
		this.salChanceDao = salChanceDao;
	}
	public List<SaleChance> showAllByThree(String chanCustName,
			String chanTitle, String chanLinkman, Byte chanFlag, Byte chanStatus) {
		return salChanceDao.queryAllByThree(chanCustName, chanTitle, chanLinkman, chanFlag, chanStatus);
	}
	public List<SaleChance> showSaleChanceLike(String chanCustName,
			String chanTitle, String chanLinkman, Byte chanFlag,
			Byte chanStatus, int page, int pagesize) {
		return salChanceDao.querySaleChanceLike(chanCustName, chanTitle, chanLinkman, chanFlag, chanStatus, page, pagesize);
	}
	
	
	
}
