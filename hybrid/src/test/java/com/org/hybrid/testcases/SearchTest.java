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
		driver.get("http://www.bing.com");
		//searchTxt_id=gs_htif0
		//searchBt_xpath=//input[@value='Google Search']
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='sb_form_go']")).click();
		
		List<WebElement> lis = driver.findElements(By.xpath("//nav[@class='b_scopebar']/ul/li/a"));
		System.out.println(lis.size());
		for(WebElement li : lis){
			System.out.println(li.getText());
		}
		
		//driver.findElement(By.id("gs_htif0")).sendKeys("Spiderman");
		//driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		//driver.findElement(By.id("_fZl")).click();
	}

	private void add(int i, int j) {
		System.out.println(i+j);
	}
	
	private void add(int i, int j , int k){
		System.out.println(i+j+k);
	}

}

