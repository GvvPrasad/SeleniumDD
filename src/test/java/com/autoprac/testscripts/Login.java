package com.autoprac.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autoprac.locators.LoginPage;
import com.autoprac.utilities.ExcelUtil;

@Listeners(com.autoprac.listeners.TestNGListener.class)
public class Login extends Base{

	//Global variables
	private static String loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private static String filePath = projectPath+"//testDataFiles//TestData.xlsx";


	@Test(dataProvider = "loginTestData")
	public static void signIn(String sno, String useremail, String pwd, String result) throws IOException, InterruptedException {
		System.out.println(useremail + pwd);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);

		driver.navigate().to(loginUrl);

		lp.setEmail(useremail);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		//Verify
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		String actualUrl = driver.getCurrentUrl();
		String loginmessage;

		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			loginmessage = "pass";
			lp.clickLogout();
		}else {
			loginmessage ="fail";
		}
		
		ExcelUtil.writeIntoExcel(filePath, loginmessage);
	}


	@DataProvider
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getExcel(filePath);
		ExcelUtil.getSheet(0);
		return ExcelUtil.getData();
	}
}