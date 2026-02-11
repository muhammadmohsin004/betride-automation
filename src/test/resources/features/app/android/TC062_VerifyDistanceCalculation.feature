@android @TC-062
Feature: TC-062 Confirm Ride - Verify Distance Calculation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-062
  Scenario: Verify distance calculation on Confirm Ride page
    Given User is on the Confirm Ride page for distance check
    When User views the distance section
    Then Distance should match the actual route
