package com.prj.dao;

import com.prj.bean.SalePlan;

public interface ISalePlanDao {
	//������ۼƻ�
	public boolean addPlan(SalePlan salePlan);
	//ɾ�����ۼƻ�
	public boolean deletePlan(SalePlan salePlan);
	//ͨ��id�������ۼƻ�
	public SalePlan getPlan(Long planNo);
	//�޸Ŀ����ƻ�
	public boolean updatePlan(SalePlan salePlan);
}
