package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.CommomMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Partice extends Base{
	
	@Test
	public static void tab() {
		//driver.navigate().to("http://only-testing-blog.blogspot.in/2014/05/form.html");
		WebElement mytable = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
		System.out.println(CommomMethods.webTable(mytable));
		
	}
}
