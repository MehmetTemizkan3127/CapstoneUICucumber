@Dashboard
Feature: Dashboard Feature

  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link
    And user logins as "usernameAzize" with password "passwordAzize"

  @SmokeTest
  Scenario: Logo Display Test
    When logo is visible
    Then logo is enabled

  @SmokeTest
  Scenario: Logo Redirects Test
    When go to userPage
    And clicks on Logo
    Then user sees Home Page

  @SmokeTest
  Scenario: Minimized Sidebar Test
    When user sees sidebar
    And user clicks on maximize icon
    Then user sees maximized sidebar
    And clicks on minimize icon
    And user sees minimized Sidebar
