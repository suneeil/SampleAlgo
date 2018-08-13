package com.org.POMPageFactory.session;

import org.openqa.selenium.WebDriver;

import com.org.POMPageFactory.base.BasePage;

public class ProfilePage extends BasePage{
	
	
	public ProfilePage(WebDriver driver){
		//this.driver = driver;
		super(driver); //Now all the initilization of the driver will be done in the BasePage constructor
	}
	
	public void verifyProfile(){
		System.out.println("Verifying the profile");
	}
	
	
}
