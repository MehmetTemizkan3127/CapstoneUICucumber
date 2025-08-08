@RolesTest @US18Test @Regression @MehmetTest @Smoke
Feature: Listing and visibility of roles on the Roles page

  Background: Authorized user logs into the system and navigates to Roles page
    Given user goes to homepage
    And User clicks login link
    And user logins as "userNameMehmet" with password "passwordMehmet"
    Then user clicks on maximize icon
    And user clicks on MenuItem from the sidebar and sees the BreadCrumb page
      | MenuItem | BreadCrumb |
      | Roles    | Roles      |

  @SmokeDemo
  Scenario: TC_018_001 List all roles on the Roles page
    Then the list of all roles should be visible on the Roles page


  Scenario: TC_018_002 to TC_018_017 Verify that multiple roles are visible on the Roles page
    Then the following roles should be visible on the Roles page:
      | testCaseNo | roleVisibility      |
      | TC_018_002 | Accountant          |
      | TC_018_003 | Customer            |
      | TC_018_004 | Logistics Personnel |
      | TC_018_005 | Quality Controller  |
      | TC_018_006 | Sales Personnel     |
      | TC_018_007 | Warehouse Personnel |
      | TC_018_008 | APP_DOMAIN_MANAGER  |
      | TC_018_009 | Guest               |
      | TC_018_010 | Purchase Manager    |
      | TC_018_011 | Quality Manager     |
      | TC_018_012 | Store Manager       |
      | TC_018_013 | Business Owner      |
      | TC_018_014 | Logistics Manager   |
      | TC_018_015 | Purchase Personnel  |
      | TC_018_016 | Sales Manager       |
      | TC_018_017 | Warehouse Manager   |


