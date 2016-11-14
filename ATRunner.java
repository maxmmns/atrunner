package com.ecs.testcases.Marjan;

import java.io.File;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ecs.pageobjects.Report.TestLinkReports;
 

public class Marjan {

    static WebActions actions;
    static TestLinkReports testLink;
	
	public static void main(String[] args) throws Exception {
		something();
		actions.quitDriver();
	}
	
	@Test
	public static void something() throws Exception {
		
		String chrdrvPath = System.getenv("CHROME_DRV");
		File file = new File(chrdrvPath);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		actions = new WebActions(new ChromeDriver());
		
		startTumblrFollowing(actions);
		
		System.out.println("\n  EXIT !!!");
		System.exit(0);
	}		
	
	@Test
	public static void startTumblrFollowing(WebActions actions) throws Exception {
		WebActions.loadURL("https://www.tumblr.com/following");
		actions.clickElement("//*[@id='signup_determine_email']");
		actions.setFields("//*[@id='signup_determine_email']", "maxmmns@gmail.com");
		actions.clickElement("//*[@class='signup_determine_btn active']");
		actions.clickElement("//*[@id='signup_password']");
		actions.setFields("//*[@id='signup_password']","makilins");
		actions.clickElement("//*[@class='signup_login_btn active']");
		System.out.println("Loged in");
		
		actions.waitUntilDisplayed("//*[@id='following']", 30);
		System.out.println("Following opend!");
	}
}


class WebActions {
	public static WebDriver driver;
//	WebElement element;
//	String random;
//	String fileName = "";
//	String url = "";
//	public String windowHandle;
	
