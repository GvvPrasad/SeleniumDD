package com.autoprac.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;
import com.autoprac.locators.LoginPage;

@Listeners(com.autoprac.listeners.TestNGListener.class)
public class Login extends Base{

	//SignUrl
	String loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";


	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.browserSetUp();
		Base.htmlReports();
		ExcelUtil.getExcel();
	}


	@Test(dataProvider = "getData")
	public void signIn(String email, String password) throws IOException {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

		driver.navigate().to(loginUrl);
		
			//Email
			lp.email().clear();
			lp.email().sendKeys(email);

			//Password
			lp.password().clear();
			lp.password().sendKeys(password);

			//Submit
			lp.submitlogin().click();
			log.info("Login Details are old:  " + email, password);
			
			//Verify
			String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
			String actualUrl = driver.getCurrentUrl();

			if (expectedUrl.equals(actualUrl)) {
				lp.logout().click();
			}
		}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		Object[][] data = loginTestData();
		return data;
	}
	
	
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getSheet(1);
		return ExcelUtil.getData();
	}


	@AfterSuite
	public void afterSuite() throws Exception {
		Base.driverclose();
	}
}
