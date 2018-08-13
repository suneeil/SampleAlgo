package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationFrontBack {

	public static void main(String[] args) throws InterruptedException {
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.bing.com/");
		
		Thread.sleep(2000);
		WebElement imagesLink = driver.findElement(By.linkText("Images"));
		imagesLink.click();
		Thread.sleep(2000);
		
		String title = driver.getTitle();//driver.findElement(By.xpath("//div[@class='maia-aux']//h2")).getText();
		System.out.println("Title  : "+ title);
		driver.navigate().back();
		
		 title = driver.getTitle();
			System.out.println("Title 2: "+ title);
			
		driver.navigate().forward();
		
		title = driver.getTitle();
		System.out.println("Title 3: "+ title);
	
	}

}
