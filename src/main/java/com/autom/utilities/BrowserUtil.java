package com.autom.utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.autom.base.Base;

public class BrowserUtil extends Base{

	//Objects & variables
	static JavascriptExecutor jse = (JavascriptExecutor) driver;

	//Scroll to Element
	public static void scrollToElement(WebElement element) throws Exception{ 
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	//Scroll length
	public static void scrollLength() {
		jse.executeScript("window.scrollBy(0,500)");
	}

	//Scroll to the bottom of page
	public static void scrollToBottom() {
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	//Scroll to Top of Page
	public static void scrollToTop() {
		jse.executeScript("window.scrollTo(0, 0)");
	}

	//Browser Alerts
	public static String browserAlert(String alertType) {
		String alertMethod = alertType.toLowerCase();
		switch (alertMethod) {
		case "dismiss":
			driver.switchTo().alert().dismiss();
			break;
		case "accept":
			driver.switchTo().alert().accept();
			break;
		case "gettext":
			String alertText = driver.switchTo().alert().getText();
			return alertText;
		}
		return alertMethod;
	}

	//Alert Send text
	public static void alertSendText(String text) {
		driver.switchTo().alert().sendKeys(text);
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
	
	//Open New Tab
	public static void openNewTab() {
		 driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
	}

	//Windows Handlers
	public static String getWindowHandles() {
		String handles = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		  while (iterator.hasNext()) {
			  handles = iterator.next();
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

}