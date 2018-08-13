package com.selenium.Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class GetValueFromINPUT {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\\\MyWorkSpace\\DesignePattern\\Webdriver\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.bing.com");
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String str = driver.findElement(By.xpath("//input[@id='sb_form_q']")).getAttribute("value");
		System.out.println(str);
	}

}
