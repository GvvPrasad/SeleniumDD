package com.autom.testscripts;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autom.base.Base;
import com.autom.utilities.ExcelUtil;

@Listeners(com.autom.listeners.TestNGListener.class)
public class Partice extends Base{
	
	@Test
	public static void tab() throws Exception {
		String filename = "D://workspace//SeleniumDD//src//test//resources//sam.xlsx";
		ExcelUtil.getExcel(filename);
		ExcelUtil.createSheet("sam3");
		ExcelUtil.getSheet(0);
		ExcelUtil.createRow(1);
		ExcelUtil.closeExcel(filename);
	}
}
