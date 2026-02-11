@android @TC-127
Feature: TC-127 Confirm Ride - Verify Estimated Travel Time

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-127
  Scenario: Verify estimated travel time is displayed correctly
    Given User is on Confirm Ride page with trip details
    Then Confirm Ride estimated travel time should be displayed correctly
