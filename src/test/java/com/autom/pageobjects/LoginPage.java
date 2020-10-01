package com.autom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autom.base.Base;

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

	//Login
	public void login(String useremail, String pwd) {
		name.sendKeys(useremail);
		password.sendKeys(pwd);
		submit.click();
	}
	
	//Logout
	public void logout() {
		logout.click();
	}
}