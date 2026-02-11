@android @TC-137
Feature: TC-137 Driver Search - Cancel YES Action

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-137
  Scenario: Verify tapping YES on cancel popup cancels request and returns to previous screen
    Given User sees cancel confirmation popup on searching screen
    When User taps YES on cancel confirmation popup
    Then Request should be cancelled and app returns to previous screen
