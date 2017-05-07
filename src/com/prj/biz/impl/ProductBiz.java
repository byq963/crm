package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.Product;
import com.prj.biz.IProductBiz;
import com.prj.dao.IProductDao;

public class ProductBiz implements IProductBiz {
	private IProductDao productDao;
	public List<Product> showProductLike(String prodName, String prodType,
			String prodGardeBatch, Byte prodFlag, int page, int pagesize) {
		return productDao.queryProductLike(prodName, prodType, prodGardeBatch, prodFlag, page, pagesize);
	}

	public List<Product> showAllProduct(String prodName, String prodType,
			String prodGardeBatch, Byte prodFlag) {
		return productDao.queryAllProduct(prodName, prodType, prodGardeBatch, prodFlag);
	}

	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}


	public Product showAllProduct(String prodName) {
		return productDao.queryAllProduct(prodName);
	}

}
