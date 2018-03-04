package dummyProject;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.file.utility.propertyFileReusable;
import com.file.utility.textFileReusable;
import com.framework.reusable.driverEngine;

public class flipcartTestCaseAutomation extends driverEngine {
	WebDriverWait wait;
	WebElement web;

	public void WaitForvisiability(String EnterXpathValue) {

		wait = new WebDriverWait(getDriver(), 30);
		web = getDriver().findElement(By.xpath(EnterXpathValue));
		wait.until(ExpectedConditions.visibilityOf(web));

	}

	public void SelectDropDownValue(String dropDownFieldXpath, String enterValue) {
		web = getDriver().findElement(By.xpath(dropDownFieldXpath));
		Select sel = new Select(web);
		sel.selectByValue(enterValue);
	}

	@Test(priority = 1)
	public void enterFlipCartUrl() throws IOException {

		propertyFileReusable pfr = new propertyFileReusable("./config.property");
		String url = pfr.getPropertyFileValue("url");

		getDriver().get(url);

		String actualTitle = getDriver().getTitle();
		String expectedTitle = "Online Shopping Site for Mobiles";

		if (actualTitle.contains(expectedTitle)) {

			System.out.println("Passed ::-- Flipcart page is openning");
		} else {
			System.out.println("Failed ::-- Flipcart page is not openning");
		}

	}

	@Test(priority = 2)
	public void mouseOverOnElectronic_StoreTextInTextFile(Method m) throws Exception {

		WaitForvisiability("//span[text()='Electronics']");
		web = getDriver().findElementByXPath("//span[text()='Electronics']");
		Actions act = new Actions(getDriver());
		act.moveToElement(web).perform();

		WaitForvisiability("//span[text()='Mobile']");
		String MobileText = getDriver().findElement(By.xpath("//span[text()='Mobile']")).getText();

		textFileReusable file = new textFileReusable("./src/test/java/TextFileFolder/textFile.txt");
		// write text in text file
		file.WriteFile(MobileText);

		getDriver().findElement(By.xpath("//span[text()='Mobile']")).click();
		;

		WaitForvisiability("//h1[text()='Mobile Phones']");

		String actualText = getDriver().findElement(By.xpath("//h1[text()='Mobile Phones']")).getText();
		if (actualText.contains("Mobile Phone")) {

			System.out.println("passed ====" + m.getName());
		} else {

			System.out.println("Failed ===" + m.getName());
		}
	}

	public void selectPriceRange(Method m) {

		String selectfield1 = "(//select[@class='a_eCSK'])[1]";
		String selectfield2 = "(//select[@class='a_eCSK'])[2]";
		SelectDropDownValue(selectfield1, "4000");
		SelectDropDownValue(selectfield2, "16000");

		String FistSelectFieldSelectedValue = getDriver().findElement(By.xpath(selectfield2)).getText();
		String SecondSelectFieldSelectedValue = getDriver().findElement(By.xpath(selectfield2)).getText();

		if (FistSelectFieldSelectedValue.contains("4000") && SecondSelectFieldSelectedValue.contains("16000")) {

			System.out.println("passed ::===" + m.getName());

		} else {

			System.out.println("Failed ::===" + m.getName());
		}
	}

	public void selectMobileBrandAsSamsung(Method m) {
     getDriver().findElement(By.xpath("//div[text()='Samsung']")).click();
      WaitForvisiability("//div[text()='✕']/following::div[text()='Samsung']");
    String filterMobileName =   getDriver().findElement(By.xpath("//div[text()='✕']/following::div[text()='Samsung']")).getText();
    
        if(filterMobileName.contains("Samsung")){
        	
        	System.out.println("Passed ==="+m.getName());
        }else{
        	
        	System.out.println("Failed ==="+m.getName());
        }
       
     
	}
}
