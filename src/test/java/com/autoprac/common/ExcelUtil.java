package com.autoprac.common;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil extends Base{

	public static String filePath = projectPath+"//testDataFiles//TestData.xlsx";
	public static XSSFWorkbook wbFile;
	public static XSSFSheet shFile;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int sheetindex ;

	//Get Excel File
	public static void getExcel() throws IOException {
		try {
			FileInputStream testdatafile = new FileInputStream(filePath);
			wbFile = new XSSFWorkbook(testdatafile);
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}


	//Get Excel Sheet
	public static void getSheet(int sheetno) throws IOException {
		try {
			shFile = wbFile.getSheetAt(sheetno);
		} catch (Exception e) {
			System.out.println("Sheet not found");
			e.printStackTrace();
		}
	}


	//Row Count
	private static int getRowCount() {
		int rowCount=0;
		try {
			rowCount = shFile.getPhysicalNumberOfRows();
			System.out.println("No of rows : "+rowCount);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}


	//Column Count
	public static int getColumnCount(){
		int colCount=0;
		try {
			colCount = shFile.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of columns : "+colCount);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}


	//Get String Value
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = shFile.getRow(rowNum).getCell(colNum).getStringCellValue();
		}catch(Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}


	//Get Numeric Value
	public static double getCellDataNumber(int rowNum, int colNum) {
		double cellData = 0;
		try {
			cellData = shFile.getRow(rowNum).getCell(colNum).getNumericCellValue();
		}catch(Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}


	//Set data to String
	public static String setCellDataToString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = shFile.getRow(rowNum).getCell(colNum).toString();
		}catch(Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}


	//Get Date
	public static String getDateValue(int rowNum, int colNum) {
		String dateValue = null;
		try {
			DataFormatter dataFormatter = new DataFormatter();
			if (HSSFDateUtil.isCellDateFormatted(shFile.getRow(rowNum).getCell(colNum))) {
				dateValue = dataFormatter.formatCellValue((Cell) shFile.getRow(rowNum).getCell(colNum).getDateCellValue());
			}
		} catch (Exception exp) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return dateValue;
	}
}