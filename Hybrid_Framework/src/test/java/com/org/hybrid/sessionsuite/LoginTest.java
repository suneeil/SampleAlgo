package com.org.hybrid.sessionsuite;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.hybrid.CONSTANTS;
import com.org.hybrid.Keywords;
import com.org.hybrid.commonUtil.DataUtil;
import com.org.hybrid.commonUtil.ExtentManager;
import com.org.hybrid.commonUtil.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{

	
	/*Xls_Reader xls = new Xls_Reader(CONSTANTS.SUITEADATA_XLS);
	String testName = "LoginTest";*/
	
	
	@BeforeTest
	public void init(){
		testName = "LoginTest";
		xls = new Xls_Reader(CONSTANTS.SUITEADATA_XLS);
	}
	//String sheetName  = "Data";
	
	@Test(dataProvider="getData")
	public void loginTest(HashMap<String, String> data){
		test = rep.startTest(testName, "Login into Facebook");
		app = new Keywords(test);
		try{

			//
			if(DataUtil.isRunnable(xls, testName) || data.get("Runmode").equalsIgnoreCase("Y")){
				test.log(LogStatus.INFO, data.toString());
				test.log(LogStatus.INFO, "Staring Flipkart Login Test");
				app.executeKeywords(testName, xls, data);
				app.getGenericKeywords().reportPass("Completed execution");
			}else{
				test.log(LogStatus.SKIP, "Skipping test case since run mode is NO " + data.toString());
				throw new SkipException(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Skipping Test");
				//throw new SkipException("Skipping test case since run mode is NO ");
			}

		}catch(Exception e){
			System.out.println(" ######## GOT EXCEPTION "+e.getMessage()+" #############");
			test.log(LogStatus.FAIL, ">>>");
			System.out.println(" ######## GOT EXCEPTION "+e.getMessage()+" #############");
		}
	}

	
	

	

}
