package com.org.hybrid;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;














import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.org.hybrid.commonUtil.ExtentManager;
import com.org.hybrid.commonUtil.PropertiesReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.FileUtils;


/**
 ** @author Sunil
 * Open browser, navigate, Click, Verify title, verify Text
 */
public class GenericKeywords {

	public WebDriver driver;
	public PropertiesReader prop;
	public String projectPath = CONSTANTS.PROJECTPATH;
	private WebElement element = null;
	public ExtentTest test;
	//private ExtentReports extent;// = ExtentManager.getInstance();
	
	public GenericKeywords(ExtentTest test){
		this.test = test;
		//extent = ExtentManager.getInstance();
		try {			
			prop = new PropertiesReader(CONSTANTS.PROJECT_RESOURCES+"/project.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getProperty(String key){		
		return prop.getPropertyValue(key); 
	}
	
	public String openBrowser(String browserType){

		if(browserType.equalsIgnoreCase("Mozilla")){
			System.setProperty("webdriver.gecko.driver", CONSTANTS.SELENIUM_DRIVERS_PATH+"/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("IE")){

		}else if(browserType.equalsIgnoreCase("chrome")){

		}
		return CONSTANTS.PASS;
	}

	/**
	 * <b>This method to capture Screen Shot for test and store at a path with file name passed as input</b>
	 * 
	 * @param fileName - name of the file in String format.
	 * @return 
	 * @throws Exception - if the file name or path not found.
	 */
	public String captureScreenShot(String fileName) 
	{
		String filePath = Paths.get(CONSTANTS.EXTENTREPORT, "report","Screenshots",fileName).toString();
		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//The below method will save the screen shot in d drive with name "screenshot.png"
			org.apache.commons.io.FileUtils.copyFile(srcFile, new File(filePath));
			//FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			//APPLICATION_LOG.info("Exception From captureScreenShot: "+ e.getMessage());
			System.out.println("Exception From captureScreenShot : "+ e.getMessage());
		}

		return filePath;
		//config.properties

	}
	
	
	
	
	public WebElement getDriverElement(String identifier) throws Exception{
		
		element = null;
		try{
			//APPLICATION_LOG.info("Driver is instance of Web");
			element = driver.findElement(identifierType(identifier));
			//APPLICATION_LOG.info("Providing the Web elemenmt: " + element);	
		}catch(Exception e){
			//APPLICATION_LOG.info("##### Exception from driverElement method, for the identifier: "+ identifier);
			//throw new Exception("Exception from driverElement\'s method because of identifier[" + identifier + "] Cause by: "+ e.getMessage());
			reportFail(">>> Filure in getting the Driver Element: [" +identifier+"] <<< "+ e.getMessage());
			Assert.fail(">>> Filure in getting the Driver Element: ["+ identifier +"] <<< " + e.getMessage());
		}
		return element;
	}
	
	public List<WebElement> getDriverElements(String identifier) throws Exception{
		List<WebElement> elements = null;
		try{
			elements = driver.findElements(identifierType(identifier));
		}catch(Exception e){
			reportFail(">>> Filure in getting the Driver \"Elements\":  ["+ identifier+"] <<<" + e.getMessage());
			Assert.fail(">>> Filure in getting the Driver \"Elements\": [" +identifier+"] <<<" + e.getMessage());
		}
		return elements;
	}
	
	/**
	 * <b>This method takes identifier name as input to decides type of locator e.g - ID,XPATH,LINKTEXT,class</b>
	 * 
	 * @param identifier -  name of element in String format provided in Object repository properties file. 
	 * @return By class Object as per the input.
	 * @throws Exception 
	 */
	public By identifierType(String identifier) throws Exception{
		By byType = null;
		try{
			if(identifier.endsWith("_xpath"))
				byType = By.xpath(getProperty(identifier));
			else if(identifier.endsWith("_id"))
				byType = By.id(getProperty(identifier));
			else if(identifier.endsWith("_linktext"))
				byType =By.linkText(getProperty(identifier));
			else if(identifier.endsWith("class"))
				byType = By.className(getProperty(identifier));
			else if(identifier.endsWith("_tag"))
				byType = By.tagName(getProperty(identifier));
		}catch(Throwable e){
			//APPLICATION_LOG.debug("######### Unknown identiier type--"+ identifier);
			System.out.println("######### Unknown identiier type-- " + identifier);
			throw new Exception("Exception From By_identifierType method because of the identifier: ["+identifier+"] Exception: " + e.getMessage());
		}
		return byType;
	}

	
	/***************** Reporting functions************************/
	/**
	 * Used for reporting. 
	 * Method need to be called before staart every test method, It starts the test and assgined to category.
	 * The category will have the calling Class file Name
	 * @param testCaseName
	 */
	/*public void startReporting(String testCaseName, String category, String description){
		//APPLICATION_LOG.info("##################################  Test: " + testCaseName + ", Starts execution ##################################");
		System.out.println(testCaseName+ " "+ category + " " + description);
		test = extent.startTest(testCaseName, description);
		//To assigne category to report, the below code is used to pick the class Name and assigne as a Category
		//String calledClass = new Exception().getStackTrace()[1].getFileName();
		//System.out.println("fileName: "+ calledClass);
		//String[] fileNames = calledClass.split("\\.");
		//String category = fileNames[0];
		test.assignCategory(category);
	//	APPLICATION_LOG.info("Assigning Category as: "+ category + " to the test: "+ testCaseName);
	}*/
	public void report(String message){
		test.log(LogStatus.INFO, message);
	}
	
	public void reportPass(String message){
		test.log(LogStatus.PASS, message);
	}
	
	
	public void reportFail(String message){
		try{
			test.log(LogStatus.FAIL, message +"<br>ScreenShot below:<br>"+ test.addScreenCapture(captureImageAsBase64()));
			Assert.fail(message);
		}catch(Exception e){
			System.out.println("Exception from report Fail Method: "+ e.getMessage());
		}
	}
	
	/**
	 * Used for reporting. This method needs to be called at the end of every test method,
	 * If this not called the report will be incomplete or will have unexpected result in the report 
	 */
	/*public void stopReporting(){
		extent.endTest(test);
		//APPLICATION_LOG.info("##################################  #### Test Ends Here #####  ##################################");
	}*/
	/***************** Utility functions************************/
	

	
	/**
	 * Selenium Method which returns the captured screen shot as base64
	 */	
	public String captureImageAsBase64() 
	{
		 String base64Str = null;
		try{
		       base64Str = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		    //The below method will save the screen shot in d drive with name "screenshot.png"  
		    
		}catch(Exception e){
			System.out.println("Exception from captureImageAsBase64 method: "+ e.getMessage()+"\n");
		}
		
		return "data:image/png;base64,"+base64Str;
	}
	public String navigate(String urlKey){
		System.out.println("Navigating to "+getProperty(urlKey));
		driver.get(getProperty(urlKey));
		return CONSTANTS.PASS;
	}

	public String click(String locatorKey) throws Exception{
		try{
			System.out.println("Clicking on "+ getProperty(locatorKey) );
			System.out.println(locatorKey+ " Displayed: "+getDriverElement(locatorKey).isDisplayed());
			getDriverElement(locatorKey).click();
		}catch(Exception e){
			throw new Exception(">>>> Execption from Click >>>> "+ e.getMessage());
		}
		return CONSTANTS.PASS;
	}

	public boolean isElelementPresent(String locatorKey) throws Exception {
		List<WebElement> elements = getDriverElements(locatorKey);
		if(elements.size()==0)
			return false;
		else
			return true;
	}
	
	
	public String navigateBack() throws Exception{
		try{
			driver.navigate().back();
		}catch(Exception e){
			throw new Exception(">>>> Execption from Navigate Back >>>> "+ e.getMessage());
		}
		return CONSTANTS.PASS;
	}
	
	public String input(String locatorKey, String data) throws Exception{
		try{
			getDriverElement(locatorKey).sendKeys(data);
		}catch(Exception e){
			throw new Exception(">>>> Execption from input Back >>>> "+ e.getMessage());
		}
		return CONSTANTS.PASS;
	}

	
	public String closeBrowser(){
		System.out.println("Close Browser");
		driver.close();
		return CONSTANTS.PASS;
	}
	
	public void pause(int data){
		try{
			Thread.sleep(data);
		}catch(Exception e){
			System.out.println("Exception ffrom PAUSE " + e.getMessage());
		}
	}
	
	/***************** Verification functions************************/
	public String verifyText(String locatorKey, String expectedText) throws Exception{
			WebElement e = getDriverElement(locatorKey);
			String actualText = e.getText();
				if(actualText.equals(expectedText))
					return CONSTANTS.PASS;
				else
					return CONSTANTS.FAIL;
	}


	public String verifyElementPresent(String locatorKey) throws Exception{
		boolean result = isElelementPresent(locatorKey);
		if(result)
			return CONSTANTS.PASS;
		else
			return CONSTANTS.FAIL + ">> Could not find element:  "+locatorKey;
	}

	public String verifyElementNotPresent(String locatorKey) throws Exception{
		boolean result = isElelementPresent(locatorKey);
		if(!result)
			return CONSTANTS.PASS;
		else
			return CONSTANTS.FAIL + ">> Found Element:  "+locatorKey;
	}

}
