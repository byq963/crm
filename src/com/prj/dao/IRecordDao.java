package com.prj.dao;

import com.prj.bean.CommunicateRecord;

public interface IRecordDao {
		//��Ӷ���
		public boolean add(CommunicateRecord record);
		//ɾ������
		public boolean delete(CommunicateRecord record);
		//�޸Ķ���
		public boolean update(CommunicateRecord record);
		//ͨ��id���Ҷ���
		public CommunicateRecord get(String commNo);
}
