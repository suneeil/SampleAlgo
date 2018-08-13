package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IFrameEx {

	public static void main(String[] args) throws InterruptedException {
		// https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select_pre
		
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select_pre");
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select");
		System.out.println("Total num of Iframes: "+driver.findElements(By.tagName("iframe")).size());
		System.out.println("Before Switching to Frame is the element displayed ?, Get the Size of Element");
		System.out.println(driver.findElements(By.xpath("//select[@name='cars']")).size());
		driver.switchTo().frame("iframeResult");
		System.out.println("After Switching to Frame is the element displayed ?, Get the Size of Element");
		System.out.println(driver.findElements(By.xpath("//select[@name='cars']")).size());
		
		WebElement dropList = driver.findElement(By.xpath("//select[@name='cars']"));
		
		/*dropList.sendKeys("Saab");
		Thread.sleep(2000);		
		dropList.sendKeys("Volvo");
		Thread.sleep(2000);
		dropList.sendKeys("Fiat");*/
	}

}
