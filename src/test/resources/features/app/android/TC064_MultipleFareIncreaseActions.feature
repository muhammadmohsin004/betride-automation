@android @TC-064
Feature: TC-064 Confirm Ride - Multiple Fare Increase Actions

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-064
  Scenario: Verify fare increases by 5 MAD when tapping plus one five times
    Given User is on the Confirm Ride page for fare test
    When User taps plus one button five times
    Then Fare should increase by 5 MAD
