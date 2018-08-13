package com.selenium.Webdriver;

import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitEx {

	public static void main(String[] args) {
		String workDir = System.getProperty("user.dir").toString();
		String geckoDriver = Paths.get(workDir,"Driver","geckodriver.exe").toString();
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		
		WebDriver driver = new FirefoxDriver();
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
		fwait.withTimeout(5, TimeUnit.SECONDS);
		fwait.pollingEvery(1, TimeUnit.SECONDS);
		fwait.ignoring(NoSuchElementException.class);

	}

}
