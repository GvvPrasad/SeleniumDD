package com.autoprac.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
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
			FileInputStream datafile = new FileInputStream(filePath);
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
			System.out.println("No of rows : "+rowCount);
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
			System.out.println("No of columns : "+colCount);
		}catch(Exception e) {
			System.out.println("Did not get Columns");
			e.printStackTrace();
		}
		return colCount;
	}


	//Get String Value
	public static String getCellDataString(int rowNum, int colNum) {
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
	public static double getCellDataNumber(int rowNum, int colNum) {
		double cellData = 0;
		try {
			cellData = shFile.getRow(rowNum).getCell(colNum).getNumericCellValue();
		}catch(Exception e) {
			System.out.println("Data not found");
			e.printStackTrace();
		}
		return cellData;
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
				data[i-1][j] = ExcelUtil.setCellDataToString(i, j);
				
			}
		}
		return data;
	}

	
	//Create Sheet
	public static int createExcelSheet() throws IOException {
		shFile = wbFile.createSheet();
		String shName = shFile.getSheetName();
		int newSheet = wbFile.getSheetIndex(shName);
		return newSheet;
	}

	
	//Write 404URL into Excel
	public static void writeExcel(int sheetno, String dataToWrite) {
		int rowCount = 0;
		try {
			ExcelUtil.getSheet(sheetno);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sheet not found");
		}
		try {
			//Get 1st row
			Row row = shFile.getRow(0);
			//Create a new row and append it at last of sheet
			Row newRow = shFile.createRow(rowCount+1);
			//Create a loop over the cell of newly created Row
			for(int i = 0; i < row.getLastCellNum(); i++){
				//Fill data in row
				Cell cell = newRow.createCell(i);
				cell.setCellValue(dataToWrite);
				FileOutputStream fileOutput = new FileOutputStream(filePath);
				wbFile.write(fileOutput);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Row not created");
		}
	}

}