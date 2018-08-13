package com.org.POMPageFactory.util;

import java.nio.file.Paths;

public class AppConstants {
	public static String PROJECTPATH = System.getProperty("user.dir");
	
	//Browsers
	public static final String BROWSER = "Mozilla";
	
	
	//paths
	public static final String CHROME_DRIVER_EXE = "C:\\Chromedriver.exe";
	public static final String FIREFOX_DRIVER_EXE = "C:/MyWorkSpace/DesignePattern/POMPageFactory/Drivers/geckodriver.exe";
	
	
	//locators
	public static final String USERNAME = "//*[@id='email']";
	public static final String PWD = "//*[@id='pass']";
	public static final String PROFILE_PAGE_LINK = "//div[@data-click='profile_icon']//span";


	


	public static final String EXTENTREPORT_CONFIG = Paths.get(PROJECTPATH,"ReportsConfig.xml").toString();
	public static final String EXTENTREPORT  = Paths.get(PROJECTPATH, "ExtentReport").toString();
	public static String APPLICATION_URL = "http://www.facebook.com";
}
