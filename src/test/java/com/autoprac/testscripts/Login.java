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
	static String loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	protected static String filePath = projectPath+"//testDataFiles//TestData.xlsx";


	@BeforeSuite
	public static void beforeSuite() throws IOException {
		Base.browserSetUp();
		Base.htmlReports();
		ExcelUtil.getExcel(filePath);
	}


	@Test(dataProvider = "loginTestData")
	public static void signIn(String email, String password) throws IOException, InterruptedException {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

		driver.navigate().to(loginUrl);

		//Email
		lp.email().sendKeys(email);

		//Password
		lp.password().sendKeys(password);

		//Submit
		lp.submitlogin().click();
		log.info("Login Details are: " + email + " - " + password);

		//Verify
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		String actualUrl = driver.getCurrentUrl();
		String loginmessage;

		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			loginmessage = "pass";
			lp.logout().click();
		}else {
			loginmessage ="fail";
		}
		
		System.out.println(email + "-" + password + "-" + loginmessage);
	}


	@DataProvider
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getSheet(0);
		return ExcelUtil.getData();
	}


	@AfterSuite
	public void afterSuite() throws Exception {
		Base.driverclose();
	}
}
