package com.selenium.Webdriver;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PopUpEx {

	public static void main(String[] args) {
		String projDir = System.getProperty("user.dir");
		Path path = Paths.get(projDir,"src","main","java","com","selenium","Webdriver");
		
		System.setProperty("webdriver.gecko.driver",path.toString()+"geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		ExpectedConditions.alertIsPresent();

	}

}
