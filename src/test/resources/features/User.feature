@Fatma
Feature: User Module

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"

  Scenario: User opens Users Page
    Given User goes to usersPage
    Then verify that  page opened


  Scenario: User checks visibility of users list
    Given User goes to usersPage
    Then verify userList exists