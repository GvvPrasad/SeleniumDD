package com.autoprac.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.autoprac.base.Base;
import com.autoprac.common.CommomMethods;
import com.autoprac.config.ObjectRespo;
import com.autoprac.utilities.ExcelUtil;
import com.aventstack.extentreports.ExtentTest;

public class Partice extends Base{
	
	@Test
	public static void tab() throws Exception {
		String message = "hello";
		
		ExcelUtil.getExcel(ObjectRespo.testLinks);
		ExcelUtil.getSheet(0);
		ExcelUtil.writeIntoExcel(ObjectRespo.testLinks, message);
		test = extent.createTest("paratice");
		CommomMethods.visiablePageScreenShot();
		CommomMethods.waitTime();
		 test.log(LogStatus.PASS, "Test Passed");
		setup.fail("test pass").addScreenCapture("D:\\workspace\\javaSeleniumFramework\\ScreenShots\\null_2020-08-17-17-55-40.png");
		assertEquals(ObjectRespo.url, "abc.com");
		
		
		
		
	}
}
