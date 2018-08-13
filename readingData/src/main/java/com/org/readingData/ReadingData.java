package com.org.readingData;

/**
 * Hello world!
 *
 */
public class ReadingData 
{
    public static void main( String[] args )
    {
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
		
		/*
		 * The below code is to get total number of Rows for a test
		 */
		int totDataRows = 0;		
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+totDataRows).equals("")){
			totDataRows++;
		}
		System.out.println("Total Data Rows for "+ testcaseName + ": "+ totDataRows);
		/*
		 * The below code is to get total number of columns for a test 
		 */
		int totDataCol = 0;
		while(!xls.getCellData(sheetName, totDataCol, colStartRowNum).equals("")){
			totDataCol++;
		}
		System.out.println("Total data Columns for testcase : "+testcaseName + " "+ totDataCol);
		
		/*
		 * Gets all the Data for test case 
		 */
		System.out.println("Data Start Row num: " + dataStartRowNum);
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+totDataRows;rNum++){
			for(int cNum=0; cNum<totDataCol;cNum++){
				System.out.print(xls.getCellData(sheetName, cNum, rNum)+" ");
			}
			System.out.println();
		}
		
    }
}
