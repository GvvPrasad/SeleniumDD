package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.base.Base;

public class LoginPage extends Base{

	public LoginPage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "txtUsername")
	WebElement name;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement submit;

	@FindBy(className = "logout")
	WebElement logout;

	public void setEmail(String useremail) {
		name.sendKeys(useremail);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public void clickLogout() {
		logout.click();
	}

}
