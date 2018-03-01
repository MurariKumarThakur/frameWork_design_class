package dummyclassmethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class screenshot {
	
	WebDriver driver ;
	public void takeScreenShot () throws IOException{
		
		   TakesScreenshot shot = (TakesScreenshot)driver ;
		   
	File file =	   shot.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(file, new File("./failureTest_CaseScreenShot/image.jpeg"));
		
		
	}
  public void takeFailureTestCaseScreenShot(ITestResult result) throws IOException{
	  
	  
	    if(result.getStatus() == ITestResult.FAILURE){
	    	
	    	      takeScreenShot ();
	    	
	    }
	  
	  
  }
}
