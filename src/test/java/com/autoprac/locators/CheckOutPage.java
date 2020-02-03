package com.autoprac.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.common.Base;

public class CheckOutPage extends Base{
	
	public CheckOutPage(WebDriver driver) {
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
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
	WebElement addresscheckout;
	
	@FindBy(id = "uniform-cgv")
	WebElement termconditions;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement shippingcheckout;
	
	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p")
	WebElement payment;
	
	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
	WebElement confirmorder;
	
	@FindBy(className = "cart_navigation exclusive")
	WebElement backtoorders;
	
	public WebElement list() {
		return list;}
	
	public WebElement addtocart() {
		return addtocart;}
	
	public WebElement popupcheckout() {
		return popupcheckout;}
	
	public WebElement proceedtocheckout() {
		return proceedtocheckout;}
	
	public WebElement addresscheckout() {
		return addresscheckout;}
	
	public WebElement termconditions() {
		return termconditions;}
	
	public WebElement shippingcheckout() {
		return shippingcheckout;}
	
	public WebElement payment() {
		return payment;}
	
	public WebElement confirmorder() {
		return confirmorder;}
	
	public WebElement backtoorders() {
		return backtoorders;}
}
