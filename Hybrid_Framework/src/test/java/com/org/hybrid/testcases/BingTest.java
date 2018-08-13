package com.org.hybrid.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.hybrid.CONSTANTS;
import com.org.hybrid.Keywords;
import com.org.hybrid.commonUtil.DataUtil;
import com.org.hybrid.commonUtil.ExtentManager;
import com.org.hybrid.commonUtil.ReadTestData;
import com.org.hybrid.commonUtil.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BingTest extends BaseTest{
	
	
	Xls_Reader xls = new Xls_Reader(CONSTANTS.SUITEA_XLS);//new Xls_Reader("C:/MyWorkSpace/DesignePattern/hybrid/Data/SuiteA.xlsx");	
	String sheetName  = "Keywords";
	
	
	@Test(dataProvider="getData")
	public void bingSearch(HashMap<String, String> data){
		String testName = "BingSearchTest";
		test = rep.startTest("Bing Search", "Search on Bing");
		app = new Keywords(test);
		try{			
			//app.executeKeywords("BingSearchTest", xls);
			app.executeKeywords(testName, xls, data);
			app.getGenericKeywords().reportPass("Completed execution");
		}catch(Exception e){
			app.getGenericKeywords().reportFail(e.getMessage());
			e.printStackTrace();
		}
	}


	
	@DataProvider
	public Object[][] getData(){		 		 
		  return DataUtil.getData(xls, "BingSearchTest");
	}
	

}
