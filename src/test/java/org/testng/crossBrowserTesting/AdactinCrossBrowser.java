package org.testng.crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinCrossBrowser {
	public static WebDriver driver;

	@Parameters({ "browserName" })
	@Test
	private void loginPage(String bName) {
		if (bName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://adactinhotelapp.com/");
		} else if (bName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("http://adactinhotelapp.com/");
		}

		driver.manage().window().maximize();
		WebElement txtUsername = driver.findElement(By.id("username"));

		txtUsername.sendKeys("Raji6193");

		WebElement txtPassword = driver.findElement(By.id("password"));

		WebElement btnLogin = driver.findElement(By.id("login"));
		txtPassword.sendKeys("Raji6193");
		btnLogin.click();
	}

}
