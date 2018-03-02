package com.business.testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.file.utility.propertyFileReusable;
import com.framework.reusable.driverEngine;

public class facebookLogin  extends driverEngine {
	


	@Test
	public void loginFacebook(By  passLocator) throws IOException{
		
		propertyFileReusable data = new propertyFileReusable("./src/test/java/com/app/objectRepository/OR.gamil.properties");
		
		     getDriver().get(data.getPropertyFileValue("url"));
		 
	      
	}
}
