package com.prj.biz.impl;

import com.prj.bean.SalePlan;
import com.prj.biz.ISalePlanBiz;
import com.prj.dao.ISalePlanDao;

public class SalePlanBiz implements ISalePlanBiz {
	private ISalePlanDao salePlanDao;
	public boolean addPlan(SalePlan salePlan) {
		return salePlanDao.addPlan(salePlan);
	}
	public ISalePlanDao getSalePlanDao() {
		return salePlanDao;
	}
	public void setSalePlanDao(ISalePlanDao salePlanDao) {
		this.salePlanDao = salePlanDao;
	}
	public boolean deletePlan(SalePlan salePlan) {
		
		return salePlanDao.deletePlan(salePlan);
	}
	public SalePlan findPlan(Long planNo) {
		return salePlanDao.getPlan(planNo);
	}
	public boolean updatePlan(SalePlan salePlan) {
		return salePlanDao.updatePlan(salePlan);
	}
	

}
