package com.training.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;
import com.training.base.BaseTest;

public class ForgotPasswordPage extends BasePage {
	static WebDriver driver;

	public ForgotPasswordPage() throws IOException {
		super(driver = BaseTest.getDriver());
		addObject("forgotPasswordUsernameField", By.xpath("//input[@id='un']"));
		addObject("continue", By.xpath("//input[@name='continue']"));
		addObject("forgotPasswordPageHeader", By.xpath("//h2[@id='header']"));
	}
}
