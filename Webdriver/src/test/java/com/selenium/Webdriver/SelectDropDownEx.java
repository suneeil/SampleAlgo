package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDropDownEx {

	public static void main(String[] args) throws InterruptedException {
		// https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select_pre
		
				String workDir = System.getProperty("user.dir").toString();
				String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
				System.setProperty("webdriver.gecko.driver", geckoDriver);
				WebDriver driver = new FirefoxDriver();	
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				//driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select_pre");
				driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select");
				System.out.println("Iframes: "+driver.findElements(By.tagName("iframe")).size());

				driver.switchTo().frame("iframeResult");
				System.out.println(driver.findElement(By.xpath("//select[@name='cars']")).isDisplayed());
				
				WebElement dropList = driver.findElement(By.xpath("//select[@name='cars']"));
				
				List<WebElement> options = dropList.findElements(By.tagName("option"));
				for(WebElement option : options){
					System.out.println(option.getText());
				}
				
				//Select Dropdown using SendKeys
				dropList.sendKeys("Saab");
				Thread.sleep(2000);		
				dropList.sendKeys("Volvo");
				Thread.sleep(2000);
				dropList.sendKeys("Fiat");
				
				//Seelcting the options using Select 
				
				
	}

}
