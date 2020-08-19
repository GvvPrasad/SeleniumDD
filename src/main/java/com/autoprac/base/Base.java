package com.autoprac.base;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.autoprac.config.ObjectRespo;
import com.autoprac.config.PropertiesFile;
import com.autoprac.utilities.ReportsGeneration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends ObjectRespo{	
	
	
	//Browser Setup
	@BeforeSuite
	public static void browserSetUp() {
		
		//Get Application properties
		PropertiesFile.GetProperties();
		
		//Select Browser
		switch (ObjectRespo.browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			
			//Setting download path
			HashMap < String, Object > chromePrefs = new HashMap < String, Object > ();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", ObjectRespo.downloadFilepath);

			//Adding Capabilities to Chrome
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("start-maximized");
			options.addArguments("--test-type");
			options.addArguments("--disable-extensions"); //to disable browser extension popup
			
			//Headless Setup
			//options.setHeadless(true);
			//options.addArguments("--headless");
			
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(foptions);
			
			//Adding Capabilities to Firefox
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir", ObjectRespo.downloadFilepath);
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
			profile.setPreference("browser.download.manager.showwhenStarting", false);

			foptions.setProfile(profile);
			
			//Headless setup
			//FirefoxOptions foptions = new FirefoxOptions();
			//foptions.setHeadless(true);
			
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			
		default:
			System.out.println("Not a Valid browser");
			break;
		}
		
		
		//For generating HTML Reports
		ReportsGeneration.htmlReports();

		driver.get(ObjectRespo.url);
		log.info("Page Opened");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	//Close Driver & Browser
	@AfterSuite
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
		//For Generating Reports (HTML, Excel)
		ReportsGeneration.generateReports();
	}
}