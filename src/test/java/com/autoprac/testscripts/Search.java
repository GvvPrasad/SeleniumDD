package com.autoprac.testscripts;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.locators.HomePage;

public class Search extends Base{
	
	static HomePage hp = new HomePage(driver);

	@Test
	public static void ProductSearch() throws InterruptedException{
		
		hp.searchbox().sendKeys("T-shirts");
		hp.searchbox().sendKeys(Keys.ENTER);
	}
	
}
 