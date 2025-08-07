@NewDepartment
Feature: New Department Feature
#T****
  Background: User goes to homepage
    Given user goes to homepage
    And User clicks login link
    When user logins as "usernameTugba" with password "passwordTugba"
    And user clicks on maximize icon
    And User clicks department button

  @TC_008_01 @Smoke @Regression @SmokeDemo
  Scenario: TC_08_01 Adding a new department in the Departments module
    Given Click Add New Department button
    When Enter a department name 'Test department name'
    And Enter a department Short name 'Test department short name'
    And Select a department type - Departmant
    And Enter a department description 'Test department description'
    And Select a departmant role
    And Click save button
    Then Verify that the newly created department is displayed in the department list.

  @TC_008_02 @Smoke @Regression
  Scenario: TC_08_02 Testing department creation with an empty name field
    Given Click Add New Department button
    When Enter a department name ''
    And Enter a department Short name 'Test department short name'
    And Select a department type - Departmant
    And Enter a department description 'Test department description'
    And Select a departmant role
    And Click save button
    Then Verify that the message 'Please enter a name for department' is displayed

  @TC_008_03 @Regression
  Scenario: TC_08_03 Testing department creation with an empty role field
    Given Click Add New Department button
    When Enter a department name 'Test department name'
    And Enter a department Short name 'Test department short name'
    And Enter a department description 'Test department description'
    And Select a departmant role
    And Click save button
    Then Verify that the message 'Please select a type for department' is displayed

  @TC_008_04 @Regression
  Scenario: TC_0008_04 Creating a department with only the name and type fields
    Given Click Add New Department button
    When Enter a department name 'Test department name'
    And Enter a department Short name ''
    And Select a department type - Departmant
    And Enter a department description ''
    And Click save button
    Then user verifies that the message 'New department successfully created' is displayed

  @TC_008_05 @NewDepartmentBug @Regression
  Scenario: TC_0008_05 Creating a department by entering a space character in the name field
    Given Click Add New Department button
    When Enter a department name '     '
    And Enter a department Short name 'Test department short name'
    And Select a department type - Departmant
    And Enter a department description 'Test department description'
    And Select a departmant role
    And Click save button
    Then user verifies that the message 'New department successfully created' is not displayed

  @TC_008_06 @Regression
  Scenario: TC_08_06 Verifying that more than one role can be added to a newly created department
    Given Click Add New Department button
    When Enter a department name 'Multiple Test'
    And Enter a department Short name 'Test department short name'
    And Select a department type - Departmant
    And Enter a department description 'Test department description'
    And Select multiple 2 departmant role
    And Click save button
    Then Verify that the count of added roles matches the count of created roles

  @TC_008_07 @Smoke @Regression
  Scenario: TC_08_07 Do not select a department as the department type / NEGATIVE TEST
    Given Click Add New Department button
    When Enter a department name 'Remote Unit department test'
    And Enter a department Short name 'Test department short name'
    And Select a department type - Remote Unit
    And Enter a department description 'Test department description'
    And Select a departmant role
    And Click save button
    Then Verify that the created department is not displayed in the department list

  @TC_008_08 @NewDepartmentBug @Regression
  Scenario: TC_08_08 Verifying that a role added during department creation can be removed
    Given Click Add New Department button
    When Enter a department name 'Multiple Test'
    And Enter a department Short name 'Test department short name'
    And Select a department type - Departmant
    And Enter a department description 'Test department description'
    And Select a departmant role
    And Remove a selected department role
    Then Verify that a selected department role is removed

  @TC_008_09 @Regression
  Scenario: TC_08_09 Verifying that the same role cannot be selected twice
    Given Click Add New Department button
    And Enter a department description 'Test department description'
    And Select a departmant role twice
    Then Verify that the same role cannot be selected again

  @TC_008_10 @NewDepartmentBug @Regression
  Scenario: TC_08_010 Creating a department more than once with the same name and type
    Given save the first department name
    When Click Add New Department button
    And create new department with the same name
    And Enter a department Short name 'Test department short name'
    And Select a department type - Departmant
    And Enter a department description 'Test department description'
    And Select a departmant role
    And Click save button
    And User clicks department button
    Then Verify that the department is not created twice with the same name

  @TC_008_11 @Smoke @Regression
  Scenario: TC_08_11 Verifying that add new department button is clickable
    Then User verifies that add new department button is clickable

  @TC_008_12 @Smoke @Regression
  Scenario: TC_08_12 Verifying that Department Name field is visible
    Given Click Add New Department button
    Then Verify that Department Name field is visible

  @TC_008_13 @Regression
  Scenario: TC_08_13 Verifying that Short Name field is visible
    Given Click Add New Department button
    Then Verify that Short Name field is visible

  @TC_008_14 @Smoke @Regression
  Scenario: TC_08_14 Verifying that Department Type field is visible
    Given Click Add New Department button
    Then Verify that Department Type field is visible

  @TC_008_15 @Regression
  Scenario: TC_08_15 Verifying that Department Description field is visible
    Given Click Add New Department button
    Then Verify that Department Description field is visible

  @TC_008_16 @Regression
  Scenario: TC_08_16 Verifying that Department Roles field is visible
    Given Click Add New Department button
    Then Verify that Department Roles field is visible

  @TC_008_17 @Regression
  Scenario: TC_08_17 Verifying that save button is visible and clickable
    Given Click Add New Department button
    Then Verify that Save button is visible
    Then Verify that Save button is clickable

  @TC_008_18 @Regression
  Scenario: TC_08_18 Verifying that Cancel button is visible
    Given Click Add New Department button
    Then Verify that Cancel button is visible

  @TC_008_19 @Regression
  Scenario: TC_08_19 Verifying that Cancel button is clickable
    Given Click Add New Department button
    And Click cancel
    Then Verify that edit button is visible

  @deleteDepartment
  Scenario: Delete Department
    Then delete the created department

