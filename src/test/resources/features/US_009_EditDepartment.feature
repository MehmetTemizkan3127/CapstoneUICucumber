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
  Scenario: TC_009_04 Verifying that you are redirected to the correct department after clicking on it
    Then Verify that you are redirected to the correct department after clicking on it
