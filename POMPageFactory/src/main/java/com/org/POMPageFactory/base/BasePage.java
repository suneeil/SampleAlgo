package com.org.POMPageFactory.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.org.POMPageFactory.pages.common.TopMenu;

public class BasePage {

	public WebDriver driver;
	public TopMenu menu; //Since every page has a Top Menu we are creating TopMenu Obj in Base page
	
	
	public TopMenu getMenu() {
		//To Access the menu in the test case you will have to landingPage.getMenu().logout();
		return menu;
	}

	public BasePage(){
		//Default Constructors
	}
	
	public BasePage(WebDriver driver){
		this.driver = driver; //Initialization of the Driver Done Here 
		//Which is a centralized location in the framework
		menu = PageFactory.initElements(driver, TopMenu.class);//Initializing Menu here will provide Top Menu for all the pages
	}
	
	
	public boolean verifyTitle(String expected){
		return true;
	}
	
	public boolean verifyText(String locator, String expectedText){
		System.out.println("Verify The TEXT");
		return true;
	}
	
	public boolean isElementPresent(String locator){
		System.out.println("Is Element Present");
		return true;
	}
	
}
