package com.prj.util;

import java.util.Comparator;

import org.apache.poi.hssf.record.formula.functions.T;

import com.prj.bean.SysRoleRight;

public class HwtSorter implements Comparator{

	

	

	public int compare(Object o1, Object o2) {
		SysRoleRight srr1=(SysRoleRight) o1;
		SysRoleRight srr2=(SysRoleRight) o2;
		//°´ÕÕidÅÅĞò
		Integer srr1id=srr1.getRfId();
		Integer srr2id=srr2.getRfId();
		return srr1id>srr2id?1:(srr1id==srr2id?0:-1);
	}

}
