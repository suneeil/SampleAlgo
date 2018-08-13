package com.org.hybrid.commonUtil;

import com.org.hybrid.CONSTANTS;


public class DataUtil {

	
	public static Object[][] getData(Xls_Reader xls, String testName){
		ReadTestData r = new ReadTestData(xls,"Data",testName);
		 return r.getTestData(xls, "Data", testName);
	}
	
	public static boolean isRunnable(Xls_Reader xls, String testName){
		int rows = xls.getRowCount(CONSTANTS.TESTCASES_SHEET);
		for(int rNum =2; rNum<=rows; rNum++){
			String tcid = xls.getCellData(CONSTANTS.TESTCASES_SHEET, CONSTANTS.TCID_COL, rNum);
				if(tcid.equals(testName)){
					String runMode =  xls.getCellData(CONSTANTS.TESTCASES_SHEET, CONSTANTS.RUNMODE_COL, rNum);
						if(runMode.equalsIgnoreCase("Y"))
							return true; //If test case runmode is Y return true
						else
							return false; //If test case runmode is N return false
				}
		}	
		return false;  // If no test case is found then return false
	}
}
