package com.autoprac.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.autoprac.locators.HomePage;

public class PageFactoryInit extends Base{

	public PageFactoryInit(WebDriver driver) {
		super();
	}

	//Page Factory of Homepage
	public static HomePage gethomepage() {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		return hp;
	}
}
