package com.prj.dao;

import java.util.List;

import com.prj.bean.SaleChance;

public interface ISalChanceDao {
	//ͨ��chanNo��ȡ����
	public SaleChance getSaleChance(long chanNo);
	//���ݿͻ����ƣ���Ҫ����ϵ�˽���ģ����ѯ
	public List<SaleChance> queryAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag);
	public List<SaleChance> queryAllByThree(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus);
	public List<SaleChance> querySaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,Byte chanStatus,int page,int pagesize);
	//�������ۻ����״̬��ѯ����ҳ
	public List<SaleChance> queryAllByPage(int page, int pagesize);
	//��ѯ����״̬Ϊδɾ���ķ���
	public List<SaleChance> queryAllByFlag(byte chanFlag);
	//���salechance�ķ���
	public boolean addChance(SaleChance saleChance);
	//�޸�
	public boolean updateChance(SaleChance saleChance);
	//ɾ��
	public boolean deleteChance(SaleChance saleChance);
	//���ݿͻ����ƣ���Ҫ����ϵ�˽���ģ����ѯ�������з�ҳ
	public List<SaleChance> querySaleChanceLike(String chanCustName,String chanTitle,String chanLinkman,Byte chanFlag,int page,int pagesize);
	
}
