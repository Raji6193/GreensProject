package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	WebDriverWait w;
	JavascriptExecutor js;

	public String getExceldata(String path, int row, int cell) throws IOException {
		File f = new File(path);
		FileInputStream fIn = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fIn);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();
		String value = "";
		if (type == 1) {
			value = c.getStringCellValue();
		} else if (type == 0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				value = sdf.format(date);
			} else {
				double numeric = c.getNumericCellValue();
				long l = (long) numeric;
				value = String.valueOf(l);
			}
		}
		return value;
	}

	public WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	public void sendkeys(WebElement element, String value) {
		element.sendKeys(value);
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public void selectByVisibleTextDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	public void scrollDownUsingJs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public String getAttributeValue(WebElement element, String attribute) {
		String text = element.getAttribute(attribute);
		return text;
	}
	public void explicitWait(By locator) {
		w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public void quitBrowser() {
		driver.quit();
	}

}
