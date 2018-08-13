package com.org.parallel;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports instance;
	
	public static synchronized ExtentReports getInstance() {
		if (instance == null) {
			System.out.println(System.getProperty("user.dir"));
			instance = new ExtentReports(System.getProperty("user.dir") + "/Extent.html");
			instance.loadConfig(new File("C:\\MyWorkSpace\\DesignePattern\\prallelExtentReporting\\src\\test\\java\\com\\org\\parallel\\ReportsConfig.xml"));
			
		}
		
		return instance;
	}
}