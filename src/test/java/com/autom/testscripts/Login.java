package com.autom.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.autom.pageobjects.LoginPage;
import com.autom.utilities.ExcelUtil;

@Listeners(com.autom.listeners.TestNGListener.class)
public class Login extends Base{
	
	@Test(dataProvider = "loginTestData")
	public static void signIn(String no, String useremail, String pwd) throws IOException, InterruptedException {
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		lp.login(useremail, pwd);
		log.info("Login completed");
	}

	@DataProvider
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testData);
		ExcelUtil.getSheet(0);		
		return ExcelUtil.getData();
	}
}