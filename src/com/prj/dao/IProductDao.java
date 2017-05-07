package com.prj.dao;

import java.util.List;

import com.prj.bean.Product;

public interface IProductDao {
	//模糊多条件查询与分页进行结合的方法,可以查询任何数据
	public List<Product> queryProductLike(String prodName,String prodType,String prodGardeBatch,Byte prodFlag,int page,int pagesize);
	//根据相关条件查询所有数据
	public List<Product> queryAllProduct(String prodName,String prodType,String prodGardeBatch,Byte prodFlag);
	public Product queryAllProduct(String custName);
}
