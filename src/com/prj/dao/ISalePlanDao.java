package com.prj.dao;

import com.prj.bean.SalePlan;

public interface ISalePlanDao {
	//添加销售计划
	public boolean addPlan(SalePlan salePlan);
	//删除销售计划
	public boolean deletePlan(SalePlan salePlan);
	//通过id查找销售计划
	public SalePlan getPlan(Long planNo);
	//修改开发计划
	public boolean updatePlan(SalePlan salePlan);
}
