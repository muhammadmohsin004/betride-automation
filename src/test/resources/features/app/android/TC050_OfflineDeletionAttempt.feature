@android @TC-050
Feature: TC-050 Settings - Verify Offline Deletion Attempt

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-050
  Scenario: Verify offline deletion attempt shows error
    Given User is on the Delete Account page with internet OFF
    When User enters correct captcha and taps Continue while offline
    Then Error message should appear No internet connection and account not deleted
