@AllDepartments
Feature: Department Feature
#T****
  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link
    When user logins as "usernameTugba" with password "passwordTugba"
    And user clicks on maximize icon
    And User clicks department button

  @TC_007_01 @Smoke @Regression
  Scenario: TC_007_01 Verifying that all registered departments are displayed
    Then Verify that all departments are displayed

  @TC_007_02 @Regression
  Scenario: TC_007_02 Verifying that authorized roles are displayed for each registered department
    Then Click on the departments that have authorized roles and Verify that the roles are displayed

  @TC_007_03 @Regression
  Scenario: TC_007_03 Verifying the number of departments
    And Verify that the number of roles shown on the department card matches the number of roles listed inside the department

  @TC_007_04 @Smoke @Regression
  Scenario: TC_007_04 Verifying that Departments text visible
    Then User verifies that the departments are displayed



