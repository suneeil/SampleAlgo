package com.selenium.Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
		System.setProperty("webdriver.gecko.driver", "C:\\\\MyWorkSpace\\DesignePattern\\Webdriver\\Driver\\geckodriver.exe");
		//C:\MyWorkSpace\DesignePattern\Webdriver\Driver\geckodriver.exe
        String projDir = System.getProperty("user.dir");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.bing.com");
        Thread.sleep(3000);
        driver.get("http://www.yahoo.com");
        Thread.sleep(3000);
        driver.get("http://www.bing.com");
    }
}
