@android @TC-051
Feature: TC-051 Settings - Verify Navigation to Send Device Logs

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-051
  Scenario: Verify navigation to Send Device Logs
    Given User is logged in and on Settings page for device logs
    When User taps on Send Device Logs option
    Then Confirmation popup should appear or logs start sending
