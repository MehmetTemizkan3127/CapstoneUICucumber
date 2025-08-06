@mehmet @regression @permissions @us20
Feature: Display and Verify User Permissions on the Permissions Page

  Background: Authorized user logs into the system and navigates to Permissions page
    Given user goes to homepage
    And User clicks login link
    And user logins as "userNameMehmet" with password "passwordMehmet"
    When user clicks on maximize icon
    And user clicks the 'Permissions' option in the left menu
    When the user navigates to the Permissions page

  @permissions-listing
  Scenario: TC_020_01 All permissions should be displayed on the Permissions page
    Then all permissions should be displayed as a list on the Permissions page
    Then the total number of permissions should be 94

  @permission-visibility
  Scenario Outline: TC_020_<rowNumber> The '<permission>' permission is displayed on the Permissions page
    Then the '<permission>' permission is displayed on the Permissions page

    Examples:
      | rowNumber | permission               |
      | 002       | accounting_write         |
      | 003       | application_read         |
      | 004       | application_read-all     |
      | 005       | application_read-slim    |
      | 006       | application_write        |
      | 007       | application_write-all    |
      | 008       | client_read              |
      | 009       | client_write             |
      | 010       | company_admin            |
      | 011       | company_fin_confirm      |
      | 012       | company_qual_confirm     |
      | 013       | company_read             |
      | 014       | company_write            |
      | 015       | country_read             |
      | 016       | dashboard_read           |
      | 017       | file_read                |
      | 018       | file_write               |
      | 019       | handmade_confirm         |
      | 020       | handmade_read            |
      | 021       | handmade_write           |
      | 022       | inventory_read           |
      | 023       | inventory_write          |
      | 024       | invoice_confirm          |
      | 025       | invoice_read             |
      | 026       | invoice_write            |
      | 027       | membership_read          |
      | 028       | membership_read-all      |
      | 029       | membership_read-app      |
      | 030       | membership_read-subscr   |
      | 031       | membership_update        |
      | 032       | membership_update-all    |
      | 033       | membership_update-app    |
      | 034       | membership_write         |
      | 035       | membership-type_read     |
      | 036       | membership-type_write    |
      | 037       | order_confirm            |
      | 038       | order_read               |
      | 039       | order_write              |
      | 040       | organization_read        |
      | 041       | organization_read-all    |
      | 042       | organization_read-app    |
      | 043       | organization_write       |
      | 044       | organization-group_read  |
      | 045       | organization-group_write |
      | 046       | organization-status_read |
      | 047       | organization-status_write|
      | 048       | permission_read          |
      | 049       | permission_write         |
      | 050       | procurement_read         |
      | 051       | procurement_write        |
      | 052       | purchasing_confirm       |
      | 053       | purchasing_read          |
      | 054       | purchasing_read_cost     |
      | 055       | purchasing_write         |
      | 056       | reception_confirm        |
      | 057       | reception_read           |
      | 058       | reception_write          |
      | 059       | role_read                |
      | 060       | role_read-all            |
      | 061       | role_read-app            |
      | 062       | role_write               |
      | 063       | specprice_read           |
      | 064       | specprice_write          |
      | 065       | subscription_read        |
      | 066       | subscription_read-all    |
      | 067       | subscription_read-app    |
      | 068       | subscription_write       |
      | 069       | subscription_write-all   |
      | 070       | subscription_write-app   |
      | 071       | user_read                |
      | 072       | user_read-all            |
      | 073       | user_read-app            |
      | 074       | user_write               |
      | 075       | user-group_read          |
      | 076       | user-group_write         |
      | 077       | user-group-type_read     |
      | 078       | user-group-type_write    |
      | 079       | user-private-token_read  |
      | 080       | user-private-token_write |
      | 081       | user-status_read         |
      | 082       | user-status_write        |
      | 083       | wishlist_admin           |
      | 084       | wishlist_approved        |
      | 085       | wishlist_cancel          |
      | 086       | wishlist_offer_confirm   |
      | 087       | wishlist_offer_ready     |
      | 088       | wishlist_quality_confirm |
      | 089       | wishlist_read            |
      | 090       | wishlist_sale_confirm    |
      | 091       | wishlist_set_coding      |
      | 092       | wishlist_set_price       |
      | 093       | wishlist_view_supp_price |
      | 094       | wishlist_write           |
      | 095       | accounting_read          |