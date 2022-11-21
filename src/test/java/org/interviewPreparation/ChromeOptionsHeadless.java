package org.interviewPreparation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsHeadless {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--headless");
		WebDriver driver = new ChromeDriver(ch);
		driver.get("https://www.facebook.com/");
		System.out.println("url Opened");
	}

}
