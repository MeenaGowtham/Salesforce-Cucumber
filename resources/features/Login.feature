#This is a practice of developing a generic cucumber framework feature
Feature: Login to the salesforce application

  @negative
  Scenario: Login with valid username and no password
    Given User is on "LoginPage"
    When User enters value into textbox "username" "abc"
    Then User clicks "login" Button
    And validate text "MissingPasswordMessage" "Please enter your password."

  @positive
  Scenario: Login with valid username and password
    Given User is on "LoginPage"
    When User enters value into textbox "username" "meego@tekarch.com"
    And User enters value into textbox "password" "Scooby18"
    Then User clicks "login" Button
    Given User is on "HomePage"
    Then validate pagetitle "Home Page ~ Salesforce - Developer Edition"

  @negative 
  Scenario: Login with invalid username and invalid password
    Given User is on "LoginPage"
    And User clears the input field "username"
    When User enters value into textbox "username" "abc"
    And User enters value into textbox "password" "Sco"
    Then User clicks "login" Button
    And validate text "InvalidCredentialsErrorMessage" "Please check your username and password. If you still can't log in, contact your Salesforce administrator."

  @positive
  Scenario: Login with valid credentials and check remember me
    Given User is on "LoginPage"
    When User enters value into textbox "username" "meego@tekarch.com"
    And User enters value into textbox "password" "Scooby18"
    Then User clicks "rememberMe" CheckBox
    Then User clicks "login" Button
    Given User is on "HomePage"
    Then validate pagetitle "Home Page ~ Salesforce - Developer Edition"
    Given User clicks "userMenuDropDown" Link
    And User clicks "logout" Button
    Then User is on "LoginPage"
    And validate pagetitle "Login | Salesforce"
    Then validate text "savedUsername" "meego@tekarch.com"
    
    @positive @testcase1
    Scenario: Verify forgot password functionality
    Given User is on "LoginPage"
    When User clicks "forgotPassword" Link
    When User is on "ForgotPasswordPage"
    And validate pagetitle "Forgot Your Password | Salesforce"
    And User enters value into textbox "forgotPasswordUsernameField" "meego@tekarch.com"
    And User clicks "continue" Button
    Then validate text "forgotPasswordPageHeader" "Check Your Email"
