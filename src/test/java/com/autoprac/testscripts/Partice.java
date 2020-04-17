package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.CommomMethods;

import io.restassured.http.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Partice extends Base{
	
	@Test
	public static void tab() throws InterruptedException {
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		
		Thread.sleep(5000);
	}
}
