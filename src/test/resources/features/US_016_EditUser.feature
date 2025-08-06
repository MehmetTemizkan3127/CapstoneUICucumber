@Fatma
Feature: User Module Edit

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"
    And user clicks on maximize icon
    And user clicks on Users

  @US_016  @AssertUserDetailPageOpens   @Regression
  Scenario:  User opens User Detail Page of first user of list
    Given User clicks on indexed username from the list
    Then Verify that User Detail page is opened

  @US_016  @AssertSelectARoleWindowOpens   @Regression
  Scenario:  User opens select a role window
    Given User clicks on indexed username from the list
    When User clicks the + button under Roles section
    Then Verify that select a role window is opened and "Select the role " message seen

  @US_016  @AddANewRoleFromFropDownMenu  @Smoke
  Scenario:  User selects a role to first user of list
    Given User clicks on indexed username from the list
    When User clicks the + button under Roles section
    And User adds a new role for user
    Then Verify that the new role is added and "New role added for this user successfuly" message seen

  @US_016  @CheckNewRoleAddedSuccessfully
  Scenario: Check that new role is saved correctly
    Given User clicks on indexed username from the list
    When User adds a new role for user
    And User refreshes the profile page
    Then Verify that the newly added role appears under Roles section


  @US_016  @DefaultRoleCannotBeDeleted
  Scenario: Default role cannot be deleted
    Given User clicks on indexed username from the list
    Then Verify that default role cannot be removed

  @US_016  @SetNewAddedRoleAsDefaultRole
  Scenario: Set a newly added role as default role
    Given User clicks on indexed username from the list
    And User adds a new role for user
    When user sets the new role as default
    Then Verify that the new default role is displayed correctly

  @US_016  @CheckCanceledRoleIsNotAddedRolesSection
  Scenario:  User cancels add a new role window
    Given User clicks on indexed username from the list
    And  User clicks the + button under Roles section
    And User selects a new role from the dropdown
    When User clicks cancel button
    Then Verify that the canceled role is not listed under Roles section
