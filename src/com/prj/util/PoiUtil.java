package com.prj.util;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.prj.bean.My;


public class PoiUtil {

	/*
	 * 导出数据
	 */
	public static boolean exportPoi(List<My> list,String url) throws Exception{
		
		//准备文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建sheet
		Sheet sheet = workbook.createSheet("客户贡献分析");
		//创建行
		Row firstRow = sheet.createRow(0);
		//创建列并赋值
		firstRow.createCell(0).setCellValue("客户名称");
		firstRow.createCell(1).setCellValue("订单金额");
		
		
		//遍历数据源
		for(int i=1;i<=list.size();i++){
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(list.get(i-1).getName());
			row.createCell(1).setCellValue(list.get(i-1).getNumber());
			
		}
		
		//使用字节输出流将文件输出出去
		FileOutputStream fos = new FileOutputStream(url);
		workbook.write(fos);
		return true;
	}
}
