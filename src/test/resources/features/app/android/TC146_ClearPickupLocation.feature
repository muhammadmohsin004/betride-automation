@android @TC-146
Feature: TC-146 Send/Receive - Clear Pickup Location

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-146
  Scenario: Verify pickup field becomes blank after tapping X icon
    Given User is on Send or Receive page with pickup location filled
    When User taps X icon to clear Send Receive pickup field
    Then Send Receive pickup field should become blank
