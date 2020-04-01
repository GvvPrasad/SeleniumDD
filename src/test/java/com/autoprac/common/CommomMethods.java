package com.autoprac.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autoprac.testscripts.Base;
import com.google.common.base.Function;


public class CommomMethods extends Base{

	//Screenshots
	public static void screenshot() throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(projectPath+"//ScreenShots//"+timeStamp+".png"));
	}


	//Implicit Wait
	public static void waitTime() throws InterruptedException {
		Thread.sleep(5000);
	}


	//Explicit Wait
	public static WebElement waitForElement(WebElement element) {
		WebDriverWait exwait = new WebDriverWait(driver,10);
		return exwait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}


	//Fluent Wait
	public static void presenceOfTheElement(final WebElement webElement) {
		FluentWait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class); 
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement((By) webElement);
			}
		});
	}


	//Scroll to Element
	public static void scrollTillElement(WebElement element) throws Exception{ 
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}


	//Scroll length
	public static void scrollLength(int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(x,y)");
	}


	//Scroll to the bottom of page
	public static void scrollToBottom() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}


	//Mouse hover
	public static void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}


	//Drag and Drop
	public static void draganddrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}


	//Web Tables
	public static String webTable(WebElement element) {
		String celltext = null;

		List<WebElement> rows = element.findElements(By.tagName("tr"));
		int rowCount=rows.size();

		for (int i = 0; i<rowCount; i++) {
			List<WebElement> Columns = rows.get(i).findElements(By.tagName("td"));
			int columnCount = Columns.size();
			for (int j = 0; j <columnCount; j++) {
				celltext = Columns.get(j).getText()+" ";
			}
		}
		return celltext;
	}


	//Browser Alerts
	public static Alert browserAlert() {
		return driver.switchTo().alert();
	}


	//Browser Actions
	public static Navigation browserActions() {
		return driver.navigate();
	}


	//Windows Handlers
	public static String getWindowHandles() {
		String handles = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles) {
			handles = handle;
		}
		return handles;
	}


	//switch to windows
	public static void switchWindows(String windowname) {
		driver.switchTo().window(windowname);
	}


	//Model popup
	public static void modelPopUp() {
		driver.switchTo().activeElement();
	}


	//Compare two values
	public static boolean compareValues(String actualValue, String expectedValue) {
		if (actualValue.equalsIgnoreCase(expectedValue)) {
			return true;
		} else {
			return false;
		}
	}


	//Convert String to Int
	public static int stringToInt(String stringValue) {
		int intValue = Integer.parseInt(stringValue);
		return intValue;
	}


	//Convert Int to String
	public static String intToString(int intValue) {
		String stringValue = Integer.toString(intValue);
		return stringValue;
	}


	//Get current Date [formatValue = dd/mm/yyyy HH:mm:ss] in desire format
	public static String getCurrentDate(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);  
		Date date = new Date(); 
		return formatter.format(date);
	}

}