package com.prj.biz;

import java.util.List;

import com.prj.bean.Product;

public interface IProductBiz {
	//模糊多条件查询与分页进行结合的方法,可以查询任何数据
		public List<Product> showProductLike(String prodName,String prodType,String prodGardeBatch,Byte prodFlag,int page,int pagesize);
		//根据相关条件查询所有数据
		public List<Product> showAllProduct(String prodName,String prodType,String prodGardeBatch,Byte prodFlag);
		public Product showAllProduct(String prodName);
}
