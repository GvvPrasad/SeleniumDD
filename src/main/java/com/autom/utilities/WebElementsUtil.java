package com.autom.utilities;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.autom.base.Base;

public class WebElementsUtil extends Base{

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


}
