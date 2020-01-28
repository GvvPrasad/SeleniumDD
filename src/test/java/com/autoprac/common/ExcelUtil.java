package com.autoprac.common;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static String ProjectPath = System.getProperty("user.dir");
	static String FilePath = ProjectPath+"//DataFiles//TestData.xlsx";
	public static XSSFWorkbook WBfile;
	public static XSSFSheet Sfile;
	public static XSSFRow row;
	public static XSSFCell cell;


	public static void readExcel() throws IOException {
		FileInputStream testdatafile = new FileInputStream(FilePath);
		WBfile = new XSSFWorkbook(testdatafile);
	}

}


