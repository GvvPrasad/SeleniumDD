package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import org.testng.annotations.AfterTest;

public class Partice extends Base{
	
	protected static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";
	
	@BeforeTest
	public void beforeTest() throws IOException {
		//Base.headlessBrowserSetUp();
	}


	@Test
	public void sample() throws InterruptedException, IOException {	
		String message = "pass";
		ExcelUtil.getExcel(filePath);
		ExcelUtil.getSheet(1);
		ExcelUtil.writeIntoExcel(message, filePath);
	}


	@AfterTest
	public void afterTest() throws Exception {
		//Base.driverclose();
	}

}
