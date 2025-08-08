@Fatma @US_015
Feature: Users Module Display

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"
    And user clicks on maximize icon
    And User goes to userPage

  @TC_015_01  @UsersPageAssertionScenario  @Regression
  Scenario: User opens Users Page
    Then verify that  page opened

  @TC_015_02  @UserlistAssertionScenario  @Regression
  Scenario: User checks visibility of users list
    Then verify userList exists

  @TC_015_03  @Emaillistassertion  @Regression
  Scenario: User checks visibility of email of each user data
    Then verify each user has an email

  @TC_015_04  @Sincelistassertion  @Regression
  Scenario: User checks visibility of email of each user data
    Then Verify that each user has a visible since date

  @TC_015_05  @AccessTypelistassertion  @Regression
  Scenario: User checks visibility of email of each user data
    Then Verify that each user has a visible access type

  @TC_015_06  @Statuslistassertion  @Regression
  Scenario: User checks visibility of email of each user data
    Then Verify that each user has a visible status