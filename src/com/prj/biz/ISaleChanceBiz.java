package com.prj.biz;

import java.util.List;

import com.prj.bean.SaleChance;

public interface ISaleChanceBiz {
	//ͨ��chanNo��ȡ����
		public SaleChance findSaleChance(long chanNo);
	//���ݿͻ����ƣ���Ҫ����ϵ�˽���ģ����ѯ
		public List<SaleChance> showAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag);
		//�������ۻ����״̬��ѯ����ҳ
		public List<SaleChance> showAllByPage(int page, int pagesize);
		//��ѯ����״̬Ϊδɾ���ķ���
		public List<SaleChance> showAllByFlag(byte chanFlag);
		//���salechance�ķ���
		public boolean addChance(SaleChance saleChance);
		//�޸�
		public boolean updateChance(SaleChance saleChance);
		//ɾ��
		public boolean deleteChance(SaleChance saleChance);
		//���ݿͻ����ƣ���Ҫ����ϵ�˽���ģ����ѯ�������з�ҳ
		public List<SaleChance> showSaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,int page,int pagesize);
		public List<SaleChance> showAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus);
		public List<SaleChance> showSaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus,int page,int pagesize);
}
