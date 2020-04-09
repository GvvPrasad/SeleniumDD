package com.autoprac.utilities;

import org.automationtesting.excelreport.Xl;

import com.autoprac.testscripts.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReportsGeneration extends Base{

	//Global Variables 
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static String reportsPath = projectPath+"//Reports//"; 
	protected static String htmlReport = reportsPath+timeStamp+".html";
	protected static String excelReport = timeStamp+".xlsx";


	//HTML Reports
	public static void htmlReports() {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(htmlReport);
		extent.attachReporter(htmlReporter);
	}


	//Excel Reports
	public static void excelReports() throws Exception {
		Xl.generateReport(reportsPath, excelReport);
	}


	//All reports generate
	public static void generateReports() throws Exception {
		extent.flush();
		excelReports();
	}

}
