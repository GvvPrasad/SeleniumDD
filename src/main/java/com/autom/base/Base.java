package com.autom.base;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.autom.init.Email;
import com.autom.init.ObjectRespo;
import com.autom.init.PropertiesFile;
import com.autom.init.ReportsGeneration;
import com.autom.utilities.CommomMethods;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.autom.listeners.TestNGListener.class)
public class Base extends ObjectRespo{	

	//Browser Setup
	@BeforeSuite
	public static void browserSetUp() {

		//Get Application properties
		PropertiesFile.GetProperties();

		//For generating HTML Reports
		ReportsGeneration.htmlReports();

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
			options.addArguments("--disable-notifications"); //to disable notifications
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);//handle SSl certificate errors

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
			profile.setAcceptUntrustedCertificates(true);//handle SSl certificate errors
			profile.setAssumeUntrustedCertificateIssuer(false);//handle SSl certificate errors

			foptions.setProfile(profile);

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

		//Opening of Browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ObjectRespo.url);
		logger.info("Application Opened in " + ObjectRespo.browser);
	}

	//Close Driver & Browser
	@AfterSuite
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
		
		//For Generating Reports (HTML, Excel)
		ReportsGeneration.generateReports();
		Email.email();	
	}

	//Add Screenshot to Extend Reports
	@AfterMethod
	public static void reportLogs(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			String screenShotPath = CommomMethods.visiablePageScreenShot(result.getName());
			extentTest.log(Status.FAIL, "Failed Test Method: "+result.getName());
			extentTest.log(Status.FAIL, "Failed log: "+result.getThrowable());
			extentTest.log(Status.FAIL, "Screenshot: "+extentTest.addScreenCaptureFromPath(screenShotPath));

		} else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(Status.SKIP, "Skipped Test Method: "+result.getName());
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Passed Test Method : "+result.getName());
		}

	}


}