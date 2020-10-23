package com.autom.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.autom.pageobjects.LeaveListPage;
import com.autom.utilities.ExcelUtil;
import com.aventstack.extentreports.ExtentTest;

@Listeners(com.autom.listeners.TestNGListener.class)
public class LeaveList extends Base{
	
	public void leaveList(String testid, String testcase, String startdate, String enddate, String empname, String leavetypevalue, String leaveactionvalue) {
		LeaveListPage llp = PageFactory.initElements(driver, LeaveListPage.class);
		ExtentTest test = extent.createTest("Leave List");
		
		llp.openLeaveList();
		logger.info("Leave List Page opened");
		
		llp.searchLeave(startdate, enddate, empname, leavetypevalue);
		logger.info("Leaved Searched");
		
		llp.cancleLeave(leaveactionvalue);
		logger.info("Leave cancled");
		
		test.info("leave search and cancled");
	}
	
	@DataProvider
	public Object[][] leaveListTestData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testData);
		ExcelUtil.getSheet(3);		
		return ExcelUtil.getData();
	}
}