package dummyProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.file.utility.propertyFileReusable;
import com.framework.reusable.driverEngine;

public class flipcartTestCaseAutomation extends driverEngine {
	 
     @Test(priority=1)
	public void enterFlipCartUrl() throws IOException {

		propertyFileReusable pfr = new propertyFileReusable("./config.property");
		String url = pfr.getPropertyFileValue("url");
		
		

		  getDriver().get(url);
		  
	 String actualTitle =	  getDriver().getTitle();
	 String expectedTitle = "Online Shopping Site for Mobiles";
	 
	     if(actualTitle.contains(expectedTitle)){
	    	 
	    	 System.out.println("Passed ::-- Flipcart page is openning");
	     }else{
	    	 System.out.println("Failed ::-- Flipcart page is not openning");
	     }
		  
		  

	}
     @Test(priority=2)
     public void mouseOverOnElectronic_StoreTextInTextFile(){
    	 
       
    	 
    	 
     }

}
