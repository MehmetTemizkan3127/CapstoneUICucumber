@Home
Feature: Login Feature

  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link

  @SmokeDemo @Regression
  @PositiveLogin
  Scenario: Successful login with valid credentials
    When user enters email "azizetest@gmail.com"
    And user enters password "yHQ_aWYbs1yJtJm"
    And user clicks on Login Button
    Then user validates sign in

  @NegativeLogin  @Regression
  Scenario: Login attempt with invalid password
    When user enters email "azizetest@gmail.com"
    And user enters password "invalidPAss"
    And user clicks on Login Button
    Then user validates error message "Invalid Credentials"

  @NegativeLogin  @Regression
  Scenario: Login attempt with invalid username
    When user enters email "invalid@gmail.com"
    And user enters password "yHQ_aWYbs1yJtJm"
    And user clicks on Login Button
    Then user validates error message "Invalid Credentials"

  @NegativeLogin  @Regression
  Scenario: Negative login Test with empty username
    And user enters email ""
    And user enters password ""
    And user clicks on Login Button
    Then user validates "username" required message

  @NegativeLogin  @Regression
  Scenario: Negative login Test with empty password
    And user enters email "anyEmail"
    And user enters password ""
    And user clicks on Login Button
    Then user validates "password" required message

  @Logo  @Regression
  Scenario: Clicking the logo on the login page redirects to homepage
    When The user clicks on the company logo
    Then The homepage should be displayed

  @ForgotPassword  @Regression
  Scenario: Forgot Password functionality with valid email
    When The user clicks the Forgot Password? link
    And The user enters a valid registered email address
    And The user clicks on the Recovery My Account button
    And An email should be sent to the user with reset instructions

  @ForgotPasswordNegative  @Regression
  Scenario: Forgot Password with an unregistered email
    When The user clicks the Forgot Password? link
    And The user enters an unregistered email address
    And The user clicks on the Recovery My Account button
    Then Email not found message should be displayed
    And No reset email should be sent

  @ForgotPasswordNegative  @Regression
  Scenario: Forgot Password with an invalid email
    When The user clicks the Forgot Password? link
    And The user enters an invalid email address
    And The user clicks on the Recovery My Account button
    Then Invalid credentials message should be displayed
    And No reset email should be sent



