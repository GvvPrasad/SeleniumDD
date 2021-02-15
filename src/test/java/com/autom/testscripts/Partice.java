package com.autom.testscripts;

import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.autom.utilities.ExcelUtil;

@Listeners(com.autom.listeners.TestNGListener.class)
public class Partice extends Base{
	
	@Test(dataProvider = "loginTestData")
	public static void writeintoexcel(String testid, String testcase, String useremail, String pwd) throws IOException {
		
		ExcelUtil.getExcel(ObjectRespo.testResults);
		ExcelUtil.getSheet(0);
		
		int rowCount = ExcelUtil.getRowCount();
		int colCount = ExcelUtil.getColumnCount();
		
		for (int i = 1; i < rowCount; i++) {
			sh.createRow(i).createCell(0).setCellValue(testid);
			//sh.createRow(i).createCell(1).setCellValue(testcase);
		}
		FileOutputStream fileOutput = new FileOutputStream(ObjectRespo.testResults);
		wb.write(fileOutput);
		wb.close();
			
	}


	@DataProvider
	public Object[][] loginTestData() throws IOException{
		ExcelUtil.getExcel(ObjectRespo.testData);
		ExcelUtil.getSheet(0);		
		return ExcelUtil.getData();
	}

}
