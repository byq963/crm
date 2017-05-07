package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.Product;
import com.prj.bean.Storage;
import com.prj.biz.IStorageBiz;
import com.prj.dao.IStorageDao;

public class StorageBiz implements IStorageBiz {
	private IStorageDao storageDao;
	public List<Storage> showStorageLike(Product product,
			String storStorehouse, Byte storFlag, int page, int pagesize) {
		return storageDao.queryStorageLike(product, storStorehouse, storFlag, page, pagesize);
	}

	public List<Storage> showAllStorage(Product product, String storStorehouse,
			Byte storFlag) {
		return storageDao.queryAllStorage(product, storStorehouse, storFlag);
	}

	public IStorageDao getStorageDao() {
		return storageDao;
	}

	public void setStorageDao(IStorageDao storageDao) {
		this.storageDao = storageDao;
	}

}
