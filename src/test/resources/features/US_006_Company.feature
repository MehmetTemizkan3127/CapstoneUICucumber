@Company @US0006
Feature: Edit company information in Company module

  Background: User Login
    Given user goes to homepage
    And User clicks login link
    When user enters email "tuubacakara@gmail.com"
    And user enters password "123456Tk#"
    And user clicks on Login Button

  Scenario: TC_006_01 Edit company name successfully
    And User navigates to Company module
    When User clicks Edit button company
    And User updates Company Name with "TestCompany Tuba12"
    And User clicks Save button company
    Then User should see success message "Company information successfully updated"
#    And user closes browser(hooksta closes var)

  Scenario: TC_006_02 Try to save without email
    And User navigates to Company module
    When User clicks Edit button company
    And User updates new E-mail with "tuba12@"
    And User clicks Save button company
    Then User should see success message "Company information successfully updated"
#    And user closes browser(hooksta closes var)
