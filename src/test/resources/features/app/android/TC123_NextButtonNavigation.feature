@android @TC-123
Feature: TC-123 City to City - Next Button Navigation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-123
  Scenario: Verify Next button navigates to Confirm Ride page
    Given User is on City to City page with both fields selected
    When User taps Next button
    Then App should navigate to Confirm Ride page
