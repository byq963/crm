package com.prj.biz;

import java.util.List;

import com.prj.bean.Product;
import com.prj.bean.Storage;

public interface IStorageBiz {
			//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
			public List<Storage> showStorageLike(Product product,String storStorehouse,Byte storFlag,int page,int pagesize);
			//�������������ѯ��������
			public List<Storage> showAllStorage(Product product,String storStorehouse,Byte storFlag);
}
