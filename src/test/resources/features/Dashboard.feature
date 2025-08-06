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

  @MySubscriptions
  Scenario:MySubscriptions click Test
    When user clicks on MySubscriptions
    Then user sees MySubscriptions page

  @MyMemberships
  Scenario:MyMemberships click Test
    When user clicks on MyMemberships
    Then user sees MyMemberships page

  @CompanyGroup
  Scenario:CompanyGroup click Test
    When user clicks on CompanyGroup
    Then user sees CompanyGroup page

  @Company
  Scenario:Company click Test
    When user clicks on Company
    Then user sees Company page

  @Departments
  Scenario:Departments click Test
    When user clicks on Departments
    Then user sees Departments page

  @RemoteUnits
  Scenario:RemoteUnits click Test
    When user clicks on RemoteUnits
    Then user sees RemoteUnits page

  @Teams
  Scenario:Teams click Test
    When user clicks on Teams
    Then user sees Teams page

  @Users
  Scenario:Users click Test
    When user clicks on Users
    Then user sees Users page

  @Roles
  Scenario:Roles click Test
    When user clicks on Roles
    Then user sees Roles page

  @Permissions
  Scenario:Permissions click Test
    When user clicks on Permissions
    Then user sees Permissions page

  @AccessToken
  Scenario:AccessToken click Test
    When user clicks on AccessToken
    Then user sees AccessToken page







