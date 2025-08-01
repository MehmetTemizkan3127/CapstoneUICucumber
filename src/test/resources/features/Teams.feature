Feature: Teams Modules Process

  Background:
    Given user goes to homepage
    And User clicks login link
    When user logins as "usernameMertay" with password "passwordMertay"

  @SmokeTest @UiTest @Teams
  Scenario: TC_0013_01 The teams button should appear
    Then The teams button should appear
  @SmokeTest @UiTest @Teams
  Scenario: TC_0013_02 The teams button should be clickable
    Then The teams button should be clickable
  @SmokeTest @UiTest @Teams
    Scenario: TC_0013_03 add new team button should be appear
    Then add new team button should be appear
  @SmokeTest @UiTest @Teams
  Scenario: TC_0013_04 add new team button should be clickable
    Then add new team button should be clickable
   @UiTest @Teams
  Scenario: TC_0013_05 The teams tittle should appear
    Then The teams tittle should appear
  @SmokeTest @UiTest @Teams
  Scenario: TC_0013_06 The search area should be clickable
    Then The search area should be clickable
  @SmokeTest @UiTest @Teams
  Scenario: TC_0013_07 The search area button should be appear
    Then The search area button should be appear

