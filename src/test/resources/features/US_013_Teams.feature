@UiTest @Teams
Feature: Teams Modules Process

  Background:
    Given user goes to homepage
    And User clicks login link
    When user logins as "usernameMertay" with password "passwordMertay"

  @RegressionTest @SmokeTest
  Scenario: TC_0013_01 The teams button should appear
    Then The teams button should appear
  @RegressionTest @SmokeTest
  Scenario: TC_0013_02 The teams button should be clickable
    Then The teams button should be clickable
  @RegressionTest @SmokeTest
    Scenario: TC_0013_03 add new team button should appear
    Then add new team button should appear
  @RegressionTest @SmokeTest
  Scenario: TC_0013_04 add new team button should be clickable
    Then add new team button should be clickable
  @RegressionTest
  Scenario: TC_0013_05 The teams tittle should appear
    Then The teams tittle should appear
  @RegressionTest @SmokeTest
  Scenario: TC_0013_06 The search area should be clickable
    Then The search area should be clickable
  @RegressionTest @SmokeTest
  Scenario: TC_0013_07 The search area button should appear
    Then The search area button should appear
  @RegressionTest
  Scenario: TC_0013_08 The clear filters button should appear
    Then The clear filters button should appear
  @RegressionTest
  Scenario: TC_0013_09 The clear filters button should be clickable
    Then The clear filters button should be clickable
  @RegressionTest
  Scenario: TC_0013_010 The search box should clean
    When user types "IT" into the search box
    Then The search box should clean
  @RegressionTest @SmokeTest
  Scenario: TC_0013_011 each area title should contain 1
    When user types "1" into the search box
    Then each area title should contain "1"
  @RegressionTest @SmokeTest @Bug
  Scenario: TC_0013_012 each area title should contain 1
    When user types "mertay" into the search box
    Then teams title text click
    And click to new user button
    And click to search by name or email button
    And write to "rooney" in this area
    And click to name checkbox
    And click to add selected users

