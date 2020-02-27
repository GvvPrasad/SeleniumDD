package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.Base;
import com.autoprac.common.CommomMethods;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class Partice extends Base{

	@BeforeTest
	public void beforeTest() throws IOException {
		Base.browserSetUp();
	}


	@Test
	public void sample() {
		driver.navigate().to("http://only-testing-blog.blogspot.com/2014/05/form.html");
		WebElement table = driver.findElement(By.xpath("//div[@id='post-body-8228718889842861683']//div//table"));

		CommomMethods.webTable(table);

	}


	@AfterTest
	public void afterTest() throws Exception {
		Base.driverclose();
	}

}
