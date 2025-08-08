@RolesTest @US19Test @Regression @MehmetTest @Smoke
Feature: Listing and visibility of roles on the Roles page

  Background: Authorized user logs into the system and navigates to Roles page
    Given user goes to homepage
    And User clicks login link
    And user logins as "userNameMehmet" with password "passwordMehmet"
    Then user clicks on maximize icon
    And user clicks on MenuItem from the sidebar and sees the BreadCrumb page
      | MenuItem | BreadCrumb |
      | Roles    | Roles      |

  Scenario: TC_019_001 to TC_019_016 Verify that roles are clickable on the Roles page
    Then the following roles should be clickable on the Roles page:
      | testCaseNo | roleClickable       |
      | TC_019_001 | Accountant          |
      | TC_019_002 | Customer            |
      | TC_019_003 | Logistics Personnel |
      | TC_019_004 | Quality Controller  |
      | TC_019_005 | Sales Personnel     |
      | TC_019_006 | Warehouse Personnel |
      | TC_019_007 | APP_DOMAIN_MANAGER  |
      | TC_019_008 | Guest               |
      | TC_019_009 | Purchase Manager    |
      | TC_019_010 | Quality Manager     |
      | TC_019_011 | Store Manager       |
      | TC_019_012 | Business Owner      |
      | TC_019_013 | Logistics Manager   |
      | TC_019_014 | Purchase Personnel  |
      | TC_019_015 | Sales Manager       |
      | TC_019_016 | Warehouse Manager   |

  Scenario: TC_019_017 to TC_019_032 Verify that role detail page appears when clicked
    Then the following roles detail page should be displayed when clicked:
      | testCaseNo | roleDisplay         |
      | TC_019_017 | Accountant          |
      | TC_019_018 | Customer            |
      | TC_019_019 | Logistics Personnel |
      | TC_019_020 | Quality Controller  |
      | TC_019_021 | Sales Personnel     |
      | TC_019_022 | Warehouse Personnel |
      | TC_019_023 | APP_DOMAIN_MANAGER  |
      | TC_019_024 | Guest               |
      | TC_019_025 | Purchase Manager    |
      | TC_019_026 | Quality Manager     |
      | TC_019_027 | Store Manager       |
      | TC_019_028 | Business Owner      |
      | TC_019_029 | Logistics Manager   |
      | TC_019_030 | Purchase Personnel  |
      | TC_019_031 | Sales Manager       |
      | TC_019_032 | Warehouse Manager   |

  Scenario: TC_019_033 to TC_019_048 Verify that role permissions are visible on the detail page
    Then the defined permissions for the following roles should be displayed on the detail page:
      | testCaseNo | roleVisibilityPermission |
      | TC_019_033 | Accountant               |
      | TC_019_034 | Customer                 |
      | TC_019_035 | Logistics Personnel      |
      | TC_019_036 | Quality Controller       |
      | TC_019_037 | Sales Personnel          |
      | TC_019_038 | Warehouse Personnel      |
      | TC_019_039 | APP_DOMAIN_MANAGER       |
      | TC_019_040 | Guest                    |
      | TC_019_041 | Purchase Manager         |
      | TC_019_042 | Quality Manager          |
      | TC_019_043 | Store Manager            |
      | TC_019_044 | Business Owner           |
      | TC_019_045 | Logistics Manager        |
      | TC_019_046 | Purchase Personnel       |
      | TC_019_047 | Sales Manager            |
      | TC_019_048 | Warehouse Manager        |
