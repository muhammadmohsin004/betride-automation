@android @TC-042
Feature: TC-042 Settings - Navigation to Language Selection Page

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-042
  Scenario: Verify navigation to Language selection page
    Given User is logged in and on Settings page
    When User taps on Languages option
    Then Choose the language page should be shown with language list
