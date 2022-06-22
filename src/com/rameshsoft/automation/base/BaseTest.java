package com.rameshsoft.automation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.utilities.DriverPaths;
import com.rameshsoft.automation.utilities.ScreenshotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	
	private static WebDriver driver;
	private static String tcName;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	
	/*
	This method is used for opening the browser
	param: which browser want to open(chrome,ie,firefx etc)
	*/
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(@Optional("chrome")String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(DriverPaths.firefoxKey, DriverPaths.firefoxValue);
			driver = new FirefoxDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(DriverPaths.chromeKey, DriverPaths.chromeValue);
			driver = new ChromeDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty(DriverPaths.ieKey, DriverPaths.ieValue);
			driver = new InternetExplorerDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty(DriverPaths.edgeKey, DriverPaths.edgeValue);
			driver = new EdgeDriver();
			init();
		}
	}
	
	public void init() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	/*
	 * Close the browser
	 */
	@AfterSuite
	public void closeBrowser() throws FrameworkException {
		if (driver!=null) {
			driver.close();
		}
		else {
			FrameworkException exception = new FrameworkException("DRIVER IS POINTING TO NULL");
			//throw exception
			System.out.println("DRIVER IS POINTING TO NULL");
			throw exception;
		}
	}
	
	@BeforeMethod
	public void beforeTCExecution(Method method) {
		tcName = method.getName();
		System.out.println("Current execution test case is: "+tcName);
		extentTest = extentReports.startTest(tcName);
		extentTest.log(LogStatus.PASS, "Current execution testcase is: "+tcName);
	}
	
	@AfterMethod
	public void afterTCExecution(ITestResult result) throws IOException {
		String tcName = result.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Test case is passed: "+tcName);
			extentTest.log(LogStatus.PASS, "Test case is passed: "+tcName);
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test case is failed: "+tcName);
			extentTest.log(LogStatus.FAIL, "Test case is failed: "+tcName);
			extentTest.log(LogStatus.FAIL, result.getThrowable());
			String imagePath = ScreenshotUtility.takeScreenshot();
			System.out.println("Exception is: "+result.getThrowable());
			extentTest.addScreenCapture(imagePath);
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("Test case is skipped: "+tcName);
			extentTest.log(LogStatus.SKIP, "Test case is failed: "+tcName);
			extentTest.log(LogStatus.SKIP, result.getThrowable());
			String imagePath = ScreenshotUtility.takeScreenshot();
			System.out.println("Exception is: "+result.getThrowable());
			extentTest.addScreenCapture(imagePath);
		}
		extentReports.endTest(extentTest);
		extentReports.flush();
	}
	
	
	@BeforeTest
	public void initReports() {
		extentReports = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\report.html");
	}
	
	@AfterTest
	public void generateReports() throws FrameworkException {
		if (extentReports!=null) {
			extentReports.close();
		}
		else {
			//throw exception
			FrameworkException exception = new FrameworkException("EXTENT REPORTS IS POINTING TO NULL");
			throw exception;
		}
	}
	
	
	/*
	 * To access WebDriver object outside the class
	 */
	public static WebDriver getDriver() {
		return driver;
	}
	
	/*
	 * To access test case name outside the class
	 */
	public static String getTcName() {
		return tcName;
	}
	
	/*
	 * To access extent test object outside the class
	 */
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	
}
