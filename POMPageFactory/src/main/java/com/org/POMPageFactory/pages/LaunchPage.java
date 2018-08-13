package com.org.POMPageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.org.POMPageFactory.base.BasePage;
import com.org.POMPageFactory.util.AppConstants;

public class LaunchPage extends BasePage{
	
	
	public LaunchPage(WebDriver driver){
		/*System.out.println("Driver Launch Here ");
		driver.get("http://www.gmail.com");*/
		super(driver); //Now all the initilization of the driver will be done in the BasePage constructor
		//this.driver = driver;
	}
	
	
	public LoginPage gotoLoginPage(){
		/*LoginPage loginPage = new LoginPage();
		return loginPage;*/
		driver.get(AppConstants.APPLICATION_URL);
		//LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//return loginPage;
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
