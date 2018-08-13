package com.proj.htmltopdf;

public class Test {

	public static void main(String[] args) {
		int exp = 5;
		int count = 0;
		
		while(!(exp==count)){
			System.out.println(count+"=="+(exp==count));
			
			count++;
		}

		System.out.println("DONE");
		
		
	}

	
	/*WebClient webClient = new WebClient(BrowserVersion.CHROME);
	webClient.getOptions().setJavaScriptEnabled(true); 
	webClient.getOptions().setThrowExceptionOnScriptError(false); 
	webClient.getOptions().setCssEnabled(false); 
	webClient.setAjaxController(new NicelyResynchronizingAjaxController()); 
	
	HtmlPage webPage = webClient.getPage("http://www.linkedin.com");
	HtmlForm loginForm = (HtmlForm) webPage.getByXPath("//form[@class='login-form']");
	
	HtmlInput userName = (HtmlInput) loginForm.getByXPath("//input[@id='login-email']");
	HtmlInput pwd = (HtmlInput)loginForm.getByXPath("//input[@id='login-password']");
	
	userName.type("g.sunilrao@gmail.com");
	pwd.type("SaiRAM@1");
	
	HtmlInput signInBt = (HtmlInput) loginForm.getByXPath("//inpur[@id='login-submit']");
	signInBt.click();
	Thread.sleep(5000);
	System.out.println(webPage.getTitleText());*/
	
}
