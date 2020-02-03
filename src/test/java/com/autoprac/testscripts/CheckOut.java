package com.autoprac.testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.CommomMethods;
import com.autoprac.locators.HomePage;
import com.autoprac.locators.LoginPage;
import com.autoprac.locators.CheckOutPage;

public class CheckOut extends Base{

	//Variables
	public static String emailid;
	public static String password;
	String parentWindowHandler;
	String subWindowHandler;


	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.browserSetUp();
		Base.htmlReports();
	}

	
	@Test(priority = 1)
	public void selectProduct() throws InterruptedException {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.tshirts().click();
	}

	
	@Test(priority = 2)
	public void addToCart() throws Exception {
		CheckOutPage cop = PageFactory.initElements(driver, CheckOutPage.class);
		
		CommomMethods.scrollTillElement(cop.list());
		cop.list().click();
		cop.addtocart().click();

		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		
		CommomMethods.waitTime();
		
		cop.popupcheckout().click();
		cop.proceedtocheckout().click();
	}

	
	@Test(priority = 3)
	public void signIn() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.email().sendKeys(emailid);
		lp.password().sendKeys(password);
		lp.submitlogin().click();
	}

	
	@Test(priority = 4)
	public void checkOut() throws Exception {
		CheckOutPage cop = PageFactory.initElements(driver, CheckOutPage.class);
		cop.addresscheckout().click();
		cop.termconditions().click();
		
		CommomMethods.scrollTillElement(cop.shippingcheckout());
		
		cop.shippingcheckout().click();
		
		cop.payment().click();
		cop.confirmorder().click();
	}
	
	
	@Test(priority = 5)
	public void checkoutVerification() {
		
	}
	
	@AfterSuite
	public void afterSuite() {
		Base.driverclose();
	}
}
