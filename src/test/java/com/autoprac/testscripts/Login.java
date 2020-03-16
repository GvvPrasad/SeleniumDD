package com.autoprac.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.locators.LoginPage;
import com.autoprac.utilities.ExcelUtil;

@Listeners(com.autoprac.listeners.TestNGListener.class)
public class Login extends Base{

	//SignUrl
	static String loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	protected static String filePath = projectPath+"//testDataFiles//TestData.xlsx";


	@BeforeSuite
	public static void beforeSuite() throws IOException {
		Base.browserSetUp();
		ExcelUtil.getExcel(filePath);
	}


	@Test(dataProvider = "loginTestData")
	public static void signIn(String email, String password, String result) throws IOException, InterruptedException {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

		driver.navigate().to(loginUrl);

		lp.email().sendKeys(email);
		lp.password().sendKeys(password); 
		lp.submitlogin().click();
		
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
		
		ExcelUtil.writeIntoExcel(filePath, loginmessage);
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
