package com.autom.init;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.autom.base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ObjectRespo{

	//Properties file objects
	public static void main(String[] args) {
		PropertiesFile.GetProperties();
	}

	//Project default Variable and Methods
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());

	//Properties file variables
	protected static String emailProperties = projectPath+"//src//main//resources//App.properties";
	protected static String emailList = projectPath+"//src//test//resources//TestEmailList.xlsx";

	//Application Variables
	protected static String browser;
	protected static String url;

	//Base Class Variables
	protected static final Logger logger = (Logger) LogManager.getLogger(Base.class); 
	protected static ChromeOptions options = new ChromeOptions();
	protected static FirefoxProfile profile = new FirefoxProfile();
	protected static FirefoxOptions foptions = new FirefoxOptions();
	protected static String downloadFilepath = projectPath+"//DownloadFiles";

	//Common Methods variables
	protected static String screenShotName = projectPath+"//ScreenShots//"+timeStamp+".png";

	//Excel Utilizes Files variables
	protected static XSSFWorkbook wb;
	protected static XSSFSheet sh;
	protected static XSSFRow row;
	protected static XSSFCell cell;
	protected static FileInputStream dataFile;
	protected static FileOutputStream fileOut;

	//Test Data Files
	protected static String testData = projectPath+"//src//test//resources//TestData.xlsx";
	protected static String testLinks = projectPath+"//src//test//resources//TestLinks.xlsx";
	protected static String sample = projectPath+"//src//test//resources//TestLinksCopy.xlsx";

	//Reports Class Variables
	protected static ExtentReports extent;
	protected static ExtentSparkReporter spark;
	protected static ExtentTest extentTest;
	protected static String reportsPath = projectPath+"//Reports//"; 
	protected static String htmlReport = reportsPath+"extend_Reports"+timeStamp+".html";
	protected static String excelReport = "excel_Reports"+timeStamp+".xlsx";

	//DataBase connectivity and utilities
	protected static java.sql.Connection con;
	protected static java.sql.Statement stmt;
	protected static String dbUrl;
	protected static String dbUser;
	protected static String dbPassword;
	protected static java.sql.ResultSet dbRes;
	
	
	
	//Email Variables
	protected static String senderMail;
	protected static String senderPassword;
	protected static String receiverMail;
	protected static String mailSubject;
	protected static String mailContent;
}