package com.autoprac.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class ObjectRespo {

	//Project default Variable and Methods

	//Global Variables
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

	//Application Variables
	protected static String browser = "Chrome";
	protected static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	//Base Class
	protected static String downloadFilepath = projectPath+"//Files";

	//Common Methods
	protected static String screenShotName = projectPath+"//ScreenShots//"+timeStamp+".png";
	protected static String fullScreenShotName = projectPath+"//ScreenShots//"+timeStamp+".png";

	//Test Data Files
	protected static String testData = projectPath+"//testDataFiles//TestData.xlsx";

	//Api Test Variables
	protected static String apiFilePath = projectPath+"//testDataFiles//TestApis.xlsx";

	//Test Links
	protected static String testLinks = projectPath+"//testDataFiles//TestLinks.xlsx";

	//Reports Variables
	protected static String reportsPath = projectPath+"//Reports//"; 
	protected static String htmlReport = reportsPath+timeStamp+".html";
	protected static String excelReport = timeStamp+".xlsx";

	//Email Variables
	protected static String senderMailId = "";
	protected static String senderMailPassword = "";
	protected static String receiverMailId = "";
	protected static String mailSubject = "";
	protected static String mailContent = "";

}
