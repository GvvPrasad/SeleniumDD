package com.autoprac.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.autoprac.base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ObjectRespo{

	//Properties file objects
	public static void main(String[] args) {
		PropertiesFile.GetProperties();
	}

	//Project default Variable and Methods
	//Global Variables
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	public static String methodName;
	
	//Application Variables
	protected static String browser;
	protected static String url;

	//Base Class
	protected static final Logger log = (Logger) LogManager.getLogger(Base.class); 
	protected static ChromeOptions options = new ChromeOptions();
	protected static FirefoxProfile profile = new FirefoxProfile();
	protected static FirefoxOptions foptions = new FirefoxOptions();
	protected static String downloadFilepath = projectPath+"//DownloadFiles";

	//Common Methods
	protected static String screenShotName = projectPath+"//ScreenShots//"+methodName+"_"+timeStamp+".png";
	protected static JavascriptExecutor jse = (JavascriptExecutor) driver;

	//Excel Utilizes Files
	protected static XSSFWorkbook wbFile;
	protected static XSSFSheet shFile;
	protected static XSSFRow row;
	protected static XSSFCell cell;
	protected static FileInputStream dataFile;
	protected static FileOutputStream fileOut;

	//Reports File
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest setup;

	//Test Data Files
	protected static String testData = projectPath+"//src//test//resources//TestData.xlsx";

	//API Test Variables
	protected static String apiFilePath = projectPath+"//src//test//resources//TestApis.xlsx";
	
	//Test Links
	protected static String testLinks = projectPath+"//src//test//resources//TestLinks.xlsx";

	//Reports Variables
	protected static String reportsPath = projectPath+"//Reports//"; 
	protected static String htmlReport = reportsPath+timeStamp+".html";
	protected static String excelReport = timeStamp+".xlsx";

	//Properties file
	protected static String emailProperties = projectPath+"//src//main//resources//App.properties";
	protected static String emailList = projectPath+"//src//test//resources//TestEmailList.xlsx";

	//Email Variables
	protected static String senderMail;
	protected static String senderPassword;
	protected static String receiverMail;
	protected static String mailSubject;
	protected static String mailContent;
}