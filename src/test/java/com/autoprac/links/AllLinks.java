//Display All the Links in the Web Page

package com.autoprac.links;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks {

	
	public static void main(String[] args) {

		//Page Url
		String PagUrl = "http://automationpractice.com/index.php";
		String url = "";

		//Set & Open Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(PagUrl);

		//collect all the links of the Web Page and we will store them in a list 
		List < WebElement > links = driver.findElements(By.tagName("a"));
		Iterator < WebElement > it = links.iterator();

		// Display Total no of links
		System.out.println("Total links are " + links.size());

		while (it.hasNext()) {
			//Get the href Value of anchor tag and store it in variable url
			url = it.next().getAttribute("href");
			//Display All the Links
			System.out.println(url);
		}

		//End of Program
		System.out.println("\n Checking the Links Complated");
		driver.close();
	}
	//End of Main Method
}