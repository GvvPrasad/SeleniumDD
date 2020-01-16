package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage{
	
	public static WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id ="contact-link")
	WebElement contactus;
	
	@FindBy(xpath ="/a[@class='login']")
	WebElement login;
	
	@FindBy(id ="search_query_top")
	WebElement searchbox;
	

	public WebElement contactus() {
		return contactus;}
	
	public WebElement login() {
		return login;}
	

	public WebElement searchbox() {
		return searchbox;}
	
	
}
