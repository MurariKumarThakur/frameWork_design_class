package com.framework.reusable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class driverEngine {

	public static ExtentReports report;
	public   ExtentTest logger;

	static String reportUrl = System.getProperty("user.dir") + "/extentReportView/report.html";
	
	static {
		
		
		report = new ExtentReports(reportUrl);
	}

	@BeforeMethod
	public void getloggerData(Method m) {

		

		logger = report.startTest(m.getName());
		
		logger.log(LogStatus.INFO, m.getName()+"===  ****************Test case started **********************");

	}

	public void loggerInfo(String passInformation) {

		logger.log(LogStatus.INFO, passInformation);

	}

	public void addFilureTestCaseImageInExtentReport(String failureTestCaseName) {

		String failureImagePath = takeScreenShot(driver, failureTestCaseName);

		String reportImagePath = logger.addScreenCapture(failureImagePath);

		logger.log(LogStatus.FAIL, reportImagePath);

		
	}

	private static RemoteWebDriver driver;
	WebDriverWait wait;

	@Parameters("BrowserName")
	@BeforeSuite

	public void OpenBrowser(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");
			driver = new ChromeDriver();
			basicInitialization();

		} else if (BrowserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./browserDrivercontainer/geckodriver.exe");
			driver = new FirefoxDriver();

			basicInitialization();
		} else if (BrowserName.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", "./browserDrivercontainer/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			basicInitialization();

		} else if (BrowserName.equalsIgnoreCase("opera")) {

			System.setProperty("webdriver.opera.driver", "./browserDrivercontainer/operadriverCheck.exe");
			driver = new OperaDriver();
			basicInitialization();

		} else if (BrowserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "./browserDrivercontainer/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

			basicInitialization();

		} else {

			System.err.println("==== CHECK BROWSER NAME ONCE ====");
		}

	}

	// ========= basic Initialization===========
	public void basicInitialization() {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void closeBrowser() {

		if (driver != null) {

			driver.get(reportUrl);
		} else {

			System.out.println("DRIVER IS NOT HOLDING ANY VALUE CHECK ONCE");
		}
	}

	

	

	// =========== TakeSceenShot ===================
	public String takeScreenShot(WebDriver passdriver, String FailureTestCaseName) {
		String dest = null;
		try {

			TakesScreenshot shootImage = (TakesScreenshot) passdriver;
			File file = shootImage.getScreenshotAs(OutputType.FILE);

			dest = System.getProperty("user.dir") + "/failureTest_CaseScreenShot/" + FailureTestCaseName + ".jpeg";
			FileUtils.copyFile(file, new File(dest));

			return dest;
		} catch (Exception e) {

			System.out.println(" CHECK === takeScreenShot () ===  ONCE " + e.getMessage());

		}
		return dest;

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getTestStatus(result);

	}
	
	
	public void getTestStatus (ITestResult result){
		
		if(result.getStatus()==ITestResult.SUCCESS){
			logger.log(LogStatus.PASS, result.getName()+"=== Successfully Executed");
		}
		else if(result.getStatus()==ITestResult.SKIP){
			
			logger.log(LogStatus.SKIP, result.getName()+"=== Test case Skipped And  Reason is === "+result.getThrowable());		
			
		}else if(result.getStatus()==ITestResult.FAILURE){
			
			addFilureTestCaseImageInExtentReport(result.getName());
			
			logger.log(LogStatus.FAIL, result.getName()+"=== Test case Failed And Reason is === "+result.getThrowable());			
			
		}else if(result.getStatus()==ITestResult.STARTED){
			
			logger.log(LogStatus.INFO, result.getName()+"=== Test case Started");		
			
		}	
		
	}
	@AfterClass
	public void afterClass(){
		
		report.endTest(logger);
		report.flush();
		//driver.get(reportUrl);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// =========== Access private Method ==========

	public static RemoteWebDriver getDriver() {

		return driver;
	}

}
