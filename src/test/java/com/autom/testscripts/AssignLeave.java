package com.autom.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.autom.pageobjects.AssignLeavePage;
import com.autom.utilities.ExcelUtil;
import com.aventstack.extentreports.ExtentTest;

@Listeners(com.autom.listeners.TestNGListener.class)
public class AssignLeave extends Base{
	
	@Test(dataProvider = "leaveassignTestData")
	public void assignLeave(String testid, String testcase, String name, String leavetypevalue, String startdate, String enddate) {
		
		AssignLeavePage alp = PageFactory.initElements(driver, AssignLeavePage.class);
		ExtentTest test = extent.createTest("Assign Leave");
		
		alp.openLeaveAssignPage();
		logger.info("Leave assign page opened");
		
		alp.assignLeave(name, leavetypevalue, startdate, enddate);
		logger.info("Leave assigned to employee");
		test.info("Leave asssigned success");
	}
	
	@DataProvider
	public Object[][] leaveassignTestData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testData);
		ExcelUtil.getSheet(2);		
		return ExcelUtil.getData();
	}

}
