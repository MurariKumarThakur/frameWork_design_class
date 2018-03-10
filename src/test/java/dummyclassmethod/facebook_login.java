package dummyclassmethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.file.utility.excelFileReusable;

public class facebook_login {
	
	WebDriver driver ;
	
	
	public void facebookWithMultipleData(String userName , String password){
	
	
	  System.setProperty("webdriver.chrome.driver", "./browserDrivercontainer/chromedriver.exe");
	  driver = new ChromeDriver();
	    driver.get("https://www.facebook.com");
	    
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    driver.findElement(By.id("email")).sendKeys(userName);
	    
	    driver.findElement(By.id("pass")).sendKeys(password);
	    
	    
	    
	    
	
	}
	
	
	@Test
	public void facebookloginwithMulitpledata(){
		
		String filePath = "./src/test/java/com/testData/TestData.xlsx";
		
		excelFileReusable obj = new excelFileReusable(filePath);	
		
		for(int m=1 ; m<=obj.TotalRowNumber("Sheet1");m++){
		facebookWithMultipleData(obj.getCellData("Sheet1", "userName", m),
				obj.getCellData("Sheet1", "password", m));
		}	
		
	}
	
	
	
	
	
}
