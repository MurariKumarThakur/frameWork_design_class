package TestCase;

import org.testng.annotations.Test;

import DriverEngine.driverEngine;

public class gamilLogin extends driverEngine {
	@Test
	public void loginGmail(){
		
		driver.get("https://www.gmail.com");
  	    driver.findElementById("identifierI").sendKeys("murariraj.two@gmail.com");
		
	}

}
