package com.org.POMPageFactory.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.org.POMPageFactory.pages.LaunchPage;
import com.org.POMPageFactory.pages.LoginPage;
import com.org.POMPageFactory.session.LandingPage;
import com.org.POMPageFactory.testcases.base.BaseTest;


public class ProfileTest extends BaseTest{

	@Test
	public void testProfile() throws InterruptedException{
		System.out.println("Started");
		init("Mozilla");
		
		System.out.println("Created Driver");
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		System.out.println("Launch Page called");
		LoginPage loginPage = launchPage.gotoLoginPage();
		
		loginPage.verifyTitle("Title");
		Object page = loginPage.doLogin("suneeil@ymail.com", "SaiRAM@1");
		Thread.sleep(5000);
		
			
			if(page instanceof LoginPage){
				System.out.println("Assert Login Failure");
				Assert.fail("Unsuccessful Login");
			}else if(page instanceof LandingPage){
				System.out.println("Login Success");
			}
			
		LandingPage landingPage = (LandingPage) page;
		landingPage.verifyTitle("Title");
		((LandingPage) landingPage).gotoProfilePage();
		
		/*ProfilePage profPage = landingPage.gotoProfilePage();
		profPage.verifyProfile();
		profPage.verifyTitle("");*/
		
		/*To Access the TopMenu and logout use the below line
		 * landingPage.getMenu().logout();
		 * */
	}
		
}
