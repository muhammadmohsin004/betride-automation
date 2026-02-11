@android @TC-131
Feature: TC-131 Confirm Ride - Decrease Fare (-1 Button)

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-131
  Scenario: Verify fare decreases by 1 MAD when tapping -1 button
    Given User is on Confirm Ride page with fare above minimum
    When User taps the minus one fare button
    Then Fare should decrease by exactly 1 MAD
