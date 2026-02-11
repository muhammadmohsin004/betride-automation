@android @TC-105
Feature: TC-105 Driver Search - Cancel YES Action

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-105
  Scenario: Verify tapping YES on cancel popup cancels ride and returns to previous screen
    Given Cancel popup is visible on searching screen
    When User taps YES on cancel popup
    Then Ride request should be cancelled
    And User should return to previous screen
