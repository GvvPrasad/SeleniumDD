package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.CommomMethods;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class Partice extends Base{

	@BeforeTest
	public void beforeTest() throws IOException {
		//Base.headlessBrowserSetUp();
	}


	@Test
	public void sample() throws InterruptedException {
		String dat = CommomMethods.getCurrentDate("dd/MM/yyyy");
		System.out.println(dat);
		
	}


	@AfterTest
	public void afterTest() throws Exception {
		//Base.driverclose();
	}

}
