package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.Base;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterSuite;

@Listeners(com.autoprac.common.Listener.class)
public class TestSuit extends Base{

	@BeforeSuite
	public void beforeSuite() {
		Base.BrowserSetUp();
	}

	
	@Test(priority = 1)
	public void searchProduct() throws InterruptedException {
		Search.ProductSearch();
	}
	
	@Test(enabled=false)
	public void loginPage() throws InterruptedException {
		Login.SingIn();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
