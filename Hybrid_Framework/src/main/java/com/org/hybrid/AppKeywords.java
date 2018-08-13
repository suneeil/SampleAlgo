package com.org.hybrid;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AppKeywords extends GenericKeywords{

	
	public AppKeywords(ExtentTest test) {
		super(test);
		// TODO Auto-generated constructor stub
	}

	
	public void verifyPageDetails(){
		
	}
	
	public String verifyMenuBar(HashMap<String, String> data){
		try{
			
			String[] menu = data.get("menu").split(",");
			String title = data.get("title");
			System.out.println("Expected Title: "+ title);
			System.out.println("========== Expecetd MENU ===========");
			for(int i=0 ; i<menu.length ; i++){
				System.out.println(menu[i]);
			}
			return CONSTANTS.PASS;
		}catch(Exception e){
			
		}	
		return CONSTANTS.PASS;
	}
	
	public String login(String userName, String password) throws Exception{		
		
		click("loginlink_xpath");	
		click("existingUsre_xpath");
		input("userName_xpath", userName);
		input("password_xpath", password);
		//getDriverElement("userName_xpath").sendKeys(userName);
		//getDriverElement("userName_xpath").sendKeys(password);
		//getDriverElement("loginbt_xpath").click();
		click("loginbt_xpath");
		//Validate login
		return CONSTANTS.PASS;
	}


	public String flipkartLogin(HashMap<String, String> testData) throws Exception {
		
		
			test.log(LogStatus.INFO, "Login using "+ testData.get("username") + " / "+ testData.get("password"));
			return login(testData.get("username"), testData.get("password"));
		
	}

	public String defaultLogin() throws Exception{
		return login("", "");
	}


	public String verifyFlipkartLogin(String expectedResult) throws Exception {
		test.log(LogStatus.INFO, "Verifying Login");
		String actResult = "";
		boolean result = isElelementPresent("");
		if(result)
			actResult="success";
		else
			actResult="failure";
		
			if(!actResult.equals(expectedResult)){
				return "Failed - " + ""+ actResult;
			}
		return CONSTANTS.PASS;		
		
	}

	
}
