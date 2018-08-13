package com.selenium.Webdriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandle {

	public static void main(String[] args) {
		String projDir = System.getProperty("user.dir");
		Path path = Paths.get(projDir,"src","main","java","com","selenium","Webdriver");
		
		System.setProperty("webdriver.gecko.driver",path.toString()+"geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("");
		
		Set<String> windows = driver.getWindowHandles();
		String firstWindow = driver.getWindowHandle();
		windows.remove(firstWindow);
		Iterator<String> itr = windows.iterator();
		
		String secondWindow = itr.next();
		driver.switchTo().window(secondWindow);
		
	}

}
