package com.prj.dao;

import java.util.List;

import com.prj.bean.BasicDictionary;

public interface IDictionaryDao {
	//ģ����������ѯ���ҳ���н�ϵķ���,���Բ�ѯ�κ�����
	public List<BasicDictionary> queryDictionaryLike(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag,int page,int pagesize);
	//�������������ѯ��������
	public List<BasicDictionary> queryAllDictionary(Long basiNo,String basiType,String basiItem,String basiValue,Byte basiEditable,Byte basiFlag);
	//���
	public boolean add(BasicDictionary basicDictionary);
	//ɾ��
	public boolean delete(BasicDictionary basicDictionary);
	//�޸�
	public boolean update(BasicDictionary basicDictionary);
	//������������ȡ��Ӧ�Ķ���
	public List<BasicDictionary> queryDictionaryByType(String basiType);
}
