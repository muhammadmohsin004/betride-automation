@android @TC-041
Feature: TC-041 Notifications - Offline Mode Behavior

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-041
  Scenario: Verify offline mode behavior in Notifications
    Given User is on the Notifications page with internet OFF
    When User attempts to change a notification toggle
    Then Error message should be shown and app should not crash
