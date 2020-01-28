package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.common.Base;

public class HomePage extends Base{

	@FindBy(id ="contact-link")
	WebElement contactbtn;

	@FindBy(className = "login")
	WebElement signinbtn;

	@FindBy(id ="search_query_top")
	WebElement searchbox;


	public HomePage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement contactbtn() {
		return contactbtn;}

	public WebElement signinbtn() {
		return signinbtn;}


	public WebElement searchbox() {
		return searchbox;}	
}
