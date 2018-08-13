package com.selenium.Webdriver.htmltopdf;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtractHTML {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.linkedin.com/");
		Thread.sleep(5000);
		
		PrintWriter out = new PrintWriter(workDir+"/source.html");
		out.println(driver.getPageSource());
		driver.quit();
	}

	
}
