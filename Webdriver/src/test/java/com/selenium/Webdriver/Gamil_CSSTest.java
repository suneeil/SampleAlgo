package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Gamil_CSSTest {
	
	//@Test
	public void test(){
	//public static void main(String[] args) {
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();
		driver.get("http://accounts.google.com");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement emailInp = driver.findElement(By.cssSelector("#Email"));
		wait.until(ExpectedConditions.visibilityOf(emailInp));
		emailInp.sendKeys("9886066267");
		String enteredText = emailInp.getAttribute("value");
		System.out.println("Entered: "+ enteredText);
	}

}
