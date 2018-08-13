package com.org.hybrid.sessionsuite;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.hybrid.commonUtil.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ChangePassword {
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	
	@BeforeSuite
	public void befSuite(){
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Before Suite");
	}
	
	@AfterSuite
	public void aftSuite(){
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Before Suite");
	}
	
	@BeforeClass
	public void beforeCls(){
		
		System.out.println("============ Before Class: " );
	}
	@AfterClass
	public void aftoreCls(){
		System.out.println("============ After Class");
	}
	@BeforeTest
	public void before(){
		
		System.out.println("$$$$$$$$$$$$$$$$$ Before Test");
	}
	
	@BeforeMethod
	public void befMeth(Method m){		
		test = rep.startTest(m.getName());
		test.assignCategory(getClass().getSimpleName());
		System.out.println("**** Before Method: " + m.getName());
	}
	
	@AfterMethod
	public void aftMeth(Method m){
		rep.endTest(test);
		System.out.println("**** After Method: " + m.getName());
	}
	
	@Test
	public void test1(){
		System.out.println(" >>> Test 1");
		test.log(LogStatus.INFO, "Creating a User ", "Details one");
		test.log(LogStatus.INFO, "Loging in ", "Details two");
		test.log(LogStatus.INFO, "Verify if user is logged in ", "Details three");
		test.log(LogStatus.INFO, "Navigate to Inbox ", "Details four");
		test.log(LogStatus.INFO, "Logout ", "Details five");
		
	}
	
	@Test
	public void test2(){
		System.out.println(" >>> Test 2");
		test.log(LogStatus.INFO, "Step1 ", "Details one");
		test.log(LogStatus.INFO, "Step2 ", "Details two");
		test.log(LogStatus.INFO, "Step3 ", "Details three");
		test.log(LogStatus.INFO, "Step4 ", "Details four");
		test.log(LogStatus.INFO, "Step5 ", "Details five");
	}
	
	@Test
	public void test3(){
		System.out.println(" >>> Test 3");
		test.log(LogStatus.INFO, "Step1 ", "Details one");
		test.log(LogStatus.INFO, "Step2 ", "Details two");
		test.log(LogStatus.INFO, "Step3 ", "Details three");
		test.log(LogStatus.INFO, "Step4 ", "Details four");
		test.log(LogStatus.INFO, "Step5 ", "Details five");
	}
	
	@AfterTest
	public void aftTest(){
		rep.flush();
		System.out.println("$$$$$$$$$$$$$$$$$ After Test");
	}
	
}




