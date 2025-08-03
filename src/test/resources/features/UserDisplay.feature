@UserDisplayFeature   @Regression
Feature: User Module Display

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"

  @UsersPageAssertionScenario
  Scenario: User opens Users Page
    Given User goes to usersPage
    Then verify that  page opened

  @UserlistAssertionScenario
  Scenario: User checks visibility of users list
    Given User goes to usersPage
    Then verify userList exists

  @Emaillistassertion
  Scenario: User checks visibility of email of each user data
    Given User goes to usersPage
    Then verify each user has an email

  @Sincelistassertion
  Scenario: User checks visibility of email of each user data
    Given User goes to usersPage
    Then Verify that each user has a visible since date

  @AccessTypelistassertion
  Scenario: User checks visibility of email of each user data
    Given User goes to usersPage
    Then Verify that each user has a visible access type

  @Statuslistassertion
  Scenario: User checks visibility of email of each user data
    Given User goes to usersPage
    Then Verify that each user has a visible status