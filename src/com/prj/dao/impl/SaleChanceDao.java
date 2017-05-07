package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.SaleChance;
import com.prj.dao.ISalChanceDao;

public class SaleChanceDao extends BaseDao implements ISalChanceDao {

	public List<SaleChance> queryAllByPage(int page, int pagesize) {
		StringBuffer str=new StringBuffer("from SaleChance where 1=1 and chanFlag=1");
		Map<String,Object> maps=new HashMap<String, Object>();
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<SaleChance> queryAllByFlag(byte chanFlag) {
		return super.getHibernateTemplate().find("from SaleChance where chanFlag=?", chanFlag);
	}

	public boolean addChance(SaleChance saleChance) {
		return super.addT(saleChance);
	}

	public boolean updateChance(SaleChance saleChance) {
		return super.updateT(saleChance);
	}

	public boolean deleteChance(SaleChance saleChance) {
		
		return super.updateT(saleChance);
	}

	public List<SaleChance> querySaleChanceLike(String chanCustName,
			String chanTitle, String chanLinkman,Byte chanFlag ,int page, int pagesize) {
		StringBuffer str=new StringBuffer("from SaleChance where 1=1 and chanFlag=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(chanCustName!=null&&!chanCustName.equals("")){
			str.append("and chanCustName like :custName ");
			maps.put("custName", "%"+chanCustName+"%");
		}
		if(chanTitle!=null&&!chanTitle.equals("")){
			str.append("and chanTitle like :title ");
			maps.put("title", "%"+chanTitle+"%");
		}
		if(chanLinkman!=null&&!chanLinkman.equals("")){
			str.append("and chanLinkman like :linkman ");
			maps.put("linkman", "%"+chanLinkman+"%");
		}
		if(chanFlag!=null&&!chanFlag.equals("")){
			str.append("and chanFlag =:flag ");
			maps.put("flag",chanFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<SaleChance> queryAllByThree(String chanCustName,
			String chanTitle, String chanLinkman,Byte chanFlag) {
		StringBuffer str=new StringBuffer("from SaleChance where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(chanCustName!=null&&!chanCustName.equals("")){
			str.append("and chanCustName like :custName ");
			maps.put("custName", "%"+chanCustName+"%");
		}
		if(chanTitle!=null&&!chanTitle.equals("")){
			str.append("and chanTitle like :title ");
			maps.put("title", "%"+chanTitle+"%");
		}
		if(chanLinkman!=null&&!chanLinkman.equals("")){
			str.append("and chanLinkman like :linkman ");
			maps.put("linkman", "%"+chanLinkman+"%");
		}
		if(chanFlag!=null&&!chanFlag.equals("")){
			str.append("and chanFlag =:flag ");
			maps.put("flag",chanFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public SaleChance getSaleChance(long chanNo) {
		return (SaleChance) super.getT(SaleChance.class, chanNo);
	}

	public List<SaleChance> queryAllByThree(String chanCustName,
			String chanTitle, String chanLinkman, Byte chanFlag, Byte chanStatus) {
		StringBuffer str=new StringBuffer("from SaleChance where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(chanCustName!=null&&!chanCustName.equals("")){
			str.append("and chanCustName like :custName ");
			maps.put("custName", "%"+chanCustName+"%");
		}
		if(chanTitle!=null&&!chanTitle.equals("")){
			str.append("and chanTitle like :title ");
			maps.put("title", "%"+chanTitle+"%");
		}
		if(chanLinkman!=null&&!chanLinkman.equals("")){
			str.append("and chanLinkman like :linkman ");
			maps.put("linkman", "%"+chanLinkman+"%");
		}
		if(chanFlag!=null&&!chanFlag.equals("")){
			str.append("and chanFlag =:flag ");
			maps.put("flag",chanFlag);
		}
		if(chanStatus!=null&&!chanStatus.equals("")){
			str.append("and chanStatus !=:chanStatus ");
			maps.put("chanStatus",chanStatus);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public List<SaleChance> querySaleChanceLike(String chanCustName,
			String chanTitle, String chanLinkman, Byte chanFlag,
			Byte chanStatus, int page, int pagesize) {
		StringBuffer str=new StringBuffer("from SaleChance where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(chanCustName!=null&&!chanCustName.equals("")){
			str.append("and chanCustName like :custName ");
			maps.put("custName", "%"+chanCustName+"%");
		}
		if(chanTitle!=null&&!chanTitle.equals("")){
			str.append("and chanTitle like :title ");
			maps.put("title", "%"+chanTitle+"%");
		}
		if(chanLinkman!=null&&!chanLinkman.equals("")){
			str.append("and chanLinkman like :linkman ");
			maps.put("linkman", "%"+chanLinkman+"%");
		}
		if(chanFlag!=null&&!chanFlag.equals("")){
			str.append("and chanFlag =:flag ");
			maps.put("flag",chanFlag);
		}
		if(chanStatus!=null&&!chanStatus.equals("")){
			str.append("and chanStatus !=:chanStatus ");
			maps.put("chanStatus",chanStatus);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

}
