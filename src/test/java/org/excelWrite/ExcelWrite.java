package org.excelWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	private void write(Workbook w,Sheet s,int rownum,int cellNum,String strValue,File f) throws IOException {
		Row r = s.createRow(rownum);

		Cell c = r.createCell(cellNum);

		c.setCellValue(strValue);
		
		FileOutputStream fout=new FileOutputStream(f);
		
		w.write(fout);
		
		System.out.println("Done");

	}
	
	public static void main(String[] args) throws IOException {

		File f = new File(
				"C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\New.xlsx");

		Workbook w = new XSSFWorkbook();

		Sheet s = w.createSheet("Course");
		
		ExcelWrite obj=new ExcelWrite();
		
		s.createRow(0).createCell(0).setCellValue("Java");
		s.getRow(0).createCell(1).setCellValue("Oracle");
		s.createRow(1).createCell(0).setCellValue("Selenium");
		
		FileOutputStream fout=new FileOutputStream(f);
		
		w.write(fout);
		
		System.out.println("Done");
		
		
		//obj.write(w,s,1,1,"JAVA",f);
		//obj.write(w,s,2,1,"ORACLE",f);

		
		
	}
}
