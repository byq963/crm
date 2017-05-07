package com.prj.dao;

import java.util.List;

import com.prj.bean.Product;

public interface IProductDao {
	//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
	public List<Product> queryProductLike(String prodName,String prodType,String prodGardeBatch,Byte prodFlag,int page,int pagesize);
	//�������������ѯ��������
	public List<Product> queryAllProduct(String prodName,String prodType,String prodGardeBatch,Byte prodFlag);
	public Product queryAllProduct(String custName);
}
