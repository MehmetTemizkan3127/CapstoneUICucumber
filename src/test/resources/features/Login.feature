@Home
Feature: Login Feature

  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link

  @PositiveLogin
  Scenario: Successful login with valid credentials
    When user enters email "azizetest@gmail.com"
    And user enters password "yHQ_aWYbs1yJtJm"
    And user clicks on Login Button
    Then user validates sign in


  @NegativeLogin
  Scenario: Login attempt with invalid password
    When user enters email "azizetest@gmail.com"
    And user enters password "invalidPAss"
    And user clicks on Login Button
    Then user validates error message "Invalid Credentials"


  @NegativeLogin
  Scenario: Login attempt with invalid username
    When user enters email "invalid@gmail.com"
    And user enters password "yHQ_aWYbs1yJtJm"
    And user clicks on Login Button
    Then user validates error message "Invalid Credentials"


  @NegativeLogin
  Scenario: Negative login Test with empty username
    And user enters email ""
    And user enters password ""
    And user clicks on Login Button
    Then user validates "username" required message


  @NegativeLogin
  Scenario: Negative login Test with empty password
    And user enters email "anyEmail"
    And user enters password ""
    And user clicks on Login Button
    Then user validates "password" required message




