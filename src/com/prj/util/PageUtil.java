package com.prj.util;

public class PageUtil {
		public static int page=1;
		
		//ÿҳ��ʾ������ maxresult
		public static	int  pagesize = 5;
		
		//��ȡ��ʼλ�� firstresult
		public static int getfirstResult(int page){	
			 return (page-1)*pagesize;
		}
		
		// �������� ��������
		public static int getallpage(int num){	
			return num%pagesize==0?num/pagesize:num/pagesize+1;
			
		}
		
}
