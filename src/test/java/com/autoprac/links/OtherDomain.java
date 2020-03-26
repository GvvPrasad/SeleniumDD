// Display Other Domain Url's compare to BaseUrl

package com.autoprac.links;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.utilities.ExcelUtil;


public class OtherDomain extends Base{

	private static String filePath = projectPath+"//testDataFiles//TestLinks.xlsx"; 


	@BeforeTest
	public static void beforeClass() throws IOException {
		Base.headlessBrowserSetUp();
		ExcelUtil.getExcel(filePath);
	}


	@Test(dataProvider = "linksData")
	public static void getOtherDomainLinks(String BaseUrl, String pageUrl) {
		String url = "";
		driver.navigate().to(pageUrl);

		//collect all the links in the Web Page
		List <WebElement> links = driver.findElements(By.tagName("a"));
		Iterator <WebElement> it = links.iterator();

		while(it.hasNext()){
			//Get the href Value of anchor tag
			url = it.next().getAttribute("href");

			//Check if URL is empty or not
			if(url == null || url.isEmpty()){
				continue;
			}

			//Check URL belong to same domain or not
			if(!url.startsWith(BaseUrl)){
				System.out.println(url);
				continue;
			}
		}
	}


	@DataProvider
	public Object[][] linksData() throws IOException{
		ExcelUtil.getSheet(1);
		return ExcelUtil.getData();
	}


	@AfterTest
	public void afterClass() throws Exception {
		Base.tearDown();
	}
}