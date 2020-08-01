package com.autoprac.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autoprac.config.ObjectRespo;
import com.autoprac.locators.LoginPage;
import com.autoprac.utilities.ExcelUtil;

@Listeners(com.autoprac.listeners.TestNGListener.class)
public class Login extends Base{

	
	@Test(dataProvider = "loginTestData")
	public static void signIn(String no, String useremail, String pwd) throws IOException, InterruptedException {
		System.out.println(useremail + pwd);
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		log.info("Entering user name");
		lp.setEmail(useremail);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		//Verify
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualUrl = driver.getCurrentUrl();
		String loginmessage;

		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			loginmessage = "pass";
			lp.clickLogout();
		}else {
			loginmessage ="fail";
		}
		log.info("before writing into ecel");
		ExcelUtil.writeIntoExcel(ObjectRespo.testData, loginmessage);
		log.info("after writing into ecel");
	}


	@DataProvider
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testData);
		ExcelUtil.getSheet(0);		
		return ExcelUtil.getData();
	}
}