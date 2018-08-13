package com.org.hybrid;

import java.io.File;
import java.nio.file.Paths;

public class CONSTANTS {
	static String separator = File.separator;
	public static String PROJECTPATH = System.getProperty("user.dir");//Workspace Path
	public static final String PROJECT_RESOURCES = Paths.get(PROJECTPATH, "src","test","resources").toString();
	public static final String SELENIUM_DRIVERS_PATH=Paths.get(PROJECT_RESOURCES, "Drivers").toString();
	public static final String TESTDATAFILES = Paths.get(PROJECTPATH, "Data").toString();
	public static final String SUITEADATA_XLS = Paths.get(TESTDATAFILES,"/SuiteA.xlsx").toString();
	public static final String EXTENTREPORT_CONFIG = Paths.get(PROJECTPATH,"src","test","resources","ReportsConfig.xml").toString();
	public static final String EXTENTREPORT  = Paths.get(PROJECTPATH, "ExtentReport","report.html").toString();
	public static final String TESTCASES_SHEET = "TestCases";
	public static final String DATA_COL = "Data";
	public static final String OBJECT_COL = "object";
	public static final String KEYWORD_COL = "Keyword";
	public static final String TCID_COL = "TCID";
	public static final String RUNMODE_COL = "Runmode";
	public static final String PASS  = "PASS";
	public static final String FAIL  = "FAIL";
	
}
