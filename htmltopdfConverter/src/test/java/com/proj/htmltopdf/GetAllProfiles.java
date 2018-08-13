package com.proj.htmltopdf;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class GetAllProfiles {

	public static void main(String args[]) throws Exception{
		String workDir = System.getProperty("user.dir").toString();
		

		
		System.out.println(" Start ");
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(options);

		try{
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

			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File(workDir+"\\headless_screenshot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Is the Connections Displayed: " + driver.findElement(By.xpath("//div[@class='stat-container']")).isDisplayed() );
			//Click on all the  connections
			driver.findElement(By.xpath("//ul[contains(@class,'nav-main')]//a[@data-link-to='mynetwork']")).click();
			Thread.sleep(5000);
			file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File(workDir+"\\AllProfiles_screenshot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Thread.sleep(5000);
			//Click on Ses All  //div[@class='left-rail-container']//a[contains(.,'See all')]
			driver.findElement(By.xpath("//div[@class='left-rail-container']//a[contains(.,'See all')]")).click();
			Thread.sleep(5000);
			//Get the Size of Links //div[@role='main']//ul//li
			List<WebElement> links = driver.findElements(By.xpath("//div[@role='main']//ul//li"));
			System.out.println("Total: " + links.size());

			//Loading ICON ------>   //span[@class='artdeco-spinner-bars']
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

			System.out.println("Actual Contacts: "+ driver.findElement(By.xpath("//header[@class='mn-connections__header']/h2")).getText());
			String strCount = driver.findElement(By.xpath("//header[@class='mn-connections__header']/h2")).getText();
			System.out.println("---------" + strCount);
			
			int ActualConnections = 491;//Integer.parseInt(strCount.replaceAll("[a-zA-Z]", "").trim());
			int count = 0;
			int actNum = links.size();
			System.out.println("Actual Connection Manual: " + ActualConnections);
			while(!(actNum == ActualConnections)){//
				System.out.println("Hit End Key");
				actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				Thread.sleep(2000);
				actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
				Thread.sleep(2000);
				actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				//actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				links = driver.findElements(By.xpath("//div[@role='main']//ul//li"));
				System.out.println("TOTAL LINKS --> "+(count++)+":"+ links.size());
				actNum = links.size();		
				System.out.println("actNum: "+ actNum + " ActualConnection: " + ActualConnections + "---"+ (actNum == ActualConnections));
				//Thread.sleep(2000);
			}

			for(int i=1 ; i<links.size();i++){
				//System.out.println(links.get(i).findElement(By.xpath("//div[@class='mn-connection-card__details']/a/span[2]")).getText());
				System.out.println(links.get(i).findElement(By.xpath("//div[@role='main']//ul/li["+i+"]//a/span[2]")).getText());
			}


			//Click on More button ---> //span[contains(.,'More')]

			//Click on Save as PDF  //button//span[contains(.,'Save to PDF')]

			//Use robot code to save

			//Navigate Back



			//  //div[@role='main']//ul//li[X]//a/span[2]

			driver.quit();
			System.out.println("  END  ");
		}catch(Exception e){

		}finally{
			driver.quit();
			System.out.println("  END  ");
		}
	}


}
