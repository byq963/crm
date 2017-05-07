package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.CustCustomer;
import com.prj.bean.Product;
import com.prj.dao.ICustomerDao;

public class CustomerDao extends BaseDao implements ICustomerDao {
	
	public boolean add(CustCustomer cust) {
		return super.addT(cust);
	}

	public List<CustCustomer> queryCustCustomerLike(String custNo,
			String custName, Byte custRegion, String custManagerName,
			Byte custLevel, Byte custFlag, int page, int pagesize) {
		StringBuffer str=new StringBuffer("from CustCustomer where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(custNo!=null&&!custNo.equals("")){
			str.append("and custNo like :custNo ");
			maps.put("custNo", "%"+custNo+"%");
		}
		if(custName!=null&&!custName.equals("")){
			str.append("and custName like :custName ");
			maps.put("custName", "%"+custName+"%");
		}
		if(custRegion!=null&&!custRegion.equals("")){
			str.append("and custRegion =:custRegion ");
			maps.put("custRegion", custRegion);
		}
		if(custManagerName!=null&&!custManagerName.equals("")){
			str.append("and custManagerName like :custManagerName ");
			maps.put("custManagerName", "%"+custManagerName+"%");
		}
		if(custLevel!=null&&!custLevel.equals("")){
			str.append("and custLevel =:custLevel ");
			maps.put("custLevel", custLevel);
		}
		if(custFlag!=null&&!custFlag.equals("")){
			str.append("and custFlag =:custFlag ");
			maps.put("custFlag", custFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<CustCustomer> queryAllCustCustomer(String custNo,
			String custName, Byte custRegion, String custManagerName,
			Byte custLevel, Byte custFlag) {
		StringBuffer str=new StringBuffer("from CustCustomer where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(custNo!=null&&!custNo.equals("")){
			str.append("and custNo like :custNo ");
			maps.put("custNo", "%"+custNo+"%");
		}
		if(custName!=null&&!custName.equals("")){
			str.append("and custName like :custName ");
			maps.put("custName", "%"+custName+"%");
		}
		if(custRegion!=null&&!custRegion.equals("")){
			str.append("and custRegion =:custRegion ");
			maps.put("custRegion", custRegion);
		}
		if(custManagerName!=null&&!custManagerName.equals("")){
			str.append("and custManagerName like :custManagerName ");
			maps.put("custManagerName", "%"+custManagerName+"%");
		}
		if(custLevel!=null&&!custLevel.equals("")){
			str.append("and custLevel =:custLevel ");
			maps.put("custLevel", custLevel);
		}
		if(custFlag!=null&&!custFlag.equals("")){
			str.append("and custFlag =:custFlag ");
			maps.put("custFlag", custFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public CustCustomer getCustomer(String custNo) {
		List<CustCustomer> custList=super.getHibernateTemplate().find("from CustCustomer where custNo=?", custNo);
		if(custList.size()>0){
			return custList.get(0);
		}
		return null;
	}

	public boolean update(CustCustomer cust) {
		return super.updateT(cust);
	}

	public CustCustomer getCustCustomerByName(String custName) {
		List<CustCustomer> custList=super.getHibernateTemplate().find("from CustCustomer where 1=1 and custFlag=1 and custName=?", custName);
		if(custList.size()>0){
			return custList.get(0);
		}
		return null;
	}
	
	public List<CustCustomer> queryAllCustCustomer(String custNo,
			String custName, Byte custRegion, String custManagerName,
			Byte custLevel, Byte custSatisfy, Byte custCredit, Byte custFlag) {
		StringBuffer str=new StringBuffer("from CustCustomer where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(custSatisfy!=null&&!custSatisfy.equals("")){
			str.append("and custSatisfy =:custSatisfy ");
			maps.put("custSatisfy", custSatisfy);
		}
		if(custCredit!=null&&!custCredit.equals("")){
			str.append("and custCredit =:custCredit ");
			maps.put("custCredit", custCredit);
		}
		if(custNo!=null&&!custNo.equals("")){
			str.append("and custNo like :custNo ");
			maps.put("custNo", "%"+custNo+"%");
		}
		if(custName!=null&&!custName.equals("")){
			str.append("and custName like :custName ");
			maps.put("custName", "%"+custName+"%");
		}
		if(custRegion!=null&&!custRegion.equals("")){
			str.append("and custRegion =:custRegion ");
			maps.put("custRegion", custRegion);
		}
		if(custManagerName!=null&&!custManagerName.equals("")){
			str.append("and custManagerName like :custManagerName ");
			maps.put("custManagerName", "%"+custManagerName+"%");
		}
		if(custLevel!=null&&!custLevel.equals("")){
			str.append("and custLevel =:custLevel ");
			maps.put("custLevel", custLevel);
		}
		if(custFlag!=null&&!custFlag.equals("")){
			str.append("and custFlag =:custFlag ");
			maps.put("custFlag", custFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

}
