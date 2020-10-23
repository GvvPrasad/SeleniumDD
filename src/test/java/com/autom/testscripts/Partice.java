package com.autom.testscripts;

import org.testng.annotations.Test;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.autom.utilities.ExcelUtil;

public class Partice extends Base{
	
	@Test
	public static void tab() throws Exception {
	ExcelUtil.getExcel(ObjectRespo.testData);
	ExcelUtil.getSheet(0);
	int rownumber = ExcelUtil.getRowCount();
	int colnumber = ExcelUtil.getColumnCount();
	System.out.println(rownumber + "  " + colnumber);
	System.out.println(ExcelUtil.getData());
	
	}
}
