package com.org.hybrid;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

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
	
	public void login(String userName, String password){
		
	}
	
}
