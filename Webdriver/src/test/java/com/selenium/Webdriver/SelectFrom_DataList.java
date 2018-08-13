package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFrom_DataList {
	static WebDriver driver;
	public static void main(String[] args) {
		
		try{
			String workDir = System.getProperty("user.dir").toString();
			String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
			System.setProperty("webdriver.gecko.driver", geckoDriver);
			
			driver = new FirefoxDriver();	
			WebDriverWait wait = new WebDriverWait(driver, 10);
			driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_datalist");
			//driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_elem_select");
			System.out.println("Iframes: "+driver.findElements(By.tagName("iframe")).size());

			driver.switchTo().frame("iframeResult");
					
			System.out.println("Input Field: "+driver.findElements(By.name("browser")).size());
				WebElement inputField = driver.findElement(By.name("browser"));
				inputField.sendKeys("o");
				Thread.sleep(2000);
				//System.out.println("Wait");
				//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//datalist[@id='browsers']"))));
				//System.out.println("Done Waiting");
				List<WebElement> suggestionBox = driver.findElements(By.xpath("//datalist[@id='browsers']/option"));
				System.out.println("Number of suggestions: "+suggestionBox.size());
				for(WebElement suggestion : suggestionBox){
					System.out.println(suggestion.getAttribute("value"));			
				}
				driver.quit();
		}catch(InterruptedException e){
			driver.quit();
		}
		
	}

}
