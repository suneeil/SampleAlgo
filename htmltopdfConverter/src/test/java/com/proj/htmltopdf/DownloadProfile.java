package com.proj.htmltopdf;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadProfile {

	public static void main(String[] args) throws InterruptedException, AWTException {
		String workDir = System.getProperty("user.dir").toString();
		System.out.println(" Start ");
		System.setProperty("webdriver.chrome.driver", "C:\\MyWorkSpace\\DesignePattern\\htmltopdfConverter\\Driver\\chromedriver.exe");
		String downloadFilepath = "C:\\TEMPD";

		  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		  chromePrefs.put("profile.default_content_settings.popups", 0);

		  chromePrefs.put("download.default_directory", downloadFilepath);

		  ChromeOptions options = new ChromeOptions();

		  HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

		  options.setExperimentalOption("prefs", chromePrefs);

		  options.addArguments("--headless");

		  DesiredCapabilities cap = DesiredCapabilities.chrome();

		  cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);

		//  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		  cap.setCapability(ChromeOptions.CAPABILITY, options);   
		  
		 WebDriver driver = new ChromeDriver(cap);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://www.linkedin.com");
		System.out.println(driver.getTitle());
		//Thread.sleep(8000);
		System.out.println("IS USER NAME FIELD DISPLAYED: "+driver.findElement(By.xpath("//input[@id='login-email']")).isDisplayed());
		System.out.println("IS PASSWORD FIELD DISPLAYED: "+driver.findElement(By.xpath("//input[@id='login-password']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("g.sunilrao@gmail.com");
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("SaiRAM@1");
		driver.findElement(By.xpath("//input[@id='login-submit']")).click();
		Thread.sleep(8000);
		System.out.println(driver.getTitle());
		System.out.println("IS THE SEARCH FIELD DISPLAYED: "+driver.findElement(By.xpath("//input[@placeholder='Search']")).isDisplayed());
		
		System.out.println("Is the Connections Displayed: " + driver.findElement(By.xpath("//div[@class='stat-container']")).isDisplayed() );
		//Click on all the  connections
		driver.findElement(By.xpath("//ul[contains(@class,'nav-main')]//a[@data-link-to='mynetwork']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class='left-rail-container']//a[contains(.,'See all')]")).click();
		Thread.sleep(5000);
		//Get the Size of Links //div[@role='main']//ul//li
		List<WebElement> links = driver.findElements(By.xpath("//div[@role='main']//ul//li"));
		System.out.println("Total: " + links.size());
		
		System.out.println(driver.findElement(By.xpath("//div[@role='main']//ul/li["+1+"]//a/span[2]")).getText());
		
		WebElement link = driver.findElement(By.xpath("//div[@role='main']//ul/li["+1+"]//a/span[2]"));
		Actions newTab = new Actions(driver);
		newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(link).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
		
		Thread.sleep(8000);
		
		//Get Window Handle
		String base = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		set.remove(base);
		System.out.println("Windows: "+set.size());
		assert set.size() == 1;
		driver.switchTo().window((String) set.toArray()[0]);
		Thread.sleep(8000);
		 System.out.println("TITLE AFTER SWITCH: "+driver.getTitle());
		 //Dopwnload Steps
		 System.out.println("MORELINK: "+ driver.findElement(By.xpath("//span[contains(.,'More')]")).isDisplayed());
		 driver.findElement(By.xpath("//span[contains(.,'More')]")).click();
		 Thread.sleep(2000);
		 System.out.println("SAVE AS PDF: "+  driver.findElement(By.xpath("//button//span[contains(.,'Save to PDF')]")).isDisplayed());
		 
		 File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File(workDir+"\\newtab.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		 driver.findElement(By.xpath("//button//span[contains(.,'Save to PDF')]")).click();
		 Thread.sleep(15000);
		 
		/* //Robot Steps
		 	Robot robot = new Robot();
			Thread.sleep(7000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(5000);*/
		 
		//close the window and switch back to the base tab
		//driver.close();
		driver.switchTo().window(base);
		System.out.println("MAIN TITLE AFTER SWITCH: "+driver.getTitle());
		driver.quit();

	}

}
