package com.autoprac.links;

//Links whose Response code >=400 are consider as Broken links
//If anchor tag is empty, it displays as null   
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autoprac.config.ObjectRespo;
import com.autoprac.testscripts.Base;
import com.autoprac.utilities.ExcelUtil;


public class Url404 extends Base{


	@Test(dataProvider = "linksData")
	public static void get404Links(String pageUrl) {
		//Initiate Variables
		String url = "";
		HttpURLConnection huc = null;
		int respCode;

		driver.navigate().to(pageUrl);     

		//collect all the links of the Web Page
		List <WebElement> links = driver.findElements(By.tagName("a"));
		Iterator <WebElement> it = links.iterator();

		while(it.hasNext()){
			//Get the href Value of anchor tag
			url = it.next().getAttribute("href");

			//Check if URL is empty or not
			if(url == null || url.isEmpty()){
				continue;
			}

			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();

				//Get Response Code
				respCode = huc.getResponseCode();

				//Check Response Code
				if(respCode >= 404){
					System.out.println(url);
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}         
		}
	}


	@DataProvider
	public Object[][] linksData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testLinks);
		ExcelUtil.getSheet(0);
		return ExcelUtil.getData();
	}
}