package com.prj.biz;

import com.prj.bean.SalePlan;

public interface ISalePlanBiz {
	//������ۼƻ�
		public boolean addPlan(SalePlan salePlan);
		//ɾ�����ۼƻ�
		public boolean deletePlan(SalePlan salePlan);
		//ͨ��id�������ۼƻ�
		public SalePlan findPlan(Long planNo);
		//�޸Ŀ����ƻ�
		public boolean updatePlan(SalePlan salePlan);
}
