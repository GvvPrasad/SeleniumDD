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
	static int sheetindex ;


	public static void readExcel() throws IOException {

		try {
			FileInputStream testdatafile = new FileInputStream(filePath);
			wbFile = new XSSFWorkbook(testdatafile);
		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	private static int getRowCount(int sheetindex) {
		sFile = wbFile.getSheetAt(sheetindex);
		int rowCount = sFile.getLastRowNum()+1;
		return rowCount;
	}

	public static int getColumnCount(int sheetindex){
		sFile = wbFile.getSheetAt(sheetindex);
		row = sFile.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}


}


