package com.autoprac.testscripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.locators.HomePage;
import com.autoprac.locators.LoginPage;

public class Login extends Base{
	
	private static Logger log = LogManager.getLogger(Login.class.getName());
	static HomePage hp = new HomePage(driver);
	static LoginPage lp = new LoginPage(driver);
	static Base bs = new Base();
	
	@Test
	public static void SingIn() throws InterruptedException{
		
		hp.login().click();
		Thread.sleep(3000);
		
		lp.email().sendKeys("jack@yopmail.com");
		log.error("email enter");
		lp.password().sendKeys("123456");
		log.info("password enter");
		lp.submit().click();
		log.debug("submit clicked");
	}
	
	
}
