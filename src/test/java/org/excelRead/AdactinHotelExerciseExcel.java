package org.excelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotelExerciseExcel {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		String path = "C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";

		String userName = getExceldata(path, 1, 0);
		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(userName);

		String password = getExceldata(path, 1, 1);
		WebElement txtPassword = driver.findElement(By.id("password"));

		WebElement btnLogin = driver.findElement(By.id("login"));
		txtPassword.sendKeys(password);
		btnLogin.click();

		String vLocation = getExceldata(path, 1, 2);
		System.out.println(vLocation);
		WebElement dropdownLocation = driver.findElement(By.id("location"));
		Select location = new Select(dropdownLocation);
		location.selectByVisibleText(vLocation);

		String vHotel = getExceldata(path, 1, 3);
		WebElement dropdownHotel = driver.findElement(By.id("hotels"));
		Select hotel = new Select(dropdownHotel);
		hotel.selectByVisibleText(vHotel);

		String vRoomType = getExceldata(path, 1, 4);
		WebElement dropdownRoomType = driver.findElement(By.id("room_type"));
		Select roomType = new Select(dropdownRoomType);
		roomType.selectByVisibleText(vRoomType);

		String roomCount = getExceldata(path, 1, 5);
		WebElement dropdownRoomNos = driver.findElement(By.id("room_nos"));
		Select numOfRooms = new Select(dropdownRoomNos);
		numOfRooms.selectByVisibleText(roomCount);

		String checkInDate = getExceldata(path, 1, 6);
		WebElement txtCheckInDate = driver.findElement(By.id("datepick_in"));
		txtCheckInDate.sendKeys(checkInDate);

		String checkOutDate = getExceldata(path, 1, 7);
		WebElement txtCheckOutDate = driver.findElement(By.id("datepick_out"));
		txtCheckOutDate.sendKeys(checkOutDate);

		String vAdultCount = getExceldata(path, 1, 8);
		WebElement dropdownAdultCount = driver.findElement(By.id("adult_room"));
		Select adultCount = new Select(dropdownAdultCount);
		adultCount.selectByVisibleText(vAdultCount);

		String vChildCount = getExceldata(path, 1, 9);
		WebElement dropdownChildCount = driver.findElement(By.id("child_room"));
		Select childCount = new Select(dropdownChildCount);
		childCount.selectByVisibleText(vChildCount);
	}

	public static String getExceldata(String path, int rowNum, int cellNum) throws IOException {
		File f = new File(path);
		FileInputStream fIn = new FileInputStream(f);
		Workbook userData = new XSSFWorkbook(fIn);
		Sheet s = userData.getSheet("Sheet1");
		Row r = s.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int type = c.getCellType();
		String value = "";
		if (type == 1) {
			value = c.getStringCellValue();
		} else if (type == 0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				value = sdf.format(date);
			} else {
				double numeric = c.getNumericCellValue();
				long l = (long) numeric;
				value = String.valueOf(l);
			}
		}
		System.out.println(value);
		return value;
	}
}
