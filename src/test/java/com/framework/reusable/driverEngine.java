package com.framework.reusable;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;




public class driverEngine {
	




	 private static RemoteWebDriver driver;
	 WebDriverWait wait ;
	
	@Parameters("BrowserName")
	@BeforeSuite

	public void OpenBrowser(@Optional("chrome") String BrowserName) {

		if (BrowserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");
			driver = new ChromeDriver();
			basicInitialization();

		} else if (BrowserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./browserDrivercontainer/geckodriver.exe");
			driver = new FirefoxDriver();

			basicInitialization();
		} else if (BrowserName.equalsIgnoreCase("internetExplorer")) {

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
//========= basic Initialization===========
	public void basicInitialization() {

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}
	@AfterSuite
    public void  closeBrowser(){
    	
    	 if(driver != null){
    		 
    		 driver.close();
    	 }else{
    		 
    		 System.out.println("DRIVER IS NOT HOLDING ANY VALUE CHECK ONCE");
    	 }
    }
	@BeforeMethod 
	 public void getMethodName(Method m){
		 
		String dyanamicTestCaseName =  m.getName();
		
		System.out.println(dyanamicTestCaseName+"==== TEST CASE EXECUTION START");
		 
		 
	 }
	@AfterMethod 
	 public void getMethodName2(Method m){
		 
		String dyanamicTestCaseName =  m.getName();
		
		System.out.println(dyanamicTestCaseName+"==== TEST CASE EXECUTION End");
		 
		 
	 }
	
	
//=========== TakeSceenShot ===================
	 public void takeScreenShot(String FailureTestCaseName){
		 
	try {
		TakesScreenshot shootImage =	    (TakesScreenshot) driver ;
		File file =     shootImage.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(file, new File("./failureTest_CaseScreenShot/"+FailureTestCaseName +".jpeg"));
	} catch (Exception e) {
		
		System.out.println(" CHECK === takeScreenShot () ===  ONCE "+ e.getMessage());
	
	}	 
	 }
	 
	 @AfterMethod
	 public void takeFailureTestCaseScreenShot (ITestResult result ){
		 
		if(result.getStatus() == ITestResult.FAILURE){
			
		   takeScreenShot(result.getName());
			
		}
		 
	 }
	 
	 // =========== Access private Method ==========
	 
	 
	 public static RemoteWebDriver getDriver(){
		 
		 return driver ;
	 }
	 
	 
}


