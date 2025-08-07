@UserDisplayFeature   @Regression
Feature: User Module Display

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"
    And user clicks on maximize icon
    And go to userPage

  @US_015  @UsersPageAssertionScenario   @Regression
  Scenario: User opens Users Page
    Then verify that  page opened

  @US_015  @UserlistAssertionScenario   @Regression
  Scenario: User checks visibility of users list
    Then verify userList exists

  @US_015  @Emaillistassertion   @Regression
  Scenario: User checks visibility of email of each user data
    Then verify each user has an email

  @US_015  @Sincelistassertion   @Regression
  Scenario: User checks visibility of email of each user data
    Then Verify that each user has a visible since date

  @US_015  @AccessTypelistassertion   @Regression
  Scenario: User checks visibility of email of each user data
    Then Verify that each user has a visible access type

  @US_015  @Statuslistassertion   @Regression
  Scenario: User checks visibility of email of each user data
    Then Verify that each user has a visible status