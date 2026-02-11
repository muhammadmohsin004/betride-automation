@android @TC-134
Feature: TC-134 Confirm Ride - Search for Driver

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-134
  Scenario: Verify tapping Search for Driver navigates to searching screen
    Given User is on Confirm Ride page with search button enabled
    When User taps Search for Driver button
    Then App should navigate to driver searching screen
