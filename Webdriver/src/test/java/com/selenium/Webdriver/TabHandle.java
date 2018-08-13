package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabHandle {

	public static void main(String[] args) throws InterruptedException {

		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();
		driver.get("http://accounts.google.com");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		WebElement privacyLInk = driver.findElement(By.linkText("Privacy"));
		privacyLInk.click();
		Thread.sleep(4000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		System.out.println("TAB COUNT: "+tabs2.size());
		driver.switchTo().window(tabs2.get(1));
		String header = driver.findElement(By.xpath("//div[@class='maia-aux']//h2")).getText();
		System.out.println("Header: "+ header);
		
	}

}


