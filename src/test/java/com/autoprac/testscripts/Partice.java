package com.autoprac.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.autoprac.base.Base;
import com.autoprac.common.CommomMethods;
import com.autoprac.config.ObjectRespo;
import com.autoprac.utilities.ExcelUtil;

public class Partice extends Base{
	
	@Test
	public static void tab() throws Exception {
		String message = "hello";
		
		ExcelUtil.getExcel(ObjectRespo.testLinks);
		ExcelUtil.getSheet(0);
		ExcelUtil.writeIntoExcel(ObjectRespo.testLinks, message);
		setup = extent.createTest("Testcase");
		CommomMethods.visiablePageScreenShot();
		CommomMethods.waitTime();
		setup.fail("test pass").addScreencastFromPath("D:\\workspace\\javaSeleniumFramework\\ScreenShots\\null_2020-08-17-17-55-40.png");
		assertEquals(ObjectRespo.url, "abc.com");
		
		
		
		
	}
}
