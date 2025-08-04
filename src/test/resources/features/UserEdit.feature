@Fatma
Feature: User Module Edit

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"

  @AssertUserDetailPageOpens
  Scenario:  User opens User Detail Page of first user of list

    Then Verify that User Detail page is opened

  @AssertSelectARoleWindowOpens
  Scenario:  User opens select a role window
    Given User goes to usersPage
    And User clicks on first username from the list
    When User clicks the + button under Roles section
    Then Verify that select a role window is opened

  @AddANewRoleFromFropDownMenu
  Scenario:  User selects a role to first user of list
    Given User goes to usersPage
    And User clicks on first username from the list
    When User clicks the + button under Roles section
    And User adds a new role from the dropdown
    And User clicks Save button
    Then Verify that the new role is added and "New role added for this user successfuly" message seen


  Scenario: Check that new role is saved correctly
    Given User goes to usersPage
    And User clicks on first username from the list
    When User adds a new role for user
    And User refreshes the profile page
    Then Verify that the newly added role appears under Roles section

  Scenario: Check that newly added role is not listed in role dropdown menu
    Given User goes to usersPage
    And User clicks on first username from the list
    When User adds a new role for user
    And User refreshes the profile page
    Then Verify that newly added role does not appear under Add New Roles dropdown list

  @AttemptToDeleteDefaultRole
  Scenario: User attempts to remove the default role
    Given User goes to usersPage
    And User clicks on first username from the list
    When User finds if there is a default role
    Then Verify that default role cannot be removed

  @EvaluateANewPassword
  Scenario: Reset Password - Evaluate A New Password
    Given User goes to usersPage
    And User clicks on first username from the list
    When User clicks Reset Password button
    And User clicks Confirm button
    Then Verify that "Reset password successfully" message seen


  @LoginWithEvaluatedPassword
  Scenario: Login With Evaluated Password for same user
    Given User resets password
    And User logs out
    And user logins as "username2" with password "password2"
    Then verify that user logged in succesfully
