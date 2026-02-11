@android @TC-100
Feature: TC-100 Confirm Booking - Fare Minimum Validation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-100
  Scenario: Verify fare does not go below minimum allowed
    Given User is on Confirm Booking page with fare at minimum
    When User taps minus one button at minimum fare
    Then Fare should not go below minimum allowed
