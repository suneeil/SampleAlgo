package com.org.readingData;

import java.util.HashMap;

public class ReadTestData {

	public String sheetName  ;//= "Data";
	public String testName ;//= "TestA";
	public Xls_Reader xls; 

	public static void main(String rags[]){
		//Xls_Reader xls = new Xls_Reader("C:/MyWorkSpace/DesignePattern/readingData/Data.xlsx");
		ReadTestData st = new ReadTestData();
		st.setSheetName("Data");
		st.setTestName("TestB");
		Xls_Reader xlsFile = new Xls_Reader("C:/MyWorkSpace/DesignePattern/readingData/Data.xlsx");
		st.setXlsFile(xlsFile);
		String sheetName = st.getSheetName();
		String testName = st.getTestName();
		Xls_Reader xls = st.getXlsFile();
		ReadTestData r =  new ReadTestData(xls, sheetName, testName);
		
		//ReadTestData r = new ReadTestData(xls, sheetName,testName);
		System.out.println("Test Start row num: "+r.getTestStartRowNum(xls, sheetName, testName));
		System.out.println("Total Data Rows for "+ testName + ": "+ r.getTotalTestDataRows(xls, sheetName, testName));
		System.out.println("Total Data columns for "+ testName + ": "+ r.getTotalTestDataColumns(xls, sheetName, testName));
		System.out.println("Data Start Row num for Test "+ testName + ": "+r.getDataStartRowNum(xls, sheetName, testName));
		int x = r.getTestData(xls, sheetName, testName).length;	
	}

	public void ReadTestData(){
		
	}
	public void setSheetName(String sheetName){
		this.sheetName = sheetName;
	}
	public String getSheetName(){
		return sheetName;
	}
	
	public void setTestName(String testName){
		this.testName = testName;
	}
	
	public String getTestName(){
		return testName;
	}
	
	public void setXlsFile(Xls_Reader xls){
		this.xls = xls;
	}
	
	public Xls_Reader getXlsFile(){
		return xls;
	}
	
	
	public ReadTestData(Xls_Reader xls, String sheetName, String testName){
		this.xls = xls;
		this.sheetName = sheetName;
		this.testName = testName;
	}


	public ReadTestData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gives the test start row num
	 * @param xls
	 * @param sheetName
	 * @return
	 */
	public int getTestStartRowNum(Xls_Reader xls, String sheetName, String testCaseName){
		//System.out.println("Inside getTestStartRowNum");
		int testStartRowNum = 1;		 	
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum ++;
		}				
		return testStartRowNum;
	}

	/**
	 * Gives the total number of rows for the testcase
	 * @param xls
	 * @param sheetName
	 * @param testCaseName
	 * @return
	 */
	public int getTotalTestDataRows(Xls_Reader xls, String sheetName, String testCaseName){
		/*
		 * The below code is to get total number of Rows for a test
		 */
	//	System.out.println("Inside getTotalTestDataRows");
		int dataStartRowNum = getDataStartRowNum(xls,sheetName, testCaseName);//getTestStartRowNum(xls,sheetName, testCaseName) + 2;
		int totDataRows = 0;		
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+totDataRows).equals("")){
			totDataRows++;
		}
		return totDataRows;
	}


	
	/**
	 * The below code gets the total number of columns for a test
	 * @param xls
	 * @param sheetName
	 * @param testCaseName
	 * @return
	 */
	public int getTotalTestDataColumns(Xls_Reader xls, String sheetName, String testCaseName){
		/*
		 * The below code is to get total number of columns for a test 
		 */
		//System.out.println("Inside getTotalTestDataColumns");
		int colStartRowNum = getColumnStartRowNum(xls,sheetName, testCaseName);//getTestStartRowNum(xls,sheetName, testCaseName) + 1;
		int totDataCol = 0;
		while(!xls.getCellData(sheetName, totDataCol, colStartRowNum).equals("")){
			totDataCol++;
		}		
		return totDataCol;
	}

	public int getColumnStartRowNum(Xls_Reader xls, String sheetName, String testCaseName){
		int colStartRowNum = getTestStartRowNum(xls,sheetName, testCaseName) + 1;
		return colStartRowNum;
	}
	
	
	public int getDataStartRowNum(Xls_Reader xls, String sheetName, String testCaseName){
		//System.out.println("Inside getDataStartRowNum");
		int dataStartRowNum = getTestStartRowNum(xls, sheetName, testName) + 2;
		return dataStartRowNum;
	}


	public Object[][] getTestData(Xls_Reader xls, String sheetName, String testCaseName){
		//System.out.println("Inside getTestData");
		// Gets all the Data for test case \
		//Object[][] data = new Object[][]
		int colStartRownNum = getColumnStartRowNum(xls,sheetName, testCaseName);// + 1;
		int dataStartRowNum = getDataStartRowNum(xls, sheetName, testName);
		int totDataRows = getTotalTestDataRows(xls, sheetName, testName);
		int totDataCol = getTotalTestDataColumns(xls, sheetName, testName);
		Object[][] data = new Object[totDataRows][1];//[totDataCol];
		int dataRow = 0;
		HashMap<String, String> table = null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+totDataRows;rNum++){
			System.out.println("");
			table = new HashMap<String, String>();
			for(int cNum=0; cNum<totDataCol;cNum++){
				System.out.print(xls.getCellData(sheetName, cNum, rNum)+" ");
				String key = xls.getCellData(sheetName, cNum, colStartRownNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				//data[dataRow][cNum]= xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0] = table; 
			dataRow ++;
			//System.out.println();
		}

		return data;
	}
}