	// Instantiate driver
	public WebActions(WebDriver driver){
		WebActions.driver = driver;
		System.out.println("[INIT] Print Browser Driver: " + WebActions.driver);
	}
	
	
	/**
	 * Throws an exception and takes a screenshot
	 * @param msg	String message that describes the error found
	 * @throws Exception
	 */
	public void throwException(String msg) throws Exception {
		System.err.println("\n[PCNP] Throw Exception!!! " + msg);
		//TODO: save screenshot
		
//		System.out.println("\n-Take a screenshot ... ");
//		
//		Calendar now = Calendar.getInstance();
//		SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		String timestamp = timeStampFormat.format(now.getTime()); 
//		
//		String dirtyString = msg;
//		String replacementStr = "";
//		String remove_pattern = "^[ .]+|\\.+$|\\.(?=[^.]*\\.[^.]*$)|[?\\\\/:;]"; 
//		String cleanString = dirtyString.replaceAll(remove_pattern, replacementStr);
//		if (cleanString.length() > 100) {
//			cleanString = cleanString.substring(0, 99);
//		}
//		
//		String fileName = timestamp + "_" + cleanString + ".jpg";
//		System.out.println("cleanString: "+cleanString);
//		saveScreenShot(fileName);
//		System.out.print("-Wait for " + 5 + " sec ");
//		Thread.sleep(5000);
//		System.out.println(" Done waiting-");
		quitDriver();
		throw new Exception(msg);
	}
//	
//	public void createLogOutput() {
//		System.out.println("-Create folder if don't exist: [" + LOG_OUTPUT_FOLDER + "] ... ");
//		
//		if ( System.getProperty("PublishResultsOnTestLink") != null ) {
//			//Executed from jenkins
//			try {
//				File file = new File(LOG_OUTPUT_FOLDER);
//				if (file.exists()) {
//					System.out.println("-Folder: [" + LOG_OUTPUT_FOLDER + "] already exists-");
//				} else {
//					//Need test-output folder for the results
//					FileUtils.forceMkdir(new File(LOG_OUTPUT_FOLDER));
//					System.out.println("-Folder: [" + LOG_OUTPUT_FOLDER + "] created-");
//				}
//			} catch (IOException e1) {
//				System.out.println("...Failed on createLogOutput, on fileName: " + fileName);
//				e1.printStackTrace();
//			}
//		} else {
//			//Local execution
//			System.out.println("...Local execution, not needed to cerate folder: [" + LOG_OUTPUT_FOLDER + "]-");
//		}
//		
//	}
//	
//	public String getXpathFromHM(String path, String formName) {
//		return cfg.config(path, formName);
//	}
//
	/**
	 * Load given URL
	 * @param url	String URL that will be loaded
	 * @throws Exception
	 */
	public static void loadURL(String url) throws Exception {
		WebActions.driver.get(url);
		WebActions.driver.getWindowHandle();
		WebActions.driver.manage().window().maximize();
	}
//	
//
//	public static void refreshPage() {
//		WebActions.driver.navigate().refresh();
//	}
//	
//	/**
//	 *  Scroll up page
//	 */
//	public void scrollUp(){
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,-10000)", "");
//	}
//	
//	// Scroll down page
//	public void scrollDown(){
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public String checkScroll(){
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		String status = jse.executeScript("return document.documentElement.clientHeight;").toString();
//		System.out.println(status);
//		System.out.println(WebActions.driver.getPageSource());
//		return status;
//	}	
//	
//	
//	public String pageRendered(){
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		String status = jse.executeScript("if (document.readyState) return document.readyState;").toString();
//		System.out.println(status);
//		return status;
//	}
//	
//	public void waitForLoad(WebDriver driver) {
//	    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
//	    	public Boolean apply(WebDriver driver) {
//	    		System.out.println (((JavascriptExecutor)driver).executeScript("return document.readyState").toString());
//	    		return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//	    		
//	    	}
//	    };
//	    WebDriverWait wait = new WebDriverWait(driver, 30);
//	    wait.until(pageLoadCondition);
//	}
//	
	/**
	 * Click on element
	 * @param path	String xpath key for element that will be clicked
	 * @param formName	String name of the form on which the element can be found
	 * @throws Exception
	 */
	public void clickElement(String xpathValue) throws Exception {
		boolean exFound = false;
		boolean done = false;
		int timeOutInSec = 30;
		Exception foundExec = null;
		
		Calendar endTimeCal = Calendar.getInstance();
		endTimeCal.add(Calendar.SECOND, timeOutInSec);
		
		Calendar now = Calendar.getInstance();
		
		while( !done & now.getTime().before(endTimeCal.getTime())  ) {
			try {
				WebActions.driver.findElement(By.xpath(xpathValue)).click();
				done = true;
			} catch (Exception ex) {
				foundExec = ex;
				exFound = true;
				
				//execute java script to scroll to found element
				JavascriptExecutor jse = (JavascriptExecutor)WebActions.driver;
				String script = "arguments[0].scrollIntoView(true);";
				System.out.println("[clickElement] Element is not clickable try to scrool it into view\n"
						+ "[JavaScript]: " + script);
				jse.executeScript(script, WebActions.driver.findElement(By.xpath(xpathValue)));
				Thread.sleep(2000);
				
			}
			now = Calendar.getInstance();
		}
		
		if (exFound && !done) {
			System.out.println("\n" + foundExec.getMessage() + "\n");
			throwException("Element xpath key:[" + xpathValue + "] "
					+ "can not be clicked after a " + timeOutInSec + " sec.");
		} else if (!done) {
			throwException("Element xpath key:[" + xpathValue + "] "
					+ "can not be clicked after a " + timeOutInSec + " sec.");
		}
	}
//	
//	/**
//	 * Right click element
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 */
//	public void rightClickElement(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		waitForElement(path, formName);
//		
//		WebElement rightClickElement = driver.findElement(By.xpath(xpathValue));
//		Actions rightAction = new Actions(driver);
//		rightAction.moveToElement(rightClickElement);
//		rightAction.contextClick(rightClickElement).build().perform();
//		System.out.println("- Right Click -");
//	}
//	
//	/**
//	 * Right click dynamic entry
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param regex
//	 * @param replacment
//	 */
//	public void rightClickDynamicEntry(String path, String formName, String regex, String replacment){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		waitForDynamicElement(path, formName, regex, replacment);
//		
//		WebElement rightClickElement = driver.findElement(By.xpath(xpathValue));
//		Actions rightAction = new Actions(driver);
//		rightAction.moveToElement(rightClickElement);
//		rightAction.contextClick(rightClickElement).build().perform();
//		System.out.println("- Right click dynamic -");
//
//	}
//	
//	/**
//	 *  Drag and drop source element to target element
//	 * @param pathSource
//	 * @param pathTarget
//	 * @param formName
//	 */
//	public void dragAndDropElement(String pathSource, String pathTarget, String formName){
//		String xpathValueSource = cfg.config(pathSource, formName);
//		String xpathValueTarget = cfg.config(pathTarget, formName);
//		WebElement source = driver.findElement(By.xpath(xpathValueSource));
//		WebElement target = driver.findElement(By.xpath(xpathValueTarget));
//		
//		waitForElement(pathSource, formName);
//		(new Actions(driver)).dragAndDrop(source, target).perform();
//			
//		System.out.println("DragAndDrop!");
//	}
//	
//	/**
//	 * Check if dynamic element is present
//	 * @param path
//	 * @param formName
//	 * @param userNameCheck
//	 * @param regex
//	 * @param replacment
//	 * @throws Exception
//	 */
//	public void dynamicElementPresent(String path, String formName, String userNameCheck, String regex, String replacment) throws Exception {
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		if (userNameCheck.equalsIgnoreCase("true")) {
//			System.out.println("- Checking if element is Present ... -");
//			if(driver.findElements(By.xpath(xpathValue)).size() !=0) {	
//				System.out.println("- Dynamic element is Present -");
//			} else {
//				throwException("Dynamic element is Absent");
//			}
//		}
//		if (userNameCheck.equalsIgnoreCase("false")) {
//			System.out.println("- Checking if element is absent ... -");
//			if(driver.findElements(By.xpath(xpathValue)).size() == 0) {
//				System.out.println("- Dynamic element is Absent -");
//			} else {
//				throwException("Dynamic element is Present");
//			}	
//		}	
//	}
//	
//	/**
//	 * Click dynamic element
//	 * @param path	Sting xpath key of an element
//	 * @param formName	String name of the form
//	 * @param regex	String value that will be changed
//	 * @param replacment	String value that will be the repelcement
//	 * @throws Exception 
//	 */
//	public void clickDynamicEntry(String path, String formName, String regex, String replacment) throws Exception{
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		System.out.println("Xpath Value: " + xpathValue);
//		waitForDynamicElement(path, formName, regex, replacment);
//		
//		try {
//			WebElement elem = WebActions.driver.findElement(By.xpath(xpathValue));
//			
//			//execute java script to scroll to found element
//			JavascriptExecutor jse = (JavascriptExecutor)WebActions.driver;
//			String script = "arguments[0].scrollIntoView(true);";
//			System.out.println(" [JavaScript]: " + script);
//			jse.executeScript(script, elem);
//			Thread.sleep(2000);
//			
//			elem.click();
//			
//		} catch (Exception e) {
//			System.err.println(e.getMessage().toString());
//			throwException("[clickDynamicEntry] Exception while clicking on: [" + xpathValue + "]");
//		}
//	}
//	
//	/**
//	 *  Get text from path and compare's to user supplied value
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param regex
//	 * @param replacment
//	 * @param value
//	 * @throws Exception
//	 */
//	public void compareDynamicText(String path, String formName, String regex, String replacment, String value) throws Exception {
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		if (actualText.contains(value)){
//			System.out.println("- Dynamic text matches -");
//		} else {
//			throwException("Dynamic text does not match!");
//		}
//	}
//	
//	/**
//	 * Get dynamic element ID attribute
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param regex
//	 * @param replacment
//	 * @return
//	 */
//	public String getIDDynamicEntry(String path, String formName, String regex, String replacment){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		System.out.println("Xpath Value: " + xpathValue);
//		waitForDynamicElement(path, formName, regex, replacment);
//		String att = WebActions.driver.findElement(By.xpath(xpathValue)).getAttribute("id");
//		return att;
//	}
//	
//	/**
//	 * Click dynamic entry
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param regex
//	 * @param replacment
//	 */
//	public void clickIDDynamicEntry(String path, String formName, String regex, String replacment){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		WebElement element = driver.findElement(By.xpath(xpathValue));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).click().perform();
//		System.out.println("- click performed");
//	}
//	
//	/**
//	 * Return number of dynamic elements on page
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param regex
//	 * @param replacment
//	 * @return
//	 */
//	public int findNumOfElements(String path, String formName, String regex, String replacment){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		return (driver.findElements(By.xpath(xpathValue))).size();
//    }
//	
//	/**
//	 *  Select element on the page by xpath
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param value
//	 */
//	public void selectElement (String path, String formName, String value){
//		String xpathValue = cfg.config(path, formName);
//		waitForElement(path, formName);
//		Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
//		dropdown.selectByValue(value);
//	}
//	
//	/**
//	 *  Wait for text to appear on the page by xpath with a wait time of 60 seconds
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param text
//	 */
//	public void waitForText (String path, String formName, String text){
//		String xpathValue = cfg.config(path, formName);
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpathValue), text));
//		System.out.println(driver.findElement(By.xpath(xpathValue)).getText());
//	}
//	
//	/**
//	 *  Get text from xpath and compare's to user supplied value, if true test case passes, if false, throws exception
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param value
//	 * @throws Exception
//	 */
//	public void compareText(String path, String formName, String value) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		if (actualText.contains(value)){
//			System.out.println("- Text matches!");
//		} else {
//			throwException("Text does not match!");
//		}
//	}
//	
//	/**
//	 *  Get text from xpath and compare's to user supplied value, if true test return true, if false, return false
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param value
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean compareTextandReport(String path, String formName, String value) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		boolean isEqual = false;
//		if (actualText.contains(value)){
//			System.out.println("- Content matches!");
//			isEqual = true;
//		} else {
//			System.out.println("- Content doesn't match!");
//		}
//		return isEqual;
//	}
//	
//	/**
//	 * Get text from xpath and compare's to user supplied value, if true pass, if false throw Exception
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param value
//	 * @throws Exception
//	 */
//	public void compareAbsoluteText(String path, String formName, String value) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		System.out.println("Real Text: " + actualText);
//		if (actualText.equalsIgnoreCase(value)){
//			System.out.println("- Absolute text matches -");
//		} else {
//			throwException("Absolute text does not match!");
//		}
//	}
//	
//	/**
//	 * Get text from xpath and compare's to user supplied value, value on status, if true pass, if false throw Exception
//	 * @param path
//	 * @param formName
//	 * @param value
//	 * @param status
//	 * @throws Exception
//	 */
//	public void compareAbsoluteTextTrueOrFalse(String path, String formName, String value, String status) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		System.out.println("Real Text: " + actualText);
//		
//		if (status.equalsIgnoreCase("true")){
//			if (actualText.equalsIgnoreCase(value)){
//				System.out.println("- Absolute text matches as expected -");
//			} else {
//				throwException("Absolute text does not match!");
//			}
//		} else {
//			if (!actualText.equalsIgnoreCase(value)){
//				System.out.println("- Absolute text does NOT matche as expected -");
//			} else {
//				throwException("Absolute text match!");
//			}
//		}
//	}
//	
//	
//	/**
//	 * Wait for attribute to change from the xpath for 10 seconds
//	 * @param path	String xpath key of an element
//	 * @param formName	String form name
//	 * @param attribute	String attribute name
//	 * @throws Exception
//	 */
//	public void waitForAttribute(String path, String formName, String attribute) throws Exception {
//		int wait = 0;
//		String xpathValue = cfg.config(path, formName);
//		WebElement temp = driver.findElement(By.xpath(xpathValue));
//		String att = "";
//		while(wait<10){
//			
//			att = temp.getAttribute(attribute);
//			
//			if( att == null){
//				System.out.println("- Element found");
//				break;
//			} else {
//				Thread.sleep(1000);
//				wait++;
//			}
//		}
//	}
//	
//	/**
//	 * Wait for a specified attribute to change to a given value
//	 * @param path	String xpath key of an element
//	 * @param formName	String form name
//	 * @param attribute	String attribute name
//	 * @param value	String expected value of the attribute
//	 * @return	boolean 'true' if attribute with given value is found
//	 * @throws Exception
//	 */
//	public boolean waitForAttributeValue(
//			String path, String formName, String attribute, String value) throws Exception {
//		boolean found = false;
//		int wait = 0;
//		String xpathValue = cfg.config(path, formName);
//		WebElement temp = driver.findElement(By.xpath(xpathValue));
//		String att = "";
//		while(wait<10){
//			att = temp.getAttribute(attribute);
//			if( att != null && att.equalsIgnoreCase(value) ){
//				System.out.println("-Attribute: [" + attribute + "] with value: [" + value + "] is found-");
//				found = true;
//				break;
//			} else if ( att == null ) {
//				System.out.println("-Attribute: [" + attribute + "] is null-");
//				break;
//			} else {
//				Thread.sleep(1000);
//				wait++;
//			}
//		}
//		
//		return found;
//	}
//
//	// Regex engine
//	public String regex(String regexPattern, String path, String formName) throws Exception {
//		String regex = "true";
//		String group = "0";
//		String xpathValue = cfg.config(path, formName);
//		String Content = driver.findElement(By.xpath(xpathValue)).getText();
//		String ignoreDuplicateMatch = "true";
//		if (Boolean.parseBoolean(regex)) {
//			System.out.println("Regex Pattern: " + regexPattern);
//			Pattern pattern = Pattern.compile(regexPattern);
//			Matcher matcher = pattern.matcher(Content);
//			//	Find a match
//			Boolean match = matcher.find();
//			System.out.println("Pattern = " + pattern);
//			System.out.println("Matcher = " + matcher);
//			if (match) {
//				System.out.println("Matcher.group = " + matcher.group());
//				// If a match is found, check if a specific group is specified.
// 				if (Integer.parseInt(group) > 0) {
// 					// If a group is specified, verify the group exists in the match
// 					System.out.println("Matcher.groupCount = " + matcher.groupCount());
// 					if (matcher.groupCount() >= Integer.parseInt(group)) {
// 						// Set the field text to the specified group
// 						Content = matcher.group(Integer.parseInt(group));
// 					} else {
// 						// Group doesn't exist.  Throw an error.
// 						throwException("Group " + group + " does not exist in the regex match");
// 					}
// 				} else {
// 					// No group is found.  Just use the whole match string.
// 					Content = matcher.group();
// 				}
//
//				// If the regex pattern matches multiple locations on the page,
// 				// we need to throw an error unless the ingoreDuplicateMatch flag
// 				// is set.
//				while ( matcher.find() && !Boolean.parseBoolean(ignoreDuplicateMatch) ) {
//					throwException("Multiple matches were found.  The regex Pattern should" +
//							" only match one occurance.");
//				}
//			} else {
//				// No match was found for the regular expression.
//				throwException("Unable to find a match in the field text for the pattern " +
//							"specified.  Fieldtext = " + Content + ".  Pattern = " + regexPattern);
//			}
//		}
//		return Content;
//	}
//
//	// Get Text from xpath and returns the value
//	public String getText (String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		return actualText;
//	}
//	
//	// Get Text from xpath and returns the value
//	public String getDynamicText (String path, String formName, String regex, String replacment){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
////		System.out.println("Xpath Value: " + xpathValue);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		return actualText;
//	}
//	
//	public String getDynamicTextWithOutPrint (String path, String formName, String regex, String replacment){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		String actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//		return actualText;
//	}
//	
//	/**
//	 * Retrieve value from configuration parameters or from the System parameters
//	 * @param path	String key value from configurations
//	 * @return	String value found with given key value
//	 */
//	public String defineValue (String path){
//		String xpathValue = null;
//		String paramFromJenkinsJob = System.getProperty(path);
//		if ( paramFromJenkinsJob == null ) {
//			xpathValue = cfg.config(path, "Inputs");
//		} else {
//			xpathValue = paramFromJenkinsJob;
//		}
//		return xpathValue;
//	}
//	
//	/**
//	 * Get value from configuration inputs 
//	 * @param key	String key value
//	 * @return	String value from the config inputs
//	 */
//	public static String getValueFromConfigInputs(String key) {
//		return cfg.config(key, "Inputs");
//	}
//	
//	/**
//	 * Get Test Link API key from configurations
//	 * @param user	String Name of a user
//	 * @return
//	 */
//	public static String getTestLinkAPIKey(String user) {
//		return getValueFromConfigInputs(user);
//	}
//	
//	
//	// Wait for element to appear on the page by xpath for 60 seconds
//	public void waitForElement(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
//	}
//	
//	/**
//	 * Wait for element to appear, display appropriate error message if element is not displayed 
//	 * after the specified amount of time in timeout parameter  
//	 * @param path	String x-path key of an element
//	 * @param formName	String name of the form
//	 * @param errorMsg	String error message
//	 * @param timeout	int timeout value in seconds
//	 * @throws Exception
//	 */
//	public void waitForElement(String path, String formName, String errorMsg, int timeout) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		try {
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
//		} catch (TimeoutException ex) {
//			System.err.println("TimeoutException! (" + timeout + "s)");
//			throwException(errorMsg);
//		}
//	}
//	
//	/**
//	 * Wait for specified element for specified timeout
//	 * @param path	String xpath key of an element
//	 * @param formName	Sting name of the form used
//	 * @param timeout	int timeout in seconds
//	 */
//	public void waitForElement(String path, String formName, int timeout){
//		String xpathValue = cfg.config(path, formName);
//		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
//	}
//	
//	// Wait for element to appear on the page by xpath for 60 seconds
//	public void waitForDynamicElement (String path, String formName, String regex, String replacment){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
//	}
//	
//	// Creates and sets cookie
//	public void createCookie(String nameValue, String newOptions) throws Exception {
//		Cookie ck = new Cookie(nameValue, newOptions);
//		driver.manage().addCookie(ck);
//	}
//	
//	// Key Press
//	public void keyPress(String key){
//		Actions a = new Actions(driver);
//		if (key.equalsIgnoreCase("END")){
//			a.sendKeys(Keys.END).perform();
//		} else if (key.equalsIgnoreCase("TAB")){
//			a.sendKeys(Keys.TAB).perform();
//		} else if (key.equalsIgnoreCase("ENTER")){
//			a.sendKeys(Keys.ENTER).perform();
//		} else if (key.equalsIgnoreCase("CONTROL-A")){
//			//a.sendKeys(Keys.chord(Keys.CONTROL, "a")).perform();
//			a.sendKeys(Keys.chord(Keys.CONTROL, "a")).perform();
//		} else if (key.equalsIgnoreCase("PASTE")){
//			a.sendKeys(Keys.chord(Keys.CONTROL, "v")).perform();
//		} else if (key.equalsIgnoreCase("PGDOWN")){
//			a.sendKeys(Keys.PAGE_DOWN);
//		} else if (key.equalsIgnoreCase("ARROW_DOWN")){
//			a.sendKeys(Keys.ARROW_DOWN).perform();
//		} else if (key.equalsIgnoreCase("ARROW_UP")){
//			a.sendKeys(Keys.ARROW_UP).perform();
//		}
//	}
//	
//	// Hovers over a drop down menu
//	public void mouseOver(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath(xpathValue))).moveToElement(driver.findElement(By.xpath(xpathValue))).click().build().perform(); 	
//	}
//
//	// Hovers over a drop down menu
//	public void mouseOverWithoutClick(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath(xpathValue))).moveToElement(driver.findElement(By.xpath(xpathValue))).perform(); 	
//	}
//	
//	/**
//	 * Grab focus of a frame
//	 * @param iframe	String name of the iframe
//	 * @throws InterruptedException
//	 */
//	public void focusFrame(String iframe) throws InterruptedException{
//		System.out.print("-Focus frame: [" + iframe + "] ... ");
//		
//		boolean frameFound = false;
//		final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//		System.out.print("iframes found: [" + iframes.size() + "] ");
//		try {
//			for (WebElement ifs : iframes) {
//		        if (ifs.getAttribute("id").equals(iframe)) {
//		        	frameFound = true;
//		        }
//		    }
//		} catch (Exception e) {
//			System.err.println("org.openqa.selenium.StaleElementReferenceException");
//		}
//		
//		if (frameFound) {
//			driver.switchTo().frame(iframe);
//		} else {
//			System.out.println("\n-Frame: [" + iframe + "] not found or allready focused-");
//		}
//		((JavascriptExecutor) driver).executeScript("window.focus();");
//		Thread.sleep(2000);
//		System.out.println("done-");
//	}
//	
//	// Move to element and select an element from the dropdown
//	public void moveToElement (String path, String formName, String dropDown) throws Exception{
//		String xpathValue = cfg.config(path, formName);
//		clickElement(dropDown, formName);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath(xpathValue))).click().build().perform();
//		Thread.sleep(500);
//		clickElement(dropDown, formName);
//	}
//
	
	/**
	 * 
	 * @param path
	 * @param formName
	 * @param value
	 */
	public void setFields (String xpathValue, String value){
		driver.findElement(By.xpath(xpathValue)).sendKeys(value);
	}
