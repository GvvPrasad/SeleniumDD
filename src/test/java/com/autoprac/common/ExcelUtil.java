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
	public static XSSFSheet shFile;
	public static XSSFRow row;
	public static XSSFCell cell;
	static int sheetindex ;


	public static void readExcel() throws IOException {

		try {
			FileInputStream testdatafile = new FileInputStream(filePath);
			wbFile = new XSSFWorkbook(testdatafile);
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	private static int getRowCount(int sheetindex) {
		shFile = wbFile.getSheetAt(sheetindex);
		int rowCount = shFile.getLastRowNum()+1;
		System.out.println("No of rows : "+rowCount);
		return rowCount;
	}

	public static int getColumnCount(int sheetindex){
		shFile = wbFile.getSheetAt(sheetindex);
		row = shFile.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("No of Columns : "+colCount);
		return colCount;
	}
	
	
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData=null;
		try {
			
			cellData = shFile.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
	
	
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			
			double cellData = shFile.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}


