package com.autoprac.testscripts;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.autoprac.config.ObjectRespo;
import com.autoprac.utilities.ReportsGeneration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends ObjectRespo{

	//Global Variables
	protected static final Logger log = (Logger) LogManager.getLogger(Base.class); 
	protected static ChromeOptions options = new ChromeOptions();
	protected static FirefoxProfile profile = new FirefoxProfile();
	protected static FirefoxOptions foptions = new FirefoxOptions();
	
	
	//Browser Setup and file download
	@BeforeClass
	public static void browserSetUp() {
		
		//For generating HTML Reports
		ReportsGeneration.htmlReports();
		
		//Setting New download path
		HashMap < String, Object > chromePrefs = new HashMap < String, Object > ();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		//Adding Capabilities to Chrome
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("start-maximized");
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); //to disable browser extension popup


		//Adding Capabilities to Firefox
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", downloadFilepath);
		profile.setPreference("browser.download.useDownloadDir", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("browser.download.manager.showwhenStarting", false);

		foptions.setProfile(profile);

		if(ObjectRespo.browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} 
		else if (ObjectRespo.browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(foptions);
		} 
		else if (ObjectRespo.browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else if (ObjectRespo.browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(ObjectRespo.url);
		log.info("from base class");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	//HeadLess browser setup
	public static void headlessBrowserSetUp() {

		options.setHeadless(true);
		options.addArguments("--headless");

		FirefoxOptions foptions = new FirefoxOptions();
		foptions.setHeadless(true);

		if(ObjectRespo.browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} 
		else if (ObjectRespo.browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(foptions);
		} 

		driver.get(ObjectRespo.url);
		log.info("dsdsa");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	//Close Driver & Browser
	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
		//For Generating Reports (HTML, Excel)
		ReportsGeneration.generateReports();
	}
}