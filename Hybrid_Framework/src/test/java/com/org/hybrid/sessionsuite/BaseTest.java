package com.org.hybrid.sessionsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import com.org.hybrid.Keywords;
import com.org.hybrid.commonUtil.DataUtil;
import com.org.hybrid.commonUtil.ExtentManager;
import com.org.hybrid.commonUtil.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	Keywords app ;
	Xls_Reader xls;
	String testName;
	
	
	

	@AfterTest
	public void tearDown(){
		System.out.println(">>>>>>>>>>>>>>>>>>.. " + test);
		rep.endTest(test);
		rep.flush();
		//app.getGenericKeywords().closeBrowser();
		//app.getGenericKeywords().endTestReport();
		//app.getGenericKeywords().closeReporting();
		//rep.flush();
		
	}
	
	
	@DataProvider
	public Object[][] getData(){		 		 
		  return DataUtil.getData(xls, testName);
	}
	
}
