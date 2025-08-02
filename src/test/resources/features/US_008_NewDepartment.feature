@NewDepartment
Feature: New Department Feature

  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link
    When user logins as "usernameTugba" with password "passwordTugba"
    And user clicks on maximize icon
    And User clicks department button

  @TC_008_01
  Scenario: TC_08_01 Adding a new department in the Departments module
    Given Click Add New Department button
    When Enter a department name
    And Enter a department Short name
    And Select a department type - Departmant
    And Enter a department description
    And Select a departmant role
    And Click save button
    Then Verify that the newly created department is displayed in the department list.










    @TC_008_11
    Scenario: TC_08_11 Verifying that add new department button is clickable
      Then User verifies that add new department button is clickable

    @TC_008_12
    Scenario: TC_08_12 Verifying that Department Name field is visible
    Given Click Add New Department button
    Then Verify that Department Name field is visible

  @TC_008_13
  Scenario: TC_08_13 Verifying that Short Name field is visible
    Given Click Add New Department button
    Then Verify that Short Name field is visible

  @TC_008_14
  Scenario: TC_08_14 Verifying that Department Type field is visible
    Given Click Add New Department button
    Then Verify that Department Type field is visible

  @TC_008_15
  Scenario: TC_08_15 Verifying that Department Description field is visible
    Given Click Add New Department button
    Then Verify that Department Description field is visible

  @TC_008_16
  Scenario: TC_08_16 Verifying that Department Roles field is visible
    Given Click Add New Department button
    Then Verify that Department Roles field is visible

  @TC_008_17
  Scenario: TC_08_17 Verifying that save button is visible and clickable
    Given Click Add New Department button
    Then Verify that Save button is visible
    Then Verify that Save button is clickable

  @TC_008_18
  Scenario: TC_08_18 Verifying that Cancel button is visible
    Given Click Add New Department button
    Then Verify that Cancel button is visible

  @TC_008_19
  Scenario: TC_08_19 Verifying that Cancel button is clickable
    Given Click Add New Department button
    And Click cancel
    Then Verify that edit button is visible





