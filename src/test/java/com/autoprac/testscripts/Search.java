package com.autoprac.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.locators.HomePage;

public class Search {
	
	static WebDriver driver;

	@Test
	public static void ProductSearch() {
		Base base = new Base();
		Base.BrowserSetUp();
		
		HomePage hp = new HomePage(driver);
		hp.searchbox();
		System.out.println(hp.searchbox());
		
	}
	
}
 