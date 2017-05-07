package com.prj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prj.bean.SysRight;
import com.prj.bean.SysRole;
import com.prj.bean.SysRoleRight;
import com.prj.biz.IUserBiz;
import com.prj.dao.ISysRightDao;
import com.prj.dao.ISysRoleDao;
import com.prj.dao.ISysRoleRightDao;
import com.prj.dao.IUserDao;

public class Test1 {
public static void main(String[] args) {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	ISysRoleRightDao iub=(ISysRoleRightDao)applicationContext.getBean("sysRoleRightDaoBean");
	ISysRoleDao dfd=(ISysRoleDao)applicationContext.getBean("sysRoleDaoBean");
	ISysRightDao dfdf=(ISysRightDao)applicationContext.getBean("sysRightDaoBean");
	IUserDao wode=(IUserDao)applicationContext.getBean("userDaoBean");
	IUserBiz wode1=(IUserBiz)applicationContext.getBean("userBizBean");
	System.out.println(wode.validateLogin("уеЁЧ", "123"));
	System.out.println(wode1.valUser("уеЁЧ","123"));
	SysRole sysRole=dfd.querySysRoleById(2);
	SysRight sysRight=dfdf.getSysRightById("L0101");
	SysRoleRight sysRoleRight=new SysRoleRight();
	sysRoleRight.setRfId(10000);
	sysRoleRight.setSysRight(sysRight);
	sysRoleRight.setSysRole(sysRole);
	System.out.println(iub.add(sysRoleRight));
}
}
