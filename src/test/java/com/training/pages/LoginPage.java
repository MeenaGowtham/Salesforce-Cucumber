package com.training.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;
import com.training.base.BaseTest;

public class LoginPage extends BasePage {
	static WebDriver driver;
	
	public LoginPage() throws IOException {
		super(driver = BaseTest.getDriver());
		addObject("username",By.xpath("//input[@id='username']"));
		addObject("password",By.xpath("//input[@id='password']"));
		addObject("login",By.xpath("//input[@id='Login']"));
		addObject("InvalidCredentialsErrorMessage", By.xpath("//form[@name='login']//div[@class='loginError']"));
		addObject("MissingPasswordMessage", By.xpath("//div[@id='error']"));
		addObject("rememberMe", By.xpath("//input[@class='r4 fl mr8']"));
		addObject("savedUsername", By.xpath("//div[@id='idcard']"));
		addObject("forgotPassword", By.xpath("//a[@id='forgot_password_link']"));
	}

}
