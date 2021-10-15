package com.training.pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;
import com.training.base.BaseTest;

public class HomePage extends BasePage {
	static WebDriver driver;
	
	public HomePage() throws IOException {
		super(driver = BaseTest.getDriver());
		addObject("userMenuDropDown",By.xpath("//div[@class='menuButtonButton']/span"));
		addObject("userMenuDropDownList",By.xpath("//div[@id='userNav-menuItems']/a"));
		addObject("logout",By.linkText("Logout"));
		addObject("allTabsIcon", By.xpath("//img[@class='allTabsArrow']"));
	}
	
}
