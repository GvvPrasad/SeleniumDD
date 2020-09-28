package com.autoprac.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.autoprac.base.Base;
import com.autoprac.config.ObjectRespo;

public class ExcelUtil extends Base{

	//Get Excel File
	public static void getExcel(String filePath) throws IOException {
		try {
			dataFile = new FileInputStream(filePath);
			wb = new XSSFWorkbook(dataFile);
		} catch (Exception e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	//Get Excel Sheet
	public static void getSheet(int sheetno) throws IOException {
		try {
			sh = wb.getSheetAt(sheetno);
		} catch (Exception e) {
			System.out.println("Sheet not found");
			e.printStackTrace();
		}
	}

	//Row Count
	public static int getRowCount() {
		int rowCount = 0; 
		try {
			rowCount = sh.getLastRowNum()+1;
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
			colCount = sh.getRow(0).getLastCellNum();
		}catch(Exception e) {
			System.out.println("Did not get Columns");
			e.printStackTrace();
		}
		return colCount;
	}

	//Get Specific cell value RAW
	public static Object getRawValue(int rowNum, int colNum) {
		Object cellData = sh.getRow(rowNum).getCell(colNum).getRawValue();
		return cellData;
	}

	//Get String Value
	public static String getStringValue(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
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
			cellData = sh.getRow(rowNum).getCell(colNum).getNumericCellValue();
		}catch(Exception e) {
			System.out.println("Data not found");
			e.printStackTrace();
		}
		return cellData;
	}

	//Get Date Value
	public static void getDateValue() {}

	//Change cell values to String
	public static String setCellDataToString(int rowNum, int colNum) {
		XSSFCell cell = null;
		String cellData = null;
		try {
			cell = sh.getRow(rowNum).getCell(colNum);
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
			for(int j=2; j<colCount; j++)
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

	//Create Excel File
	public static void createExcelFile() throws IOException{}

	//Create Sheet
	//Create Row
	//Create Column
	//Write into Excel
}