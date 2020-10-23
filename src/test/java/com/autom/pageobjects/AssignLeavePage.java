package com.autom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.autom.base.Base;
import com.autom.utilities.BrowserUtil;

public class AssignLeavePage extends Base{
	
	public AssignLeavePage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leavemodule;
	
	@FindBy(id = "menu_leave_assignLeave")
	WebElement assignleave;
	
	@FindBy(id = "employee_value")
	WebElement empname;
	
	@FindBy(id = "select-options-753a8406-db51-be8f-c802-2c053dfcf4b4")
	WebElement leavetype;
	
	@FindBy(id = "from")
	WebElement leavestartdate;
	
	@FindBy(id = "to")
	WebElement leaveenddate;
	
	@FindBy(xpath = "//*[@id=\"applyLeaveForm\"]/div[2]/div/button")
	WebElement leaveassign;
	
	
	public void openLeaveAssignPage() {
		leavemodule.click();
		assignleave.click();
	}
	
	public void assignLeave(String name, String leavetypevalue, String startdate, String enddate) {
		empname.sendKeys(name);
		
		Select dropdown = new Select(leavetype);
		dropdown.selectByVisibleText(leavetypevalue);
		
		leavestartdate.sendKeys(startdate);
		leaveenddate.sendKeys(enddate);
		
		BrowserUtil.scrollToBottom();
		leaveassign.click();
	}
}
