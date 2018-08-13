package com.selenium.Webdriver;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectEx {

	public static void main(String[] args) throws InterruptedException {
		//String projDir = System.getProperty("user.dir");
		//Path path = Paths.get(projDir,"src","main","java","com","selenium","Webdriver");
		
		System.setProperty("webdriver.gecko.driver", "C:\\\\MyWorkSpace\\DesignePattern\\Webdriver\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select");
		
		Select se = new Select(driver.findElement(By.xpath("(//select)[1]")));
		//se.selectByIndex(1);
		se.selectByValue("value3");
		Thread.sleep(2000);
		se.selectByValue("value2");
		Thread.sleep(2000);
		se.selectByValue("value1");
		//se.selectByVisibleText("");

	}

}
