// Display Null and Other Domain Url's compare to BaseUrl

package com.autoprac.links;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherDomain {
	
	@Test
	public static void main(String[] args) {

		//Initiate Base Url to compare and Check 
		String BaseUrl = "http://sample.com/";
		String url = "";

		//Set & Open Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Open Page that need to check
		driver.get("http://automationpractice.com/index.php");

		//collect all the links in the Web Page
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

			//Check URL belong to same domain or not
			if(!url.startsWith(BaseUrl)){
				System.out.println(url);
				continue;
			}
		}

		System.out.println("\n Checking the Links Complated");
		driver.close();
	}
}
