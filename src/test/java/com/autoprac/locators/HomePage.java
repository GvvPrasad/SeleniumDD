package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.common.Base;

public class HomePage extends Base{
		
	public HomePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id ="contact-link")
	WebElement contactus;
	
	@FindBy(xpath ="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
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
