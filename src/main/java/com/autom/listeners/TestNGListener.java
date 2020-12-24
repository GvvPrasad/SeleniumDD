package com.autom.listeners;

import java.io.IOException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.autom.base.Base;

public class TestNGListener extends Base implements ISuiteListener, ITestListener{
	
	//Global Variables
	public static String nameofCurrMethod;

	public void onTestStart(ITestResult result) {}

	public void onTestSuccess(ITestResult result) {}

	public void onTestFailure(ITestResult result) {
		System.out.println("Faild Test: " + result.getName());
		nameofCurrMethod = result.getName();

		try {
			com.autom.utilities.CommomMethods.visiablePageScreenShot(nameofCurrMethod);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped Test: " + result.getName());
		nameofCurrMethod = result.getName();
		
		try {
			com.autom.utilities.CommomMethods.visiablePageScreenShot(nameofCurrMethod);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("FailedButWithinSuccessPercentage Test: " + result.getName());
		nameofCurrMethod = result.getName();
				
		try {
			com.autom.utilities.CommomMethods.visiablePageScreenShot(nameofCurrMethod);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onStart(ITestContext context) {}

	public void onFinish(ITestContext context) {}

	public void onStart(ISuite suite) {
		System.out.println("Test Suit Started: " + suite.getName());
	}

	public void onFinish(ISuite suite) {
		System.out.println("Test Suit Finished: " + suite.getName());
	}

}