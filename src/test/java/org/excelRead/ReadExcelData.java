package org.excelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadExcelData {
	
	public static void main(String[] args) throws IOException {
		File f=new File("C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\Excelread.xlsx");
		
		//To convert File to Java Object
		FileInputStream fIn=new FileInputStream(f);
		
		//To create Workbook
		Workbook w=new XSSFWorkbook(fIn);
		
		//To get Sheet
		Sheet s= w.getSheet("Data");
		
		//To get row
		Row r=s.getRow(2);
		
		//To get Cell
		Cell c=r.getCell(0);
		
		//To get No.of Rows
		int rows=s.getPhysicalNumberOfRows();
		System.out.println(rows);
		
		//To get No.of Cells
		int cells=r.getPhysicalNumberOfCells();
		System.out.println(cells);
		
		//To to the entire excel data

		for(int i=0;i<rows;i++)
		{
			Row eachRow=s.getRow(i);
			for(int j=0;j<cells;j++)
			{
				Cell eachCell=eachRow.getCell(j);
				System.out.println(eachCell);
			}
		}
	}

}
