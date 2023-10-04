@Functionality
Feature: Google Search

  @TC001
  Scenario: Verify if Login is successful with valid credentials
    Given User has opened the browser
    And User has navigated to google search column
    When User enters keyword
    And User clicks enter from the keyboard
    Then Showing selenium.dev at the first place