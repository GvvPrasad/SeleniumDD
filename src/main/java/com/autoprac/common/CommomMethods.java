package com.autoprac.common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autoprac.base.Base;
import com.autoprac.config.ObjectRespo;
import com.google.common.base.Function;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class CommomMethods extends Base{


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
		Wait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class); 
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement((By) webElement);
			}
		});
	}


	//Element Screenshot
	public static void elementScreenshot(WebElement element) throws IOException {
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element); 
		ImageIO.write(screenshot.getImage(),"PNG",new File(ObjectRespo.screenShotName));
	}

	//Visible Page Screenshots
	public static void visiablePageScreenShot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File(ObjectRespo.screenShotName));
	}

	//Full Page ScreenShot
	public static void fullPageScreenshot() throws IOException {
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver); 
		ImageIO.write(screenshot.getImage(),"PNG",new File(ObjectRespo.screenShotName));
	}


	//Scroll to Element
	public static void scrollToElement(WebElement element) throws Exception{ 
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	//Scroll length
	public static void scrollLength() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
	}

	//Scroll to the bottom of page
	public static void scrollToBottom() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	//Scroll to Top of Page
	public static void scrollToTop() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, 0)");
	}


	//Mouse hover
	public static void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	//Drag and Drop
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}


	//Web Tables get All Data values
	public static String webTableAllValues(WebElement element) {
		String celltext = null;

		List<WebElement> rows = element.findElements(By.tagName("tr"));
		int rowCount=rows.size();

		for (int i = 0; i<rowCount; i++) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			int columnCount = columns.size();
			for (int j = 0; j <columnCount; j++) {
				celltext = columns.get(j).getText()+" ";
			}
		}
		return celltext;
	}

	//Web Table - get all values in a row
	public static String webTableRowValues(WebElement element, int i) {
		String celltext = null;
		List<WebElement> rows = element.findElements(By.tagName("tr"));

		List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
		int columnCount = columns.size();
		for (int j = 0; j <columnCount; j++) {
			celltext = columns.get(j).getText()+" ";
		}
		return celltext;

	}
	//Web Table - get all values in a column
	public static String webTablesColValues(WebElement element, int j) {
		String celltext = null;
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		int rowCount=rows.size();
		for (int i = 0; i<rowCount; i++) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			celltext = columns.get(j).getText()+" ";
		}
		return celltext;
	}
	
	//Web Table - get specific value
	public static String webTableSpecificValue(WebElement element, int i, int j) {
		String celltext = null;

		List<WebElement> rows = element.findElements(By.tagName("tr"));
		List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
		celltext = columns.get(j).getText()+" ";
		return celltext;
	}


	//Browser Alerts
	public static String browserAlert(String alertType, String textToSend) {

		String alertMethod = alertType.toLowerCase();

		switch (alertMethod) {
		case "dismiss":
			driver.switchTo().alert().dismiss();
			break;
		case "accept":
			driver.switchTo().alert().accept();
			break;
		case "sendtext":
			driver.switchTo().alert().sendKeys(textToSend);
			break;
		case "gettext":
			String alertText = driver.switchTo().alert().getText();
			return alertText;
		}
		return alertMethod;
	}


	//Browser Actions
	public static void browserActions(String action) {

		String requiredAction = action.toLowerCase();

		switch (requiredAction) {
		case "forward":
			driver.navigate().forward();
			break;
		case "backward":
			driver.navigate().back();
			break;
		case "refresh":
			driver.navigate().refresh();
			break;
		}
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

	//switch to Specific windows
	public static void switchWindows(String windowname) {
		driver.switchTo().window(windowname);
	}


	//Model popup
	public static void modelPopUp() {
		driver.switchTo().activeElement();
	}


	//Compare two string values
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
}