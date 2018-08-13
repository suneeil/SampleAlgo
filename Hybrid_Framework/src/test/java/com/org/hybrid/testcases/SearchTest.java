package com.org.hybrid.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.org.hybrid.CONSTANTS;

public class SearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		/*SearchTest t = new SearchTest();
		t.add(2,3);
		t.add(1, 2, 3);*/
		System.setProperty("webdriver.gecko.driver", CONSTANTS.SELENIUM_DRIVERS_PATH+"/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		//searchTxt_id=gs_htif0
		//searchBt_xpath=//input[@value='Google Search']
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/a")).click();
		//Thread.sleep(3000);
			WebElement existingUser = driver.findElement(By.xpath("//span[text()='Existing User? Log in']")); 
			if(existingUser.isDisplayed())
				driver.findElement(By.xpath("//span[text()='Existing User? Log in']")).click();
		
		driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']")).sendKeys("g.sunilrao@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ka04em");
		driver.findElement(By.xpath("//button//span[text()='Login']")).click();
		
	/*	List<WebElement> lis = driver.findElements(By.xpath("//nav[@class='b_scopebar']/ul/li/a"));
		System.out.println(lis.size());
		for(WebElement li : lis){
			System.out.println(li.getText());
		}*/
		
		//driver.findElement(By.id("gs_htif0")).sendKeys("Spiderman");
		//driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		//driver.findElement(By.id("_fZl")).click();
	}

	

}

