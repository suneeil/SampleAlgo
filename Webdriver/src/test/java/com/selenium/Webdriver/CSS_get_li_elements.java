package com.selenium.Webdriver;

import java.beans.Visibility;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CSS_get_li_elements {

	public static void main(String[] args) {
		//li[data-category='trending news'] li span:nth-child(2)
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://in.yahoo.com/?p=us");
		WebElement outUL = driver.findElement(By.cssSelector("li[data-category='trending news']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(outUL));
		List<WebElement> liEle = driver.findElements(By.cssSelector("li[data-category='trending news'] li span:nth-child(2)"));
		for(WebElement ele : liEle){
			System.out.println(ele.getText());
		}
		
		

	}

}
