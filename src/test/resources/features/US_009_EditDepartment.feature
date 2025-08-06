@EditDepartment
Feature: Edit Department Feature
#T****
  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link
    When user logins as "usernameTugba" with password "passwordTugba"
    And user clicks on maximize icon
    And User clicks department button

  @TC_009_01
  Scenario: TC_009_01 Updating the information of the created department
    Given Click on a department that has already been created
    When Click Edit Department button
    And refresh page until page loads
    And Update the name field "update name"
    And Update the short name field "Update short name"
    And Update description field "Update description"
    And Click save button
    Then Verify that the information has been updated

  @TC_009_02
  Scenario: TC_009_02 Verifying that Edit Department button visible and clickable
    Given Click on a department that has already been created
    Then Verify that Edit Department button visible and clickable

  @TC_009_03
  Scenario: TC_009_03 Verifying that New User button visible and clickable
    Given Click on a department that has already been created
    Then Verify that New User button visible and clickable

  @TC_009_04
  Scenario: TC_009_04 Verifying that you are redirected to the correct department after clicking on it
    Then Verify that you are redirected to the correct department after clicking on it

  @TC_009_05
  Scenario: TC_009_05 Verifying that the card with the changed department type is no longer listed among the departments
    Given Create a new department with the name "A", short name "Type Test", type "Department", description "Test", role "Sales Manager"
    When User clicks department button
    And Click created department
    And Click Edit Department button
    And refresh page until page loads
    And Update the short name field "Update short name"
    And Select a department type -  as a Remote Unit
    And Click save button
    Then Verify that the created department is not displayed in the department list

  @TC_009_06
  Scenario: TC_009_06 Verifying that Delete Department button is visible and clickable
    Given Click on a department that has already been created
    When Click Edit Department button
    And refresh page until page loads
    Then Verify that Delete Department button is visible and clickable

  @TC_009_07
  Scenario: TC_009_07 Deleting the created department
    Given Create a new department with the name "A", short name "Type Test", type "Department", description "Test", role "Sales Manager"
    When User clicks department button
    And Click created department
    When Click Edit Department button
    And refresh page until page loads
    And Click Delete Department button
    And Click Confirm
    Then User verifies that the departments are displayed
    Then Verify that the created department is not displayed in the department list

  @TC_009_08
  Scenario: TC_009_08 Verifying that Change image button is visible and clickable
    Given Click on a department that has already been created
    When Click Edit Department button
    And refresh page until page loads
    Then Verify that Change image button is visible and clickable