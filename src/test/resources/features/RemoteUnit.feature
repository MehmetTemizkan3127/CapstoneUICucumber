@US_0010
Feature:displayed remote units
  @Display_Created_Remote_Unit
  Scenario: The user displays the created remote unit
    Given user goes to homepage
    When user clicks on Login button
    And the user enters a valid "usuario" username in the username field
    And the user enters a valid "clave" password in the Password field
    And the user clicks on the Sign in button
    And user clicks the Remote Units  menu
    And user verify the Remote units page menu