package com.prj.biz;

import com.prj.bean.CustLinkman;

public interface ICustLinkmanBiz {
		//��Ӷ���
		public boolean addLinkman(CustLinkman custLinkman);
		//ɾ������
		public boolean deleteLinkman(CustLinkman custLinkman);
		//�޸Ķ���
		public boolean updateLinkman(CustLinkman custLinkman);
		//ͨ��id���Ҷ���
		public CustLinkman findLinkman(String linkNo);
}
