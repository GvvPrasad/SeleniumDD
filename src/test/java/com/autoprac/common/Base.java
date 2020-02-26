package com.autoprac.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.automationtesting.excelreport.Xl;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.autoprac.config.AppConfig;
import com.autoprac.config.EmailReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	//Global Variables
	public static String browserName;
	public static String urlLink;
	protected static WebDriver driver;
	protected static String projectPath = System.getProperty("user.dir");
	static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()); 
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest setup;
	protected static String htmlReport = projectPath+"//Reports//"+timeStamp+".html";
	protected static String excelReport = projectPath+"//Reports//"+timeStamp+".xlsx";
	protected static Logger log = (Logger) LogManager.getLogger();


	//Browser Setup
	public static void browserSetUp() {

		AppConfig.getProperties();

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
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


	//HTML Reports
	public static void htmlReports() {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(htmlReport);
		extent.attachReporter(htmlReporter);
		setup = extent.createTest("SetUp");
	}


	//Excel Reports
	public static void excelReports() throws Exception {
		Xl.generateReport(projectPath+"//Reports//", timeStamp+".xlsx");
	}


	//Close Driver & Browser
	public static void driverclose() throws Exception {
		driver.close();
		driver.quit();
		extent.flush();
		excelReports();
	}


	//Mails Reports
	public static void mailReports() {
		EmailReports.main(null);
	}
}


