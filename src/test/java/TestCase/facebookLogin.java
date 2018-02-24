package TestCase;

import org.testng.annotations.Test;

import DriverEngine.driverEngine;

public class facebookLogin  extends driverEngine {
	@Test
	public void loginFacebook(){
		
		 driver.get("https://www.facebook.com");
		 driver.findElementById("emai").sendKeys("murariraj.two@gmail.com");
		
	}
}
