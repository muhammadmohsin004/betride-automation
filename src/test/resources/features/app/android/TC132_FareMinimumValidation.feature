@android @TC-132
Feature: TC-132 Confirm Ride - Fare Minimum Validation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-132
  Scenario: Verify fare does not decrease below minimum
    Given User is on Confirm Ride page with fare at minimum
    When User taps minus button at minimum fare
    Then Fare should not decrease below minimum value
