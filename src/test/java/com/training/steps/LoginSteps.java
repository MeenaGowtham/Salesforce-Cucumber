package com.training.steps;

import java.io.IOException;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pageFactory.PageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseTest {
	
	BasePage page;
	PageFactory pageFactory = new PageFactory();

	@Before
	public void setup() throws IOException {
		System.out.println("In Before Class");
		launchApplication();
	}
	
	@When("User enters value into textbox {string} {string}")
	public void user_enters_value_into_textbox(String logicalName, String value) {
	    page.enterIntoTextBox(logicalName, value);
	}
	
	@Then("User clicks {string} Button")
	public void user_clicks_button(String logicalName) {
	    page.click(logicalName);
	}
	
	@Given("User is on {string}")
	public void user_is_on(String pageName) {
		page = pageFactory.initialize(pageName);
		Log.info("User is on "+pageName);
	}
	
	@Then("validate pagetitle {string}")
	public void validate_pagetitle(String expectedPageTitle) {
	    page.validatePageTitle(expectedPageTitle);
	}
	
	@Then("validate text {string} {string}")
	public void validate_text(String logicalName, String expectedText) {
	    page.validateText(logicalName, expectedText);
	}

	@Then("User clicks {string} CheckBox")
	public void user_clicks_check_box(String logicalName) {
	    page.click(logicalName);
	}
	
	@Given("User clicks {string} Link")
	public void user_clicks_link(String logicalName) {
	    page.click(logicalName);
	}
	
	@Given("User clears the input field {string}")
	public void user_clears_the_input_field(String logicalName) {
	    page.clearField(logicalName);
	}

}
