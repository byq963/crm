package com.prj.biz;

import java.util.List;

import com.prj.bean.Product;
import com.prj.bean.Storage;

public interface IStorageBiz {
			//模糊多条件查询与分页进行结合的方法,可以查询任何数据
			public List<Storage> showStorageLike(Product product,String storStorehouse,Byte storFlag,int page,int pagesize);
			//根据相关条件查询所有数据
			public List<Storage> showAllStorage(Product product,String storStorehouse,Byte storFlag);
}
