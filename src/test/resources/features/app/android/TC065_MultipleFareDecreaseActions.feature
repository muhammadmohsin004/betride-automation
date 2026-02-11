@android @TC-065
Feature: TC-065 Confirm Ride - Multiple Fare Decrease Actions

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-065
  Scenario: Verify fare decreases by 5 MAD when tapping minus one five times
    Given User is on the Confirm Ride page with increased fare
    When User taps minus one button five times
    Then Fare should decrease by 5 MAD
