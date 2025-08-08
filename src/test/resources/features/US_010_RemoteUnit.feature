@US_0010 @Regression
Feature:  displayed remote units

  Background:Login
    Given user goes to homepage
    When user clicks on Login button
    And the user enters a valid "usuario" username in the username field
    And the user enters a valid "clave" password in the Password field
    And the user clicks on the Sign in button

  @TC_001_01 @Smoke
  Scenario:TC_010_01
    And user clicks the Remote Units  menu
    Then user verify the Remote units page menu

