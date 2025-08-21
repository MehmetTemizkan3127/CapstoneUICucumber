@Fatma @US_016
Feature: User Module Edit

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"
    And user clicks on maximize icon
    And User goes to userPage

  @TC_016_01  @AssertUserDetailPageOpens  @Regression
  Scenario:  User opens User Detail Page of first user of list
    Given User clicks on indexed username from the list
    Then Verify that User Detail page is opened

  @TC_016_02  @AssertSelectARoleWindowOpens  @Regression
  Scenario:  User opens select a role window
    Given User clicks on indexed username from the list
    When User clicks the + button under Roles section
    Then Verify that select a role window is opened

  @TC_016_03  @AddANewRoleFromFropDownMenu  @Smoke  @Regression
  Scenario:  User selects a role to first user of list
    Given User clicks on indexed username from the list
    When User clicks the + button under Roles section
    And User adds a new role for user
    Then Verify that the new role is added and "New role added for this user successfuly" message seen

  @TC_016_04  @CheckNewRoleAddedSuccessfully  @Regression
  Scenario: Check that new role is saved correctly
    Given User clicks on indexed username from the list
    And User clicks the + button under Roles section
    When User adds a new role for user
    And User refreshes the profile page
    Then Verify that the newly added role appears under Roles section

  @TC_016_05  @DefaultRoleCannotBeDeleted  @Regression
  Scenario: Default role cannot be deleted
    Given User clicks on indexed username from the list
    Then Verify that default role cannot be removed

  @TC_016_06  @SelectRoleWindowOpens  @Regression
  Scenario:  User opens User Detail Page of first user of list
    Given User clicks on indexed username from the list
    When User clicks the + button under Roles section
    Then Verify that select role window is opened

  @TC_016_07  @SetNewAddedRoleAsDefaultRole  @Regression
  Scenario: Set a newly added role as default role
    Given User clicks on indexed username from the list
    And User clicks the + button under Roles section
    And User adds a new role for user
    When user sets the new role as default
    Then Verify that the new default role is displayed correctly

  @TC_016_08  @CheckCanceledRoleIsNotAddedRolesSection  @Regression
  Scenario:  User cancels add a new role window
    Given User clicks on indexed username from the list
    And  User clicks the + button under Roles section
    And User selects a new role from the dropdown
    When User clicks cancel button
    Then Verify that the canceled role is not listed under Roles section

  @TC_016_09  @RoleSavingError  @Regression
  Scenario: User saves without selecting role
    Given User clicks on indexed username from the list
    And  User clicks the + button under Roles section
    When User click save button
    Then Verify that adding role error message "You can add a role to the user from the profile page." is occured


  @TC_016_09  @DoesEditButtonWorks  @Regression
  Scenario: Does Profile page edit button works
    Given User clicks on indexed username from the list
    When User clicks the Pencil Image
    Then Verify that pencil image is changed into tick and cross buttons

  @TC_016_10  @EmailAdressUnclickable  @Regression
  Scenario: Email addres cannot be changed
    Given User clicks on indexed username from the list
    When User clicks the Pencil Image
    Then Verify that email addres cannot be changed

  @TC_016_11  @UsernameCannotBeEmpty  @Regression
  Scenario: Username cannot be empty
    Given User clicks on indexed username from the list
    When User clicks the Pencil Image
    And User deletes username input
    Then Verify that username error message "Username cannot be empty" is occured

  @TC_016_12  @ResetPasswordWindowOpens  @Regression
  Scenario: Reset Password window should ben opened
    And User clicks on indexed username from the list
    When User clicks Reset Password button
    Then Verify that Reset Password window should be opened