@android @TC-075
Feature: TC-075 Ride Booking - Drop-off Same as Pickup

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-075
  Scenario: Verify error when drop-off is same as pickup location
    Given User is on ride booking screen
    When User enters same location in both pickup and drop-off fields
    Then Error message Pickup and drop-off cannot be same should appear
