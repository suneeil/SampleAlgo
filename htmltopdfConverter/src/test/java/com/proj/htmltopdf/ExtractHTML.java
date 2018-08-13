package com.proj.htmltopdf;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtractHTML {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, AWTException {
		
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.linkedin.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("g.sunilrao@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("SaiRAM@1");
		driver.findElement(By.xpath("//input[@id='login-submit']")).click();
		Thread.sleep(8000);
		System.out.println(driver.getTitle());
		System.out.println("IS THE SEARCH FIELD DISPLAYED: "+driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed());
		//Search for the Profile
		//Click on More Text --> //span[contains(text(),'More')]
		//Click on Save to PDF --> //span[contains(text(),'Save to PDF')]
		
		
		
		//driver.findElement(By.id("login-email")).sendKeys(Keys.chord(Keys.CONTROL,"S"));
		
		//driver.findElement(By.id("login-email")).sendKeys(Keys.ENTER);
		
		//Actions action = new Actions(driver);
		//WebElement searchBox = driver.findElement(By.id("main-container"));
		//action.contextClick(searchBox).perform();
		/**
		 * The below Code works using Robot
		 */
		/*Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
		//------------------------
		
		/*PrintWriter out = new PrintWriter(workDir+"/source.html");
		out.println(driver.getPageSource());*/
		//driver.quit();
		
				
		
	}

	
}
