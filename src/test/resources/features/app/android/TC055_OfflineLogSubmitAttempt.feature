@android @TC-055
Feature: TC-055 Settings - Verify Offline Log Submit Attempt

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-055
  Scenario: Verify offline log submit attempt shows error
    Given User is on Settings page with internet OFF
    When User taps on Send Device Logs while offline
    Then Error message should appear Unable to send logs No internet connection
