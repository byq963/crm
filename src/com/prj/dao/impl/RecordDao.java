package com.prj.dao.impl;

import java.util.List;

import com.prj.bean.CommunicateRecord;
import com.prj.dao.IRecordDao;

public class RecordDao extends BaseDao implements IRecordDao {

	public boolean add(CommunicateRecord record) {
		return super.addT(record);
	}

	public boolean delete(CommunicateRecord record) {
		return super.updateT(record);
	}

	public boolean update(CommunicateRecord record) {
		return super.updateT(record);
	}

	public CommunicateRecord get(String commNo) {
		List<CommunicateRecord> recordList=super.getHibernateTemplate().find("from CommunicateRecord where commNo=?", commNo);
		if(recordList.size()>0){
			return recordList.get(0);
		}
		return null;
	}

}
