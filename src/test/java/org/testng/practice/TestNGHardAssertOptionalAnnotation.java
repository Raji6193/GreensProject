package org.testng.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGHardAssertOptionalAnnotation {
	//When parameter name in xml file and parameter name passed in class got mismatched, we use @optional
	@Parameters({"username","password"})
	@Test
	private void test1(@Optional("Raji6193") String s,String s1) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		Assert.assertTrue(driver.getCurrentUrl().contains("ada"), "Verify URL");

		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(s);

		WebElement txtPassword = driver.findElement(By.id("password"));

		WebElement btnLogin = driver.findElement(By.id("login"));
		txtPassword.sendKeys(s1);
		btnLogin.click();
	}

}
