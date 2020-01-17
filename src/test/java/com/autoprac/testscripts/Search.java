package com.autoprac.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.locators.HomePage;

public class Search extends Base{
	

	@Test
	public static void ProductSearch(){
		HomePage hp = new HomePage(driver);
		hp.searchbox().sendKeys("prasad");
		driver.findElement(By.id("sdsa"));
	}
	
}
 