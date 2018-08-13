package com.org.POMPageFactory.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.org.POMPageFactory.testcases.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest(){
		
		test =  extent.startTest("Login Test");
		test.log(LogStatus.INFO, "Starting Login test");
		test.log(LogStatus.INFO, "Opening Browser");
		//init(AppConstants.BROWSER);
		//LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		test.log(LogStatus.INFO, "Logging in");
		//LoginPage loginPage = launchPage.gotoLoginPage();
		//loginPage.doLogin("", "");
		
	}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
	}
	
}
