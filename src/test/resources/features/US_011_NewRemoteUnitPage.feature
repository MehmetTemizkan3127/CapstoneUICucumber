@US_0011
Feature: AddNew Remote Unit Page

  Background:Login
    Given user goes to homepage
    When user clicks on Login button
    And the user enters a valid "usuario" username in the username field
    And the user enters a valid "clave" password in the Password field
    And the user clicks on the Sign in button
  @TC_001_01 @Smoke
    Scenario: TC_011_01
    And user clicks the Remote Units  menu
    And the user clicks on the Add New Remote Unit button
    And the user enters Department Name
    And the user selects the department type as Remote Unit from the dropdown menu.
    And the user clicks the Save button
  @TC_001_02 @Smoke
    Scenario: TC_011_02
    And user clicks the Remote Units  menu
    Then the user verifies that the newly added remote unit displayed under Remote Units.
    And  user closes browser