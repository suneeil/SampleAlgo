package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class SelectUsingSelectClass {

	public static void main(String[] args) throws InterruptedException {

		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select_pre");
		//driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select");
		System.out.println("Iframes: "+driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame("iframeResult");
		System.out.println(driver.findElement(By.xpath("//select[@name='cars']")).isDisplayed());
		
		WebElement dropList = driver.findElement(By.xpath("//select[@name='cars']"));
		Select sel = new Select(dropList);
		System.out.println("Selecting by Index");
		//Select By Index
		sel.selectByIndex(1);
		Thread.sleep(2000);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		sel.selectByIndex(1);
		System.out.println("Selecting by Visible Text: ");
		//Select By Visible Text
		sel.selectByVisibleText("Audi");
		Thread.sleep(2000);
		sel.selectByVisibleText("Fiat");
		Thread.sleep(2000);
		sel.selectByVisibleText("Audi");
		System.out.println("Selecting by value Attribute: ");
		//Select By Value attribute
		sel.selectByValue("volvo");
		Thread.sleep(2000);
		sel.selectByValue("saab");
		Thread.sleep(2000);
		sel.selectByValue("audi");
		Thread.sleep(2000);
		sel.selectByValue("volvo");
		//------------
		WebElement selectedEle = sel.getFirstSelectedOption();
		System.out.println("Selected Elemenet: "+selectedEle.getText());
		//-----------
		List<WebElement> opt = sel.getOptions();
		System.out.println("Total Options: "+ opt.size());
		for(WebElement o : opt){
			System.out.print(o.getText()+ " ");
		}
		
	}

}
