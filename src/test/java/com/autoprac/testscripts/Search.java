package com.autoprac.testscripts;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;
import com.autoprac.locators.HomePage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;

@Listeners(com.autoprac.common.Listener.class)
public class Search extends Base{

	HomePage hp = PageFactory.initElements(driver, HomePage.class);
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.browserSetUp();
		ExcelUtil.readExcel();
		Base.htmlReports();
	}


	@Test
	public void searchProduct() {
		ExcelUtil.shFile = ExcelUtil.wbFile.getSheetAt(0);

		for(int i=0; i<= ExcelUtil.shFile.getLastRowNum(); i++) {
			ExcelUtil.cell = ExcelUtil.shFile.getRow(i).getCell(0);
			ExcelUtil.cell.setCellType(CellType.STRING);
			hp.searchbox().sendKeys(ExcelUtil.cell.getStringCellValue());
			hp.searchbox().sendKeys(Keys.ENTER);
		}
	}


	@AfterSuite
	public void afterSuite() {
		Base.driverclose();
	}

}
