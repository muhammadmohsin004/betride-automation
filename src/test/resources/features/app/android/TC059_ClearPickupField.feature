@android @TC-059
Feature: TC-059 Ride Booking - Clear Pickup Field

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-059
  Scenario: Verify clear icon clears pickup field
    Given User has filled the pickup field with text
    When User taps on the clear x icon
    Then Pickup field should become empty
