@UiTest @Teams
Feature: Teams Modules Process

  Background:
    Given user goes to homepage
    And User clicks login link
    When user logins as "usernameMertay" with password "passwordMertay"
    Then Added new team button

  @RegressionTest
  Scenario:TC_0014_01 information tittle should be appear
    Then appear to information tittle

  @RegressionTest
  Scenario:TC_0014_02 company tittle should be appear
    Then appear to company tittle

  @RegressionTest
  Scenario:TC_0014_03 company name should be appear
    Then appear to company name

  @RegressionTest
  Scenario:TC_0014_04 department name tittle should be appear
    Then appear to department name tittle

  @RegressionTest @SmokeTest
  Scenario:TC_0014_05 department name button should be appear
    Then appear to department name button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_06 department name button should be clickable
    Then click to department name button

  @RegressionTest
  Scenario:TC_0014_07 department short name tittle should be appear
    Then appear to department short name tittle

  @RegressionTest @SmokeTest
  Scenario:TC_0014_08 department short name button should be appear
    Then appear to department short name button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_09 department short name button should be clickable
    Then click to department short name button

  @RegressionTest
  Scenario:TC_0014_10 department type tittle should be appear
    Then appear to department type tittle

  @RegressionTest @SmokeTest
  Scenario:TC_0014_11 department type dropdown menu should be appear
    Then appear to department type dropdown menu

  @RegressionTest @SmokeTest
  Scenario:TC_0014_12 department type dropdown menu should be clickable
    Then click to department type dropdown menu

  @RegressionTest
  Scenario:TC_0014_13 Description tittle should be visible
    Then appear to Description tittle

  @RegressionTest @SmokeTest
  Scenario:TC_0014_14 Description Description button should be visible
    Then appear to Department Description button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_15 Description Description button should be clickable
    Then click to Department Description button

  @RegressionTest
  Scenario:TC_0014_16 Roles tittle should be visible
    Then appear to Roles tittle

  @RegressionTest @SmokeTest
  Scenario:TC_0014_17 Department Roles button should be visible
    Then appear to Department Roles button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_18 Department Roles button should be clickable
    Then click to Department Roles button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_19 Save button should be visible
    Then appear to Save button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_20 Save button should be clickable
    Then click to Save button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_21 Cancel button should be visible
    Then appear to Cancel button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_22 Cancel button should be clickable
    Then click to Cancel button

  @RegressionTest @SmokeTest
  Scenario:TC_0014_23 need to see this error message -> Please enter a name for department
    When real click to department name button
    And write to this "" word in department name area
    And real click to department type dropdown menu
    And select to team
    Then real click to Save button with error assertion

  @RegressionTest @SmokeTest
  Scenario:TC_0014_24 needs to this error message is visible->Please select a type for department
    When real click to department name button
    And write to this "mertay" word in department name area
    Then real click to Save button with error assertion

  @RegressionTest @SmokeTest @SmokeDemo
  Scenario:TC_0014_25 needs to see this message is visible->New department successfully created
    When real click to department name button
    And write to this "mertay" word in department name area
    And real click to department type dropdown menu
    And select to team
    Then real click to Save button with true assertion

  @RegressionTest @SmokeTest @Bug
  Scenario:TC_0014_26 needs to see this message is visible->New department successfully created
    When write to "mertay" to search by name button
    And click to mertay tittle
    Then click to edit team button and false assertion


