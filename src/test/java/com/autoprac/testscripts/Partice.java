package com.autoprac.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.autoprac.base.Base;
import com.autoprac.common.CommomMethods;
import com.autoprac.config.ObjectRespo;
import com.aventstack.extentreports.ExtentTest;

public class Partice extends Base{
	
	@Test
	public static void tab() throws Exception {
		
		ExtentTest test = extent.createTest("paratice");
		CommomMethods.visiablePageScreenShot();
		CommomMethods.waitTime();
		test.fail("test pass").addScreenCaptureFromPath("D:\\workspace\\javaSeleniumFramework\\ScreenShots\\null_2020-08-17-17-55-40.png");
		assertEquals(ObjectRespo.url, "abc.com");
	}
}
