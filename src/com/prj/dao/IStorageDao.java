package com.prj.dao;

import java.util.List;

import com.prj.bean.Product;
import com.prj.bean.Storage;

public interface IStorageDao {
		//模糊多条件查询与分页进行结合的方法,可以查询任何数据
		public List<Storage> queryStorageLike(Product product,String storStorehouse,Byte storFlag,int page,int pagesize);
		//根据相关条件查询所有数据
		public List<Storage> queryAllStorage(Product product,String storStorehouse,Byte storFlag);
}
