package com.autom.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.autom.pageobjects.LoginPage;
import com.autom.utilities.ExcelUtil;

@Listeners(com.autom.listeners.TestNGListener.class)
public class Login extends Base{

	@Test(priority = 1, dataProvider = "loginTestData")
	public static void signIn(String testid, String testcase, String useremail, String pwd) throws IOException, InterruptedException {

		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		extentTest = extent.createTest(testid +":  " + testcase);

		lp.login(useremail, pwd);
		logger.info("Entered login details "+useremail +"  " +pwd);
		extentTest.info("Entered Login details");

		Assert.assertEquals(driver.getCurrentUrl().contains("dashboard"), true);
	}


	@DataProvider
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testData);
		ExcelUtil.getSheet(0);		
		return ExcelUtil.getData();
	}
}