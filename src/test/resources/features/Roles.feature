@Mehmet @Regression @Roles @US_018
Feature: Listing and visibility of roles on the Roles page

  Background: Authorized user logs into the system and navigates to Roles page
    Given user goes to homepage
    And User clicks login link
    And user logins as "userNameMehmet" with password "passwordMehmet"
    When user expands the left menu if collapsed
    And user clicks the 'Roles' option in the left menu

  Scenario: TC_018_001 List all roles on the Roles page
    Then the list of all roles should be visible on the Roles page

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
