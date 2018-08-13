//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

package com.org.hybrid.commonUtil;

import java.io.File;
import java.nio.file.Paths;

import com.org.hybrid.CONSTANTS;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	private ExtentManager(){}

	public static ExtentReports getInstance() {
		if (extent == null) {
			//String projDir = System.getProperty("user.dir");
			String reportConfigFile = Paths.get(CONSTANTS.EXTENTREPORT_CONFIG).toString();

			//extent = new ExtentReports("D:\\report\\report.html", true, DisplayOrder.OLDEST_FIRST);			
			extent = new ExtentReports(CONSTANTS.EXTENTREPORT,true,DisplayOrder.OLDEST_FIRST);

			// optional
			//	extent.config().documentTitle("Automation Report")
			//			.reportName("Regression").reportHeadline("");
			extent.loadConfig(new File(reportConfigFile));
			// optional
			extent.addSystemInfo("Selenium Version", "3.x").addSystemInfo("Environment", "QA");
		}
		return extent;
	}
}
