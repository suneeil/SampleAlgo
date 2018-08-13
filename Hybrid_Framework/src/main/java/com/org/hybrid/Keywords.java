package com.org.hybrid;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.omg.CORBA.TCKind;
import org.testng.Assert;

import com.org.hybrid.commonUtil.Xls_Reader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Hello world!
 *
 */
public class Keywords 
{
	ExtentTest test;
	AppKeywords app;

	public Keywords(ExtentTest test) {
		this.test = test;
	}

		

	public void executeKeywords(String testCaseName, Xls_Reader xls,HashMap<String, String> testData) throws Exception{
		
		//String testUnderExecution = "GmailTest";
		System.out.println("Entered in executeKeywords method");
		app = new AppKeywords(test);
	//	Class c = app.getClass(); //--------
	//	Method[] methods = c.getMethods(); //-------------
		
		System.out.println(" Setting app = new GenericKeywords");
		//xls = new Xls_Reader(CONSTANTS.SUITEADATA_XLS);
		int rows = xls.getRowCount("Keywords");
		int columns = xls.getColumnCount("Keywords");
		System.out.println("Before For loop");
		for(int rnum = 2; rnum<=rows; rnum++){
			
			//Class c = AppKeywords.class.getClass();
			
			String TCID = xls.getCellData("Keywords", "TCID", rnum);
			System.out.println("TCID: "+ TCID);
			if(TCID.equals(testCaseName)){
				String keyWord = xls.getCellData("Keywords", "Keyword", rnum); // Need to Add the sheet name in constants file
				String object = xls.getCellData("Keywords", "Object", rnum);
				String key = xls.getCellData("Keywords", "Data", rnum);
				String data = testData.get(key);
				
				
				System.out.println("TCID: "+TCID+" "+", keyword: "+keyWord+", Object: "+ object+", Data: "+ data);
				//app.report("TCID: "+TCID+" "+", keyword: "+keyWord+", Object: "+ object+", Data: "+ data);
				System.out.println("--------------------------------------");
				//test.log(LogStatus.INFO, "TCID: "+TCID+" "+", keyword: "+keyWord+", Object: "+ object+", Data: "+ data);
				String result="";
				//===============================================================				
				/*	for(Method m : methods){
						if(keyWord.equals(m.getName())){
							System.out.println("**************************************");
							m.invoke(app, object,data);
						}
					}
				*/
				//===============================================================
				if(keyWord.equals("openBrowser")){
					app.report("Open Browser: " + data);
					result = app.openBrowser(data);
				}else if(keyWord.equals("navigate")){
					app.report("Navigate to  "+object);
					result = app.navigate(object);
				}else if(keyWord.equals("click")){
					app.report("Click "+ object);
					result = app.click(object);
				}else if(keyWord.equals("navigateback")){
					app.report("Navigating back");
					result = app.navigateBack();
				}else if(keyWord.equals("input")){
					app.report("Entered data: "+data+" for the field: "+ object);
					result = app.input(object, data);
				}else if(keyWord.equals("verifyMenuBar")){
					app.report("Verifying Menu: "+data+" for the field: "+ object);
					result = app.verifyMenuBar(testData);
				}else if(keyWord.equals("verifyElementPresent")){
					app.report("Verifying Is Element present: " + object);
					result = app.verifyElementPresent(object);
				}else if(keyWord.equals("verifyElementNotPresent")){
					app.report("Verifying Is Element present: " + object);
					result = app.verifyElementNotPresent(object);
				}else if(keyWord.equals("flipkartLogin")){
					app.report("flipkartLogin:  " + data );
					app.flipkartLogin(testData);
				}else if(keyWord.equals("verifyFlipkartLogin")){
					app.report("verifyFlipkartLogin:  ");
					app.verifyFlipkartLogin(testData.get("expectedResult"));
				}
				
				//Common Place to report Failure
				if(!result.equals(CONSTANTS.PASS)){
					app.reportFail(result);
					Assert.fail(" >> " + result);
				}
			}
		}
		//app.openBrowser("Mozilla");
		//app.navigate("url");
		//app.click("gmailLink_xpath");
	}

	public AppKeywords getGenericKeywords(){
		return app;
	}
	
	public void executeKeywords(String testCaseName, Xls_Reader xls) throws Exception{
		//String testUnderExecution = "GmailTest";
				System.out.println("Entered in executeKeywords method");
				app = new AppKeywords(test);
				System.out.println(" Setting app = new GenericKeywords");
				xls = new Xls_Reader(CONSTANTS.SUITEADATA_XLS);
				int rows = xls.getRowCount("Keywords");
				int columns = xls.getColumnCount("Keywords");
				System.out.println("Before For loop");
				for(int rnum = 2; rnum<=rows; rnum++){

					String TCID = xls.getCellData("Keywords", "TCID", rnum);

					if(TCID.equals(testCaseName)){
						String keyWord = xls.getCellData("Keywords", "Keyword", rnum); // Need to Add the sheet name in constants file
						String object = xls.getCellData("Keywords", "Object", rnum);
						String data = xls.getCellData("Keywords", "Data", rnum); //>>>> String key = xls.getCellData("Keywords", "Data", rnum);
						//String data = testData.get(key);
						System.out.println("TCID: "+TCID+" "+", keyword: "+keyWord+", Object: "+ object+", Data: "+ data);
						//app.report("TCID: "+TCID+" "+", keyword: "+keyWord+", Object: "+ object+", Data: "+ data);
						System.out.println("--------------------------------------");
						//test.log(LogStatus.INFO, "TCID: "+TCID+" "+", keyword: "+keyWord+", Object: "+ object+", Data: "+ data);
						if(keyWord.equals("openBrowser")){
							app.report("Open Browser: " + data);
							app.openBrowser(data);
						}else if(keyWord.equals("navigate")){
							app.report("Navigate to  "+object);
							app.navigate(object);
						}else if(keyWord.equals("click")){
							app.report("Click "+ object);
							app.click(object);
						}else if(keyWord.equalsIgnoreCase("navigateback")){
							app.report("Navigating back");
							app.navigateBack();
						}else if(keyWord.equalsIgnoreCase("input")){
							app.report("Entered data: "+data+" for the field: "+ object);
							app.input(object, data);
						}
					}
				}
	}
	


}
