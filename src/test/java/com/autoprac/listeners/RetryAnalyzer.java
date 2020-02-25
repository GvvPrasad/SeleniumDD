package com.autoprac.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int count = 0;
	private static int maxTry = 1; //Run the failed test 2 times

	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {                      //Check if test not succeed
			if (count < maxTry) {                       //Check if maxtry count is reached
				count++;                                //Increase the maxTry count by 1
				result.setStatus(ITestResult.FAILURE);  //Mark test as failed
				failOperations(result);                 //ExtentReports fail operations
				return true;                            //Tells TestNG to re-run the test
			}
		} else {
			result.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
		}
		return false;

	}

	private void failOperations(ITestResult result) {
		System.out.println("The retry count is: " + count);
	}
}
