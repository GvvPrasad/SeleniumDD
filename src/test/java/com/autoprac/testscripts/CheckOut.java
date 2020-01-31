package com.autoprac.testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.locators.HomePage;
import com.autoprac.locators.LoginPage;
import com.autoprac.locators.ProductPage;

public class CheckOut extends Base{
	
	//Variables
	public static String emailid;
	public static String password;
	String parentWindowHandler;
	String subWindowHandler;


	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.browserSetUp();
	}
	
	@Test(priority = 1)
	public void selectProduct() throws InterruptedException {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		mouseHover(hp.tshirts());
		hp.tshirts().click();
	}
	
	@Test(priority = 2)
	public void addToCart() {
		ProductPage pp = PageFactory.initElements(driver, ProductPage.class);
		pp.list().click();
		pp.addtocart().click();
		
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		
		pp.popupcheckout().click();
		
		mouseHover(pp.proceedtocheckout());
		pp.proceedtocheckout().click();
	}
	
	@Test(priority = 3)
	public void signIn() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.email().sendKeys(emailid);
		lp.password().sendKeys(password);
		lp.submitlogin().click();
	}
	
	@Test(priority = 4)
	public void checkOut() {
		ProductPage pp = PageFactory.initElements(driver, ProductPage.class);
		mouseHover(pp.proceedtocheckout());
		pp.proceedtocheckout().click();
		
		pp.termconditions().click();
		pp.proceedtocheckout().click();
	}
	
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
	}
}
