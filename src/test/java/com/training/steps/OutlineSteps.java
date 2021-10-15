package com.training.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OutlineSteps {

	WebDriver driver;

	@Given("User lauches the salesforce application")
	public void user_lauches_the_salesforce_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
	}

	@When("User enters invalid username {string}")
	public void user_enters_invalid_username(String username) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	}

	@When("User enters invalid password {string}")
	public void user_enters_invalid_password(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	@Then("click on {string} button")
	public void click_on_button(String string) {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}

	@Given("user prints some name")
	public void user_prints_some_name() {
		System.out.println("!!!!!! From Background !!!!!!");
	}

}
