@android @TC-079
Feature: TC-079 Ride Booking - Navigate Back from Confirm Ride

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-079
  Scenario: Verify tapping back arrow returns to Add Destination page
    Given Confirm Ride screen is loaded
    When User taps on back arrow
    Then App should return to Add Destination page
