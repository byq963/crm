package com.prj.dao.impl;

import com.prj.bean.SalePlan;
import com.prj.dao.ISalePlanDao;

public class SalePlanDao extends BaseDao implements ISalePlanDao {

	public boolean addPlan(SalePlan salePlan) {
		return super.addT(salePlan);
	}

	public boolean deletePlan(SalePlan salePlan) {
		return super.updateT(salePlan);
	}

	public SalePlan getPlan(Long planNo) {
		return (SalePlan) super.getT(SalePlan.class, planNo);
	}

	public boolean updatePlan(SalePlan salePlan) {
		return super.updateT(salePlan);
	}

}
