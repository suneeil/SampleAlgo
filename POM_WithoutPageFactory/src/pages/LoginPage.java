package pages;

public class LoginPage {

	public LandingPage doLogin(String user, String pwd){
		System.out.println("Loging into FB usig " + user + ", pwd: "+ pwd);
		LandingPage landPage = new LandingPage();
		return landPage;
	}
	
}
