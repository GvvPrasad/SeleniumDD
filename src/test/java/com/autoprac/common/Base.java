package com.autoprac.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.autoprac.utilities.AppConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	//Global Variables
	public static String browserName;
	public static String urlLink;
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	protected static String downloadFilepath = projectPath+"//Files";
	protected static Logger log = (Logger) LogManager.getLogger(); 
	protected static ChromeOptions options = new ChromeOptions();
	protected static FirefoxProfile profile = new FirefoxProfile();
	protected static FirefoxOptions foptions = new FirefoxOptions();
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());


	//Browser Setup and file download
	public static void browserSetUp() {

		AppConfig.getProperties();

		//Setting New download path
		HashMap < String, Object > chromePrefs = new HashMap < String, Object > ();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		//Adding Capabilities to ChromeOptions
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("start-maximized");
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); //to disable browser extension popup


		//For Firefox
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", downloadFilepath);
		profile.setPreference("browser.download.useDownloadDir", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("browser.download.manager.showwhenStarting", false);

		foptions.setProfile(profile);

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(foptions);
		} 
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(urlLink);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	//HeadLess browser setup
	public static void headlessBrowserSetUp() {

		AppConfig.getProperties();

		options.setHeadless(true);
		options.addArguments("--headless");

		FirefoxOptions foptions = new FirefoxOptions();
		foptions.setHeadless(true);

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} 
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(foptions);
		} 

		driver.get(urlLink);
		driver.manage().deleteAllCookies();
	}


	//Close Driver & Browser
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
}