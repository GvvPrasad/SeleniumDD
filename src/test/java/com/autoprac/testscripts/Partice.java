package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.CommomMethods;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class Partice extends Base{

	@BeforeTest
	public void beforeTest() throws IOException {
		Base.browserSetUp();
	}


	@Test
	public void sample() throws InterruptedException {
		driver.navigate().to("https://www.flipkart.com/");
		CommomMethods.modelPopUp();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("jack");
		CommomMethods.waitTime();
	}


	@AfterTest
	public void afterTest() throws Exception {
		Base.driverclose();
	}

}
