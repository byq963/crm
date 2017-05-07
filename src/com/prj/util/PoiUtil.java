package com.prj.util;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.prj.bean.My;


public class PoiUtil {

	/*
	 * ��������
	 */
	public static boolean exportPoi(List<My> list,String url) throws Exception{
		
		//׼���ļ�
		HSSFWorkbook workbook = new HSSFWorkbook();
		//����sheet
		Sheet sheet = workbook.createSheet("�ͻ����׷���");
		//������
		Row firstRow = sheet.createRow(0);
		//�����в���ֵ
		firstRow.createCell(0).setCellValue("�ͻ�����");
		firstRow.createCell(1).setCellValue("�������");
		
		
		//��������Դ
		for(int i=1;i<=list.size();i++){
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(list.get(i-1).getName());
			row.createCell(1).setCellValue(list.get(i-1).getNumber());
			
		}
		
		//ʹ���ֽ���������ļ������ȥ
		FileOutputStream fos = new FileOutputStream(url);
		workbook.write(fos);
		return true;
	}
}
