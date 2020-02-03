package com.autoprac.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.autoprac.config.AppConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	//Global Variables
	public static String browserName;
	public static String urlLink;
	protected static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest setup;


	//Browser config
	public static void browserSetUp() {

		AppConfig.getProperties();

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(urlLink);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	//Screenshots
	public static void screenshot() throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(projectPath+"//ScreenShots//"+timeStamp+".png"));
	}

	
	//Logs
	public static void logsSet() {
		
	}

	//HTML Reports
	public static void htmlReports() {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(projectPath+"//Reports//report"+timeStamp+".html");
		extent.attachReporter(htmlReporter);
		setup = extent.createTest("SetUp");
	}
	
	
	//Close Driver
	public static void driverclose() {
		driver.close();
		driver.quit();
		extent.flush();
	}
	
}


