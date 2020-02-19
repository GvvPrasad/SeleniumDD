package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.common.Base;

public class HomePage extends Base{

	public HomePage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "header_logo")
	WebElement logo;

	@FindBy(id ="contact-link")
	WebElement contactbtn;

	@FindBy(className = "login")
	WebElement signinbtn;

	@FindBy(id ="search_query_top")
	WebElement searchbox;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement women;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tshirts;

	public WebElement logo() {
		return logo;}

	public WebElement contactbtn() {
		return contactbtn;}

	public WebElement signinbtn() {
		return signinbtn;}

	public WebElement searchbox() {
		return searchbox;}

	public WebElement women() {
		return women;}

	public WebElement tshirts() {
		return tshirts;}

}
