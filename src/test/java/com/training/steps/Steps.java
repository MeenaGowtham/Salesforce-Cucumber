package com.training.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	
	WebDriver driver;
	
	@Given("Launch the url")
	public void launch_the_url() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://login.salesforce.com");
	}
	@When("User enters the username")
	public void user_enters_the_username() {
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("meego@tekarch.com");
	   
	}
	@When("User enters the password")
	public void user_enters_the_password() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Scooby18");
	   
	}
	@Then("User enters the login button")
	public void user_enters_the_login_button() {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	   
	}
}
