package com.autom.utilities;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.autom.base.Base;

public class WebElementsUtil extends Base{

	//Objects & Variables
	static String celltext = null;
	static String elementValue = null;
	static Actions act = new Actions(driver);

	
	//CheckBox or Radio Button
	public static String checkBoxAndRadioButton(List<WebElement> elements) {
		List<WebElement> elementsList = elements;

		for (int i = 0; i < elementsList.size(); i++) {
			elementValue = elementsList.get(i).getAttribute("value");
		}
		return elementValue;
	}

	//Dropdown
	public static void dropDown(WebElement element) {
		Select dropdown = new Select(element);
	}

	//Date
	//Time

	//Links
	public static String AllLinks() {
		List < WebElement > links = driver.findElements(By.tagName("a"));
		Iterator < WebElement > it = links.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
		}
		return url;
	}

	//Web Tables get All Data values
	public static String webTableAllValues(WebElement element) {

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

		List<WebElement> rows = element.findElements(By.tagName("tr"));
		List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
		celltext = columns.get(j).getText()+" ";
		return celltext;
	}

	//Iframes
	public static String iFrames(List<WebElement> elements) {
		List<WebElement> elementsList = elements;

		for (int i = 0; i < elementsList.size(); i++) {
			elementValue = elementsList.get(i).getAttribute("iframe");
		}
		return elementValue;
	}

	//File Upload
	public static void fileUpload(WebElement element, String filepath) {
		WebElement fileupload = element;
		fileupload.sendKeys(filepath);
	}

	//File Download

	//Range Slider
	public static void slider(WebElement element, int x, int y) {
		act.dragAndDropBy(element, x, y).build().perform();	
	}

	//Drag and Drop
	public static void dragAndDrop(WebElement source, WebElement target) {
		act.dragAndDrop(source, target).build().perform();
	}

	//Mouse hover
	public static void mouseHover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

}