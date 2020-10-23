package com.autom.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.autom.base.Base;

public class LeaveListPage extends Base{
	
	public LeaveListPage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leavemodule;
	
	@FindBy(id = "menu_leave_viewLeaveList")
	WebElement leavelist;
	
	@FindBy(id = "from")
	WebElement leavestartdate;
	
	@FindBy(id = "to")
	WebElement leaveenddate;
	
	@FindBy(id = "selectedEmployee_value")
	WebElement emplyoename;
	
	@FindBy(id = "select-options-31b81e83-c4f7-e39f-ff4e-8d7afdda5c1e")
	WebElement leavetype;
	
	@FindBy(id = "statusAll")
	WebElement allstatus;
	
	@FindBy(id = "//*[@id=\"searchLeaveList\"]/div[2]/div/button")
	WebElement search;
	
	@FindBy(id = "select-options-13314451-f9e2-e10d-24c0-129fa5453d5d")
	WebElement leaveaction;
	
	
	
	public void openLeaveList() {
		leavemodule.click();
		leavelist.click();
	}
	
	public void searchLeave(String startdate, String enddate, String empname, String leavetypevalue) {
		leavestartdate.sendKeys(startdate);
		leaveenddate.sendKeys(enddate);
		emplyoename.sendKeys(empname);
		Select dropdown = new Select(leavetype);
		dropdown.selectByVisibleText(leavetypevalue);
		allstatus.click();
		search.click();
	}
	
	public void cancleLeave(String leaveactionvalue) {
		Select dropdown = new Select(leaveaction);
		dropdown.selectByVisibleText(leaveactionvalue);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}
}
