package dummyProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.file.utility.excelFileReusable;
import com.object.utility.objectUtility;

public class facebook_login_With_MultipleData {

	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@AfterClass
	public void closeBrowser(){
		
		//driver.close();
	}

	public void facebookWithMultipleData(String userName, String password) {

		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("email")).sendKeys(userName);

		driver.findElement(By.id("pass")).sendKeys(password);

	}

	@Test
	public void facebookloginwithMulitpledata() {

		excelFileReusable excelhandling = objectUtility.getExcelReusable(objectUtility.getExcelFilePath());

		for (int m = 1; m <= excelhandling.TotalRowNumber("Sheet1"); m++) {
			facebookWithMultipleData(excelhandling.getColumeWiseData("Sheet1", "userName", m),
					excelhandling.getColumeWiseData("Sheet1", "password", m));
		}

	}

}
