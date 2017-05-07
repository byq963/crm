package com.prj.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProduceId {
	public static String produceString(String s){
		StringBuffer str=new StringBuffer(s);
		Date date=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("yyyyMMddHHmmss");
		return str.append(simple.format(date)).toString();
	}
	public static void main(String[] args) {
		System.out.println(produceString("djf"));
	}
}
