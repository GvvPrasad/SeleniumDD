package com.autoprac.utilities;

import org.automationtesting.excelreport.Xl;

import com.autoprac.base.Base;
import com.autoprac.config.ObjectRespo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ReportsGeneration extends Base{


	//HTML Reports
	public static void htmlReports() {
		report = new ExtentSparkReporter(ObjectRespo.htmlReport);
		extent = new ExtentReports();
		extent.attachReporter(report);

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
