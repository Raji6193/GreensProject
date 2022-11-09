package org.adactin.testng.parameters.dataproviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinTestNgWithParameters {
	WebDriver driver;

	@BeforeClass
	private void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	@Parameters({ "userName", "password" })
	@Test(priority = 1)
	private void loginPage(String userName, String password) {
		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(userName);

		WebElement txtPassword = driver.findElement(By.id("password"));

		WebElement btnLogin = driver.findElement(By.id("login"));
		txtPassword.sendKeys(password);
		btnLogin.click();
	}

	@Parameters({ "vLocation", "vHotel", "vRoomType", "roomCount", "checkInDate", "checkOutDate", "vAdultCount",
			"vChildCount" })
	@Test(priority = 2)
	private void searchHotelPage(String vLocation, String vHotel, String vRoomType, String roomCount,
			String checkInDate, String checkOutDate, String vAdultCount, String vChildCount) {
		WebElement dropdownLocation = driver.findElement(By.id("location"));
		Select location = new Select(dropdownLocation);
		location.selectByVisibleText(vLocation);

		WebElement dropdownHotel = driver.findElement(By.id("hotels"));
		Select hotel = new Select(dropdownHotel);
		hotel.selectByVisibleText(vHotel);

		WebElement dropdownRoomType = driver.findElement(By.id("room_type"));
		Select roomType = new Select(dropdownRoomType);
		roomType.selectByVisibleText(vRoomType);

		WebElement dropdownRoomNos = driver.findElement(By.id("room_nos"));
		Select numOfRooms = new Select(dropdownRoomNos);
		numOfRooms.selectByVisibleText(roomCount);

		WebElement txtCheckInDate = driver.findElement(By.id("datepick_in"));
		txtCheckInDate.sendKeys(checkInDate);

		WebElement txtCheckOutDate = driver.findElement(By.id("datepick_out"));
		txtCheckOutDate.sendKeys(checkOutDate);

		WebElement dropdownAdultCount = driver.findElement(By.id("adult_room"));
		Select adultCount = new Select(dropdownAdultCount);
		adultCount.selectByVisibleText(vAdultCount);

		WebElement dropdownChildCount = driver.findElement(By.id("child_room"));
		Select childCount = new Select(dropdownChildCount);
		childCount.selectByVisibleText(vChildCount);
		
		WebElement btnSearch=driver.findElement(By.id("Submit"));
		btnSearch.click();
	}
	
	@Test(priority = 3)
	private void selectHotelpage() {
		WebElement radioBtn=driver.findElement(By.id("radiobutton_0"));
		radioBtn.click();
		
		WebElement btnContinue=driver.findElement(By.id("continue"));
		btnContinue.click();
	}
	
	@Parameters({"vFirstName","vLastname","vAddress","vCreditCardNumber","vCardType","vExpiryMonth","vExpiryYear","vCvv"})
	@Test(priority = 4)
	private void bookHotelPage(String vFirstName,String vLastname,String vAddress,String vCreditCardNumber,String vCardType,String vExpiryMonth,String vExpiryYear, String vCvv) {
		WebElement txtCvvNum=driver.findElement(By.id("cc_cvv"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", txtCvvNum);
		
		WebElement txtFirstname=driver.findElement(By.id("first_name"));
		txtFirstname.sendKeys(vFirstName);
		
		WebElement txtLastname=driver.findElement(By.id("last_name"));
		txtLastname.sendKeys(vLastname);
		
		WebElement txtAddress=driver.findElement(By.id("address"));
		txtAddress.sendKeys(vAddress);
		
		WebElement txtCreditCardNum=driver.findElement(By.id("cc_num"));
		txtCreditCardNum.sendKeys(vCreditCardNumber);
		
		WebElement dropDownCreditCardType=driver.findElement(By.id("cc_type"));
		Select s = new Select(dropDownCreditCardType);
		s.selectByVisibleText(vCardType);
		
		WebElement dropDownExpiryMonth=driver.findElement(By.id("cc_exp_month"));
		Select s1 = new Select(dropDownExpiryMonth);
		s1.selectByVisibleText(vExpiryMonth);
		
		WebElement dropDownExpiryYear=driver.findElement(By.id("cc_exp_year"));
		Select s2 = new Select(dropDownExpiryYear);
		s2.selectByVisibleText(vExpiryYear);
		
		txtCvvNum.sendKeys(vCvv);
		
		WebElement btnBookNow=driver.findElement(By.id("book_now"));
		btnBookNow.click();

	}
		
	@Test(priority = 5)
	private void orderNumPage() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement txtOrderNo= w.until(ExpectedConditions.presenceOfElementLocated(By.id("order_no")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", txtOrderNo);
		String textValue = txtOrderNo.getAttribute("value");
		System.out.println(textValue);
	}
	
	@AfterClass
	private void quitBrowser() {
		driver.quit();

	}
}
