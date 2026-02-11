@android @TC-140
Feature: TC-140 City to City - Validation Pickup Equals Drop-off

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-140
  Scenario: Verify error when pickup and drop-off are the same location
    Given User is on City to City page with same location for both fields
    When User taps Next with same pickup and dropoff
    Then Error message should display pickup and dropoff cannot be same
