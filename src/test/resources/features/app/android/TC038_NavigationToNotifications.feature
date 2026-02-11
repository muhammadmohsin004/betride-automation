@android @TC-038
Feature: TC-038 Notifications - Navigation to Notifications Page

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-038
  Scenario: Navigation to Notifications page from Settings
    Given User is logged in on the app
    When User opens Settings
    And User taps on Notifications option
    Then Notifications page should open with notification options
