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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Url404 {

	//Main Method 
	public static void main(String[] args) {

		//Initiate Variables
		String url = "";
		HttpURLConnection huc = null;
		int respCode;

		//Set & Open Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Set Web Page that need to check
		driver.get("http://automationpractice.com/index.php");     


		//collect all the links of the Web Page
		List <WebElement> links = driver.findElements(By.tagName("a"));
		Iterator <WebElement> it = links.iterator();

		// Display Total no of links
		System.out.println("Total links are "+links.size());

		while(it.hasNext()){
			//Get the href Value of anchor tag
			url = it.next().getAttribute("href");

			//Check if URL is empty or not
			if(url == null || url.isEmpty()){
				System.out.println(url);
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

		System.out.println("\n Checking the Links Complated");
		driver.close();
	}
}