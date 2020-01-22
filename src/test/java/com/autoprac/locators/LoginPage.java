package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.common.Base;

public class LoginPage extends Base{
	
	public LoginPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "passwd")
	WebElement passwd;
	
	@FindBy(id = "SubmitLogin")
	WebElement SubmitLogin;
	
	
	
	public WebElement email() {
		return email;
	}
	
	public WebElement password() {
		return passwd;
	}
	
	public WebElement submit() {
		return SubmitLogin;
	}

}
