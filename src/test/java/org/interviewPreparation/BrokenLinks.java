package org.interviewPreparation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

		public static void main(String[] args) throws IOException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
			
			List<WebElement> elements = driver.findElements(By.xpath("//a"));
			System.out.println(elements.size());
			for (WebElement element : elements) {
				String attribute = element.getAttribute("href");
				if(attribute!=null)
				{
					URL url = new URL(attribute);
					URLConnection openConnection = url.openConnection();
					HttpURLConnection http = (HttpURLConnection)openConnection;
					int responseCode = http.getResponseCode();
					if(responseCode!=200)
					{
						System.out.println(attribute);
					}
				}
			}
			
		}

}
