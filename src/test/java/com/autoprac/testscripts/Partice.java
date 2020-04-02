package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.utilities.ExcelUtil;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import org.testng.annotations.AfterTest;

public class Partice{
	
	public static String projectPath = System.getProperty("user.dir");
	private static String filePath = projectPath+"//testDataFiles//TestData.xlsx";

	@Test(dataProvider = "loginTestData")
	public static void signIn(String sno, String useremail, String pwd, String result) throws IOException, InterruptedException {
		System.out.println(useremail+ "  " + pwd);
	}

	@DataProvider
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getExcel(filePath);
		ExcelUtil.getSheet(0);
		return ExcelUtil.getData();
	}
}
