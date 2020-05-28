package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.common.CommomMethods;

import io.restassured.http.Method;

import org.apache.logging.log4j.spi.AbstractLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Partice extends Base{
	
	@Test
	public static void tab() throws InterruptedException {
		log.info("from partice");
		log.error("this is error message");
		System.out.println("sfsdf");
	}
}
