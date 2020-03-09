//Display All the Links in the Web Page

package com.autoprac.links;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;

public class AllLinks extends Base{

	protected static String filePath = projectPath+"//testDataFiles//TestLinks.xlsx"; 

	
	@BeforeClass
	public static void beforeClass() throws IOException {
		Base.headlessBrowserSetUp();
		ExcelUtil.getExcel(filePath);
	}

	
	@Test(dataProvider = "linksData")
	public static void getAllLinks(String pageUrl) {
		String url = "";
		driver.navigate().to(pageUrl);

		//collect all the links of the Web Page and we will store them in a list 
		List < WebElement > links = driver.findElements(By.tagName("a"));
		Iterator < WebElement > it = links.iterator();

		while (it.hasNext()) {
			//Get the href Value of anchor tag and store it in variable url
			url = it.next().getAttribute("href");
			//Display All the Links
			System.out.println(url);
		}
	}

	
	@DataProvider
	public Object[][] linksData() throws IOException{
		ExcelUtil.getSheet(0);
		return ExcelUtil.getData();
	}

	
	@AfterClass
	public void afterClass() throws Exception {
		Base.driverclose();
	}
}

