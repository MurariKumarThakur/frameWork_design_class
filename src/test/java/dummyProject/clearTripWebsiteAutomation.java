package dummyProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.file.utility.propertyFileReusable;
import com.framework.reusable.driverEngine;

public class clearTripWebsiteAutomation extends driverEngine {
	WebDriverWait wait;
	WebElement web;
	boolean selected;
	boolean display;
	propertyFileReusable config = new propertyFileReusable("./config.property");

	public void WaitForvisiability(String EnterXpathValue) {

		wait = new WebDriverWait(getDriver(), 30);
		web = getDriver().findElement(By.xpath(EnterXpathValue));
		wait.until(ExpectedConditions.visibilityOf(web));

	}

	public void clickOnEnterButton() {

		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SelectDropDownValue(String dropDownFieldXpath, String enterVisiableText) {
		web = getDriver().findElement(By.xpath(dropDownFieldXpath));
		Select sel = new Select(web);
		sel.selectByVisibleText(enterVisiableText);

	}
@Test(priority=1)
	public void checkDesireSiteIsOpenningOrNot() {

		String clearTripUrl = config.getPropertyFileValue("cleartripUrl");
		getDriver().get(clearTripUrl);
		String actualTitle = getDriver().getTitle();
		String expectedTitle = "Site for Booking Flights";

		Assert.assertTrue(actualTitle.contains(expectedTitle));

	}
@Test(priority=2)
	public void checkOneTripIsSelectedOrNot() {

		selected = getDriver().findElement(By.id("OneWay")).isSelected();

		if (selected == true) {

			System.out.println("Passed ::-- One way Selected !!!");
		} else {

			System.out.println("Failed ::-- One way Not Selected !!!");
		}

	}
@Test(priority=3)
	public void clickOnRoundTrip() {

		getDriver().findElement(By.id("RoundTrip")).click();
		selected = getDriver().findElement(By.id("RoundTrip")).isSelected();
		if (selected == true) {

			System.out.println("Passed ::-- RoundTrip Selected !!!");
		} else {

			System.out.println("Failed ::- RoundTrip Not Selected !!!");
		}

	}
@Test(priority=4)
	public void SelectDistination() {

		getDriver().findElement(By.id("FromTag")).sendKeys("Hyderabad");

		WaitForvisiability("//a[@class='uiSelected']");
		clickOnEnterButton();
	
		String text = getDriver().findElement(By.id("FromTag")).getAttribute("value") ;
            System.out.println("=======text is"+text);
		if (text.contains("Hyderabad")) {

			System.out.println("Passed ::-- Hyderabad Selected !!!");
		} else {

			System.out.println("Failed ::-- Hyderabd Not Selected !!!");
		}

		getDriver().findElement(By.id("ToTag")).sendKeys("tirupati");

		WaitForvisiability("//a[@class='uiSelected']");
		clickOnEnterButton();
		clickOnEnterButton();
	
		String text2 = getDriver().findElement(By.id("ToTag")).getAttribute("value");

		if (text2.contains("Tirupati")) {

			System.out.println("Passed ::-- Tirupati Selected !!!");
		} else {

			System.out.println("Failed ::-- Tirupati Not Selected !!!");
		}

	}
@Test(priority=5)
	public void dropSelectDropDownValue() {

		SelectDropDownValue("//select[@name='adults']", "5");
		String selectedAdult = getDriver().findElement(By.xpath("//select[@name='adults']")).getAttribute("value");
		if (selectedAdult.equals("5")) {

			System.out.println("Passed::--5 Adults are selected !!!");
		} else {
			System.out.println("Failed::--5 Adults are Not selected !!!");

		}
		SelectDropDownValue("//select[@name='childs']", "2");
		String selectedChild = getDriver().findElement(By.xpath("//select[@name='childs']")).getAttribute("value");
		if (selectedChild.equals("2")) {

			System.out.println("Passed::--2 Child are selected !!!");
		} else {
			System.out.println("Failed::--2 child are Not selected !!!");

		}
		SelectDropDownValue("//select[@name='infants']", "3");
		String selectedInfants = getDriver().findElement(By.xpath("//select[@name='infants']")).getAttribute("value");
		if (selectedInfants.equals("3")) {

			System.out.println("Passed::--3 Infants are selected !!!");
		} else {
			System.out.println("Failed::--3 Infants are Not selected !!!");

		}
		
	}
@Test(priority=6)
	public void clickSearchButtonWorkingOrNot(){
		
		getDriver().findElement(By.xpath("//*[@id='SearchBtn']")).click();
		WaitForvisiability("//a[text()='Price']");
		
	String actualText =	 getDriver().findElement(By.xpath("//a[text()='Price']")).getText();
		 if(actualText.contains("Price")){
			 
			 System.out.println("Passed ::-- Result is coming !!!");
		 }else {
			 
			 System.out.println("Failed ::-- Result is Not coming !!!");
		 }
		
		
	}
}
