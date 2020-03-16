package com.autoprac.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.autoprac.common.Base;


public class ExcelUtil extends Base{
	
	//Global Variables
	public static XSSFWorkbook wbFile;
	public static XSSFSheet shFile;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream datafile;
	public static FileOutputStream fileOut;


	//Get Excel File
	public static void getExcel(String filePath) throws IOException {
		try {
			datafile = new FileInputStream(filePath);
			wbFile = new XSSFWorkbook(datafile);
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
	public static int getRowCount() {
		int rowCount = 0; 
		try {
			rowCount = shFile.getLastRowNum()+1;
		}catch(Exception e) {
			System.out.println("Did not get Rows");
			e.printStackTrace();
		}
		return rowCount;
	}


	//Column Count
	public static int getColumnCount(){
		int colCount=0;
		try {
			colCount = shFile.getRow(0).getLastCellNum();
		}catch(Exception e) {
			System.out.println("Did not get Columns");
			e.printStackTrace();
		}
		return colCount;
	}


	//Get String Value
	public static String getStringValue(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = shFile.getRow(rowNum).getCell(colNum).getStringCellValue();
		}catch(Exception e) {
			System.out.println("Data not found");
			e.printStackTrace();
		}
		return cellData;
	}


	//Get Numeric Value
	public static double getNumericValue(int rowNum, int colNum) {
		double cellData = 0;
		try {
			cellData = shFile.getRow(rowNum).getCell(colNum).getNumericCellValue();
		}catch(Exception e) {
			System.out.println("Data not found");
			e.printStackTrace();
		}
		return cellData;
	}


	//Get raw value
	public static Object getRawValue(int rowNum, int colNum) {
		Object cellData = shFile.getRow(rowNum).getCell(colNum).getRawValue();
		return cellData;
	}


	//Get Date Value
	public static String getDateValue(int rowNum, int colNum) {
		XSSFCell cellData;
		Date date = null;
		String datevalue = null;
		try {
			cellData = shFile.getRow(rowNum).getCell(colNum);
			if (HSSFDateUtil.isCellDateFormatted(cellData)) {
				date = cellData.getDateCellValue();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				datevalue = formatter.format(date);
				return datevalue;
			}else {
				System.out.println("Not a Date Value");
			}
		} catch (Exception e) {
			System.out.println("Not a Date Value");
		}
		return datevalue;
	}


	//Change data to String
	public static String setCellDataToString(int rowNum, int colNum) {
		XSSFCell cell = null;
		String cellData = null;
		try {
			cell = shFile.getRow(rowNum).getCell(colNum);
			cell.setCellType(CellType.STRING);
			cellData = cell.getStringCellValue();
		}catch(Exception e) {
			System.out.println("Data not found");
			e.printStackTrace();
		}
		return cellData;
	}


	//DataProvider from Excel
	public static Object[][] getData() throws IOException{

		int rowCount = ExcelUtil.getRowCount();
		int colCount = ExcelUtil.getColumnCount();

		Object[][] data = new Object[rowCount-1][colCount];

		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				//Check cell is empty or not
				if (data[i-1][j] == null) {
					data[i-1][j] = "";
				}

				//Check if cell has DATE vale or not


				//change values to string
				data[i-1][j] = ExcelUtil.setCellDataToString(i, j);
			}
		}
		return data;
	}


	//Create Sheet
	public static int createSheet() throws IOException {
		XSSFSheet newSheet = wbFile.createSheet();
		String shName = newSheet.getSheetName();
		int newSheetno = wbFile.getSheetIndex(shName);
		return newSheetno;
	}


	//Create Row
	public static void createRow() {
		int rowCount = ExcelUtil.getRowCount();
		try {
			if (rowCount <= 0) {
				shFile.createRow(0);
			}
			shFile.createRow(rowCount);
		} catch (Exception e) {
			System.out.println("New Row did not ccreated");
		}
	}


	//Create Column
	public static void createColumn() {
		int rowCount = ExcelUtil.getRowCount();
		int colCount = ExcelUtil.getColumnCount();

		try {
			for (int i = 0; i < rowCount; i++) {
				shFile.getRow(i).createCell(colCount);
			}
		} catch (Exception e) {
			System.out.println("New Column did not ccreated");
		}
	}


	//Write into Excel
	public static void writeIntoExcel(String filePath, String dataToWrite) throws IOException {
		int rowCount = ExcelUtil.getRowCount();
		int colCount = ExcelUtil.getColumnCount();

		try {
			for (int i = 1; i <= rowCount; i++) {
				shFile.getRow(i).createCell(colCount-1).setCellValue(dataToWrite); 
				fileOut = new FileOutputStream(filePath);
				wbFile.write(fileOut);
				fileOut.close();
			}
		} catch (Exception e) {
			System.out.println("Data is not entered into excel");
		}
	}
}