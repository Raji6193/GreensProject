package org.junit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	WebDriverWait w;
	JavascriptExecutor js;
	Actions acc;
	TakesScreenshot tk;
	Alert a;

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
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void navigateForward() {
		driver.navigate().forward();
	}
	public void refresh() {
		driver.navigate().refresh();
	}
	public void sendkeys(WebElement element, String value) {
		element.sendKeys(value);
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public String getAttributeValue(WebElement element, String attribute) {
		String text = element.getAttribute(attribute);
		return text;
	}
	public String getTextValue(WebElement element) {
		String text = element.getText();
		return text;	
	}
	public String getTagNameValue(WebElement element) {
		String tagName = element.getTagName();
		return tagName;
	}
	public void moveToElementAction(WebElement element) {
		acc.moveToElement(element).perform();
	}
	public void dragAndDropAction(WebElement source,WebElement target) {
		acc.dragAndDrop(source, target).perform();
	}
	public void contentClickAction(WebElement element) {
		acc.contextClick(element).perform();
	}
	public void doubleClickAction(WebElement element) {
		acc.doubleClick(element).perform();
	}
	public void screenshot(String path) throws IOException {
		tk=(TakesScreenshot) driver;
		File screenshotAs = tk.getScreenshotAs(OutputType.FILE);
		File f1=new File(path);
		FileUtils.copyFile(screenshotAs, f1);
	}
	public void sendkeysUsingJS(WebElement element,String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"')");
	}
	public void clickUsingJs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
	}
	public String getAttributeUsingJs(WebElement element,String value) {
		js = (JavascriptExecutor) driver;
		Object attribute = js.executeScript("return arguments[0].getAttribute('"+value+"')", element);
		String text=(String) attribute;
		return text;
	}
	public boolean isElementDisplayed(WebElement element) {
		boolean b = element.isDisplayed();
		return b;
	}
	public boolean isElementEnabled(WebElement element) {
		boolean b = element.isEnabled();
		return b;
	}
	public boolean isElementSelected(WebElement element) {
		boolean b = element.isSelected();
		return b;
	}
	public void scrollUpUsingJs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public void scrollDownUsingJs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void alertAccept(WebElement element) {
		driver.switchTo().alert().accept();
	}
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}
	public void promptAlertAccept(String value) {
		a=driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();
	}
	public void promptAlertDismiss(String value) {
		a=driver.switchTo().alert();
		a.sendKeys(value);
		a.dismiss();
	}
	public void switchToFrameWithIdOrName(String idName) {
		driver.switchTo().frame(idName);
	}
	public void switchToFrameWithWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToDefaultContentFrame() {
		driver.switchTo().defaultContent();
	}
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	public void selectByValueDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	public void selectByVisibleTextDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	public void selectByIndexDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void switchToWindow(int winNumber) {
		int count=0;
		//String parId=driver.getWindowHandle();
		Set<String> allWinid = driver.getWindowHandles();
		for (String eachId : allWinid) {
			if(count==winNumber)
			{
				driver.switchTo().window(eachId);
			}
			count++;
		}
	}
	@SuppressWarnings("deprecation")
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void explicitWait(WebElement element) {
		w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOf(element));

	}
	public void quitBrowser() {
		driver.quit();
	}
	
}
