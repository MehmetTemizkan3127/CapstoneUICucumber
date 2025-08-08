@PermissionsTest @US20Test @Regression @MehmetTest @Smoke
Feature: Listing and visibility of roles on the Roles page

  Background: Authorized user logs into the system and navigates to Roles page
    Given user goes to homepage
    And User clicks login link
    And user logins as "userNameMehmet" with password "passwordMehmet"
    Then user clicks on maximize icon
    And user clicks on MenuItem from the sidebar and sees the BreadCrumb page
      | MenuItem    | BreadCrumb  |
      | Permissions | Permissions |

  Scenario: TC_020_01 All permissions should be displayed on the Permissions page
    Then all permissions should be displayed as a list on the Permissions page
    Then the total number of permissions should be 94

  Scenario: TC_020_002 to TC_020_095 The defined permissions are displayed on the Permissions page
    Then the following permissions are displayed on the Permissions page:
      | testCaseNo | permissionVisibility      |
      | TC_020_002 | accounting_read           |
      | TC_020_003 | accounting_write          |
      | TC_020_004 | application_read          |
      | TC_020_005 | application_read-all      |
      | TC_020_006 | application_read-slim     |
      | TC_020_007 | application_write         |
      | TC_020_008 | application_write-all     |
      | TC_020_009 | client_read               |
      | TC_020_010 | client_write              |
      | TC_020_011 | company_admin             |
      | TC_020_012 | company_fin_confirm       |
      | TC_020_013 | company_qual_confirm      |
      | TC_020_014 | company_read              |
      | TC_020_015 | company_write             |
      | TC_020_016 | country_read              |
      | TC_020_017 | dashboard_read            |
      | TC_020_018 | file_read                 |
      | TC_020_019 | file_write                |
      | TC_020_020 | handmade_confirm          |
      | TC_020_021 | handmade_read             |
      | TC_020_022 | handmade_write            |
      | TC_020_023 | inventory_read            |
      | TC_020_024 | inventory_write           |
      | TC_020_025 | invoice_confirm           |
      | TC_020_026 | invoice_read              |
      | TC_020_027 | invoice_write             |
      | TC_020_028 | membership_read           |
      | TC_020_029 | membership_read-all       |
      | TC_020_030 | membership_read-app       |
      | TC_020_031 | membership_read-subscr    |
      | TC_020_032 | membership_update         |
      | TC_020_033 | membership_update-all     |
      | TC_020_034 | membership_update-app     |
      | TC_020_035 | membership_write          |
      | TC_020_036 | membership-type_read      |
      | TC_020_037 | membership-type_write     |
      | TC_020_038 | order_confirm             |
      | TC_020_039 | order_read                |
      | TC_020_040 | order_write               |
      | TC_020_041 | organization_read         |
      | TC_020_042 | organization_read-all     |
      | TC_020_043 | organization_read-app     |
      | TC_020_044 | organization_write        |
      | TC_020_045 | organization-group_read   |
      | TC_020_046 | organization-group_write  |
      | TC_020_047 | organization-status_read  |
      | TC_020_048 | organization-status_write |
      | TC_020_049 | permission_read           |
      | TC_020_050 | permission_write          |
      | TC_020_051 | procurement_read          |
      | TC_020_052 | procurement_write         |
      | TC_020_053 | purchasing_confirm        |
      | TC_020_054 | purchasing_read           |
      | TC_020_055 | purchasing_read_cost      |
      | TC_020_056 | purchasing_write          |
      | TC_020_057 | reception_confirm         |
      | TC_020_058 | reception_read            |
      | TC_020_059 | reception_write           |
      | TC_020_060 | role_read                 |
      | TC_020_061 | role_read-all             |
      | TC_020_062 | role_read-app             |
      | TC_020_063 | role_write                |
      | TC_020_064 | specprice_read            |
      | TC_020_065 | specprice_write           |
      | TC_020_066 | subscription_read         |
      | TC_020_067 | subscription_read-all     |
      | TC_020_068 | subscription_read-app     |
      | TC_020_069 | subscription_write        |
      | TC_020_070 | subscription_write-all    |
      | TC_020_071 | subscription_write-app    |
      | TC_020_072 | user_read                 |
      | TC_020_073 | user_read-all             |
      | TC_020_074 | user_read-app             |
      | TC_020_075 | user_write                |
      | TC_020_076 | user-group_read           |
      | TC_020_077 | user-group_write          |
      | TC_020_078 | user-group-type_read      |
      | TC_020_079 | user-group-type_write     |
      | TC_020_080 | user-private-token_read   |
      | TC_020_081 | user-private-token_write  |
      | TC_020_082 | user-status_read          |
      | TC_020_083 | user-status_write         |
      | TC_020_084 | wishlist_admin            |
      | TC_020_085 | wishlist_approved         |
      | TC_020_086 | wishlist_cancel           |
      | TC_020_087 | wishlist_offer_confirm    |
      | TC_020_088 | wishlist_offer_ready      |
      | TC_020_089 | wishlist_quality_confirm  |
      | TC_020_090 | wishlist_read             |
      | TC_020_091 | wishlist_sale_confirm     |
      | TC_020_092 | wishlist_set_coding       |
      | TC_020_093 | wishlist_set_price        |
      | TC_020_094 | wishlist_view_supp_price  |
      | TC_020_095 | wishlist_write            |
