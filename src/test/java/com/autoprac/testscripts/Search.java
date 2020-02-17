package com.autoprac.testscripts;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;
import com.autoprac.locators.HomePage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;

@Listeners(com.autoprac.listeners.TestNGListener.class)
public class Search extends Base{

	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.browserSetUp();
		Base.htmlReports();
		ExcelUtil.getExcel();
	}


	@Test
	public void searchProduct() throws IOException {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);

		ExcelUtil.getSheet(0);
		String value = ExcelUtil.getCellDataString(0, 0);
		hp.searchbox().sendKeys(value);
		hp.searchbox().sendKeys(Keys.RETURN);
	}


	@AfterSuite
	public void afterSuite() {
		Base.driverclose();
	}

}
