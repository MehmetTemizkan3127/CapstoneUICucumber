@AddNewUserFeature @Fatma
Feature: New User

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"
    And user clicks on maximize icon
    And go to userPage

  @NewRegistrationPageOpens   @Regression
  Scenario: Does New User Registration page open
    Given User clicks Add New Member button
    Then Verify that title "New User Registration" is seen

  @NewRegistrationWithoutData
  Scenario: Attempt to create a new member without any data
    Given User clicks Add New Member button
    When User clicks Register button
    Then Verify that role error message "Please select a role for the user you will add" is occured

  @NewRegistrationWithoutOrWithInvalidEmail
  Scenario Outline: Attempt to create a new member without an email
    Given User clicks Add New Member button
    When User selects a role from Roles dropdown menu
    And User enters '<email>'
    And User clicks Register button
    Then Verify that email error message "Please enter a valid email" is occured
    Examples:
      | email    |
      |          |
      | fat@s    |
      | @asd.asd |
      | @asd.com |


    #todo  ->   existed mail listesi çoğaltılabilir
  @NewRegistrationWithRegisteredEmail
  Scenario Outline: Attempt to create a new member with an existed/registered email
    Given User clicks Add New Member button
    When User selects a role from Roles dropdown menu
    And User enters '<email>'
    And User clicks Register button
    Then Verify that error message "An error occurred" is occured

    Examples:
      | email                  |
      | fatmapostaci@gmail.com |


  @NewRegistrationWithValidCredentials   @Regression   @Smoke
  Scenario: Create a new member with an acceptable data in all areas
    Given User clicks Add New Member button
    When User selects a department from Deparments dropdown menu
    And User selects a role from Roles dropdown menu
    And User enters fake email
    And User clicks Register button
    Then Keep the created password
    Then Verify that register succesful message "Successful" is occured


  @DoesCancelButtonWorks   @Regression
  Scenario:  Does Cancel button works
    Given User clicks Add New Member button
    And User selects a department from Deparments dropdown menu
    And User selects a role from Roles dropdown menu
    And User enters "something@something.com"
    When User clicks Cancel button
    Then Verify that window closed without saving


  @NewRegistrationWithValidCredentials   @Smoke
    Scenario: Login with new registered member
    Given User logs out
    And User clicks login link
    When user logins as "usernameFake" with password "passwordFake"
    Then user validates sign in
