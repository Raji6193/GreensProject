package org.baseClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdactinHotelApp {
	public static void main(String[] args) throws IOException {
		BaseClass b=new BaseClass();
		WebDriver driver = b.launchBrowser();
		b.launchUrl("http://adactinhotelapp.com/");		
		String path = "C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";

		String userName = b.getExceldata(path, 1, 0);
		WebElement txtUsername = driver.findElement(By.id("username"));
		b.sendkeys(txtUsername, userName);
		
		String password = b.getExceldata(path, 1, 1);
		WebElement txtPassword = driver.findElement(By.id("password"));
		b.sendkeys(txtPassword, password);

		WebElement btnLogin = driver.findElement(By.id("login"));
		b.btnClick(btnLogin);

		String vLocation = b.getExceldata(path, 1, 2);
		WebElement dropdownLocation = driver.findElement(By.id("location"));
		b.selectByVisibleTextDropDown(dropdownLocation,vLocation);

		String vHotel = b.getExceldata(path, 1, 3);
		WebElement dropdownHotel = driver.findElement(By.id("hotels"));
		b.selectByVisibleTextDropDown(dropdownHotel,vHotel);

		String vRoomType = b.getExceldata(path, 1, 4);
		WebElement dropdownRoomType = driver.findElement(By.id("room_type"));
		b.selectByVisibleTextDropDown(dropdownRoomType,vRoomType);

		String roomCount = b.getExceldata(path, 1, 5);
		WebElement dropdownRoomNos = driver.findElement(By.id("room_nos"));
		b.selectByVisibleTextDropDown(dropdownRoomNos,roomCount);

		String checkInDate = b.getExceldata(path, 1, 6);
		WebElement txtCheckInDate = driver.findElement(By.id("datepick_in"));
		b.sendkeys(txtCheckInDate, checkInDate);

		String checkOutDate = b.getExceldata(path, 1, 7);
		WebElement txtCheckOutDate = driver.findElement(By.id("datepick_out"));
		b.sendkeys(txtCheckOutDate, checkOutDate);

		String vAdultCount = b.getExceldata(path, 1, 8);
		WebElement dropdownAdultCount = driver.findElement(By.id("adult_room"));
		b.selectByVisibleTextDropDown(dropdownAdultCount,vAdultCount);

		String vChildCount = b.getExceldata(path, 1, 9);
		WebElement dropdownChildCount = driver.findElement(By.id("child_room"));
		b.selectByVisibleTextDropDown(dropdownChildCount,vChildCount);
		
		WebElement btnSearch=driver.findElement(By.id("Submit"));
		b.btnClick(btnSearch);
		
		WebElement btnRadio=driver.findElement(By.id("radiobutton_0"));
		b.btnClick(btnRadio);
		
		WebElement btnContinue=driver.findElement(By.id("continue"));
		b.btnClick(btnContinue);
		
		WebElement txtCvvNum=driver.findElement(By.id("cc_cvv"));
		b.scrollDownUsingJs(txtCvvNum);
		
		WebElement txtFirstname=driver.findElement(By.id("first_name"));
		b.sendkeys(txtFirstname, "abc");
		
		WebElement txtLastname=driver.findElement(By.id("last_name"));
		b.sendkeys(txtLastname, "def");
		
		WebElement txtAddress=driver.findElement(By.id("address"));
		b.sendkeys(txtAddress, "xyz,123");
		
		WebElement txtCreditCardNum=driver.findElement(By.id("cc_num"));
		b.sendkeys(txtCreditCardNum, "1234567812345678");
		
		WebElement dropDownCreditCardType=driver.findElement(By.id("cc_type"));
		b.selectByVisibleTextDropDown(dropDownCreditCardType, "Master Card");
		
		WebElement dropDownExpiryMonth=driver.findElement(By.id("cc_exp_month"));
		b.selectByVisibleTextDropDown(dropDownExpiryMonth, "December");
		
		WebElement dropDownExpiryYear=driver.findElement(By.id("cc_exp_year"));
		b.selectByVisibleTextDropDown(dropDownExpiryYear, "2022");
		
		b.sendkeys(txtCvvNum, "123");
		
		WebElement btnBookNow=driver.findElement(By.id("book_now"));
		b.btnClick(btnBookNow);
		
		By txtOrderNo=By.id("order_no");
		b.explicitWait(txtOrderNo);
		b.scrollDownUsingJs(driver.findElement(txtOrderNo));
		String textValue = b.getAttributeValue(driver.findElement(txtOrderNo),"value");
		System.out.println(textValue);
		
		b.quitBrowser();
	}

}
