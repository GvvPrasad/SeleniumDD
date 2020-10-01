package com.autom.init;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.autom.base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ObjectRespo{

	//Properties file objects
	public static void main(String[] args) {
		PropertiesFile.GetProperties();
	}

	//Project default Variable and Methods
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());

	//Application Variables
	protected static String browser;
	protected static String url;

	//Base Class Variables
	protected static final Logger log = (Logger) LogManager.getLogger(Base.class); 
	protected static ChromeOptions options = new ChromeOptions();
	protected static FirefoxProfile profile = new FirefoxProfile();
	protected static FirefoxOptions foptions = new FirefoxOptions();
	protected static String downloadFilepath = projectPath+"//DownloadFiles";

	//Properties file variables
	protected static String emailProperties = projectPath+"//src//main//resources//App.properties";
	protected static String emailList = projectPath+"//src//test//resources//TestEmailList.xlsx";

	//Common Methods variables
	protected static String screenShotName = projectPath+"//ScreenShots//"+timeStamp+".png";

	//Excel Utilizes Files variables
	protected static XSSFWorkbook wb;
	protected static XSSFSheet sh;
	protected static XSSFRow row;
	protected static XSSFCell cell;
	protected static FileInputStream dataFile;
	protected static FileOutputStream fileOut;

	//Reports Class Variables
	protected static ExtentSparkReporter report;
	protected static ExtentReports extent;
	protected static String reportsPath = projectPath+"//Reports//"; 
	protected static String htmlReport = reportsPath+timeStamp+".html";
	protected static String excelReport = timeStamp+".xlsx";

	//Email Variables
	protected static String senderMail;
	protected static String senderPassword;
	protected static String receiverMail;
	protected static String mailSubject;
	protected static String mailContent;

	//Test Data Files
	protected static String testData = projectPath+"//src//test//resources//TestData.xlsx";
	protected static String testLinks = projectPath+"//src//test//resources//TestLinks.xlsx";
	protected static String sample = projectPath+"//src//test//resources//TestLinksCopy.xlsx";
}