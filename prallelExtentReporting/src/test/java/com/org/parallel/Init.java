package com.org.parallel;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Init {

	public ExtentTest test;
	
	public Init(ExtentTest testReporter) {
		this.test = testReporter;
		testReporter.log(LogStatus.INFO, "Initializing");
		loginFunction();
		logOut();
	}
	
	public void loginFunction(){
		test.log(LogStatus.INFO, "-------Logged In-------");
	}
	
	public void logOut(){
		test.log(LogStatus.INFO, "-------Logged Out-------");
		//Assert.fail("Failed");
	}
}
