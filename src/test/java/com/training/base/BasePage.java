package com.training.base;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.log.Log;

public class BasePage {

	protected WebDriver driver;
	public HashMap<String, By> objRep = new HashMap<String, By>();
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addObject(String logicalName, By by){
		objRep.put(logicalName, by);
	}
	
	public void waitForClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForPageToLoad(String partOfTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.titleContains(partOfTitle));
	}
	
	public void clickButton(WebElement element) {
		waitForClick(element);
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		} else {
			System.out.println("Not Clicked");
		}
	}
	
	public void selectFromDropDownByText(WebElement element, String visibleText) {
		waitForElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectFromDropDownByIndex(WebElement element, int index) {
		waitForElement(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void takeScreenshot(WebDriver driver) throws IOException {
		Date currentDate = new Date();
		String timestamp = new SimpleDateFormat("YYYY-dd-MM hh-mm-ss").format(currentDate);
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String filePath = "C:\\Users\\meena\\eclipse-workspace\\MyFirstFramework\\Screenshots\\Screenshot"+timestamp+".png";
		File destination = new File(filePath);
		FileUtils.copyFile(source, destination);
	}

	public void enterIntoTextBox(String logicalName, String value) {
		WebElement element = getWebElement(logicalName);
		enterIntoTextBox(element, value);
	}
	
	private void enterIntoTextBox(WebElement element, String value) {
		waitForElement(element);
		element.sendKeys(value);
	}

	private WebElement getWebElement(String logicalName) {
		By by = objRep.get(logicalName);
		WebElement element = driver.findElement(by);
		return element;
	}

	public void click(String logicalName) {
		WebElement element = getWebElement(logicalName);
		click(element);		
	}
	
	private void click(WebElement element) {
		waitForClick(element);
			element.click();
	}

	public void validatePageTitle(String expectedValue) {
		waitForPageToLoad(expectedValue);
		String actualValue = driver.getTitle();
		Assert.assertEquals(actualValue, expectedValue);
	    Log.info("Title validation is success : "+actualValue);
	}

	public void validateText(String logicalName, String expectedText) {
		WebElement element = getWebElement(logicalName);
		validateText(element, expectedText);
	}

	private void validateText(WebElement element, String expectedString) {
		waitForElement(element);
		String actualText = element.getText();
		Assert.assertEquals(actualText, expectedString);
	    Log.info("Text validated : "+actualText);
	}

	public void clearField(String logicalName) {
		WebElement element = getWebElement(logicalName);
		clearField(element);		
	}

	private void clearField(WebElement element) {
		waitForElement(element);
		element.clear();
	}
	
}
