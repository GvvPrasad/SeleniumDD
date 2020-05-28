package com.autoprac.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.autoprac.common.CommomMethods;


public class TestNGListener implements ITestListener, ISuiteListener{

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Faild Test: " + result.getName());

		try {
			CommomMethods.screenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped Test: " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("FailedButWithinSuccessPercentage Test: " + result.getName());

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	public void onStart(ISuite suite) {
		System.out.println("Test Suit Started: " + suite.getName());
	}

	public void onFinish(ISuite suite) {
		System.out.println("Test Suit Finished: " + suite.getName());
	}

}
