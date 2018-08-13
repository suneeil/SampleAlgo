package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickEachLink {

	public static void main(String[] args) throws InterruptedException {
		// .//*[@id='popular_cat']
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.navigate().to("http://shopping.rediff.com/");
			WebElement box = driver.findElement(By.xpath("//*[@id='popular_cat']"));
			List<WebElement> aTag = box.findElements(By.tagName("a"));
			
			for(WebElement e : aTag){
				System.out.println("--->>> " + e.getText());
				e.click();				
				System.out.println(driver.getTitle());				
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(3000);
				
				//wait.until(ExpectedConditions.visibilityOf(e));
				box = driver.findElement(By.xpath("//*[@id='popular_cat']"));
				aTag = box.findElements(By.tagName("a"));
			}

	}

}
