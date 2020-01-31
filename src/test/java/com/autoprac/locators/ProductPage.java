package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.common.Base;

public class ProductPage extends Base{
	
	public ProductPage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "list")
	WebElement list;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[1]")
	WebElement addtocart;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement popupcheckout;
	
	@FindBy(linkText = "Proceed to checkout")
	WebElement proceedtocheckout;
	
	@FindBy(id = "uniform-cgv")
	WebElement termconditions;
	
	
	
	public WebElement list() {
		return list;}
	
	public WebElement addtocart() {
		return addtocart;}
	
	public WebElement popupcheckout() {
		return popupcheckout;}
	
	public WebElement proceedtocheckout() {
		return proceedtocheckout;}
	
	public WebElement termconditions() {
		return termconditions;}
}