//	
//	// Sets a value for a input (type="text") 
//	public void setInputFileTypeField(String path, String formName, String value){
//		String xpathValue = cfg.config(path, formName);
//		driver.findElement(By.xpath(xpathValue)).sendKeys(new File(value).getAbsolutePath());
//	}
//	
//	// Clears all values in a field
//	public void clearFields (String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		driver.findElement(By.xpath(xpathValue)).clear();
//	}
//	
//	// Get random generated string
//	public String getName(){
//		return random;
//	}
//
//	// Set random string length according to user specification
//	public void usernameLength (int Length){
//		random = RandomStringUtils.randomAlphabetic(Length);
//	}
//
//	// Get page source
//	public static String getSource() {
//		return WebActions.driver.getPageSource();
//	}	
//
//	//Gets a modified date format specified by user and returns the value
//	public static String getModifiedDate(String dateFormat) {
//		Date date = new Date();
//		String modifiedDate = new SimpleDateFormat(dateFormat).format(date);
//		return modifiedDate;
//	}
//	
//	// Focus on default frame
//	public void defaultFrame(){
//		driver.switchTo().defaultContent();
//	}
//
//	// Generate numeric unique name and returns the value
//	public String uniqueString(String suffix){
//		DateFormat dateFormat = new SimpleDateFormat("MMddyyHHmmss");
//		Date date = new Date();
//		String unique = suffix + dateFormat.format(date);
//		return unique;
//	}
//	
//	// Generate numeric unique name and returns the value
//	public String uniqueDateString(){	
//		DateFormat month = new SimpleDateFormat("yyyyMMMdd");
//		Date date = new Date();
//		String unique = month.format(date);
//		return unique;
//	}
//
//	public String getCustomDate(String formatString, String dayRange){
//		String customDate = "";
//		Calendar cal = Calendar.getInstance();
//		//Date d = new Date();
//		SimpleDateFormat dateFormat;
//		if(formatString == null) {
//			formatString="yyyy-MM-dd";
//		}
//		dateFormat = new SimpleDateFormat(formatString);
//		//String formattedDate = dateFormat.format(d);
//		if (dayRange.equalsIgnoreCase("1D")){
//			cal.add(Calendar.DATE, -1);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("1W")){
//			cal.add(Calendar.DATE, -7);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("1M")){
//			cal.add(Calendar.MONTH, -1);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("3M")){
//			cal.add(Calendar.MONTH, -3);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("1Y")){
//			cal.add(Calendar.YEAR, -1);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("4Y")){
//			cal.add(Calendar.YEAR, -4);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("10D")){
//			cal.add(Calendar.DATE, +10);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("30D")){
//			cal.add(Calendar.DATE, +30);
//			customDate = dateFormat.format(cal.getTime());
//		} else if (dayRange.equalsIgnoreCase("0D")){
//			cal.add(Calendar.DATE, 0);
//			customDate = dateFormat.format(cal.getTime());
//		}
//		System.out.println("Custom Date: " + customDate);
//		return customDate;
//	}
//
//	// Creates key value file with tab delimiter
//	public void createAndEditOutputFile(String fileName, String key, String value){
//		System.out.println("- Create And Edit Output File: [" + fileName + "]");
//		try {
//			Writer output = null;
//			File file = new File(fileName);
//			output = new BufferedWriter(new FileWriter(file, true));
//			output.write(key);
//			output.write("\t");
//			output.write(value);
//			((BufferedWriter) output).newLine();
//			output.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
//	
//	// Reads a single line from a file and returns its value
//	public String readFromFile(String fileName) throws Exception {
//		File f = new File (fileName);
//		BufferedReader reader = new BufferedReader(new FileReader(f));
//		url = reader.readLine();
//		reader.close();
//		return url;
//	}
//	
//	public ArrayList<String> readFileToArray(String fileName) throws FileNotFoundException{
//		ArrayList<String> fileContents = new ArrayList<String>();
//		BufferedReader reader = new BufferedReader(new FileReader(fileName));
//		String line = "";
//		try {
//			while(true){
//				line = reader.readLine();
//				if(line != null){
//					System.out.println("Line: " + line);
//					fileContents.add(line.replaceAll("\t", ""));  
//				}else{
//					break;
//				}
//			}
//			reader.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}   
//		return fileContents;
//	}
//	
//	// Gets size of an attribute of an element and returns a string value
//	public String getAttributeSize(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		int size = driver.findElements(By.xpath(xpathValue)).size();
//		String stringSize = Integer.toString(size);
//		return stringSize;
//	}
//	
//	// Gets size of an attribute of an element and returns a string value
//		public String getAttributeSize(String xpath){
//			int size = driver.findElements(By.xpath(xpath)).size();
//			String stringSize = Integer.toString(size);
//			return stringSize;
//		}	
//	// Compares a user specified content to a variable ignoring case sensitve
//	public void compareContent(String value, String content) throws Exception {
//		if (value.equalsIgnoreCase(content)){
//			System.out.println("- Content Matches -");
//		} 
//		else  {
//			throwException("Content does not match!");
//		}
//	}
//
//	// Selects the element by user specified text if the text is visible
//    public void selectElementByText(String path, String formName, String value){
//        String xpathValue = cfg.config(path, formName);
//        waitForElement(path, formName);
//        Select dropdown = new Select(driver.findElement(By.xpath(xpathValue)));
//        dropdown.selectByVisibleText(value);
//    }
//    
//    /**
//     * Select 'input->option' that contains given keyword
//     * @param keyword	String a keyword
//     * @param path	Sting xpath key of an element
//     * @param formName	name of the form
//     * @throws Exception
//     */
//    public void selectOptionByKeyword(String keyword, String path, String formName) throws Exception {
//    	System.out.println("-Select Option by keyword: [" + keyword + "] ... ");
//    	
//    	String xpathValue = cfg.config(path, formName);
//    	WebElement element = WebActions.driver.findElement(By.xpath(xpathValue));
//    	
//    	JavascriptExecutor jse = (JavascriptExecutor)WebActions.driver;
//		jse.executeScript("arguments[0].scrollIntoView(true);", element);
//    	element.click();
//    	
//    	List<WebElement> opts = element.findElements(By.xpath(".//option"));
//		String optsTxt = "";
//		WebElement opt = null;
//		boolean found = false;
//		for (int i=0; i<opts.size();i++) {
//			opt = opts.get(i);
//			optsTxt = opt.getText().toLowerCase();
//			//System.out.println("optsTxt"+optsTxt);
//			if (optsTxt.contains(keyword)) {
//				found = true;
//				System.out.println("-Option: [" + optsTxt + "] is found, clicking on it ...");
//				
//				//Scroll element into view
//				//JavascriptExecutor jse = (JavascriptExecutor)WebActions.driver;
//				jse.executeScript("arguments[0].scrollIntoView(true);", opt);
//
//				opt.click();
//				System.out.println("-Option: [" + optsTxt + "] is clicked ... ");
//				Thread.sleep(2000);
//				
//				String val = element.getAttribute("value");
//				String valTxt = element.findElement(By.xpath(".//option[contains(@value,'" + val + "')]")).getText();
//				
//				if ( valTxt.toLowerCase().contains(keyword) ) {
//					System.out.println("-Option: [" + valTxt + "] is selected-");
//				}
//				break;
//			}
//		}
//		if (!found) {
//			throwException("selectOptionByKeyword: Option that contains: [" + keyword + "] do not exist!");
//		}
//    }
//    
	public void quitDriver() {
		String driverStr = WebActions.driver.toString();
		if (!driverStr.contains("(null)") ) {
			WebActions.driver.close();
			WebActions.driver.quit();
		} else {
			System.out.println("Drivers is already closed {" + driverStr + "}");
		}
	}
