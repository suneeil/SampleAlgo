package com.org.parallel;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends TestListenerAdapter{
	public ExtentTest testReporter;
	
	
	
	@BeforeMethod
	public void beforeMethod(Method caller) {
		testReporter = ExtentTestManager.startTest(caller.getName(), "This is a simple test.");
		Init init = new Init(testReporter); 
		testReporter.assignCategory(this.getClass().getSimpleName());
		//System.out.println(testReporter.getTest().getName());
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.isSuccess()) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed");
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped");
		}
		
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.getInstance().flush();
	}
}
