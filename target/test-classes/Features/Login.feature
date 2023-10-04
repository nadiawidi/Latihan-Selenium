@Functionality
Feature: Login

  Background: 
    Given User has opened swag labs browser
    And User has navigated to the login page

  @TCID001
  Scenario Outline: Verify if login is successful with valid credentials
    When User enters valid <username> and <password>
    And User clicks on login button
    Then User should be able to see Product page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  @TCID002
  Scenario Outline: Verify if login is un-successful with invalid credentials
    When User enters invalid <username> and <password>
    And User clicks on login button
    Then User should be able to see the error pop up message

    Examples: 
      | username | password |
      | coba     | coba123  |
