package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollIntoView {

	public static void main(String[] args) {
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		//driver.get("https://yahoo.com");
		WebElement container = driver.findElement(By.xpath("//ul[@id='Stream']//h3"));
		//ul[@id='Stream']//h3
		// //div[@id='mCSB_2_container']
		JavascriptExecutor js = (JavascriptExecutor) driver;
			
		List<WebElement> paras =	container.findElements(By.tagName("p"));
		System.out.println(paras.size());
		for(WebElement ele : paras){
			//js.executeScript("args[0].scrollIntoView(true);", ele);
			System.out.println(ele.getText());
		}
	}

}