//	
//	/**
//	 *  Verifies if an element exists or does not exist on the page, throws exception depending on user specification
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param status
//	 * @throws Exception
//	 */
//	public void getElementVisibility(String path, String formName, String status) throws Exception{
//		String xpathValue = cfg.config(path, formName);
//		if (status.equalsIgnoreCase("true")){
//			if (driver.findElement(By.xpath(xpathValue)).isDisplayed() == true){
//				System.out.println("- Element exists on the page as expected -");
//			} else {
//				throwException("Element does not exist on the page!");
//			}
//		} else if (status.equalsIgnoreCase("false")){
//			if (driver.findElement(By.xpath(xpathValue)).isDisplayed() == true){
//				throwException("Element exist on the page!");
//			} else {
//				System.out.println("- Element does not exist on the page as expected -");
//			}
//		}
//	}
//	
//	/**
//	 * Returns an Web Element
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @return
//	 * @throws Exception
//	 */
//	public WebElement getElement(String path, String formName) throws Exception{
//		String xpathValue = cfg.config(path, formName);
//		return driver.findElement(By.xpath(xpathValue));
//	}
//	
//	/**
//	 *  Verifies if a value is contained in string, throws exception depending on user specification
//	 * @param rawData
//	 * @param value
//	 * @param status
//	 * @throws Exception
//	 */
//	public void contentPresent(String rawData, String value, String status) throws Exception{
//		if (status.equalsIgnoreCase("true")){
//			if (rawData.contains(value)){
//				System.out.println("- " + value + " - exists as expected -");
//			} else {
//				throwException (value + " does not exist!");
//			}
//		} else if (status.equalsIgnoreCase("false")){
//			if (rawData.contains(value)){
//				throwException (value + " exist!");
//			} else {
//				System.out.println("- " + value + "- does not exist as expected -");
//			}
//		}
//	}
//	
//	/**
//	 * Compares two int num by value
//	 * @param valueOne
//	 * @param valueTwo
//	 * @param status
//	 * @throws Exception
//	 */
//	public void compareNumberValue(int valueOne, int valueTwo, String status) throws Exception{
//		if (status.equalsIgnoreCase("true")){
//			if (valueOne == valueTwo){
//				System.out.println("- Number Value matches!");
//			} 
//			else  {
//				throwException("Number Value does not match!");
//			}
//		} else if (status.equalsIgnoreCase("false")){
//			if (valueOne != valueTwo){
//				System.out.println("- Number Value does not match!");
//			} 
//			else  {
//				throwException("Number Value matches!");
//			}
//		} else {
//			throwException("Status: " + status + " is not valid");
//		}
//	}
//	
//	// Creates a file from user supplied url
//	public void getAndStoreFile(String url, String fileName){
//		try {
//		    org.apache.commons.io.FileUtils.copyURLToFile(new URL(url), new File(fileName));
//		} catch (Exception ex) { 
//			ex.printStackTrace(); 
//		}
//	}
//	
//	// Counts the number of lines in a file. Once the next line read is empty, method prints out the number of total lines
//	public int getTotalLinesFile(String url, String fileName){
//		int lines = 0;
//		if (!url.isEmpty()){
//			getAndStoreFile(url, fileName);
//		}
//		BufferedReader br = null;
//		try {
//			br = new BufferedReader(new FileReader(fileName));
//			while((br.readLine()) != null) {
//				lines++;
//			}
//			br.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null)br.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//		System.out.println("total lines: " + lines);
//		return lines;
//	}
//	
//	// Gets the value of attribute and returns the value
//	public String getAttribute (String path, String formName, String attribute){
//		String xpathValue = cfg.config(path, formName);
//		String actualValue = driver.findElement(By.xpath(xpathValue)).getAttribute(attribute);
//		return actualValue;
//	}
//	
//	
//	// Gets the value of attribute and returns the value
//	public String getAttributeDynamicElement (String path, String formName, String regex, String replacment, String attribute){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		String actualValue = driver.findElement(By.xpath(xpathValue)).getAttribute(attribute);
//		return actualValue;
//	}
//	
//	public void checkAttributePresentDynamicElement (String path, String formName, String userNameCheck, String regex, String replacment, String attribute) throws Exception{
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		String actualValue = driver.findElement(By.xpath(xpathValue)).getAttribute(attribute);
//		
//		if (userNameCheck.equalsIgnoreCase("true")) {
//			System.out.println("- Checking if attribute is empty ... -");
//			if(!(actualValue.isEmpty())) {	
//				System.out.println("- Dynamic element attribute is Present -");
//			} else {
//				throwException("Dynamic element attribute is Absent");
//			}
//		}
//		if (userNameCheck.equalsIgnoreCase("false")) {
//			System.out.println("- Checking if element is absent ... -");
//			if(actualValue.isEmpty()) {
//				System.out.println("- Dynamic element attribute is Absent -");
//			} else {
//				throwException("Dynamic element attribute is Present");
//			}	
//		}
//		
//	}
//	
//	public String getAttributeDynamic (
//			String path, 
//			String formName, 
//			String regex, 
//			String replacment,
//			String attribute){
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		String actualValue = driver.findElement(By.xpath(xpathValue)).getAttribute(attribute);
//		return actualValue;
//	}
//	
//	// Checks if element is present
//	public void elementPresent(String path, String formName, String userNameCheck) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		if (userNameCheck.equalsIgnoreCase("true")) {
//			if(driver.findElements(By.xpath(xpathValue)).size() !=0) {	
//				System.out.println("- Element is Present -");
//			} else {
//				throwException("Element is Absent");
//		 	}
//		}
//		if (userNameCheck.equalsIgnoreCase("false")) {
//			if(driver.findElements(By.xpath(xpathValue)).size() == 0) {
//				System.out.println("- Element is Absent -");
//			} else {
//				throwException("Element is Present");
//			}	
//		}	
//	}
//	
//	//Returns boolean for element state
//	public boolean checkIfElementPresentAndNotify (String path, String formName) {
//		String xpathValue = cfg.config(path, formName);
//		boolean elementState = false;
//		
//		if(driver.findElements(By.xpath(xpathValue)).size() !=0){	
//			System.out.println("- Notify element is Present -");
//			elementState = true;
//		} else {
//			System.out.println("- Notify element is Absent -");
//		}
//		
//		return elementState;	
//	}
//	
//	//Returns boolean for element state
//	public boolean checkIfDynamicElementPresentAndNotify(String path, String formName, String regex, String replacment) throws Exception {
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//		boolean elementState = false;
//		
//		if(driver.findElements(By.xpath(xpathValue)).size() !=0) {	
//			System.out.println("- Notify dynamic element is Present -");
//			elementState = true;
//		} else {
//			System.out.println("- Notify dynamic element is Absent -");
//		}
//		
//		return elementState;
//	}
//
//	public String readLines (String fileName, String splitter) throws Exception {
//		BufferedReader br = null;
//		String temp;
//		List<String> lines = new ArrayList <String>();
//		try {
//			br = new BufferedReader(new FileReader(fileName));
//				while((temp = br.readLine()) != null){
//					lines.add(temp.split(splitter)[2]);
//				System.out.println("Lines : " + temp);
//				}
//				String secondFromBottom = lines.get(lines.size()-2);
//				System.out.println("The last two lines are: " + secondFromBottom);			
//				return secondFromBottom;
//		}finally {
//			try {
//				if (br != null)br.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//	}
//	
//	// Focus on a particular frame
//	public static String getURL(){
//		String url = driver.getCurrentUrl();
//		System.out.println("Current URL: " + url);
//		return url;
//	}
//	
//	public void doubleClick(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		Actions a = new Actions(driver);
//		a.doubleClick(driver.findElement(By.xpath(xpathValue))).build().perform();
//	
//	}
//	
//	public boolean portIsOpen(String ip, int port, int timeout) {
//        try {
//            Socket socket = new Socket();
//            socket.connect(new InetSocketAddress(ip, port), timeout);
//            socket.close();
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }
//    }
//	   // Switching to new browser window opened 
//	public void setNewWindowHandle (){
//		//Switch to new window opened
//		for(String winHandle : driver.getWindowHandles()){
//			driver.switchTo().window(winHandle);
//		}
//	}
//	
//	public void compareValues(String content1, String content2, String status) throws Exception {
//		if (status.equalsIgnoreCase("true")) {
//			if (content1.contains(content2)) {
//				System.out.println("- " + content2 +  " exists as expected!");
//			} else  {
//				throwException(content2 + " does not exist!");
//			}
//		} else if(status.equalsIgnoreCase("false")){
//			if(content1.contains(content2)){
//				throwException (content2 + " exist!");
//			}
//			System.out.println("- " + content2 +  " does not exist as expected!");
//		}
//	}
//
//	public static void setClipboardContents(String text) {
//		  StringSelection stringSelection = new StringSelection( text );
//		  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//		  clipboard.setContents(stringSelection, null);
//	}	
//	
//	/**
//	 * WebActions save its own windowHandle on construction
//	 * 
//	 * @param windowHandle
//	 * @throws InterruptedException
//	 */
//	public void switchToWindowHandle(ChromeDriver Driver, String WindowHandle) throws InterruptedException {
//		driver = Driver;
//		// ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(WindowHandle);
//		driver.switchTo().defaultContent();
//		((JavascriptExecutor) driver).executeScript("window.focus();");
//		Thread.sleep(2000);
//		System.out.println("...WebDriver switched to default ChromeDriver and WindowHandle: " + WindowHandle);
//	}
//	
//	//=======================================================================
//	//================================ Marjan ===============================
//	//=======================================================================
//	
//	/**
//	 * Click on element by offset position
//	 * @param path	String name of the xpath used to locate an element
//	 * @param formName	String name of a form
//	 * @param x	int offset position by x
//	 * @param y	int offset position by y
//	 */
//	public void clickElementWithOffset(String path, String formName, int x, int y) {
//		String xpathValue = cfg.config(path, formName);
//		waitForElement(path, formName);
//		WebElement elem = WebActions.driver.findElement(By.xpath(xpathValue));
//		Actions act = new Actions(driver);
//		act.moveToElement(elem);
//		act.moveByOffset(x, y);
//		act.click().build().perform();
//	}
//	
//	// Find elements that are matched to the x-path
//	public List<WebElement> findElements(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		waitForElement(path, formName);
//		System.out.println(" Found elements size: " + WebActions.driver.findElements(By.xpath(xpathValue)).size());
//		return WebActions.driver.findElements(By.xpath(xpathValue));
//	}
//	
//	public List<WebElement> findElementsNoPrint(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		waitForElement(path, formName);
//		return WebActions.driver.findElements(By.xpath(xpathValue));
//	}
//	
//	/**
//	 * Find web elements by using dynamically changed x-path 
//	 * @param path	String x-path name
//	 * @param formName	Sting name of the form
//	 * @param regex	Sting that will be replaced
//	 * @param replacemnt	Sting dynamically changeable name 
//	 * @return
//	 */
//	public List<WebElement> findElementsDynamic(String path, String formName, String regex, String replacemnt){
//		
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacemnt);
//		waitForDynamicElement(path, formName, regex, replacemnt);
//		
//		return WebActions.driver.findElements(By.xpath(xpathValue));
//	}
//	
//	/**
//	 * Click on specified element in a list
//	 * @param path	String	xpath key
//	 * @param formName	String form name
//	 * @param num	int number of element in a list which will be clicked
//	 */
//	public void clickOnElement(String path, String formName, int num){
//		List<WebElement> foundElements;
//		String xpathValue = cfg.config(path, formName);
//		foundElements = WebActions.driver.findElements(By.xpath(xpathValue));
//		if (foundElements.size() > 1) {
//			foundElements.get(num).click();
//		} else {
//			foundElements.get(0).click();
//		}	
//	}
//	
//	public void expandDropdown(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		waitForElement(path, formName);
//		WebActions.driver.findElement(By.xpath(xpathValue)).click();
//	}
//	
//	/**
//	 * Closes current browser window and returns to previous browser window
//	 */
//	public void closeCurrentBrowserWin() {
//	
//		String currentWinHandle = driver.getWindowHandle();
//		
//	    Set<String> set = driver.getWindowHandles();
//    
//	    set.remove(currentWinHandle);
//	    assert set.size()==1;
//	    driver.close();
//	    
//	    for (String s : set) {
//	        driver.switchTo().window(s);
//	    }
//	}
//	
//	public void switchCurrentBrowserWin(String winHandle) throws Exception {
//		
//        driver.switchTo().window(winHandle);
//	    Thread.sleep(2000);
//	    
//	    String currentHandle = driver.getWindowHandle();
//	    if (currentHandle.compareTo(winHandle) != 0) {
//	    	throwException("Window handle is not changed!");
//	    } else {
//	    	System.out.println("-Browser Window is switched-");
//	    }
//	    
//	}
//	
//	public void isEnabled(String path, String formName, String status) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		WebElement elem = WebActions.driver.findElement(By.xpath(xpathValue));
//		
//		if (elem.isDisplayed() == true) {
//			waitForElement(path, formName);
//			if (status.equalsIgnoreCase("true")){
//				if (elem.isEnabled() == true){
//					System.out.println("Element [" + path + "] is enabled, as expected!");
//				} else {
//					throwException("Element is not enabled!");
//				}
//			} else if (status.equalsIgnoreCase("false")){
//				if (elem.isEnabled() == true){
//					throwException("Element is enabled!");
//				} else {
//					System.out.println("Element [" + path + "] is not enabled, as expected!");
//				}
//			}
//		} else {
//			if (status.equalsIgnoreCase("true")){
//				throwException("Element is not enabled!");
//			} else if (status.equalsIgnoreCase("false")){
//				System.out.println("Element is not enabled, as expected!");
//			}
//		}
//	}
//	
//	public boolean isEnabled(String path, String formName) throws Exception {
//		
//		boolean enabled = false;
//		String xpathValue = cfg.config(path, formName);
//		waitForElement(path, formName);
//		WebElement elem = WebActions.driver.findElement(By.xpath(xpathValue));
//		
//		if (elem.isEnabled() == true){
//			System.out.println("Element [" + path + "] is enabled");
//			enabled = true;
//		} 
//		
//		return enabled;
//	}
//	
//	/**
//	 * Method check if a radio button is selected or not
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param status
//	 * @throws Exception
//	 */
//	public void isRadioBtnSelected(String path, String formName, String status) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		WebElement elem = WebActions.driver.findElement(By.xpath(xpathValue));
//		
//		waitForElement(path, formName);
//		if (status.equalsIgnoreCase("true")){
//			if (elem.getAttribute("disabled") == null){
//				System.out.println("Element [" + path + "] is selected, as expected!");
//			} else {
//				throwException("Element is not selected!");
//			}
//		} else if (status.equalsIgnoreCase("false")){
//			if (elem.getAttribute("disabled") == null){
//				throwException("Element is selected!");
//			} else {
//				System.out.println("Element [" + path + "] is not selected, as expected!");
//			}
//		}
//		
//	}
//	
//	/**
//	 * Cehck if checkbox is selected
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @param status
//	 * @throws Exception
//	 */
//	public void isCheckboxSelected(String path, String formName, String status) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		WebElement elem = WebActions.driver.findElement(By.xpath(xpathValue));
//		waitForElement(path, formName);
//		
//		System.out.println("-" + elem.getAttribute("value"));
//		
//		if (status.equalsIgnoreCase("true")){
//			if (elem.isSelected()){
//				System.out.println("Element [" + path + "] is selected, as expected!");
//			} else {
//				throwException("Element is not selected!");
//			}
//		} else if (status.equalsIgnoreCase("false")){
//			if (elem.isSelected()){
//				throwException("Element is selected!");
//			} else {
//				System.out.println("Element [" + path + "] is not selected, as expected!");
//			}
//		}
//		
//	}
//	
//	public String getCurrentHandle() {
//		String currentWinHandle = driver.getWindowHandle();
//		return currentWinHandle;
//	}
//	
//	/**
//	 * Find all elements that match xpath, even if the are not visible
//	 * @param path	Sting xpath key of an element 
//	 * @param formName
//	 * @return
//	 */
//	public List<WebElement> listElementsPresent(String path, String formName){
//		String xpathValue = cfg.config(path, formName);
//		System.out.println("Found elements size: " + WebActions.driver.findElements(By.xpath(xpathValue)).size());
//		return WebActions.driver.findElements(By.xpath(xpathValue));
//	}
//	
//	/**
//	 * Find all elements that match xpath, even if the are not visible, and click on first element that is visible
//	 * @param path	Sting xpath key of an element
//	 * @param formName
//	 * @throws Exception
//	 */
//	public void clickOnVisibleListElem(String path, String formName) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		List<WebElement> list = WebActions.driver.findElements(By.xpath(xpathValue));
//		
//		for (int i=0; i<list.size(); i++ ) {
//			if (list.get(i).isDisplayed()) {
//				list.get(i).click();	
//			} 
//		}
//	}
//	
//	/**
//	 * Generates an random int, smaller than "max" value
//	 * @param max
//	 * @return
//	 */
//	@Deprecated
//	public String getRandomInt(int max){
//        Random rand = new Random();
//        int randomNum = rand.nextInt(max);
//        return Integer.toString(randomNum);
//    }
//	
//	/**
//	 * Returns value of a css attribute
//	 * @param path	String name of the xpath used to locate an element
//	 * @param formName	String name of the form 
//	 * @param cssAtt	String name of the css attribute who's value is being returned 
//	 * @return	String value of a specified css attribute
//	 * @throws Exception
//	 */
//	public String getCssValue(String path, String formName, String cssAtt) throws Exception {
//		String xpathValue = cfg.config(path, formName);
//		String value = WebActions.driver.findElement(By.xpath(xpathValue)).getCssValue(cssAtt);
//		return value;
//	}
//	
//	/**
//	 * Check if element is displayed without throwing an exception
//	 * @param path	String name of the xpath used to locate an element
//	 * @param formName	String name of the form 
//	 * @return	boolean indicates if element is displayed or not
//	 * @throws InterruptedException 
//	 */
//	public boolean isDisplayed(String path, String formName) throws InterruptedException {
//		boolean found = false;
//		String xpathValue = cfg.config(path, formName);
//		Thread.sleep(2000);
//		try {
//			found = WebActions.driver.findElement(By.xpath(xpathValue)).isDisplayed();
//		} catch (NoSuchElementException ex) {
//			//Ignore this exception
//		}
//    	return found;
//	}
//	
//	/**
//	 * Check if dynamic element is displayed without throwing an exception
//	 * @param path	String name of the xpath used to locate an element
//	 * @param formName	String name of the form
//	 * @param regex	String string that will be replaced
//	 * @param replacment	String that will be replaced with
//	 * @return	boolean indicates if element is displayed or not
//	 * @throws InterruptedException
//	 */
//	public boolean isDisplayedDynamicEntry(
//			String path, 
//			String formName, 
//			String regex, 
//			String replacment) throws InterruptedException {
//		boolean found = false;
//		boolean done = false;
//		int timeOutInSec = 60;
//		
//		Calendar endTimeCal = Calendar.getInstance();
//		endTimeCal.add(Calendar.SECOND, timeOutInSec);
//		Calendar now = Calendar.getInstance();
//		
//		while (!done & now.getTime().before(endTimeCal.getTime())  ) {
//			try {
//				String xpathValue = cfg.config(path, formName).replaceAll(regex, replacment);
//				Thread.sleep(3000);
//				try {
//					found = WebActions.driver.findElement(By.xpath(xpathValue)).isDisplayed();
//				} catch (NoSuchElementException ex) {
//					System.out.println("-Not displayed :" + path + "-");
//					break;
//				}
//				done = true;
//			} catch (StaleElementReferenceException ex) {
//				System.err.println("StaleElementReferenceException: stale element reference: element "
//						+ "is not attached to the page document");
//			}
//			now = Calendar.getInstance();
//		}
//		return found;
//	}
//	
//	/**
//	 * Wait until an element is displayed, wait for it for maximum specified time
//	 * @param path	String xpath key
//	 * @param formName	String form name
//	 * @param timeOutInSec	int timeout in seconds
//	 * @return	boolean true if element is displayed, false otherwise 
//	 * @throws Exception
//	 */
	public boolean waitUntilDisplayed(String xpathValue, int timeOutInSec) throws Exception{
		
		boolean displayed = false;
		Calendar endTimeCal = Calendar.getInstance();
		endTimeCal.add(Calendar.SECOND, timeOutInSec);
		Calendar now = Calendar.getInstance();
		
		while (!displayed & now.getTime().before(endTimeCal.getTime()) ) {
			try {
				if ( WebActions.driver.findElement(By.xpath(xpathValue)).isDisplayed() ) {
					displayed = true;
				} else {
					Thread.sleep(500);
				}	
			} catch (NoSuchElementException e) {
				Thread.sleep(500);
			}
			now = Calendar.getInstance();
		}
		return displayed;
	}
