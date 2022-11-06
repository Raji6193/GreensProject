package org.junit;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.pom.sample.BaseClass;
import org.pom.sample.BookHotelPojo;
import org.pom.sample.LoginPojo;
import org.pom.sample.OrderNumPojo;
import org.pom.sample.SearchHotelPojo;
import org.pom.sample.SelectHotelPojo;

public class JunitTest {
	public static BaseClass b = new BaseClass();
	
	@BeforeClass
	public static void beforeClass() {
		b.launchBrowser();
		b.launchUrl("http://adactinhotelapp.com/");
	}
	
	@Before
	public void before() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	public void a() throws IOException {
		LoginPojo lp = new LoginPojo();
		String path="C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";
		String userName = b.getExceldata(path, 1, 0);
		WebElement txtUsername = lp.getTxtUsername();
		b.sendkeys(txtUsername, userName);
		String password = b.getExceldata(path, 1, 1);
		b.sendkeys(lp.getTxtPassword(), password);
		b.btnClick(lp.getBtnLogin());
	}
	
	@Test
	public void b() throws IOException {
		SearchHotelPojo searchHp = new SearchHotelPojo();
		String path="C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";
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
	
	@Test
	public void c() {
		SelectHotelPojo selectHp = new SelectHotelPojo();
		b.btnClick(selectHp.getBtnRadio());
		b.btnClick(selectHp.getBtnContinue());
	}
	
	@Test
	public void d() throws IOException {
		BookHotelPojo bookHp=new BookHotelPojo();
		String path="C:\\Users\\arune\\eclipse-workspace\\Maven\\Sample\\src\\test\\resources\\ExcelData\\ExcelData.xlsx";
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
	
	@Test
	public void e() {
		OrderNumPojo onp=new OrderNumPojo();
		b.explicitWait(onp.getTxtOrderNo());
		b.scrollDownUsingJs(onp.getTxtOrderNo());
		String textValue = b.getAttributeValue(onp.getTxtOrderNo(),"value");
		System.out.println(textValue);		
	}
	
	@After
	public void after() {
		Date d = new Date();
		System.out.println(d);
	}
	
	@AfterClass
	public static void afterClass() {
		b.quitBrowser();
	}

}
