package com.prj.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prj.bean.BasicDictionary;
import com.prj.dao.IDictionaryDao;

public class DictionaryDao extends BaseDao implements IDictionaryDao {

	public List<BasicDictionary> queryDictionaryLike(Long basiNo,
			String basiType, String basiItem, String basiValue,
			Byte basiEditable, Byte basiFlag, int page, int pagesize) {
		StringBuffer str=new StringBuffer("from BasicDictionary where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(basiNo!=null&&!basiNo.equals("")){
			str.append("and basiNo =:basiNo ");
			maps.put("basiNo", basiNo);
		}
		if(basiType!=null&&!basiType.equals("")){
			str.append("and basiType like :basiType ");
			maps.put("basiType", "%"+basiType+"%");
		}
		if(basiItem!=null&&!basiItem.equals("")){
			str.append("and basiItem like :basiItem ");
			maps.put("basiItem", "%"+basiItem+"%");
		}
		if(basiValue!=null&&!basiValue.equals("")){
			str.append("and basiValue like :basiValue ");
			maps.put("basiValue", "%"+basiValue+"%");
		}
		if(basiEditable!=null&&!basiEditable.equals("")){
			str.append("and basiEditable =:basiEditable ");
			maps.put("basiEditable",basiEditable);
		}
		if(basiFlag!=null&&!basiFlag.equals("")){
			str.append("and basiFlag =:basiFlag ");
			maps.put("basiFlag",basiFlag);
		}
		return super.queryByPage(str.toString(), maps, page, pagesize);
	}

	public List<BasicDictionary> queryAllDictionary(Long basiNo,
			String basiType, String basiItem, String basiValue,
			Byte basiEditable, Byte basiFlag) {
		StringBuffer str=new StringBuffer("from BasicDictionary where 1=1 ");
		Map<String,Object> maps=new HashMap<String, Object>();
		if(basiNo!=null&&!basiNo.equals("")){
			str.append("and basiNo =:basiNo ");
			maps.put("basiNo", basiNo);
		}
		if(basiType!=null&&!basiType.equals("")){
			str.append("and basiType =:basiType ");
			maps.put("basiType", basiType);
		}
		if(basiItem!=null&&!basiItem.equals("")){
			str.append("and basiItem =:basiItem ");
			maps.put("basiItem", basiItem);
		}
		if(basiValue!=null&&!basiValue.equals("")){
			str.append("and basiValue =:basiValue ");
			maps.put("basiValue", basiValue);
		}
		if(basiEditable!=null&&!basiEditable.equals("")){
			str.append("and basiEditable =:basiEditable ");
			maps.put("basiEditable",basiEditable);
		}
		if(basiFlag!=null&&!basiFlag.equals("")){
			str.append("and basiFlag =:basiFlag ");
			maps.put("basiFlag",basiFlag);
		}
		return super.queryByCondition(str.toString(), maps);
	}

	public boolean add(BasicDictionary basicDictionary) {
		return super.addT(basicDictionary);
	}

	public boolean delete(BasicDictionary basicDictionary) {
		return super.updateT(basicDictionary);
	}

	public boolean update(BasicDictionary basicDictionary) {
		return super.updateT(basicDictionary);
	}
	//根据类型来获取相应的字段名称
	public List<BasicDictionary> queryDictionaryByType(String basiType) {
		return super.getHibernateTemplate().find("from BasicDictionary where basiType=?", basiType);
	}

}
