package com.autoprac.common;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil extends Base{

	static String filePath = projectPath+"//DataFiles//TestData.xlsx";
	public static XSSFWorkbook wbFile;
	public static XSSFSheet sFile;
	public static XSSFRow row;
	public static XSSFCell cell;


	public static void readExcel() throws IOException {
		FileInputStream testdatafile = new FileInputStream(filePath);
		wbFile = new XSSFWorkbook(testdatafile);
	}

}


