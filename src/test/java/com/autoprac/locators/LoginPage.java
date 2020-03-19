package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.common.Base;

public class LoginPage extends Base{

	public LoginPage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement submit;

	@FindBy(className = "logout")
	WebElement logout;

	public void setEmail(String useremail) {
		email.sendKeys(useremail);
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
