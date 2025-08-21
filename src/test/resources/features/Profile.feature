Feature: Profile Module Password Change
  As a user, I want to change my password under specific conditions to ensure security.

  Background: User Login TC_0001
    Given user goes to homepage
    And User clicks login link
    When user enters email "tuubacakara@gmail.com"

  @PasswordPositive @Smoke
  Scenario Outline: Successful password change with valid credentials pozitif
    And user enters password "<current_password>"
    And user clicks on Login Button
    When profile the user clicks on the Change Password button on the right side
    Then profile the Change Password section should be displayed
    When profile the user enters "<password1>" in the password field
    And profile the user re-enters "<password2>" in the confirmation field
    And profile the user clicks on the Confirm button
    Then profile the message "<alert_message>" should be displayed in the upper right corner
    And user closes browser

    Examples:
      | current_password     | password1            | password2            | alert_message                |
      | 123456Tk#            | Abcd1234$@#$%$&@@Aa | Abcd1234$@#$%$&@@Aa | Change password successfully |
      | Abcd1234$@#$%$&@@Aa | 123456Tk#            | 123456Tk#            | Change password successfully |


  @PasswordNegative
  Scenario Outline: Password change validation with invalid credentials negative

    And user enters password "<current_password>"
    And user clicks on Login Button
    When profile the user clicks on the Change Password button on the right side
    Then profile the Change Password section should be displayed
    When profile the user enters "<new_password>" in the password field
    And profile the user re-enters "<confirm_password>" in the confirmation field
    And profile the user clicks on the Confirm button
    Then profile the message "<error_message>" should be displayed
    And user closes browser

    Examples:
      | current_password | new_password        | confirm_password     | error_message                                      |
      | 123456Tk#        | Aa1@bcd             | Aa1@bcd              | Password must be between 8 to 20 characters long. |
      | 123456Tk#        |Abcd1234$@#$%$&@@A%%$ | Abcd1234$@#$%$&@@A%%$ | Password must be between 8 to 20 characters long. |





