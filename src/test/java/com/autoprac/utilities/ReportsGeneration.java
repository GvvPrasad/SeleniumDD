package com.autoprac.utilities;

import org.automationtesting.excelreport.Xl;

import com.autoprac.config.ObjectRespo;
import com.autoprac.testscripts.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ReportsGeneration extends Base{

	//Global Variables 
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest setup;

	//HTML Reports
	public static void htmlReports() {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(ObjectRespo.htmlReport);
		extent.attachReporter(htmlReporter);
		//setup = extent.createTest("Test");	
	}


	//Excel Reports
	public static void excelReports() throws Exception {
		Xl.generateReport(ObjectRespo.reportsPath, ObjectRespo.excelReport);
	}


	//All reports generate
	public static void generateReports() throws Exception {
		extent.flush();
		excelReports();
	}

}
