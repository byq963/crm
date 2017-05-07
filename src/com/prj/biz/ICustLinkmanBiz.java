package com.prj.biz;

import com.prj.bean.CustLinkman;

public interface ICustLinkmanBiz {
		//添加对象
		public boolean addLinkman(CustLinkman custLinkman);
		//删除对象
		public boolean deleteLinkman(CustLinkman custLinkman);
		//修改对象
		public boolean updateLinkman(CustLinkman custLinkman);
		//通过id查找对象
		public CustLinkman findLinkman(String linkNo);
}
