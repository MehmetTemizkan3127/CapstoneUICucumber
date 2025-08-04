@AddNewUserFeature
Feature: User New Registration

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"

  @NewRegistrationPageOpens
  Scenario: Does New User Registration page open
    Given User goes to usersPage
    And User clicks Add New Member button
    Then Verify that title "New User Registration" is seen

  @NewRegistrationWithoutData
  Scenario: Attempt to create a new member without any data
    Given User goes to usersPage
    And User clicks Add New Member button
    When User clicks Register button
    Then Verify that role error message "Please select a role for the user you will add" is occured

  @NewRegistrationWithoutOrWithInvalidEmail
  Scenario Outline: Attempt to create a new member without an email
    Given User goes to usersPage
    And User clicks Add New Member button
    When User selects a role from Roles dropdown menu
    And User enters '<email>'
    And User clicks Register button
    Then Verify that email error message "Please enter a valid email" is occured
    Examples:
      | email                  |
      |                        |
      | fat@s                  |
      | @asd.asd               |
      | @asd.com               |


    #todo  ->   existed mail listesi çoğaltılabilir
  @NewRegistrationWithRegisteredEmail
  Scenario Outline: Attempt to create a new member with an existed/registered email
    Given User goes to usersPage
    And User clicks Add New Member button
    When User selects a role from Roles dropdown menu
    And User enters '<email>'
    And User clicks Register button
    Then Verify that error message "An error occurred" is occured

    Examples:
      | email                  |
      | fatmapostaci@gmail.com |


 #todo  ->   input listesi her run edilmeden önce güncellemem gerek, dinamik yapabilir miyim, yada faker olarak üretebilir miyim
  @NewRegistrationWithValidCredentials
  Scenario Outline: Create a new member with an acceptable data in all areas
    Given User goes to usersPage
    And User clicks Add New Member button
    When User selects a department from Deparments dropdown menu
    When User selects a role from Roles dropdown menu
    And User enters '<email>'
    And User clicks Register button
    Then Verify that register succesful message "Successful" is occured
 #todo  --> yada And Remove registered users from organization diye bir adım mı eklesem

    Examples:
      | email                  |
      | fatmatest3@gmail.com |
      | fatmatest4@outlook.com |


    @DoesCancelButtonWorks
    Scenario:  Does Cancel button works
      Given User goes to usersPage
      And User clicks Add New Member button
      And User selects a department from Deparments dropdown menu
      And User selects a role from Roles dropdown menu
      And User enters "something@something.com"
      When User clicks Cancel button
      Then Verify that window closed without saving

      @CheckNewMemberIsVisibleOnAllMembersList
      Scenario: Check new member registration with valid credentials is visible on All Members List
        Given User goes to usersPage
        And User creates a new member
