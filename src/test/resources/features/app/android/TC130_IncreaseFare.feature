@android @TC-130
Feature: TC-130 Confirm Ride - Increase Fare (+1 Button)

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-130
  Scenario: Verify fare increases by 1 MAD when tapping +1 button
    Given User is on Confirm Ride page with editable fare
    When User taps the plus one fare button
    Then Fare should increase by exactly 1 MAD
