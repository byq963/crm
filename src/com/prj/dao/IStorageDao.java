package com.prj.dao;

import java.util.List;

import com.prj.bean.Product;
import com.prj.bean.Storage;

public interface IStorageDao {
		//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
		public List<Storage> queryStorageLike(Product product,String storStorehouse,Byte storFlag,int page,int pagesize);
		//�������������ѯ��������
		public List<Storage> queryAllStorage(Product product,String storStorehouse,Byte storFlag);
}
