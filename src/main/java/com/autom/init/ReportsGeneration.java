package com.autom.init;

import org.automationtesting.excelreport.Xl;

import com.autom.base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsGeneration extends Base{

	//HTML Reports start generation
	public static void htmlReports() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(ObjectRespo.htmlReport);
		extent.attachReporter(spark);
		
	}

	//Excel Reports start generation
	public static void excelReports() throws Exception {
		Xl.generateReport(ObjectRespo.reportsPath, ObjectRespo.excelReport);
	}

	//All reports generate exit/complete
	public static void generateReports() throws Exception {
		extent.flush();
		excelReports();
	}

}
