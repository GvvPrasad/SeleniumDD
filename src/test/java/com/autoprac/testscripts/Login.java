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

	//Objects
	ExcelUtil eu = new ExcelUtil();


	//SignUrl
	String loginurl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";	


	@BeforeSuite
	public void beforeSuite() throws IOException {
		Base.BrowserSetUp();
		ExcelUtil.readExcel();
	}


	@Test
	public void signIn() {
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		driver.navigate().to(loginurl);
		ExcelUtil.Sfile = ExcelUtil.WBfile.getSheetAt(1);

		for(int i=1; i<= ExcelUtil.Sfile.getLastRowNum(); i++) {
			//Email
			lp.email().clear();
			ExcelUtil.cell = ExcelUtil.Sfile.getRow(i).getCell(0);
			ExcelUtil.cell.setCellType(CellType.STRING);
			lp.email().sendKeys(ExcelUtil.cell.getStringCellValue());

			//Password
			lp.password().clear();
			ExcelUtil.cell = ExcelUtil.Sfile.getRow(i).getCell(1);
			ExcelUtil.cell.setCellType(CellType.STRING);
			lp.password().sendKeys(ExcelUtil.cell.getStringCellValue());

			//Submit
			lp.submitlogin().click();

			String ExpectedUrl = "http://automationpractice.com/index.php?controller=my-account";
			String ActualUrl = driver.getCurrentUrl();

			if (ExpectedUrl.equals(ActualUrl)) {
				lp.logout().click();
			} 
		}
	}


	@AfterSuite
	public void afterSuite() {
		driver.close();
	}

}
