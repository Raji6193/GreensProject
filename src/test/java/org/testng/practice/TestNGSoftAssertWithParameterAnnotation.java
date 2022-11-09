package org.testng.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGSoftAssertWithParameterAnnotation {
	@Parameters({"username","password"})
	@Test
	private void test1(String s,String s1) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		//SoftAssert sa= new SoftAssert();
		//sa.assertTrue(driver.getCurrentUrl().contains("fb"), "Verify URL");

		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(s);

		WebElement txtPassword = driver.findElement(By.id("password"));

		WebElement btnLogin = driver.findElement(By.id("login"));
		txtPassword.sendKeys(s1);
		//sa.assertEquals(txtPassword.getAttribute("value"),"Raji6193","VerifyPassword");
		btnLogin.click();
		
		//To Highlight assert
		//sa.assertAll();
	}

}
