@Profile @US0004
Feature: Profile Module Password Change
  As a user, I want to change my password under specific conditions to ensure security.

  Background: User Login TC_0001
    Given user goes to homepage
    And User clicks login link
    When user enters email "tuubacakara@gmail.com"


  @PasswordPositive @Smoke
  Scenario Outline: Successful password change with valid credentials pozitif
    And user enters password "Abcd1234$@#$%$&@@Aa"
    And user clicks on Login Button
    When profile the user clicks on the Change Password button on the right side
    Then profile the Change Password section should be displayed
    When profile the user enters "<password1>" in the password field
    And profile the user re-enters "<password2>" in the confirmation field
    And profile the user clicks on the Confirm button
    Then profile the message "<alert_message>" should be displayed in the upper right corner
    And  user closes browser
    Examples:
      | password1 | password2 | alert_message                |
      | 123456Tk# | 123456Tk# | Change password successfully |


