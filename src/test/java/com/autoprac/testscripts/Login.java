package com.autoprac.testscripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;
import com.autoprac.locators.LoginPage;

@Listeners(com.autoprac.listeners.TestNGListener.class)
public class Login extends Base{

	//SignUrl
	String loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	Logger log =(Logger) LogManager.getLogger(Login.class);
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.browserSetUp();
		Base.htmlReports();
		ExcelUtil.getExcel();
	}


	@Test
	public void signIn() throws IOException {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

		driver.navigate().to(loginUrl);
		ExcelUtil.getSheet(1);

		for(int i=1; i<= ExcelUtil.shFile.getLastRowNum(); i++) {

			//Email
			lp.email().clear();
			String email = ExcelUtil.setCellDataToString(i, 0);
			lp.email().sendKeys(email);
			log.info("email sent");

			//Password
			lp.password().clear();
			String password = ExcelUtil.setCellDataToString(i, 1);
			lp.password().sendKeys(password);
			log.info("password sent");

			//Submit
			lp.submitlogin().click();

			String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
			String actualUrl = driver.getCurrentUrl();

			if (expectedUrl.equals(actualUrl)) {
				lp.logout().click();
			}
		}
	}


	@AfterSuite
	public void afterSuite() {
		Base.driverclose();
	}
}
