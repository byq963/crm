package com.prj.biz;

import com.prj.bean.CommunicateRecord;

public interface IRecordBiz {
	//��Ӷ���
	public boolean add(CommunicateRecord record);
	//ɾ������
	public boolean delete(CommunicateRecord record);
	//�޸Ķ���
	public boolean update(CommunicateRecord record);
	//ͨ��id���Ҷ���
	public CommunicateRecord find(String commNo);
}
