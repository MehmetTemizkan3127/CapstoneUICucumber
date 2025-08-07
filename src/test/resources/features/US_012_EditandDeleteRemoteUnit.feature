@US_0012
Feature: US_12 -Edit the units displayed in the Remote Unit module.


  Background:Login
    Given user goes to homepage
    When user clicks on Login button
    And the user enters a valid "usuario" username in the username field
    And the user enters a valid "clave" password in the Password field
    And the user clicks on the Sign in button
  @TC_001_01 @Smoke
    Scenario: TC_012_01
    And user clicks the Remote Units  menu
    And Select any of the available Remote Unite title and click on it.
    And the user clicks on the Edit Remote Unit button
    And the user enters new Department Name
    And  the user clicks the Save button
  @TC_001_03 @Smoke
  Scenario:TC_012_03
    And  user finds and clicks the delete button
    And user clicks the Confirm button in the confirmation window
    Then verify that the delete operation succesfull
    And user closes browser