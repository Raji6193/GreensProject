package org.interviewPreparation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsIncognitoMaxDisableAutomatedText {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		ch.addArguments("--incognito");
		ch.addArguments("--start-maximized");
		WebDriver driver=new ChromeDriver(ch);
		driver.get("https://www.facebook.com/");
	}

}
