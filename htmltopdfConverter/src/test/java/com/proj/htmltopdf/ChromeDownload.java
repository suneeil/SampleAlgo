package com.proj.htmltopdf;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeDownload {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String workDir = System.getProperty("user.dir").toString();
		System.setProperty("webdriver.chrome.driver", "C:\\MyWorkSpace\\DesignePattern\\htmltopdfConverter\\Driver\\chromedriver.exe");
	       String downloadFilepath = "C:\\TEMPD\\";
 
	       HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	       chromePrefs.put("profile.default_content_settings.popups", 0);
	       chromePrefs.put("download.default_directory", downloadFilepath);
	       
	       ChromeOptions options = new ChromeOptions();
	       options.setExperimentalOption("prefs", chromePrefs);
	      // options.addArguments("--test-type");
	       options.addArguments("--disable-extensions"); //to disable browser extension popup
	       //options.addArguments("--headless");
 
	       driver = new ChromeDriver(options);  
	                driver.get("http://www.seleniumhq.org/download/");
	                System.out.println(driver.getTitle());
	               System.out.println( driver.findElement(By.linkText("32 bit Windows IE")).isDisplayed());
	                driver.findElement(By.linkText("32 bit Windows IE")).click();
	                Thread.sleep(2000);
	                
	                File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                try {
	    				FileUtils.copyFile(file, new File(workDir+"\\chrome.png"));
	    			} catch (IOException e) {
	    				e.printStackTrace();
	    			}
	                
	                System.out.println("END");

	}

}
