package org.testng;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest {
	BaseClass b = new BaseClass();

	@BeforeClass
	public void launchBrowser() {
		b.launchBrowser();
		b.launchUrl("http://adactinhotelapp.com/");
	}

	@BeforeMethod
	public void before() {
		Date d = new Date();
		System.out.println(d);
	}

	@Test(priority = 1)
	public void loginPage() throws IOException {
		LoginPojo lp = new LoginPojo();
		String path = "C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";
		String userName = b.getExceldata(path, 1, 0);
		WebElement txtUsername = lp.getTxtUsername();
		b.sendkeys(txtUsername, userName);
		String password = b.getExceldata(path, 1, 1);
		b.sendkeys(lp.getTxtPassword(), password);
		b.btnClick(lp.getBtnLogin());
	}

	@Test(priority = 2)
	public void searchHotelPage() throws IOException {
		SearchHotelPojo searchHp = new SearchHotelPojo();
		String path = "C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";
		String vLocation = b.getExceldata(path, 1, 2);
		b.selectByVisibleTextDropDown(searchHp.getDropdownLocation(), vLocation);
		String vHotel = b.getExceldata(path, 1, 3);
		b.selectByVisibleTextDropDown(searchHp.getDropdownHotel(), vHotel);
		String vRoomType = b.getExceldata(path, 1, 4);
		b.selectByVisibleTextDropDown(searchHp.getDropdownRoomType(), vRoomType);
		String roomCount = b.getExceldata(path, 1, 5);
		b.selectByVisibleTextDropDown(searchHp.getDropdownRoomNos(), roomCount);
		String checkInDate = b.getExceldata(path, 1, 6);
		b.sendkeys(searchHp.getTxtCheckInDate(), checkInDate);
		String checkOutDate = b.getExceldata(path, 1, 7);
		b.sendkeys(searchHp.getTxtCheckOutDate(), checkOutDate);
		String vAdultCount = b.getExceldata(path, 1, 8);
		b.selectByVisibleTextDropDown(searchHp.getDropdownAdultCount(), vAdultCount);
		String vChildCount = b.getExceldata(path, 1, 9);
		b.selectByVisibleTextDropDown(searchHp.getDropdownChildCount(), vChildCount);
		b.btnClick(searchHp.getBtnSearch());
	}

	@Test(priority = 3)
	public void selectHotelPage() {
		SelectHotelPojo selectHp = new SelectHotelPojo();
		b.btnClick(selectHp.getBtnRadio());
		b.btnClick(selectHp.getBtnContinue());
	}

	@Test(priority = 4)
	public void bookHotelPage() throws IOException {
		BookHotelPojo bookHp = new BookHotelPojo();
		String path = "C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";
		b.scrollDownUsingJs(bookHp.getTxtCvvNum());
		b.sendkeys(bookHp.getTxtFirstname(), b.getExceldata(path, 4, 0));
		b.sendkeys(bookHp.getTxtLastname(), b.getExceldata(path, 4, 1));
		b.sendkeys(bookHp.getTxtAddress(), b.getExceldata(path, 4, 2));
		b.sendkeys(bookHp.getTxtCreditCardNum(), b.getExceldata(path, 4, 3));
		b.selectByVisibleTextDropDown(bookHp.getDropDownCreditCardType(), "Master Card");
		b.selectByVisibleTextDropDown(bookHp.getDropDownExpiryMonth(), "December");
		b.selectByVisibleTextDropDown(bookHp.getDropDownExpiryYear(), "2022");
		b.sendkeys(bookHp.getTxtCvvNum(), b.getExceldata(path, 4, 4));
		b.btnClick(bookHp.getBtnBookNow());
	}

	@Test(priority = 5)
	public void orderNumberPage() {
		OrderNumPojo onp = new OrderNumPojo();
		b.explicitWait(onp.getTxtOrderNo());
		b.scrollDownUsingJs(onp.getTxtOrderNo());
		String textValue = b.getAttributeValue(onp.getTxtOrderNo(), "value");
		System.out.println(textValue);
	}

	@AfterMethod
	public void after() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterClass
	public void quitBrowser() {
		b.quitBrowser();
	}
}
