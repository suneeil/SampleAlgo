package tests;

import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LaunchPage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest {

	@Test
	public void testProfile(){
		LaunchPage lp = new LaunchPage();
		LoginPage login = lp.gotoLoginPage();
		LandingPage landPage = login.doLogin("Sunil", "mypwd");
		ProfilePage profilePage = landPage.gotoProfilePage();
	}
		
}
