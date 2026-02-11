@android @TC-066
Feature: TC-066 Confirm Ride - Fare Cannot Be Negative

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-066
  Scenario: Verify fare cannot go below minimum when tapping minus one
    Given User is on the Confirm Ride page with fare at minimum
    When User taps minus one button again
    Then Fare should remain at minimum allowed
