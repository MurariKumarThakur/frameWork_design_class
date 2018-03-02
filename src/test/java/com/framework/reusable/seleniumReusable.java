package com.framework.reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumReusable extends driverEngine{

	WebElement web;
	WebDriverWait wait;

	public void waitForVisiability(By passLocator) {

		web = getDriver().findElement(passLocator);

		wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(web));

	}
	public void mouseOverConcept(){
		
	WebElement web =	getDriver().findElement(By.xpath(""));
		 Actions act = new Actions(getDriver());
		
		 act.moveToElement(web).build().perform();
		 
		 
	}

}
