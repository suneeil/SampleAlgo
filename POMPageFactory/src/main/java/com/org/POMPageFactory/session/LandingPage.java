package com.org.POMPageFactory.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.POMPageFactory.base.BasePage;
import com.org.POMPageFactory.pages.common.TopMenu;
import com.org.POMPageFactory.util.AppConstants;

public class LandingPage extends BasePage{
	
	
	@FindBy(xpath=AppConstants.PROFILE_PAGE_LINK)
	WebElement profileLink;
	public LandingPage(WebDriver driver){
		super(driver); //Now all the initilization of the driver will be done in the BasePage constructor
		//this.driver = driver;
	}
	
	
	
	
	public ProfilePage gotoProfilePage(){
		//ProfilePage proifle = new ProfilePage();
		System.out.println(" On Landing Go to Profile");
		profileLink.click();
		return PageFactory.initElements(driver, ProfilePage.class);
	}
	
	
	
	
	public void verifyProfile(){
		
	}
	
}
