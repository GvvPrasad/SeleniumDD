package com.autom.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.autom.base.Base;

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
		String cellValue = sh.getRow(rowNum).getCell(colNum).getRawValue();
		return cellValue;
	}

	//Get String Value
	public static String getStringValue(int rowNum, int colNum) {
		String cellValue = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellValue;
	}

	//Get Numeric Value
	public static double getNumericValue(int rowNum, int colNum) {
		double cellValue = sh.getRow(rowNum).getCell(colNum).getNumericCellValue();;
		return cellValue;
	}

	//Get Date Value
	public static String getDateValue(int rowNum, int colNum) {
		String cellText = String.valueOf(cell.getNumericCellValue());
		if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA"))) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// format in form of M/D/YY
				double d = cell.getNumericCellValue();

				Calendar cal = Calendar.getInstance();
				cal.setTime(HSSFDateUtil.getJavaDate(d));
				cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
				cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

				System.out.println(cellText);

			}

			return cellText;
		}
		return cellText;
		
	}
	
	//Get Time Value
	public static void getTimeValue() {}

	//Change cell values to String
	public static String setCellDataToString(int rowNum, int colNum) {
		XSSFCell cell = null;
		String cellValue = null;
		try {
			cell = sh.getRow(rowNum).getCell(colNum);
			cell.setCellType(CellType.STRING);
			cellValue = cell.getStringCellValue().trim();
		}catch(Exception e) {
			System.out.println("Data not found");
			e.printStackTrace();
		}
		return cellValue;
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
				data[i-1][j] = ExcelUtil.setCellDataToString(i, j).trim();
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