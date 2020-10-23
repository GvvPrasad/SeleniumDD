package com.autom.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.autom.base.Base;
import com.autom.utilities.BrowserUtil;

public class AddEmployeePage extends Base{
	
	public AddEmployeePage(WebDriver driver) {
		Base.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "menu_pim_viewPimModule")
	WebElement pim;

	@FindBy(id = "menu_pim_addEmployee")
	WebElement addemployee;
	
	@FindBy(id = "addEmployeeButton")
	WebElement addempbtn;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "employeeId")
	WebElement employeeId;

	@FindBy(id = "location_inputfileddiv")
	WebElement location;

	@FindBy(id = "systemUserSaveBtn")
	WebElement next;

	@FindBy(xpath = "//*[@id=\"1_inputfileddiv\"]/div/input")
	WebElement bloodgroup;

	@FindBy(id = "5")
	WebElement hobbies;

	@FindBy(xpath = "//*[@id=\"wizard-nav-button-section\"]/button[2]")
	WebElement next2;

	@FindBy(id = "select-options-69c451c2-c1a1-7c53-b24d-b6efa3aa4f25")
	WebElement region;

	@FindBy(id = "select-options-efd53b31-cc72-6fe1-bc0d-b773b2189805")
	WebElement fte;

	@FindBy(id = "select-options-347bf5c4-7578-8d67-1428-d2a63ca330b0")
	WebElement depeartment;

	@FindBy(css = "#wizard-nav-button-section > button:nth-child(3)")
	WebElement save;

	//Open Add employe page
	public void openAddEmp() {
		pim.click();
		addemployee.click();
	}

	//Add Basic Details
	public void addBasic(String fname, String lname, String locationvalue) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		
		addempbtn.click();
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		Select dropdown = new Select(location);
		dropdown.selectByVisibleText(locationvalue);
		next.click();
	}

	//Add Personal details
	public void addPersonal(String bloodgroupvalue, String hobbiesvalue) {
		BrowserUtil.scrollToBottom();
		Select dropdown = new Select(bloodgroup);
		dropdown.selectByVisibleText(bloodgroupvalue);
		hobbies.sendKeys(hobbiesvalue);
		next2.click();
	}

	//Emp Details Save 
	public void empDetails(String regionvalue, String ftevalue, String depeartmentvalue) {
		BrowserUtil.scrollToBottom();
		Select dropdown = new Select(region);
		dropdown.selectByVisibleText(regionvalue);

		Select ftedropdown = new Select(fte);
		ftedropdown.selectByVisibleText(ftevalue);

		Select depdropdown = new Select(depeartment);
		depdropdown.selectByVisibleText(depeartmentvalue);
		save.click();
	}
}