package com.autoprac.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.autoprac.common.CommomMethods;
import com.autoprac.config.ObjectRespo;
import com.autoprac.utilities.ExcelUtil;

import java.io.IOException;

public class Partice extends Base{
	
	@Test
	public static void tab() throws Exception {
		String message = "hello";
		
		ExcelUtil.getExcel(ObjectRespo.testLinks);
		ExcelUtil.getSheet(0);
		ExcelUtil.writeIntoExcel(ObjectRespo.testLinks, message);
		
	}
}
