package com.prj.biz;

import java.util.List;

import com.prj.bean.BasicDictionary;

public interface IDictionaryBiz {
		//������������ȡ��Ӧ�Ķ���
		public List<BasicDictionary> showDictionaryByType(String basiType);
		//���
		public boolean addDictionary(BasicDictionary basicDictionary);
		//ɾ��
		public boolean deleteDictionary(BasicDictionary basicDictionary);
		//�޸�
		public boolean updateDictionary(BasicDictionary basicDictionary);
		//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
		public List<BasicDictionary> showDictionaryLike(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag,int page,int pagesize);
		//�������������ѯ��������
		public List<BasicDictionary> showAllDictionary(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag);
}
