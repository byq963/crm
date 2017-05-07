package com.prj.util;

public class PageUtil {
		public static int page=1;
		
		//每页显示的数据 maxresult
		public static	int  pagesize = 5;
		
		//获取起始位置 firstresult
		public static int getfirstResult(int page){	
			 return (page-1)*pagesize;
		}
		
		// 参数传入 数据总数
		public static int getallpage(int num){	
			return num%pagesize==0?num/pagesize:num/pagesize+1;
			
		}
		
}
