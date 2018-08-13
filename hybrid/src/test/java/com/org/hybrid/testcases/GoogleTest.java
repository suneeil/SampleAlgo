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


public class GoogleTest {
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	Xls_Reader xls = new Xls_Reader(CONSTANTS.SUITEADATA_XLS);//new Xls_Reader("C:/MyWorkSpace/DesignePattern/hybrid/Data/SuiteA.xlsx");	
	String sheetName  = "Data";
	
	@Test(dataProvider="getData")
	public void googleSearch(HashMap<String, String> data){
		String testName = "GoogleSearchTest";
		test = rep.startTest("GoogleSearchTest", "Search on Google");
		Keywords app = new Keywords(test);				
		try {			
			if(DataUtil.isRunnable(xls, testName) || data.get("Runmode").equalsIgnoreCase("Y")){
				app.executeKeywords(testName, xls, data);
				app.getGenericKeywords().report("Data: Runmode: "+ data.get("Runmode")+ " Search Query: "+ data.get("searchQuery")+ " On Browser: "+ data.get("browserName"));									
			app.getGenericKeywords().reportPass("Completed execution");
			}else{
				test.log(LogStatus.SKIP, "Skipping Test");
			}
		} catch (Exception e) {
			app.getGenericKeywords().reportFail(e.getMessage());
			e.printStackTrace();
		}
	}
	

	@AfterTest
	public void tearDown(){
		System.out.println(">>>>>>>>>>>>>>>>>>.. " + test);
		rep.endTest(test);
		rep.flush();
		//app.getGenericKeywords().endTestReport();
		//app.getGenericKeywords().closeReporting();
		//rep.flush();
	}
	
	
	@DataProvider
	public Object[][] getData(){		 		 
		  return DataUtil.getData(xls, "GoogleSearchTest");
	}
	
	
	/*@DataProvider
	public Object[][] getData(){		
	      Xls_Reader xls = new Xls_Reader("C:/MyWorkSpace/DesignePattern/readingData/Data.xlsx");	       
	      String sheetName  = "Data";
		  String testcaseName = "TestB";
		  
		  int testStartRowNum = 1;
		  
			while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testcaseName)){
				testStartRowNum ++;
			}
			
			System.out.println("Start Row: "+ testStartRowNum);
			int colStartRowNum = testStartRowNum + 1; //
			int dataStartRowNum = testStartRowNum + 2;
			
			
			 * The below code is to get total number of Rows for a test
			 
			int totDataRows = 0;		
			while(!xls.getCellData(sheetName, 0, dataStartRowNum+totDataRows).equals("")){
				totDataRows++;
			}
			System.out.println("Total Data Rows for "+ testcaseName + ": "+ totDataRows);
			
			 * The below code is to get total number of columns for a test 
			 
			int totDataCol = 0;
			while(!xls.getCellData(sheetName, totDataCol, colStartRowNum).equals("")){
				totDataCol++;
			}
			System.out.println("Total data Columns for testcase : "+testcaseName + " "+ totDataCol);
			
			
			 * Gets all the Data for test case 
			 
			System.out.println("Data Start Row num: " + dataStartRowNum);
			Object[][] data = new Object[totDataRows][1];
			Map<String, String> hmap = new HashMap<String, String>();
			int dataRow=0;
			HashMap<String, String> table = null;
			for(int rNum=dataStartRowNum;rNum<dataStartRowNum+totDataRows;rNum++){
				table = new HashMap<String, String>();
				
				for(int cNum=0; cNum<totDataCol;cNum++){
					String key = xls.getCellData(sheetName, cNum, colStartRowNum); // Here the key will be always constant
					String value = xls.getCellData(sheetName, cNum, rNum);
					//System.out.print(xls.getCellData(sheetName, cNum, rNum)+" ");
					//data[dataRow][cNum] = xls.getCellData(sheetName, cNum, rNum);
					table.put(key, value);
				}
				//System.out.println();
				data[dataRow][0] = table; //The col is zero because, the two dimensional object array has only one column 
				dataRow++;
			}
			return data;					
	}*/

}
