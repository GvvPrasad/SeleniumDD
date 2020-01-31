package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.ExcelUtil;
import com.autoprac.locators.LoginPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;

@Listeners(com.autoprac.common.Listener.class)
public class Login extends Base{

	//SignUrl
	String loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";	


	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.browserSetUp();
		ExcelUtil.readExcel();
	}


	@Test
	public void signIn() throws IOException {
		driver.navigate().to(loginUrl);
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
		ExcelUtil.sFile = ExcelUtil.wbFile.getSheetAt(1);

		for(int i=1; i<= ExcelUtil.sFile.getLastRowNum(); i++) {
			//Email
			lp.email().clear();
			ExcelUtil.cell = ExcelUtil.sFile.getRow(i).getCell(0);
			ExcelUtil.cell.setCellType(CellType.STRING);
			lp.email().sendKeys(ExcelUtil.cell.getStringCellValue());

			//Password
			lp.password().clear();
			ExcelUtil.cell = ExcelUtil.sFile.getRow(i).getCell(1);
			ExcelUtil.cell.setCellType(CellType.STRING);
			lp.password().sendKeys(ExcelUtil.cell.getStringCellValue());

			//Submit
			lp.submitlogin().click();

			String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
			String actualUrl = driver.getCurrentUrl();

			if (expectedUrl.equals(actualUrl)) {
				lp.logout().click();
			}
		}
	}


	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
