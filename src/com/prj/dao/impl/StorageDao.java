package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.Product;
import com.prj.bean.Storage;
import com.prj.dao.IStorageDao;

public class StorageDao extends BaseDao implements IStorageDao {

	public List<Storage> queryStorageLike(Product product,
			String storStorehouse, Byte storFlag, int page, int pagesize) {
		
		StringBuffer str=new StringBuffer("from Storage where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(product!=null&&!product.equals("")){
			str.append("and product like :product ");
			maps.put("product", product);
		}
		if(storStorehouse!=null&&!storStorehouse.equals("")){
			str.append("and storStorehouse like :storStorehouse ");
			maps.put("storStorehouse", "%"+storStorehouse+"%");
		}
		if(storFlag!=null&&!storFlag.equals("")){
			str.append("and storFlag =:storFlag ");
			maps.put("storFlag", storFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<Storage> queryAllStorage(Product product,
			String storStorehouse, Byte storFlag) {
		
		StringBuffer str=new StringBuffer("from Storage where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(product!=null&&!product.equals("")){
			str.append("and product like :product ");
			maps.put("product", product);
		}
		if(storStorehouse!=null&&!storStorehouse.equals("")){
			str.append("and storStorehouse like :storStorehouse ");
			maps.put("storStorehouse", "%"+storStorehouse+"%");
		}
		if(storFlag!=null&&!storFlag.equals("")){
			str.append("and storFlag =:storFlag ");
			maps.put("storFlag", storFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

}
