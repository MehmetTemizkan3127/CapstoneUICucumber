@US_0012
Feature: US_12 -Edit the units displayed in the Remote Unit module.

  @EditAndDeleteRemoteUnits
  Scenario: The user displays the created remote unit
    Given user goes to homepage
    When user clicks on Login button
    And the user enters a valid "usuario" username in the username field
    And the user enters a valid "clave" password in the Password field
    And the user clicks on the Sign in button
    And user clicks the Remote Units  menu
    And Select any of the available Remote Unite title and click on it.
    And the user clicks on the Edit Remote Unit button
    And the user enters new Department Name
    And  the user clicks the Save button
    And  user finds and clicks the delete button
    And user clicks the Confirm button in the confirmation window
    Then verify that the delete operation succesfull
    And user closes browser