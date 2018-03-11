package com.business.testCase;

import org.testng.annotations.Test;

import com.framework.reusable.driverEngine;

public class gamilLogin extends driverEngine {
	@Test
	public void loginGmail(){
		
		getDriver().get("https://www.gmail.com");
		getDriver().findElementById("identifierId").sendKeys("murariraj.two@gmail.com");
		
	}
	@Test
public void loginGmail2(){
		
		getDriver().findElementById("identifierId").clear();
		getDriver().findElementById("identifierI").sendKeys("murariraj.two@gmail.com");
		
	}
	
	@Test
	public void loginGmail3(){
			
			getDriver().findElementById("identifierId").clear();
			getDriver().findElementById("identifierI").sendKeys("murariraj.two@gmail.com");
			
		}
}
