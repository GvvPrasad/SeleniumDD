package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.utilities.ExcelUtil;

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
		
		ExcelUtil.getExcel(filePath);
		ExcelUtil.getSheet(1);
		ExcelUtil.getRawValue(0, 0);
	}


	@AfterTest
	public void afterTest() throws Exception {
		//Base.driverclose();
	}

}
