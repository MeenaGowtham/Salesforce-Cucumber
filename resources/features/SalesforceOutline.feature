Feature: Login to salesforce application

  Background: 
    Run this before every scenario

    Given user prints some name

  Scenario Outline: Login with invalid username and invalid password
    Given User lauches the salesforce application
    When User enters invalid username "<username>"
    And User enters invalid password "<password>"
    Then click on "<Login>" button

    Examples: 
      | username          | password |
      | meego@tekarch.com | Scooby18 |
      | goman             | 98456!@! |
