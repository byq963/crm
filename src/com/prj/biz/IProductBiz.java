package com.prj.biz;

import java.util.List;

import com.prj.bean.Product;

public interface IProductBiz {
	//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
		public List<Product> showProductLike(String prodName,String prodType,String prodGardeBatch,Byte prodFlag,int page,int pagesize);
		//�������������ѯ��������
		public List<Product> showAllProduct(String prodName,String prodType,String prodGardeBatch,Byte prodFlag);
		public Product showAllProduct(String prodName);
}
