package com.zks.controller;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.zks.model.User;

public class gongjv {
	public SXSSFWorkbook ulist (List<User> ulist) {
		SXSSFWorkbook workbook = new SXSSFWorkbook(100);//�ڴ��б���100�����ݣ������ڴ����
		Sheet sheet = workbook.createSheet();//��ȡ�Ĺ�������ĵ�һ��sheet
		int uSize = ulist.size();
		Row row = sheet.createRow(0);//������
		Cell title1 = row.createCell(0);
		Cell title2 = row.createCell(1);
		Cell title3 = row.createCell(2);
		Cell title4 = row.createCell(3);
		Cell title5 = row.createCell(4);
		Cell title6 = row.createCell(5);
		Cell title7 = row.createCell(6);
		Cell title8 = row.createCell(7);
		Cell title9 = row.createCell(8);
		Cell title10 = row.createCell(9);
		
		
		title1.setCellValue("����");
		title2.setCellValue("�Ա�");
		title3.setCellValue("�绰");
		title4.setCellValue("����");
		title5.setCellValue("��ɫ");
		title6.setCellValue("����");
		title7.setCellValue("����ʱ��");
		title8.setCellValue("ʡ");
		title9.setCellValue("��");
		title10.setCellValue("����");
		for (int i = 0; i < uSize; i++) {
			User user = ulist.get(i);
			Row row1 = sheet.createRow(i + 1);
			Cell cell1 = row1.createCell(0);
			Cell cell2 = row1.createCell(1);
			Cell cell3 = row1.createCell(2);
			Cell cell4 = row1.createCell(3);
			Cell cell5 = row1.createCell(4);
			Cell cell6 = row1.createCell(5);
			Cell cell7 = row1.createCell(6);
			Cell cell8 = row1.createCell(7);
			Cell cell9 = row1.createCell(8);
			Cell cell10 = row1.createCell(9);
			
			cell1.setCellValue(user.getUser_name());
			cell2.setCellValue(user.getSex());
			cell3.setCellValue(user.getTele_phone());
			cell4.setCellValue(user.getMail());
			cell5.setCellValue(user.getRole_name());
			cell6.setCellValue(user.getJob_num());
			cell7.setCellValue(user.getCreate_time());
			cell8.setCellValue(user.getProvince_name());
			cell9.setCellValue(user.getCity_name());
			cell10.setCellValue(user.getCounty_name());
			
		}
		
		return workbook;
	}

}
