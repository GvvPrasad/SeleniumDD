package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.utilities.ExcelUtil;
import com.autoprac.utilities.ReportsGeneration;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import org.testng.annotations.AfterTest;

public class Partice extends Base{
	
	private static String filePath = projectPath+"//testDataFiles//TestApis.xlsx";
	
	@BeforeTest
	public void beforeTest() throws IOException {
		//Base.headlessBrowserSetUp();
	}


	@Test
	public void sample() throws InterruptedException, IOException {	
		
		ExcelUtil.getExcel(filePath);
		ExcelUtil.getSheet(0);
		ExcelUtil.createColumn(filePath);
		
	}


	@AfterTest
	public void afterTest() throws Exception {
		//Base.driverclose();
	}

}
