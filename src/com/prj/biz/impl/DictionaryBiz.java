package com.prj.biz.impl;

import java.util.List;

import com.prj.bean.BasicDictionary;
import com.prj.biz.IDictionaryBiz;
import com.prj.dao.IDictionaryDao;

public class DictionaryBiz implements IDictionaryBiz {
	private IDictionaryDao dictionaryDao;
	public List<BasicDictionary> showDictionaryLike(Long basiNo,
			String basiType, String basiItem, String basiValue,
			Byte basiEditable, Byte basiFlag, int page, int pagesize) {
		return dictionaryDao.queryDictionaryLike(basiNo, basiType, basiItem, basiValue, basiEditable, basiFlag, page, pagesize);
	}

	public List<BasicDictionary> showAllDictionary(Long basiNo,
			String basiType, String basiItem, String basiValue,
			Byte basiEditable, Byte basiFlag) {
		return dictionaryDao.queryAllDictionary(basiNo, basiType, basiItem, basiValue, basiEditable, basiFlag);
	}
	public IDictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(IDictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	public boolean addDictionary(BasicDictionary basicDictionary) {
		return dictionaryDao.add(basicDictionary);
	}

	public boolean deleteDictionary(BasicDictionary basicDictionary) {
		return dictionaryDao.delete(basicDictionary);
	}

	public boolean updateDictionary(BasicDictionary basicDictionary) {
		return dictionaryDao.update(basicDictionary);
	}

	public List<BasicDictionary> showDictionaryByType(String basiType) {
		return dictionaryDao.queryDictionaryByType(basiType);
	}

}
