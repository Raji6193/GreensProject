package org.pom.sample;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Sample {
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass b = new BaseClass();
		b.launchBrowser();
		b.launchUrl("http://adactinhotelapp.com/");
		String path = "C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";

		LoginPojo lp = new LoginPojo();
		SearchHotelPojo searchHp = new SearchHotelPojo();
		SelectHotelPojo selectHp = new SelectHotelPojo();
		BookHotelPojo bookHp=new BookHotelPojo();
		OrderNumPojo onp=new OrderNumPojo();

		//========Login page===========
		String userName = b.getExceldata(path, 1, 0);
		WebElement txtUsername = lp.getTxtUsername();
		b.sendkeys(txtUsername, userName);
		String password = b.getExceldata(path, 1, 1);
		b.sendkeys(lp.getTxtPassword(), password);
		b.btnClick(lp.getBtnLogin());

		//========Search Hotel Page===========
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

		//========Select Hotel Page=======
		b.btnClick(selectHp.getBtnRadio());
		b.btnClick(selectHp.getBtnContinue());
		
		//===========Book Hotel Page============
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
		
		//==========Order Number Page==========
		//Thread.sleep(10000);
		b.explicitWait(onp.getTxtOrderNo());
		b.scrollDownUsingJs(onp.getTxtOrderNo());
		String textValue = b.getAttributeValue(onp.getTxtOrderNo(),"value");
		System.out.println(textValue);
		
		b.quitBrowser();
	}

}
