package com.autoprac.common;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener, ISuiteListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Faild Test: " + result.getName());
	
		 try {
			Base.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Faild Test: " + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Faild Test: " + result.getName());
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