//	
//	/**
//	 * Wait until a dynamic element is displayed, wait for it for maximum specified time
//	 * @param path	String xpath key
//	 * @param formName	String form name
//	 * @param regex	String value to be changed
//	 * @param replacement	String replacement value
//	 * @param timeOutInSec	int timeout in seconds
//	 * @return	boolean true if element is displayed, false otherwise
//	 * @throws Exception
//	 */
//	public boolean waitUntilDisplayedDynamic(
//			String path, 
//			String formName,
//			String regex,
//			String replacement,
//			int timeOutInSec) throws Exception{
//		
//		System.out.println("-Wait until [" + path + "] is displayed ... ");
//		String xpathValue = cfg.config(path, formName).replaceAll(regex, replacement);
//		boolean displayed = false;
//		Calendar endTimeCal = Calendar.getInstance();
//		endTimeCal.add(Calendar.SECOND, timeOutInSec);
//		Calendar now = Calendar.getInstance();
//		
//		while (!displayed & now.getTime().before(endTimeCal.getTime()) ) {
//			try {
//				if ( WebActions.driver.findElement(By.xpath(xpathValue)).isDisplayed() ) {
//					displayed = true;
//				} else {
//					Thread.sleep(500);
//				}
//			} catch (NoSuchElementException e) {
//				Thread.sleep(500);
//			}
//			now = Calendar.getInstance();
//		}
//		return displayed;
//	}
//	
//	/**
//	 * Remove attribute from a HTML element, element is located by elementID
//	 * @param elementID	String ID of a HTML element
//	 * @param attibuteName	String name of a attribute that will be removed
//	 * @throws InterruptedException
//	 */
//	public void removeAttribute(String elementID, String attibuteName) throws InterruptedException {
//		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		
//		String script = "document.getElementById('" + elementID + "').removeAttribute('" + attibuteName + "');";
//		System.out.println(" [JavaScript]: " + script);
//		jse.executeScript(script);
//		Thread.sleep(2000);
//	}
//	
//	/**
//	 * loops xpath value and clicks the one that contains strMarker value as text
//	 * @param strMarker
//	 * @param firstHalfXpath
//	 * @param secondHalfXpath
//	 * @throws Exception
//	 */
//	public void clickProperStringInLoop(String strMarker,String firstHalfXpath, String secondHalfXpath) throws Exception{
//		String xpathValue = "";
//		String actualText ="";
//	
//		for (int i=1; i<100; i++){
//			xpathValue = firstHalfXpath + i + secondHalfXpath;
//			actualText = WebActions.driver.findElement(By.xpath(xpathValue)).getText();
//			if(actualText.contains(strMarker)){
//				WebActions.driver.findElement(By.xpath(xpathValue)).click();
//				System.out.println("Item: "+i+" clicked!");
//				break;
//			}
//		}
//	}
//	
//	/**
//	 * Find and scroll element into view
//	 * @param path	Sting xpath key of an element
//	 * @param formName	String form name
//	 * @throws Exception
//	 */
//	public void scrollElementIntoView(String path, String formName) throws Exception {
//		System.out.println("-Scroll element into view ... ");
//		String xpathValue = cfg.config(path, formName);
//		List<WebElement> elem = WebActions.driver.findElements(By.xpath(xpathValue));
//		
//		//execute java script to scroll to found element
//		JavascriptExecutor jse = (JavascriptExecutor)WebActions.driver;
//		String script = "arguments[0].scrollIntoView(true);";
//		System.out.println(" [JavaScript]: " + script);
//		jse.executeScript(script, elem.get(0));
//		Thread.sleep(2000);
//	}
//	
//	/**
//	 * Find and scroll element into view
//	 * @param path	Sting xpath key of an element
//	 * @param formName	String form name
//	 * @throws Exception
//	 */
//	public void scrollDynamicElementIntoView(
//			String path, String formName, String regex, String replacement) throws Exception {
//		
//		System.out.println("-Scroll element into view ... ");
//		String xpathValue = cfg.config(path, formName);
//		List<WebElement> elem = WebActions.driver.findElements(By.xpath(xpathValue));
//		
//		//execute java script to scroll to found element
//		JavascriptExecutor jse = (JavascriptExecutor)WebActions.driver;
//		String script = "arguments[0].scrollIntoView(true);";
//		System.out.println(" [JavaScript]: " + script);
//		jse.executeScript(script, elem.get(0));
//		Thread.sleep(2000);
//	}
//	
//	public static ArrayList<String> readArrayFromFile(String fileName) throws IOException{
//		ArrayList <String> linksArray = new ArrayList<String>();
//		String readLine;
//		FileReader read = new FileReader(fileName);
//		BufferedReader br = new BufferedReader(read);
//	    while ((readLine = br.readLine())!=null) {
//	    	linksArray.add(readLine);
//	    }
//	    br.close();
//	    return linksArray;
//	}
//	
//	public static String matchLineFromFile(ArrayList<String> input, String str) throws Exception{
//		String line = "";
//		for (int i=0; i<input.size(); i++){
//			if (input.get(i).contains(str)){
//				line = input.get(i);
//			}
//		}
//		if (line.isEmpty()){
//			throw new Exception("Unable to get line from file. There's no match!");
//		}
//		return line;
//	}
//	
//	public static int regexMatcherCount(String input, String regexPattern, String flag) throws Exception {
//		int count = 0;
//		Pattern pattern = Pattern.compile(regexPattern);
//		Matcher matcher = pattern.matcher(input);
//		while(matcher.find()){
//			count++;
//		}
//		if (flag.equalsIgnoreCase("true")){
//			if (count == 0){
//				throw new Exception("String doesn't contain regex pattern!");
//			} else {
//				System.out.println("Total regex matches: " + count);
//			}
//		} else if (flag.equalsIgnoreCase("false")){
//			if (count == 0){
//				System.out.println("Total regex matches: " + count);
//			} else {
//				throw new Exception("String contains regex pattern!");
//			}
//		}
//		return count;
//	}
//	
//	public static String[] splitResultsTXT(String line, String splitReplacePattern, String splitPattern) {
//		String[] elements = null;
//		elements = line.trim().replaceAll(splitReplacePattern, "").split(splitPattern);
//		System.out.println(line);
//		return elements;
//	}
//	
//	// Clear output file
//	public void clearOutputFile(String fileName, String value, boolean flag){
//		try {
//			Writer output = null;
//			File file = new File(fileName);
//			output = new BufferedWriter(new FileWriter(file, flag));
//			output.write(value);
//			output.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	} 
//	
//	// Creates key value file with tab delimiter
//	public void createOutputFile(String fileName, String value, boolean flag){
//		try {
//			Writer output = null;
//			File file = new File(fileName);
//			output = new BufferedWriter(new FileWriter(file, flag));
//			output.write(value);
//			((BufferedWriter) output).newLine();
//			output.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
//	
//	public static String regexMatcherString(String input, String regexPattern) throws Exception {
//		String regExMatch = "";
//		Pattern pattern = Pattern.compile(regexPattern);
//		Matcher matcher = pattern.matcher(input);
//		while(matcher.find()){
//			regExMatch = matcher.group(0);
//			System.out.println("Matcher find : " + regExMatch);
//		}
//		return regExMatch;
//	} 
//	
//	public static ArrayList<String> regexMatcherArray(String input, String regexPattern) throws Exception {
//		String regExMatch = "";
//		ArrayList<String> arrayRegexMatch = new ArrayList <String>();
//		Pattern pattern = Pattern.compile(regexPattern);
//		Matcher matcher = pattern.matcher(input);
//		while(matcher.find()){
//			regExMatch = matcher.group(0);
//			System.out.println("Matcher find : " + regExMatch);
//			arrayRegexMatch.add(regExMatch); 
//		}
//		return arrayRegexMatch;
//	} 
//	
//	public String readLines(String fileName, int Count) throws Exception {
//		BufferedReader br = null;
//		String temp;
//		List<String> lines = new ArrayList <String>();
//		try {
//			br = new BufferedReader(new FileReader(fileName));
//			while((temp = br.readLine()) != null){
//				lines.add(temp);
//			}
//			String individualLine = lines.get(lines.size()-Count);
//			return individualLine;
//		} finally {
//			try {
//				if (br != null)
//					br.close();
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//	}
//	
//	/**
//	 * Save a screenshot with given file name
//	 * @param fileName	String name of a file
//	 * @throws Exception
//	 */
//	public void saveScreenShot(String fileName) throws Exception {
//		System.out.println("-Save screenshot with name: [" + fileName + "] ... ");
//		//Take a screenshot
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		//Generate a path
//		String fullFilePath = System.getProperty("user.dir") + fs + "test-output" + fs + "EXECUTION_SCREENSHOTS" + fs + fileName;
//		//Save a screenshot on the path
//		FileUtils.copyFile(scrFile, new File(fullFilePath));
//	}
	
}
