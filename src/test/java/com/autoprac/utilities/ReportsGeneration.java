package com.autoprac.utilities;

import org.automationtesting.excelreport.Xl;

import com.autoprac.testscripts.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReportsGeneration extends Base{

	//Global Variables 
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest setup;
	public static String htmlReport = projectPath+"//Reports//"+timeStamp+".html";
	public static String excelReport = projectPath+"//Reports//"+timeStamp+".xlsx";


	//HTML Reports
	public static void htmlReports() {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(htmlReport);
		extent.attachReporter(htmlReporter);
		setup = extent.createTest("SetUp");
	}


	//Excel Reports
	public static void excelReports() throws Exception {
		Xl.generateReport(excelReport);
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
