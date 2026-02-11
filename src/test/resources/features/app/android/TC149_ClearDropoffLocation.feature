@android @TC-149
Feature: TC-149 Send/Receive - Clear Drop-off Location

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-149
  Scenario: Verify drop-off field cleared after tapping X icon
    Given User is on Send or Receive page with drop-off location filled
    When User taps X icon to clear Send Receive drop-off field
    Then Send Receive drop-off field should be cleared successfully
