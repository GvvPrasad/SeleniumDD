package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

	public WebDriver driver;


	@FindBy(id ="contact-link")
	WebElement contactbtn;

	@FindBy(className = "login")
	WebElement signinbtn;

	@FindBy(id ="search_query_top")
	WebElement searchbox;


	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement contactbtn() {
		return contactbtn;}

	public WebElement signinbtn() {
		return signinbtn;}


	public WebElement searchbox() {
		return searchbox;}	
}
