@Fatma
Feature: User Module Edit

  Background: User logs in application
    Given user goes to homepage
    And User clicks login link
    And user logins as "username1" with password "password1"

  Scenario:  User adds a new role to first user of list
    Given User goes to usersPage
    Then verify that  page opened