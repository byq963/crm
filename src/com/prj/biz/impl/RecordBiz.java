package com.prj.biz.impl;

import com.prj.bean.CommunicateRecord;
import com.prj.biz.IRecordBiz;
import com.prj.dao.IRecordDao;

public class RecordBiz implements IRecordBiz {
	private IRecordDao recordDao;
	public boolean add(CommunicateRecord record) {
		return recordDao.add(record);
	}

	public boolean delete(CommunicateRecord record) {
		return recordDao.delete(record);
	}

	public boolean update(CommunicateRecord record) {
		return recordDao.update(record);
	}

	public CommunicateRecord find(String commNo) {
		return recordDao.get(commNo);
	}

	public IRecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(IRecordDao recordDao) {
		this.recordDao = recordDao;
	}

}
