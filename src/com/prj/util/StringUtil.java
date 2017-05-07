package com.prj.util;

import java.io.UnsupportedEncodingException;

public class StringUtil {
	
	
	public static String toUTF(String str){
		try {
			return new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
}
