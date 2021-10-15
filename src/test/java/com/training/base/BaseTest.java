package com.training.base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	
	public static WebDriver getDriver() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public void launchApplication() throws IOException {
		String url = common.getApplicationProperty("url");
		driver = getDriver();
		System.out.println("URL : "+url);
		driver.get(url);
	}

}
