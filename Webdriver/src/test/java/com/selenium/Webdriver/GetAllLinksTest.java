package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GetAllLinksTest {

	@Test
	public void gettest(){
	//public static void main(String[] args) {
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://yahoo.com");
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total: "+li.size());
		for(WebElement ele :li){
			String url = ele.getAttribute("href");
			if(url.startsWith("http")){
				System.out.println(ele.getText()+": "+url );
			}
		}
		
		
			
	}

}
