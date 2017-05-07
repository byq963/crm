package com.prj.biz;

import java.util.List;

import com.prj.bean.BasicDictionary;

public interface IDictionaryBiz {
		//根据类型来获取相应的对象
		public List<BasicDictionary> showDictionaryByType(String basiType);
		//添加
		public boolean addDictionary(BasicDictionary basicDictionary);
		//删除
		public boolean deleteDictionary(BasicDictionary basicDictionary);
		//修改
		public boolean updateDictionary(BasicDictionary basicDictionary);
		//模糊多条件查询与分页进行结合的方法,可以查询任何数据
		public List<BasicDictionary> showDictionaryLike(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag,int page,int pagesize);
		//根据相关条件查询所有数据
		public List<BasicDictionary> showAllDictionary(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag);
}
