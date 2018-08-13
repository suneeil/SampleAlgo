package com.org.readingData;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestB {


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
		  String testCaseName = "TestA";
		  ReadTestData r = new ReadTestData(xls,sheetName,testCaseName);
		  return r.getTestData(xls, sheetName, testCaseName);
		  
		/*	
		  	int testStartRowNum = r.getTestStartRowNum(xls, sheetName, testcaseName);
		  				
			System.out.println("Start Row: "+ testStartRowNum);
			int colStartRowNum = r.getColumnStartRowNum(xls, sheetName, testCaseName);//testStartRowNum + 1; //
			int dataStartRowNum = r.getTestStartRowNum(xls, sheetName, testCaseName);//testStartRowNum + 2;
			
			
			 //The below code is to get total number of Rows for a test
			 
			int totDataRows = r.getTotalTestDataRows(xls, sheetName, testCaseName);//0;		
			while(!xls.getCellData(sheetName, 0, dataStartRowNum+totDataRows).equals("")){
				totDataRows++;
			}
			System.out.println(">>>> Total Data Rows for "+ testcaseName + ": "+ totDataRows);
			
			// * The below code is to get total number of columns for a test 
			 
			int totDataCol = r.getTotalTestDataColumns(xls, sheetName, testCaseName);//0;
			while(!xls.getCellData(sheetName, totDataCol, colStartRowNum).equals("")){
				totDataCol++;
			}
			System.out.println(">>> Total data Columns for testcase : "+testcaseName + " "+ totDataCol);
			
			
			// * Gets all the Data for test case 
			 
			System.out.println("Data Start Row num: " + dataStartRowNum);*/
		//	Object[][] data =r.getTestData(xls, sheetName, testCaseName);/* new Object[totDataRows][1];
			/*Map<String, String> hmap = new HashMap<String, String>();
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
			//return r.getTestData(xls, sheetName, testCaseName);//data;					
	}
	

	
	
	
}
