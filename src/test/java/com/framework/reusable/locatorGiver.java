package com.framework.reusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.file.utility.propertyFileReusable;

public class locatorGiver extends driverEngine {
	
	
	

	public WebElement locatorFinder(String locator) throws Exception {
		
	

		
		String[] str = locator.split(":");
		String locatorName = str[0];
		String locatorValue = str[1];
		if (locatorName.equalsIgnoreCase("id")) {

			getDriver().findElement(By.id(locatorValue));
		} else if (locatorName.equalsIgnoreCase("class")) {

			return getDriver().findElement(By.className(locatorValue));
		} else if (locatorName.equalsIgnoreCase("name")) {

			return getDriver().findElement(By.name(locatorValue));
		}

		else if (locatorName.equalsIgnoreCase("xpath")) {

			return getDriver().findElement(By.xpath(locatorValue));
		} else if (locatorName.equalsIgnoreCase("css")) {

			return getDriver().findElement(By.cssSelector(locatorValue));
		} else if (locatorName.equalsIgnoreCase("linkText")) {

			return getDriver().findElement(By.linkText(locatorValue));
		} else if (locatorName.equalsIgnoreCase("partialLinkText")) {

			return getDriver().findElement(By.partialLinkText(locatorValue));
		}
		else{
			
			throw new  Exception("Locator name not match---"+locatorName);
		}
		return null;

	}
	
	 public WebElement getWebElement(String locator) throws Exception{
		return locatorFinder(locator);
		 
		 
	 }
  
	public static void main(String[] args) throws Exception {
		
		propertyFileReusable gmailProFile= new propertyFileReusable("./src/test/java/com/app/objectRepository/OR.flipcart.properties");
		String userNameLoc =  gmailProFile.getPropertyFileValue("userName");
		locatorGiver lc = new locatorGiver();
		lc.getWebElement(userNameLoc);
		
		  
	}

}
