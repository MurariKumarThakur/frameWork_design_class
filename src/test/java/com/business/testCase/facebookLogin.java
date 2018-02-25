package com.business.testCase;

import org.testng.annotations.Test;

import com.framework.reusable.driverEngine;

public class facebookLogin  extends driverEngine {
	@Test
	public void loginFacebook(){
		
		 getDriver().get("https://www.facebook.com");
		 getDriver().findElementById("emai").sendKeys("murariraj.two@gmail.com");
		
	}
}
