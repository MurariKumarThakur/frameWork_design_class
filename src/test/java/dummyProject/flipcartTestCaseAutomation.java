package dummyProject;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class flipcartTestCaseAutomation extends driverEngine {
	WebDriverWait wait;
	WebElement web;

	public void WaitForvisiability(String EnterXpathValue) {

		wait = new WebDriverWait(getDriver(), 30);
		web = getDriver().findElement(By.xpath(EnterXpathValue));
		wait.until(ExpectedConditions.visibilityOf(web));

	}

	public void WaitForClickable(String EnterXpathValue) {

		wait = new WebDriverWait(getDriver(), 30);
		web = getDriver().findElement(By.xpath(EnterXpathValue));
		wait.until(ExpectedConditions.elementToBeClickable(web));

	}

	public void SelectDropDownValue(String dropDownFieldXpath, String enterValue) {
		web = getDriver().findElement(By.xpath(dropDownFieldXpath));
		Select sel = new Select(web);
		sel.selectByValue(enterValue);
	}

	public void windowHandle() {

		Set<String> windows = getDriver().getWindowHandles();
		Iterator iterator = windows.iterator();
		 int i =1 ;
		while (iterator.hasNext()) {
			String window = (String) iterator.next();
			
			if (i==2) {
				getDriver().switchTo().window(window);
				break;
			}
			i++;
		}

	}

	public void scrool(String enterXpathLoc) {
		web = getDriver().findElement(By.xpath(enterXpathLoc));

		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].scrollIntoView(true);", web);
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
		String popupLoc = "//button[text()='✕']";
		WaitForvisiability(popupLoc);
		getDriver().findElement(By.xpath(popupLoc)).click();
		WaitForvisiability("//span[text()='Electronics']");
		web = getDriver().findElementByXPath("//span[text()='Electronics']");
		Actions act = new Actions(getDriver());
		act.moveToElement(web).perform();

		WaitForvisiability("//span[text()='Mobiles']");
		String MobileText = getDriver().findElement(By.xpath("//span[text()='Mobiles']")).getText();

		textFileReusable file = new textFileReusable("./src/test/java/TextFileFolder/textFile.txt");
		// write text in text file
		file.WriteFile(MobileText);

		getDriver().findElement(By.xpath("//span[text()='Mobiles']")).click();

		WaitForvisiability("//h1[text()='Mobile Phones']");

		String actualText = getDriver().findElement(By.xpath("//h1[text()='Mobile Phones']")).getText();
		if (actualText.contains("Mobile Phone")) {

			System.out.println("passed ====" + m.getName());
		} else {

			System.out.println("Failed ===" + m.getName());
		}
	}

	@Test(priority = 3)
	public void selectPriceRange(Method m) {

		String selectfield1 = "(//select[@class='a_eCSK'])[1]";
		String selectfield2 = "(//select[@class='a_eCSK'])[2]";
		SelectDropDownValue(selectfield1, "4000");
		SelectDropDownValue(selectfield2, "16000");

		String FistSelectFieldSelectedValue = getDriver().findElement(By.xpath(selectfield1)).getAttribute("value");
		String SecondSelectFieldSelectedValue = getDriver().findElement(By.xpath(selectfield2)).getAttribute("value");

		if (FistSelectFieldSelectedValue.contains("4000") && SecondSelectFieldSelectedValue.contains("16000")) {

			System.out.println("passed ::===" + m.getName());

		} else {

			System.out.println("Failed ::===" + m.getName());
		}
	}

	@Test(priority = 4)
	public void selectMobileBrandAsSamsung(Method m) {
		String brandLoc = "//div[text()='Brand']";
		scrool(brandLoc);

		WaitForvisiability("//div[text()='Samsung']");
		getDriver().findElement(By.xpath("//div[text()='Samsung']")).click();

		WaitForvisiability("//div[text()='✕']/following::div[text()='Samsung']");
		String filterMobileName = getDriver()
				.findElement(By.xpath("//div[text()='✕']/following::div[text()='Samsung']")).getText();

		if (filterMobileName.contains("Samsung")) {

			System.out.println("Passed ===" + m.getName());
		} else {

			System.out.println("Failed ===" + m.getName());
		}

	}

	@Test(priority = 5)
	public void checkAllSamsungMobileDisplayOrNot() {

		String allMObile = "//div[contains(@class,'gKeQ')]";
		String allMobileName = "//div[contains(@class, '3wU53n')]";

		WaitForvisiability(allMObile);

		int size = getDriver().findElements(By.xpath(allMObile)).size();

		for (int i = 1; i <= size; i++) {

			String dynamicMobileName = "(//div[contains(@class, '3wU53n')])[" + i + "]";
			String dynamicMobileLocator = dynamicMobileName.trim();
			String ActualMobileName = getDriver().findElement(By.xpath(dynamicMobileLocator)).getText();

			if (ActualMobileName.contains("Samsung")) {

				if (i == size) {
					System.out.println("Total number of Displayed Samsung Mobile is " + i);
					System.out.println("Passed ::=== Displed Mobile is  Samsung ");
				}

			} else {

				System.out.println("Failed ::=== position---" + i + " Samsung mobile is not There !!! ");
			}

		}

	}

	@Test(priority = 6)
	public void ClickOnFistSamsungMobileIfItIsNotOutOfStock() {
		String allMObiles = "//div[contains(@class,'gKeQ')]";
		String allOutOfStockMobile = "//div[contains(@style,'filter: grayscale')]";

		int allMobileNum = getDriver().findElements(By.xpath(allMObiles)).size();
		int allOutOfStockMobileNum = getDriver().findElements(By.xpath(allOutOfStockMobile)).size();

		if (allMobileNum > allOutOfStockMobileNum) {

			getDriver().findElement(By.xpath("(//div[contains(@class,'gKeQ')])[1]")).click();
			
			System.out.println("Fist Mobile clicked !!!");
		} else {
			System.out.println("Stock Not avilable ");
		}

	}

	@Test(priority = 7)
	public void addMobileToCart() {
		//windowHandle();
		windowHandle();
		String addMobileToCartButton = "//button[text()='ADD TO CART']";
		String myCartPage = "//span[contains(text(),'My Cart')]";

		WaitForClickable(addMobileToCartButton);
		getDriver().findElement(By.xpath(addMobileToCartButton)).click();
		WaitForvisiability(myCartPage);
		int MyCart = getDriver().findElements(By.xpath(myCartPage)).size();
		if (MyCart > 0) {

			System.out.println("Passed ::== Item is added successfully To Cart ");
		} else {

			System.out.println("Faileed ::== Item is not Added Succefully To Cart");
		}

	}

	@Test(priority = 8)
	public void placeOrder() {

		String placeorderBuytton = "//span[text()='Place Order']";
		String loginAndSingUPText = "//span[contains(text(),'Login or Signup')]";

		getDriver().findElement(By.xpath(placeorderBuytton)).click();

		WaitForvisiability(loginAndSingUPText);

		int loginAndSignupNum = getDriver().findElements(By.xpath(loginAndSingUPText)).size();
		if (loginAndSignupNum > 0) {

			System.out.println("Passed ::===Order is Place Successfully !!! ");
		} else {

			System.out.println("Failed ::=== Order is Not place Successfully !!! ");
		}

	}

	@Test(priority = 9)
	public void enterMobileOrPhoneNumber() {
		String emailOrPhoneNumberTextBox = "//input";
		String continueButton = "//button";
		String myEmail = "murariraj.one@gmail.com";
		String loginButton = "//span[text()='Login']";
		getDriver().findElement(By.xpath(emailOrPhoneNumberTextBox)).sendKeys(myEmail);
		getDriver().findElement(By.xpath(continueButton)).click();

		WaitForvisiability(loginButton);

		int loginButtonNum = getDriver().findElements(By.xpath(loginButton)).size();

		if (loginButtonNum > 0) {
			System.out.println("Passed ::=== Email Or Phone Number Entered !!!");

		} else {

			System.out.println("Failed ::=== Email Or Phone Number Not Entered !!!");
		}

	}
}
