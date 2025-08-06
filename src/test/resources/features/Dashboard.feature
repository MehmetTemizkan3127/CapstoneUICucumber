@Dashboard
Feature: Dashboard Feature

  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link
    And user logins as "usernameAzize" with password "passwordAzize"

  @TC_0002_01
  Scenario: Logo Display Test
    When logo is visible
    Then logo is enabled

  @TC_0002_02
  Scenario: Logo Redirects Test
    When go to userPage
    And clicks on Logo
    Then user sees Home Page

  @TC_0002_03
  Scenario: Minimized Sidebar Test
    When user sees sidebar
    And user clicks on maximize icon
    Then user sees maximized sidebar
    And clicks on minimize icon
    And user sees minimized Sidebar


  @Sidebar
  Scenario: User navigates to each page from the sidebar
    When user clicks on maximize icon
    And user clicks on MenuItem from the sidebar and sees the BreadCrumb page
      | MenuItem         | BreadCrumb       |
      | Profile          | Profile          |
      | My Subscriptions | My Subscriptions |
      | My Memberships   | My Memberships   |
      | Company Group    | Company Group    |
      | Company          | Company Detail   |
      | Departments      | Departments      |
      | Remote Units     | Remote Units     |
      | Teams            | Teams            |
      | Users            | Users            |
      | Roles            | Roles            |
      | Permissions      | Permissions      |
      | Access Tokens    | Access Tokens    |


  @DropDown @Regression
  @TC_0003_01
  Scenario: User sees their email, role and company in dropdown
    When The user clicks on the profile image
    Then The dropdown menu should display the user's email and role
    And The dropdown menu should display the user's company

  @TC_0003_02
  Scenario: User navigates to My Subscriptions from dropdown
    When The user clicks on the profile image
    And The user clicks on the "My Subscriptions" option
    Then The user should be redirected to the "My Subscriptions" page

  @TC_0003_03
  Scenario: User navigates to My Memberships from dropdown
    When The user clicks on the profile image
    And The user clicks on the "My Memberships" option
    Then The user should be redirected to the "My Memberships" page

  @TC_0003_04
  Scenario: User logs out from dropdown
    When The user clicks on the profile image
    And The user clicks on the "Logout" option
    Then The user should be redirected to the Login page

  @UserDetailsCheck
  Scenario: User sees their email, role and company in dropdown menu
    Then user sees own avatar
    And user sees own username and role
    And user sees own company