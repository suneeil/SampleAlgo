package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton {

	public static void main(String[] args) {
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		
		WebDriver driver = new FirefoxDriver();	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		
		List<WebElement> allRadio = driver.findElements(By.name("group1"));
		System.out.println(allRadio.size());
		for(WebElement radio : allRadio){
			System.out.println(radio.getAttribute("value")+" "+radio.getAttribute("checked"));
		}
		driver.findElement(By.xpath("//input[@value='Milk']")).click();
		
		for(WebElement radio : allRadio){
			System.out.println(radio.getAttribute("value")+" "+radio.getAttribute("checked"));
		}
	}

}
