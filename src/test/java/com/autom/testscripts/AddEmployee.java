package com.autom.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.autom.pageobjects.AddEmployeePage;
import com.autom.utilities.BrowserUtil;
import com.autom.utilities.CommomMethods;
import com.autom.utilities.ExcelUtil;
import com.aventstack.extentreports.ExtentTest;

@Listeners(com.autom.listeners.TestNGListener.class)
public class AddEmployee extends Base{
	
	@Test(dataProvider = "addempTestData")
	public void addEmployee(String testid, String testcase, String fname, String lname, String locationvalue, String bloodgroupvalue, String hobbiesvalue, String regionvalue, String ftevalue, String depeartmentvalue) throws InterruptedException {
		
		AddEmployeePage aep = PageFactory.initElements(driver, AddEmployeePage.class);
		ExtentTest test = extent.createTest("Add Employee");
		
		aep.openAddEmp();
		logger.info("opened employee creation page");
				
		BrowserUtil.modelPopUp();
		
		aep.addBasic(fname, lname, locationvalue);
		logger.info("Basic Details Entered");
		
		aep.addPersonal(bloodgroupvalue, hobbiesvalue);
		logger.info("Personal details entered");
		
		aep.empDetails(regionvalue, ftevalue, depeartmentvalue);
		logger.info("Employee Details Entered");
		
		test.info("Employee added");
	}
	
	@DataProvider
	public Object[][] addempTestData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testData);
		ExcelUtil.getSheet(1);		
		return ExcelUtil.getData();
	}
	
}
