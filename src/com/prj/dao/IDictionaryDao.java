package com.prj.dao;

import java.util.List;

import com.prj.bean.BasicDictionary;

public interface IDictionaryDao {
	//模糊多条件查询与分页进行结合的方法,可以查询任何数据
	public List<BasicDictionary> queryDictionaryLike(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag,int page,int pagesize);
	//根据相关条件查询所有数据
	public List<BasicDictionary> queryAllDictionary(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag);
	//添加
	public boolean add(BasicDictionary basicDictionary);
	//删除
	public boolean delete(BasicDictionary basicDictionary);
	//修改
	public boolean update(BasicDictionary basicDictionary);
	//根据类型来获取相应的对象
	public List<BasicDictionary> queryDictionaryByType(String basiType);
}
