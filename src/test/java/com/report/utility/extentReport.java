package com.report.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.reusable.driverEngine;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentReport {
	ExtentReports report;
	ExtentTest logger;

	WebDriver driver;
	
	
	String reportUrl = System.getProperty("user.dir")+"/extentReportView/report.html";

	public extentReport(String ReportHeading) {

		report = new ExtentReports(reportUrl);

		logger = report.startTest(ReportHeading);

	}
	
	
	@BeforeClass
	public void launchBrowser(){

		System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");

		driver = new ChromeDriver();	
		logger.log(LogStatus.INFO, "Browser Lunch Successfully");	
		
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Window maximize ");
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		logger.log(LogStatus.INFO, "implicit wait added");
	}
	
	
@Test
	public void facebookLogin() {


		
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Window maximize ");
		driver.get("https://www.facebook.com");

		logger.log(LogStatus.INFO, "Url loaded");
		
	String actualUrl =	driver.getCurrentUrl();
	
	String expectedUrl = "https://www.facebook.co";
		
		Assert.assertTrue(actualUrl.equals(expectedUrl));
		
		logger.log(LogStatus.INFO, "Test case  pass successfully");

	}

@AfterMethod
public void tearDown(ITestResult result){
	
	if(result.getStatus()==ITestResult.FAILURE){
		
	driverEngine obj = new driverEngine();
	
String screenshotPath = 	obj.takeScreenShot(driver , result.getName());

 

String imagePath = logger.addScreenCapture(screenshotPath);



logger.log(LogStatus.FAIL,imagePath);
logger.log(LogStatus.INFO, result.getName()+"=====Test Case fail");
	

		
	}
	
	report.endTest(logger);
	report.flush();
	
	driver.get(reportUrl);
	
	
	
	
	
}

 
}
