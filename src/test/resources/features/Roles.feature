@mehmet @regression @roles
Feature: Listing and visibility of roles on the Roles page

  Background: Authorized user logs into the system and navigates to Roles page
    Given user goes to homepage
    And User clicks login link
    And user logins as "userNameMehmet" with password "passwordMehmet"
    When user expands the left menu if collapsed
    And user clicks the 'Roles' option in the left menu

  @us18 @role-listing
  Scenario: TC_018_001 List all roles on the Roles page
    Then the list of all roles should be visible on the Roles page

  @us18 @role-visibility
  Scenario Outline: TC_018_<rowNumber> Verify role '<role>' is visible on the Roles page
    Then the role with name '<role>' should be visible on the Roles page

    Examples:
      | rowNumber | role                |
      | 002       | Accountant          |
      | 003       | Customer            |
      | 004       | Logistics Personnel |
      | 005       | Quality Controller  |
      | 006       | Sales Personnel     |
      | 007       | Warehouse Personnel |
      | 008       | APP_DOMAIN_MANAGER  |
      | 009       | Guest               |
      | 010       | Purchase Manager    |
      | 011       | Quality Manager     |
      | 012       | Store Manager       |
      | 013       | Business Owner      |
      | 014       | Logistics Manager   |
      | 015       | Purchase Personnel  |
      | 016       | Sales Manager       |
      | 017       | Warehouse Manager   |



  @us19 @role-clickable
  Scenario Outline: TC_019_<rowNumber> Verify role '<role>' is clickable on the Roles page
    Then the role with name '<role>' should be clickable on the Roles page

    Examples:
      | rowNumber | role                |
      | 001       | Accountant          |
      | 002       | Customer            |
      | 003       | Logistics Personnel |
      | 004       | Quality Controller  |
      | 005       | Sales Personnel     |
      | 006       | Warehouse Personnel |
      | 007       | APP_DOMAIN_MANAGER  |
      | 008       | Guest               |
      | 009       | Purchase Manager    |
      | 010       | Quality Manager     |
      | 011       | Store Manager       |
      | 012       | Business Owner      |
      | 013       | Logistics Manager   |
      | 014       | Purchase Personnel  |
      | 015       | Sales Manager       |
      | 016       | Warehouse Manager   |


  @us19 @role-display
  Scenario Outline: TC_019_<rowNumber> Role '<role>' detail page should be displayed when clicked
    When the user clicks the '<role>' role on the Roles page
    Then the Role Detail page should be displayed

    Examples:
      | rowNumber | role                |
      | 017       | Accountant          |
      | 018       | Customer            |
      | 019       | Logistics Personnel |
      | 020       | Quality Controller  |
      | 021       | Sales Personnel     |
      | 022       | Warehouse Personnel |
      | 023       | APP_DOMAIN_MANAGER  |
      | 024       | Guest               |
      | 025       | Purchase Manager    |
      | 026       | Quality Manager     |
      | 027       | Store Manager       |
      | 028       | Business Owner      |
      | 029       | Logistics Manager   |
      | 030       | Purchase Personnel  |
      | 031       | Sales Manager       |
      | 032       | Warehouse Manager   |


  @us19 @role-visibility-permission
  Scenario Outline: TC_019_<rowNumber> Defined permissions of '<role>' role should be visible on the detail page
    When the user clicks the '<role>' role on the Roles page
    Then the Role Detail page should be displayed
    And the defined permissions for the role should be displayed

    Examples:
      | rowNumber | role                |
      | 033       | Accountant          |
      | 034       | Customer            |
      | 035       | Logistics Personnel |
      | 036       | Quality Controller  |
      | 037       | Sales Personnel     |
      | 038       | Warehouse Personnel |
      | 039       | APP_DOMAIN_MANAGER  |
      | 040       | Guest               |
      | 041       | Purchase Manager    |
      | 042       | Quality Manager     |
      | 043       | Store Manager       |
      | 044       | Business Owner      |
      | 045       | Logistics Manager   |
      | 046       | Purchase Personnel  |
      | 047       | Sales Manager       |
      | 048       | Warehouse Manager   |
