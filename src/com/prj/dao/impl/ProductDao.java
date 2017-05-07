package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.Product;
import com.prj.dao.IProductDao;

public class ProductDao extends BaseDao implements IProductDao{

	public List<Product> queryProductLike(String prodName, String prodType,
			String prodGardeBatch, Byte prodFlag, int page,
			int pagesize) {
		StringBuffer str=new StringBuffer("from Product where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(prodName!=null&&!prodName.equals("")){
			str.append("and prodName like :prodName ");
			maps.put("prodName", "%"+prodName+"%");
		}
		if(prodType!=null&&!prodType.equals("")){
			str.append("and prodType like :prodType ");
			maps.put("prodType", "%"+prodType+"%");
		}
		if(prodGardeBatch!=null&&!prodGardeBatch.equals("")){
			str.append("and prodGardeBatch like :prodGardeBatch ");
			maps.put("prodGardeBatch", "%"+prodGardeBatch+"%");
		}
		if(prodFlag!=null&&!prodFlag.equals("")){
			str.append("and prodFlag =:prodFlag ");
			maps.put("prodFlag", prodFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<Product> queryAllProduct(String prodName, String prodType,
			String prodGardeBatch, Byte prodFlag) {
		StringBuffer str=new StringBuffer("from Product where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(prodName!=null&&!prodName.equals("")){
			str.append("and prodName like :prodName ");
			maps.put("prodName", "%"+prodName+"%");
		}
		if(prodType!=null&&!prodType.equals("")){
			str.append("and prodType like :prodType ");
			maps.put("prodType", "%"+prodType+"%");
		}
		if(prodGardeBatch!=null&&!prodGardeBatch.equals("")){
			str.append("and prodGardeBatch like :prodGardeBatch ");
			maps.put("prodGardeBatch", "%"+prodGardeBatch+"%");
		}
		if(prodFlag!=null&&!prodFlag.equals("")){
			str.append("and prodFlag =:prodFlag ");
			maps.put("prodFlag", prodFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public Product queryAllProduct(String prodName) {
		List<Product> productList=super.getHibernateTemplate().find("from Product where 1=1 and prodFlag=1 and prodName=?", prodName);
		if(productList.size()>0){
			return productList.get(0);
		}
		return null;
	}

}
