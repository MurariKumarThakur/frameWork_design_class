package com.business.testCase;

import org.testng.annotations.Test;

import com.framework.reusable.driverEngine;

public class gamilLogin extends driverEngine {
	@Test
	public void loginGmail(){
		
		getDriver().get("https://www.gmail.com");
		getDriver().findElementById("identifierId").sendKeys("murariraj.two@gmail.com");
		
	}

}
