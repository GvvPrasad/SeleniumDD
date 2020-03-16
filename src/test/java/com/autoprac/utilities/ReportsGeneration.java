package com.autoprac.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.automationtesting.excelreport.Xl;

import com.autoprac.common.Base;
import com.autoprac.config.EmailConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReportsGeneration extends Base{

	//Global Variables
	static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()); 
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest setup;
	protected static String htmlReport = projectPath+"//Reports//"+timeStamp+".html";
	protected static String excelReport = projectPath+"//Reports//"+timeStamp+".xlsx";


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


	//All reports generate
	public static void generateReports() throws Exception {
		extent.flush();
		excelReports();
	}


	//Mail
	public static void mailReports() {
		EmailConfig.email();
	}
}
