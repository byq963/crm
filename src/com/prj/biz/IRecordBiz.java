package com.prj.biz;

import com.prj.bean.CommunicateRecord;

public interface IRecordBiz {
	//添加对象
	public boolean add(CommunicateRecord record);
	//删除对象
	public boolean delete(CommunicateRecord record);
	//修改对象
	public boolean update(CommunicateRecord record);
	//通过id查找对象
	public CommunicateRecord find(String commNo);
}
