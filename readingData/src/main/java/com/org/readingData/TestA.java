package com.org.readingData;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestA {

	 Xls_Reader xls = new Xls_Reader("C:/MyWorkSpace/DesignePattern/readingData/Data.xlsx");
	 String sheetName  = "sheet";
	  String testcaseName = "TestA";
		
	@Test(dataProvider="getData")
	public void testA(HashMap<String, String> data){
		System.out.println(data.get("runmode")+"---"+data.get("username")+"---"+data.get("pwd")+"---"+data.get("browser"));
	}
	
	

	
	@DataProvider
	public Object[][] getData(){		
	      Xls_Reader xls = new Xls_Reader("C:/MyWorkSpace/DesignePattern/readingData/Data.xlsx");	       
	      String sheetName  = "Data";
		  String testCaseName = "TestB";
		  ReadTestData r = new ReadTestData(xls,sheetName,testCaseName);
		  return r.getTestData(xls, sheetName, testCaseName);
			/*
			
		int testStartRowNum = 1;
		  
			while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
				testStartRowNum ++;
			}
			
			System.out.println("Start Row: "+ testStartRowNum);
			int colStartRowNum = testStartRowNum + 1; //
			int dataStartRowNum = testStartRowNum + 2;
			
			
			 //The below code is to get total number of Rows for a test
			 
			int totDataRows = 0;		
			while(!xls.getCellData(sheetName, 0, dataStartRowNum+totDataRows).equals("")){
				totDataRows++;
			}
			System.out.println("Total Data Rows for "+ testCaseName + ": "+ totDataRows);
			
			// * The below code is to get total number of columns for a test 
			 
			int totDataCol = 0;
			while(!xls.getCellData(sheetName, totDataCol, colStartRowNum).equals("")){
				totDataCol++;
			}
			System.out.println("Total data Columns for testcase : "+testCaseName + " "+ totDataCol);
			
			
			// * Gets all the Data for test case 
			 
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
			}*/
			//return data;					
	}
	

	
	
	
}
